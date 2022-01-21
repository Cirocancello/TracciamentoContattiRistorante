package it.polito.tdp.TracciamentoContatti.db;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import it.polito.tdp.TracciamentoContatti.model.Cliente;
import it.polito.tdp.TracciamentoContatti.model.Ristorante;
import it.polito.tdp.TracciamentoContatti.model.Tavolo;

public class StcrDAO {

	/**
	 * cerca il codice del ristorante in cui voglio effettuare la prenotazione
	 * riceve come parametro il nome del ristorante
	 * 
	 * @param nome nome del ristorante
	 * @return ritorna il codice del ristorante
	 */
	public int getCodiceRistorante(String nome) {

		String sql = "SELECT codice " + "FROM ristoranti " + "WHERE nome = ? ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, nome);
			ResultSet res = st.executeQuery();

			res.first();
			int codiceRistorante = res.getInt("codice");

			res.close();
			st.close();
			conn.close();

			return codiceRistorante;

		} catch (SQLException e) {
			throw new RuntimeException("Database error in cerca codice ristorante", e);
		}

	}

	/**
	 * ricerca dei tavoli liberi nel ristorante in cui si deve fare una prenotazione
	 * 
	 * @param codiceRistorante
	 * @return ritorna una lista di tavoli liberi
	 */
	public List<Tavolo> getTavoliDisponibili(int codiceRistorante, Date data, int numeroPersone) {

		String sql = "SELECT t.* " + "FROM tavoli t " + "INNER JOIN sale s ON t.codiceSala = s.codice "
				+ "INNER JOIN ristoranti r ON s.codiceRistorante  = r.codice "
				+ "WHERE r.Codice = ? AND  t.CapacitaMassima >= ? AND t.codice NOT IN(SELECT p.CodiceTavolo " + "FROM prenotazioni p "				
				+ "INNER JOIN tavoli t ON p.codicetavolo = t.Codice " + "INNER JOIN sale s ON t.codiceSala = s.codice "
				+ "INNER JOIN ristoranti r ON s.codiceRistorante = r.codice " + "WHERE r.codice = ? AND  p.data = ?) "
				+ "ORDER BY t.CapacitaMassima ASC ";
		
		// s.codiceRistorante è il codice che ho messo come parametro
		List<Tavolo> tavoliLiberi = new ArrayList<>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, codiceRistorante);
			st.setInt(2, numeroPersone);
			st.setInt(3, codiceRistorante);
			st.setDate(4, data);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				Tavolo t = new Tavolo(res.getInt("codice"), res.getInt("codicesala"), res.getString("nome"),
						res.getInt("CapacitaMassima"));
				tavoliLiberi.add(t);
			}
			res.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Database error in cerca tavoli liberi", e);
		}
		return tavoliLiberi;

	}

	/**
	 * Ricerca dei contatti in caso di contagio, nei tavoli adiacenti al contagiato
	 * e in quelli adiacenti a quest
	 * 
	 * @param cI   carta di identità del contagiato
	 * @param data data della tavolata
	 * @return ritorna il nome, cognome e telefono delle persone che hanno avuto
	 *         contatto con il contagiato
	 */
	public List<Cliente> tracciaContatti(String cI, Date data) {

		String sql = "SELECT Cognome, Nome,Telefono " + "FROM clienti " + "WHERE CodiceTavolo IN "
				+ "(SELECT codiceTavolo FROM clienti " + "WHERE DATA = ? " + "AND codiceTavolo IN ( "
				+ "SELECT CodiceTavolo " + "FROM clienti " + "WHERE numeroCartaIdentita = ? " + "AND DATA = ? "
				+ "UNION " + "SELECT CodiceTavoloAdiacente " + "FROM tavoliadiacenti " + "WHERE CodiceTavolo IN "
				+ "(SELECT CodiceTavolo clienti " + "FROM clienti " + "WHERE numeroCartaIdentita = ? "
				+ "AND DATA = ? )) " + "UNION " + "SELECT codiceTavoloAdiacente " + "FROM tavoliadiacenti "
				+ "WHERE codiceTavolo IN (SELECT codiceTavolo FROM clienti " + "WHERE DATA = ? "
				+ "AND codiceTavolo IN ( " + "SELECT CodiceTavoloAdiacente " + "FROM tavoliadiacenti "
				+ "	WHERE CodiceTavolo IN " + "(SELECT CodiceTavolo " + "FROM clienti "
				+ "WHERE numeroCartaIdentita = ? " + "AND DATA = ?)))) ";

		List<Cliente> clientidaContattare = new ArrayList<>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setDate(1, data);
			st.setDate(3, data);
			st.setDate(5, data);
			st.setDate(6, data);
			st.setDate(8, data);
			st.setString(2, cI);
			st.setString(4, cI);
			st.setString(7, cI);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				Cliente c = new Cliente(res.getString("Cognome"), res.getString("Nome"), res.getString("Telefono"));
				clientidaContattare.add(c);
			}
			res.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Database error in cerca tavoli liberi", e);
		}
		return clientidaContattare;
	}

	public int creaPrenotazione(int codiceRistorante, String cognome, String nome, String telefono, int numeroPersone,
			Date data) {

		int codicePrenotazione = 0;

		List<Tavolo> tavoliLiberi = getTavoliDisponibili(codiceRistorante, data, numeroPersone);

		if (tavoliLiberi.size() > 0) {
			int codiceTavoloDisponibile = tavoliLiberi.get(0).getCodice();
			System.out.println("Tavolo prenotato per il : " + data + ", codice tavolo assegnato "
					+ tavoliLiberi.get(0).getCodice());

			String sql = "INSERT INTO prenotazioni (CodiceTavolo, Cognome,Nome,Telefono,NumeroPersone, DATA) VALUES ( ?, ?, ?, ?, ? ,?) ";

			try {
				Connection conn = DBConnect.getConnection();
				PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				st.setInt(1, codiceTavoloDisponibile );
				st.setString(2, cognome);
				st.setString(3, nome);
				st.setString(4, telefono);
				st.setInt(5, numeroPersone);
				st.setDate(6, data);

				st.executeUpdate();
				try (ResultSet generatedKeys = st.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						codicePrenotazione = generatedKeys.getInt(1);
					} else {
						throw new SQLException("errore nella creazione della prenotazione");
					}
				}
				st.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("Database error in insert into prenotazioni", e);
			}			

		} else {
			System.out.println("Tavolo non disponibile");
		}
		return codicePrenotazione;
	}
		

	public int cercaCodiceprenotazione(String cognome, String nome, Date data) {

		int codiceP;

		String sql1 = "SELECT codice " + "FROM prenotazioni " + "WHERE cognome = ? " + "AND nome = ? "
				+ "AND data = ? ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql1);

			st.setString(1, cognome);
			st.setString(2, nome);
			st.setDate(3, data);
			ResultSet res = st.executeQuery();

			res.first();
			codiceP = res.getInt("codice");
			// System.out.println(codiceP); non lo deve stampare a video

			res.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Database error in cerca codice ristorante", e);
		}

		return codiceP;
	}

	public int cercaCodiceTavoloPrenotato(int codiceP) {

		String sql1 = "SELECT CodiceTavolo " + "FROM tavoliprenotati " + "WHERE CodicePrenotazione = ? ";

		int codTP = 0;

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql1);

			st.setInt(1, codiceP);

			ResultSet res = st.executeQuery();

			res.first();
			codTP = res.getInt("CodiceTavolo");

			res.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Database error in cerca codice ristorante", e);
		}

		return codTP;
	}

	public void inserisciCliente(int codicet, String cognome, String nome, String numCartaIdentita, String telefono,
			Date data) {

		String sql = "INSERT INTO clienti (CodiceTavolo, Cognome, Nome, NumeroCartaIdentita, Telefono, DATA) "
				+ "VALUES ('" + codicet + "','" + cognome + "','" + nome + "','" + numCartaIdentita + "','" + telefono
				+ "','" + data + "' ) ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.execute(sql);

			st.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Database error in insert into prenotazioni", e);
		}
	}

	public int cercaNumeroPersone(int codicePrenotazione) {

		String sql = "SELECT NumeroPersone " + "FROM prenotazioni " + "WHERE codice = ? ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, codicePrenotazione);
			ResultSet res = st.executeQuery();

			res.first();
			int numP = res.getInt("NumeroPersone");
			return numP;

		} catch (SQLException e) {
			throw new RuntimeException("Database error in read into prenotazioni", e);
		}
	}

}

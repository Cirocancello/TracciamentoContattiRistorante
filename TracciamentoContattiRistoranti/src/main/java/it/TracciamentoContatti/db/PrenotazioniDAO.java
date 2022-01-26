package it.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.TracciamentoContatti.model.Prenotazione;
import it.TracciamentoContatti.model.Tavolo;

public class PrenotazioniDAO {
	
	/**
	 * creo una nuova prenotazione inserendo il codice del ristorante scelto ed i dati del cliente che vuole 
	 * prenotare, il metodo mi restituisce il codice della prenotazione registrata, altrimenti il messaggio 
	 * ' nessun tavolo disponibile' 
	 * 
	 * @param codiceRistorante
	 * @param cognome
	 * @param nome
	 * @param telefono
	 * @param numeroPersone
	 * @param data
	 * 
	 * @return il metodo ritorna il codice della eventuale prenotazione registrata
	 */
	public int creaPrenotazione(int codiceRistorante, String cognome, String nome, String telefono, int numeroPersone,
			Date data) {

		int codicePrenotazione = 0;
		
		//___________________________Cerco eventuali tavoli disponibili
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
		


	/**
	 * ricerca dei tavoli liberi nel ristorante in cui si deve fare una prenotazione
	 * 
	 * @param codiceRistorante
	 * 
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
	 * recupero le informazioni della prenotazione per registrare i clienti al momento che si presentano al ristorante
	 * e visualizzo il nome della sala in cui è stata effettuata la prenotazione
	 * 
	 * @param codicePrenotazione
	 * 
	 * @return ritorna le informazioni della prenotazione
	 */
	public List<Prenotazione> cercaPrenotazione(int codicePrenotazione) {		
		
		String sql ="SELECT s.Nome, p.codice, p.cognome, p.nome, p.telefono, p.NumeroPersone, p.`Data` "
                  + "FROM prenotazioni p, tavoli t, sale s "				 
                  + "WHERE p.codiceTavolo = t.Codice "
                  + "AND p.codice = ? "
                  + "AND t.CodiceSala = s.Codice ";			
		
		String nomeSala;
		List<Prenotazione> prenotazione = new ArrayList<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, codicePrenotazione);
			
			ResultSet res1 = st.executeQuery();
			res1.first();
			nomeSala = res1.getString("s.nome");
			System.out.println("nome della sala in cui è stata effettuata la prenotazione : "+ nomeSala);
			res1.close();
			
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Prenotazione p = new Prenotazione(res.getInt("p.codice"), res.getString("p.cognome"), res.getString("p.nome"), 
						res.getString("p.telefono"),res.getInt("p.numeroPersone"), res.getDate("p.data"));
				prenotazione.add(p);
			}					
				
			res.close();
			st.close();
			conn.close();
			
			return prenotazione;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error in cerca codice tavolo prenotato", e);
		}
		
		
	}
}
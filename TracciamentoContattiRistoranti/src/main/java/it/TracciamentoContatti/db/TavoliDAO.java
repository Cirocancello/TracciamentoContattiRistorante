package it.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.TracciamentoContatti.model.Tavolo;

public class TavoliDAO {
	/**
	 * ricerca dei tavoli liberi nel ristorante in cui si deve fare una prenotazione
	 * 
	 * @param codiceRistorante
	 * 
	 * @return ritorna una lista di tavoli liberi
	 */
	public List<Tavolo> getTavoloDisponibile(Integer codiceRistorante, Date data, Integer numeroPersone) {

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

}

package it.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.TracciamentoContatti.Ristorante;
import it.TracciamentoContatti.db.DBConnect;


public class RistoranteDAO {
	
	/**
	 * visualizzo le informazioni sui ristoranti in base dati
	 * 
	 * @return informazioni ristoranti
	 */
	public List<Ristorante> getRistoranti() {		
			
			String sql = "SELECT * FROM ristoranti ";
			
			List<Ristorante> ristoranti = new ArrayList<>();
			
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();			
			
			while(res.next()) {
				Ristorante r = new Ristorante(res.getInt("codice"), res.getString("nome"), 
						res.getString("indirizzo"), res.getString("citta"), res.getString("provincia"),
						res.getString("telefono"));
				ristoranti.add(r);
			}
			res.close();
			st.close();
			conn.close();			
		} catch (SQLException e) {
			throw new RuntimeException("Database error in readShapes", e) ;
		}
		return ristoranti;

	}
	
	
	/**
	 * cerca il codice del ristorante in cui voglio effettuare la prenotazione
	 * riceve come parametro il nome del ristorante
	 * 
	 * @param nome nome del ristorante
	 * @return ritorna il codice del ristorante
	 */
	public int getCodiceRistorante(String nome) {

		String sql = "SELECT codice FROM ristoranti WHERE nome = ? ";

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
	
}			
	

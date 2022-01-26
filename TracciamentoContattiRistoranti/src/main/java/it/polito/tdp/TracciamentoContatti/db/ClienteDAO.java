package it.polito.tdp.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
	
	public void inserisciCliente(int codiceTavolo, String cognome, String nome, String numeroCartaIdentita, String telefono,
			Date data) {

		String sql = "INSERT INTO clienti (CodiceTavolo, Cognome, Nome, NumeroCartaIdentita, Telefono, DATA) "
				+ "VALUES ( ?, ?, ?, ?, ?, ? ) ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, codiceTavolo);
			st.setString(2,cognome);
			st.setString(3, nome);
			st.setString(4, numeroCartaIdentita);
			st.setString(5,telefono);
			st.setDate(6, data);	
			
			st.executeUpdate();
//			try (ResultSet generatedKeys = st.getGeneratedKeys()) {
//				if (generatedKeys.next()) {
//					codicePrenotazione = generatedKeys.getInt(1);
//				} else {
//					throw new SQLException("errore nella creazione della prenotazione");
//				}
//			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Database error in insert into clienti", e);
		}			
			
	}	
	

}

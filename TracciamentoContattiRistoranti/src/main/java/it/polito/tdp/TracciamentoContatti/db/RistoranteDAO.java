package it.polito.tdp.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.TracciamentoContatti.db.DBConnect;
import it.polito.tdp.TracciamentoContatti.model.Ristorante;

public class RistoranteDAO {
	
	public List<Ristorante> readRistoranti() {		
			
			String sql = "SELECT * "
					+ "FROM ristoranti ";
			
			List<Ristorante> ristoranti = new ArrayList<>();
			
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();			
			
			while(res.next()) {
				Ristorante r = new Ristorante(res.getString("codice"), res.getString("nome"), 
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
	
	
}			
	

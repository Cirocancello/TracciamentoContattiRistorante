package it.TracciamentoContatti.dao;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.TracciamentoContatti.Statistica;

/**
 * implementazione della classe per poter effettuare il login dell' utente
 * con il recupero del codice ID dopo aver inserito username e password
 * @author Ciro Cancello
 *
 */

public class loginDAO {

	/**
	 * implementazione della classe per poter effettuare il login dell' utente
	 * con il recupero del codice ID dopo aver inserito username e password
	 * @param userName credenziali forniti in input
	 * @param password
	 * @return il metodo restituisce il codice ID se le credenziali sono presenti nel database
	 */
	public static Integer login(String userName, String password) {
		
		String sql = "SELECT ID "
				+ "FROM login "
				+ "WHERE userName = ? "
				+ "AND password = ? ";
		
		Integer codiceLogin = null;
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, userName);	
			st.setString(2, password);
			
			ResultSet res = st.executeQuery();			
			
			if(res.first()) {			
		    	codiceLogin = res.getInt("ID");
			}
		
			res.close();			
		    st.close();
		    conn.close();	
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e);
		}
		
		return codiceLogin;
	}	

	
}	



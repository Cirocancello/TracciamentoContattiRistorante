package it.TracciamentoContatti.DAO;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.TracciamentoContatti.Statistica;

public class loginDAO {

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



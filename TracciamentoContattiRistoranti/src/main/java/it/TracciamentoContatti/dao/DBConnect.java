package it.TracciamentoContatti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Implementazione del metodo per creare la connessione al database
 * che verrà condivisa cin le altre classi DAO
 * 
 * @author Ciro Cancello
 *
 */
public class DBConnect {

	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/stcr?user=root&password=root";
		return DriverManager.getConnection(jdbcURL) ;
	}

}


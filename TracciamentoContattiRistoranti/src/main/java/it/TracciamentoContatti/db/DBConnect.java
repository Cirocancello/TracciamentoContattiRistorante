package it.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/stcr?user=root&password=root";
		return DriverManager.getConnection(jdbcURL) ;
	}

}

package it.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.TracciamentoContatti.Statistica;

public class StatisticaMensileDAO {
	
	public static  List<Statistica> totaliAvventoriGiornalieri(String codiceRistorante) {

		Integer codiceRistorante1 = Integer.parseInt(codiceRistorante);
		
		String sql = "SELECT data, COUNT(*) AS totaleAvventori "
				+ "FROM clienti c, sale s, tavoli t, ristoranti r "
				+ "WHERE r.codice = ? "			
				+ "AND c.CodiceTavolo = t.Codice "
				+ "AND t.CodiceSala = s.Codice "
				+ "AND s.CodiceRistorante = r.Codice "
				+ "Group BY MONTH (data) ";

		List<Statistica> statistica = new ArrayList<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, codiceRistorante1);		
			
			ResultSet res = st.executeQuery();			
			
			while (res.next()) {
				Statistica s = new Statistica(res.getDate("data"), res.getInt("totaleAvventori"));
				statistica.add(s);
			}
		
			res.close();			
		    st.close();
		    conn.close();	
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error in insert into prenotazioni", e);
		}	

	return statistica;		
	
	}

 
}



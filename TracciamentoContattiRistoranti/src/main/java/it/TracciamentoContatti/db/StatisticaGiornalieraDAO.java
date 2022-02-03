package it.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import it.TracciamentoContatti.model.Prenotazione;

public class StatisticaGiornalieraDAO {

	public static Integer totaliAvventoriGiornalieri(String codiceRistorante) {
		//TODO imlementare una tabella in cui si visualizza la data e il numero di avventori
		Integer statistica = 0;
		//Date date = Date.valueOf(data);
		Integer codiceRistorante1 = Integer.parseInt(codiceRistorante);
		
		String sql = "SELECT data, COUNT(*) AS totaleAvventori "
				+ "FROM clienti c, sale s, tavoli t, ristoranti r "
				+ "WHERE r.codice = ? "
			//	+ "AND DATA = ? "
				+ "AND c.CodiceTavolo = t.Codice "
				+ "AND t.CodiceSala = s.Codice "
				+ "AND s.CodiceRistorante = r.Codice "
				+ "Group BY data ";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, codiceRistorante1);			
		//	st.setDate(2, date);
			
			ResultSet res = st.executeQuery();			
			res.first();
			statistica = res.getInt("totaleAvventori");
			res.close();			
		    st.close();
		    conn.close();	
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error in insert into prenotazioni", e);
		}	

	return statistica;		
	
	}


//test metodo per statistica giornaliera
public static void main(String[] args) {
	Integer statistica = totaliAvventoriGiornalieri("2");
	System.out.println(statistica);
}
}
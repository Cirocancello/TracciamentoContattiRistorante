package it.TracciamentoContatti.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.toedter.calendar.JDateChooser;

public class SalaDAO {

    public String cercaNomeSala(Integer codice)	{	
    	
		String sql ="SELECT s.Nome "
                  + "FROM prenotazioni p, tavoli t, sale s "				 
                  + "WHERE p.codiceTavolo = t.Codice "
                  + "AND p.codice = ? "
                  + "AND t.CodiceSala = s.Codice ";			
		
		String nomeSala;		
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, codice);
			
			ResultSet res = st.executeQuery();
			res.first();
			nomeSala = res.getString("s.nome");
			//System.out.println("nome della sala in cui è stata effettuata la prenotazione : "+ nomeSala);
			res.close();			
		    st.close();
		    conn.close();
		    
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e);
		}
		return nomeSala;		
		
	}
    
    public String cercaNomeSalaNonPrenotata(Integer tavoloLibero, Integer codiceRistorante) {
    	String nomeSala = null;
    	
    	String sql ="SELECT distinct s.nome "
    			+ "FROM sale s, tavoli t "
    			+ "WHERE s.codice = t.codiceSala "
    			+ "AND s.CodiceRistorante = ? "
    			+ "AND t.codice = ? ";
    	
    	try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, codiceRistorante);
			st.setInt(2, tavoloLibero);
			
			ResultSet res = st.executeQuery();
			res.first();
			nomeSala = res.getString("s.nome");
			//System.out.println("nome della sala in cui è stata effettuata la prenotazione : "+ nomeSala);
			res.close();			
		    st.close();
		    conn.close();
		    
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error in cerca codice tavolo prenotato", e);
		}
    	
    	
		return nomeSala;
    	
    }
}

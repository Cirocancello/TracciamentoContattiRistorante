package it.TracciamentoContatti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.toedter.calendar.JDateChooser;

public class SalaDAO {

	/**
	 * il metodo permette di ricercare il nome di una sala di un ristorante in cui è presente una prenotazione
	 * @param codice    codice del ristorante a cui appartiene la sala
	 * @return ritorna il nome della sala
	 */
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
    
    /**
     * implementa il metodo per effettuare la ricerca del nome di una sala di un ristorante per cui non 
     * è presente una prenotazione
     * 
     * @param tavoloLibero       codice del tavolo libero disponibile per la tavolata
     * @param codiceRistorante   codice del ristorante in cui i vuole fare la cena
     * @return ritorna il npome della sala
     */
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

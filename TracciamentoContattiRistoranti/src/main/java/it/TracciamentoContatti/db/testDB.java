package it.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.TracciamentoContatti.model.Prenotazione;
import it.TracciamentoContatti.model.Tavolo;

public class testDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 String nomeSala = cercaNomeSalaNonPrenotata(22, 2);
		 System.out.println(nomeSala);
		
		
		LocalDate data = LocalDate.of(2022, 01, 17);
		
		List<Tavolo> tavoliLiberi =	getTavoliDisponibili(2,Date.valueOf(data), 6);
		if(tavoliLiberi.size() > 0) {
			for(Tavolo t : tavoliLiberi) {
		        System.out.println(t.getCodice());
			}
		}else {
			System.out.println("nessun tavolo");
		}
		
		
	}

		private static String cercaNomeSalaNonPrenotata(int tavoloLibero, int codiceRistorante ) {
		
			
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
	
	

		public static List<Tavolo> getTavoliDisponibili(int codiceRistorante, Date data, int numeroPersone) {

			String sql = "SELECT t.* " + "FROM tavoli t " + "INNER JOIN sale s ON t.codiceSala = s.codice "
					+ "INNER JOIN ristoranti r ON s.codiceRistorante  = r.codice "
					+ "WHERE r.Codice = ? AND  t.CapacitaMassima >= ? AND t.codice NOT IN(SELECT p.CodiceTavolo " + "FROM prenotazioni p "				
					+ "INNER JOIN tavoli t ON p.codicetavolo = t.Codice " + "INNER JOIN sale s ON t.codiceSala = s.codice "
					+ "INNER JOIN ristoranti r ON s.codiceRistorante = r.codice " + "WHERE r.codice = ? AND  p.data = ?) "
					+ "ORDER BY t.CapacitaMassima ASC ";
			
			// s.codiceRistorante è il codice che ho messo come parametro
			List<Tavolo> tavoliLiberi = new ArrayList<>();

			try {
				Connection conn = DBConnect.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);

				st.setInt(1, codiceRistorante);
				st.setInt(2, numeroPersone);
				st.setInt(3, codiceRistorante);
				st.setDate(4, data);

				ResultSet res = st.executeQuery();

				while (res.next()) {
					Tavolo t = new Tavolo(res.getInt("codice"), res.getInt("codicesala"), res.getString("nome"),
							res.getInt("CapacitaMassima"));
					tavoliLiberi.add(t);
				}
				res.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("Database error in cerca tavoli liberi", e);
			}
			
			return tavoliLiberi;
		}
	}



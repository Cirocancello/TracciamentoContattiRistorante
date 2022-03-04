package it.TracciamentoContatti.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import it.TracciamentoContatti.Prenotazione;
import it.TracciamentoContatti.Tavolo;

public class PrenotazioniDAO {
	
	/**
	 * creo una nuova prenotazione inserendo il codice del ristorante scelto ed i dati del cliente che vuole 
	 * prenotare, il metodo mi restituisce il codice della prenotazione registrata, altrimenti il messaggio 
	 * ' nessun tavolo disponibile' 
	 * 
	 * @param codiceRistorante
	 * @param cognome
	 * @param nome
	 * @param telefono
	 * @param numeroPersone
	 * @param data
	 * 
	 * @return il metodo ritorna il codice della eventuale prenotazione registrata
	 */
	public Integer creaPrenotazione(Integer codiceTavoloDisponibile, String cognome, String nome, String telefono, Integer numeroPersone,
			Date data) {

		Integer codicePrenotazione = 0;
		
			String sql = "INSERT INTO prenotazioni (CodiceTavolo, Cognome, Nome, Telefono, NumeroPersone, DATA) VALUES ( ?, ?, ?, ?, ? ,?) ";

			try {
				Connection conn = DBConnect.getConnection();
				PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				st.setInt(1, codiceTavoloDisponibile);
				st.setString(2, cognome);
				st.setString(3, nome);
				st.setString(4, telefono);
				st.setInt(5, numeroPersone);
				st.setDate(6, data);

				st.executeUpdate();
				try (ResultSet generatedKeys = st.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						codicePrenotazione = generatedKeys.getInt(1);
					} else {
						throw new SQLException("errore nella creazione della prenotazione");
					}
				}
				st.close();
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("Database error in insert into prenotazioni", e);
			}	

		return codicePrenotazione;
	}
		



	/**
	 * recupero le informazioni della prenotazione per registrare i clienti al momento che si presentano al ristorante
	 * e visualizzo nome, cognome, telefono, numero delle persone prenotate
	 * la ricerca avviene fornanedo la data della prenotazione ed il cognome con cui il cliente si è registrato
	 * 
	 * @param codicePrenotazione
	 * 
	 * @return ritorna le informazioni della prenotazione
	 */
	public List<Prenotazione> cercaPrenotazione(String theData, String cognome) {		
		
		String sql ="SELECT * "
				+ "FROM prenotazioni "
		        + "WHERE data = ? "
				+ "AND cognome = ? ";
		
		List<Prenotazione> prenotazione = new ArrayList<>();
		Date data = Date.valueOf(theData);
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setDate(1, data);
			st.setString(2, cognome);
			
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Prenotazione p = new Prenotazione(res.getInt("codice"),res.getInt("codicetavolo"), res.getString("cognome"), res.getString("nome"), 
						res.getString("telefono"),res.getInt("numeroPersone"), res.getDate("data"));
				prenotazione.add(p);
			}					
				
			res.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Database error in cerca codice tavolo prenotato", e);
		}	
		
		return prenotazione;
	}		
			

    
    
    
    
}
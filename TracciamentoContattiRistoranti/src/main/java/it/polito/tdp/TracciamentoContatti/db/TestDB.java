package it.polito.tdp.TracciamentoContatti.db;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import it.polito.tdp.TracciamentoContatti.model.Cliente;
import it.polito.tdp.TracciamentoContatti.model.Ristorante;
import it.polito.tdp.TracciamentoContatti.model.Sala;
import it.polito.tdp.TracciamentoContatti.model.Tavolo;

	public class TestDB {
		public static void main(String[] args) {			
		
//			RistoranteDAO dao = new RistoranteDAO();
	
//			List<Ristorante> ristoranti = dao.readRistoranti() ;
//	
//			for(Ristorante risto: ristoranti) {		
//				System.out.println(risto);
//			}
			
			// trovo il codice del ristorante in cui voglio prenotare
			StcrDAO dao = new StcrDAO();
			
			String cartaIdentita = "AC675CA";	
			LocalDate data = LocalDate.of(2022, 01, 17);
			
			List<Cliente> clientidaContattare =  dao.tracciaContatti(cartaIdentita, Date.valueOf(data)); // passare anche la data come pararmetro
			
			for(Cliente c : clientidaContattare) {
				System.out.println(c.getNome()+" "+c.getCognome()+" "+c.getTelefono());
			}
			
			int codiceRistorante = dao.getCodiceRistorante("La figlia del marinaio");
			
			System.out.println(codiceRistorante);
			
			//cerco tavoli liberi nel ristorante selezioneto e li stampo
			LocalDate data1 = LocalDate.of(2022, 01, 18);
			List<Tavolo> tavoliLiberi = dao.cercaTavoli(codiceRistorante, Date.valueOf(data1));
			for(Tavolo tav : tavoliLiberi) {
				System.out.println(tav);
			}
				
			
		//LocalDate data1 = LocalDate.of(2022, 01, 18); creo oggetto data e con valueof la converto nel formato sql
			//Date.valueOf(data);
	
			
		// int codicePrenotazione = dao.prenotazione(dao, "La figlia del marinaio","Grinaldi", "Salvatore", "3463474887", 4, Date.valueOf(data1));
		// System.out.println(codicePrenotazione);			
		//	int codicePrenotazione = 25;// la devo togliere perche la ricavo prima
		   // dao.inserisciClienti(codicePrenotazione, "Cancello", "Luca", "CL123LC", "3563652556",  Date.valueOf(data));
		   // dao.inserisciClienti(codicePrenotazione, "Cancello", "Vincenzo", "CV587VC", "3563652556",  Date.valueOf(data));
		   // dao.inserisciClienti(codicePrenotazione, "Cancello", "Nadia", "CN123NC", "3563652556",  Date.valueOf(data));
		    
		}	
		
	
}

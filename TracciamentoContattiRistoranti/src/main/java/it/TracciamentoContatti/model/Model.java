package it.TracciamentoContatti.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextField;

import java.sql.Date;

import it.TracciamentoContatti.db.ClienteDAO;
import it.TracciamentoContatti.db.PrenotazioniDAO;
import it.TracciamentoContatti.db.RistoranteDAO;
import it.TracciamentoContatti.db.TracciaContattiDAO;
import it.TracciamentoContatti.model.Cliente;
import it.TracciamentoContatti.model.Prenotazione;
import it.TracciamentoContatti.model.Ristorante;
import it.TracciamentoContatti.model.Sala;
import it.TracciamentoContatti.model.Tavolo;

	public class Model {
		
//		public void stampa() {
//			System.out.println("Sono il model");
//		}		
		
		public List<Ristorante> getRistoranti() {
			
			RistoranteDAO ristoranteDao = new RistoranteDAO();
			
			// visualizzo le informazioni sui ristoranti
			List<Ristorante> ristoranti = ristoranteDao.getRistoranti() ;
			
			return ristoranti;
		
		}
		
		public  List<Cliente> tracciaContatti(String cartaIdentita, Date data) {
			
			TracciaContattiDAO tracciaContattiDao = new TracciaContattiDAO();			
			
			
			//traccia contatti in caso di contagio simulando uno scenario di contagio
			List<Cliente> clientidaContattare =  tracciaContattiDao.tracciaContatti(cartaIdentita, data); // passare anche la data come pararmetro

			
			return clientidaContattare;
			
			
		}
		
		
		public Integer getTavoliDisponibili(Integer codiceRistorante, Date data, Integer numeroPersone) {
			//___________________________Cerco eventuali tavoli disponibili
			PrenotazioniDAO prenotazioneDao = new PrenotazioniDAO();
			
			List<Tavolo> tavoliLiberi = prenotazioneDao.getTavoliDisponibili(codiceRistorante, data, numeroPersone);
			
			Integer codiceTavoloDisponibile = null;
			
			if (tavoliLiberi.size() > 0) {
				codiceTavoloDisponibile = tavoliLiberi.get(0).getCodice();
			
			} else {
			    System.out.println("Tavolo non disponibile");
		    }
			
			return codiceTavoloDisponibile;
		}
		
		
	
		public static void main(String[] args) {				
		
			RistoranteDAO ristoranteDao = new RistoranteDAO();
	
			// visualizzo le informazioni sui ristoranti
			List<Ristorante> ristoranti = ristoranteDao.getRistoranti() ;		
		
			for(Ristorante risto:ristoranti) {
				System.out.println(risto);
			}
			
			
			TracciaContattiDAO tracciaContattiDao = new TracciaContattiDAO();
			
		
			String cartaIdentita1 = "AC675CA";	
			LocalDate data = LocalDate.of(2022, 01, 17);
			
			//traccia contatti in caso di contagio simulando uno scenario di contagio
			List<Cliente> clientidaContattare =  tracciaContattiDao.tracciaContatti(cartaIdentita1, Date.valueOf(data)); // passare anche la data come pararmetro
			
			System.out.println("clienti da contattare");
			for(Cliente c : clientidaContattare) {
				System.out.println(c.getNome()+" "+c.getCognome()+" "+c.getTelefono());
			}
			
			// trovo il codice del ristorante in cui voglio prenotare
			int codiceRistorante = ristoranteDao.getCodiceRistorante("La figlia del marinaio");
			
			System.out.println(codiceRistorante);
			
			//LocalDate data1 = LocalDate.of(2022, 01, 18); creo oggetto data e con valueof la converto nel formato sql
			//Date.valueOf(data);
	
		    //effettuo una prenotazione e ricavo il relativo codice assegnato 
	        //il codice del ristorante lo devo passare come parametro, dall' interfccia grafica 
	         
			PrenotazioniDAO prenotazioneDao = new PrenotazioniDAO();
			LocalDate data1 = LocalDate.of(2022, 01, 21);
	        //scelgo il ristorante recupero il codice invocando il metodi getCodiceRistorante e il cognome, nome, ecc....		
		    int codicePrenotazione = prenotazioneDao.creaPrenotazione(1,2,"Cancello", "Ciro", "3463474887", 1, Date.valueOf(data1));
	
			
			//cerco tavoli liberi nel ristorante selezioneto e li stampo
			LocalDate data2 = LocalDate.of(2022, 01, 21);
			List<Tavolo> tavoliLiberi = prenotazioneDao.getTavoliDisponibili(codiceRistorante, Date.valueOf(data1), 4);
		
			System.out.println("Tavoli liberi");
			for(Tavolo tav : tavoliLiberi) {
				System.out.println(tav);
			}
			
			//visualizzo le informazioni di una prenotazione 
			//visualizzo il nome della sala in cui è stata registrata la prenotazione  
			
			
			List<Prenotazione> prenotazione = prenotazioneDao.cercaPrenotazione(1);
			
			for(Prenotazione p : prenotazione) {
				System.out.println(p);
				
				//System.out.println(p.getNumeroPersone());
			}
			// inserisci la tavolata aggiungendo i clienti che forniscono i loro dati anagrafici e tel
			// invoco il metodo inserisciClienti
			ClienteDAO clienteDao = new ClienteDAO();
			
			int codiceTavoloPrenotato = 4;// l' ho visualizzato dal metodo precedente
			
			String cognome = "Cancello";
			String nome = "Ciro";
			String cartaIdentita = "CC999CC";
			String telefono = "3463356044";
			
			clienteDao.inserisciCliente(codiceTavoloPrenotato, cognome, nome, cartaIdentita, telefono,  Date.valueOf(data1));
			
			//se la tavolata non è stata prenotata, devo trovare eventuali tavoli liberi
			//invocando il metodo getTavoliDisponibili e nel caso aggiungere i clienti
			
					
			
			
			
			
		}


				
			 
			
		//________________________________________________________________________	
			
			//System.out.println(codicePrenotazione);	
		   
			//recupero il numero di persone da prenotazioni
			//int codicePrenotazione = 1;// la devo togliere perche la ricavo prima
	    	//int numeroPersone = dao.cercaNumeroPersone(codicePrenotazione); 
		//	System.out.println(numeroPersone);
		    // recupero il codice del tavolo assegnato
		//	int codiceTavoloPrenotato = dao.cercaCodiceTavoloPrenotato(codicePrenotazione); 	
//		//	System.out.println(codicePrenotazione+ " "+ numeroPersone+ " " +codiceTavoloPrenotato);
//			
//			
//			
//			Scanner input = new Scanner(System.in);
//			
//			int cont = 1;
//			System.out.println("clienti da inserire "+numeroPersone);
//			
//			while  (numeroPersone > 0) {
//				
//				System.out.println("Inserisci il cliente n.ro "+ cont);
//				
//				System.out.print("cognome " );
//				cognome = input.nextLine();
//				System.out.print("nome " );
//				nome = input.nextLine();
//				System.out.print("carta identita " );
//				cartaIdentita = input.nextLine();
//				System.out.print("telefono " );
//				telefono = input.nextLine();				
//				dao.inserisciCliente(codiceTavoloPrenotato, cognome, nome, cartaIdentita, telefono,  Date.valueOf(data1));
//				
//				numeroPersone--;
//				cont++;
		//	}
//			System.out.println("Tavolata completata, buon apetito");
			//dao.inserisciCliente(codicePrenotazione, "Cancello", "Ciro", "CC589CC", "3463474887",  Date.valueOf(data1));
		   // dao.cliente(codicePrenotazione, "Cancello", "Luca", "CL123LC", "3563652556",  Date.valueOf(data1));
		   // dao.cliente(codicePrenotazione, "Cancello", "Vincenzo", "CV587VC", "3563652556",  Date.valueOf(data1));
		   // dao.cliente(codicePrenotazione, "Cancello", "Giovanni", "GN123GC", "3545898856",  Date.valueOf(data1));
		    
				
	
}

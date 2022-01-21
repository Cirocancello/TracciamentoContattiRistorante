package it.polito.tdp.TracciamentoContatti.db;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
			LocalDate data1 = LocalDate.of(2022, 01, 21);
			List<Tavolo> tavoliLiberi = dao.getTavoliDisponibili(codiceRistorante, Date.valueOf(data1),4);
			for(Tavolo tav : tavoliLiberi) {
				System.out.println(tav);
			}
				
			
		//LocalDate data1 = LocalDate.of(2022, 01, 18); creo oggetto data e con valueof la converto nel formato sql
			//Date.valueOf(data);
	
		//effettuo una prenotazione e ricavo il relativo codice assegnato 	
		    int codicePrenotazione = dao.creaPrenotazione(2,"Cancello", "Ciro", "3463474887", 4, Date.valueOf(data1));
		// System.out.println(codicePrenotazione);			
//			int codicePrenotazione = 26;// la devo togliere perche la ricavo prima
//			int numeroPersone = dao.cercaNumeroPersone(codicePrenotazione); // recupero il codice del tavolo 
//			int codicet = dao.cercaCodiceTavoloPrenotato(codicePrenotazione); //recupero il numero del tavolo assegnato	
//			System.out.println(codicePrenotazione+ " "+ numeroPersone+ " " +codicet);
//			
//			String cognome = null;
//			String nome = null;
//			String cartaIdentita1 = null;
//			String telefono = null;
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
//				dao.inserisciCliente(codicet, cognome, nome, cartaIdentita, telefono,  Date.valueOf(data1));
//				
//				numeroPersone--;
//				cont++;
//			}
//			System.out.println("Tavolata completata, buon apetito");
			//dao.inserisciCliente(codicePrenotazione, "Cancello", "Ciro", "CC589CC", "3463474887",  Date.valueOf(data1));
		   // dao.cliente(codicePrenotazione, "Cancello", "Luca", "CL123LC", "3563652556",  Date.valueOf(data1));
		   // dao.cliente(codicePrenotazione, "Cancello", "Vincenzo", "CV587VC", "3563652556",  Date.valueOf(data1));
		   // dao.cliente(codicePrenotazione, "Cancello", "Giovanni", "GN123GC", "3545898856",  Date.valueOf(data1));
		    
		}	
		
	
}

package it.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import java.sql.Date;

import it.TracciamentoContatti.db.ClienteDAO;
import it.TracciamentoContatti.db.PrenotazioniDAO;
import it.TracciamentoContatti.db.RistoranteDAO;
import it.TracciamentoContatti.db.SalaDAO;
import it.TracciamentoContatti.db.StatisticaGiornalieraDAO;
import it.TracciamentoContatti.db.StatisticaMensileDAO;
import it.TracciamentoContatti.db.TavoliDAO;
import it.TracciamentoContatti.db.TracciaContattiDAO;
import it.TracciamentoContatti.db.loginDAO;
import it.TracciamentoContatti.model.Cliente;
import it.TracciamentoContatti.model.Prenotazione;
import it.TracciamentoContatti.model.Ristorante;
import it.TracciamentoContatti.model.Sala;
import it.TracciamentoContatti.model.Tavolo;
import it.TracciamentoContatti.model.Statistica;

	public class Model {	
		
		public List<Ristorante> getRistoranti() {
			
			RistoranteDAO ristoranteDao = new RistoranteDAO();
			
			// visualizzo le informazioni sui ristoranti
			List<Ristorante> ristoranti = ristoranteDao.getRistoranti() ;
			
			return ristoranti;
		
		}
		
		public  List<Cliente> tracciaContatti(String cartaIdentita, String data) {
			
			TracciaContattiDAO tracciaContattiDao = new TracciaContattiDAO();			
			
			
			//traccia contatti in caso di contagio simulando uno scenario di contagio
			List<Cliente> clientidaContattare =  tracciaContattiDao.tracciaContatti(cartaIdentita, data); // passare anche la data come pararmetro

			
			return clientidaContattare;
			
			
		}
		
		
		public List<Tavolo> getTavoloDisponibile(Integer codiceRistorante, Date data, Integer numeroPersone) {
			//___________________________Cerco eventuali tavoli disponibili
			TavoliDAO tavoliDao = new TavoliDAO();
			
			List<Tavolo> tavoliLiberi = tavoliDao.getTavoloDisponibile(codiceRistorante, data, numeroPersone);	
			
			//return codiceTavoloDisponibile;
			return tavoliLiberi;
		}
		
		
		
		public Integer creaPrenotazione(Integer codiceTavoloDisponibile, String cognome,
				                     String nome, String telefono, Integer numeroPersone, Date data) {
		
			PrenotazioniDAO prenotazioneDao = new PrenotazioniDAO();
			Integer codicePrenotazione = prenotazioneDao.creaPrenotazione(codiceTavoloDisponibile, cognome, nome, telefono, numeroPersone, data);
			
			return codicePrenotazione;
		}
		
		
		public void InserisciCliente(Integer codiceTavoloPrenotato, String cognome, String nome, String cartaIdentita, String telefono, Date data) {
			
			ClienteDAO clienteDao = new ClienteDAO();			
				
			clienteDao.inserisciCliente(codiceTavoloPrenotato, cognome, nome, cartaIdentita, telefono, data);
			
			
		}
		
		
		public List<Prenotazione> cercaPrenotazione(String data, String cognome) {
			
			PrenotazioniDAO prenotazioneDao = new PrenotazioniDAO();
			List<Prenotazione> prenotazione = prenotazioneDao.cercaPrenotazione(data, cognome);
			
			return prenotazione;
		}
		
		
		
		public String cercaNomeSala(Integer codice) {
			
			SalaDAO saleDao = new SalaDAO();
			
			String nomeSala = saleDao.cercaNomeSala(codice);
			
			return nomeSala;
			
		}
		
		public String cercaNomeSalaNonPrenotata(Integer tavoloLibero, Integer codiceRistorante) {
			
			SalaDAO saleDao = new SalaDAO();
			
			String nomeSala = saleDao.cercaNomeSalaNonPrenotata(tavoloLibero, codiceRistorante);
			
			return nomeSala;
		}

		public List<Statistica> statisticaGiornaliera(String codiceRistorante) {
			
			
			StatisticaGiornalieraDAO  statiscticaGiornalieraDao = new StatisticaGiornalieraDAO();
			
			List<Statistica> statistica = statiscticaGiornalieraDao.totaliAvventoriGiornalieri(codiceRistorante);
					
			
			return statistica;
		     
			
		}

		public List<Statistica> statisticaMensile(String codiceRistorante) {
			StatisticaMensileDAO  statiscticaMensileDao = new StatisticaMensileDAO();
			
			List<Statistica> statistica = statiscticaMensileDao.totaliAvventoriGiornalieri(codiceRistorante);
					
			
			return statistica;
		     
		}

		public Integer login(String userName, String password) {
			
			Integer codiceLogin = loginDAO.login(userName, password);
			
			return codiceLogin;
			
			
		}
	
}
	

		



		


				
			 
			

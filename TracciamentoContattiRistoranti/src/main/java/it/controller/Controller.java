package it.controller;


import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import it.TracciamentoContatti.Cliente;
import it.TracciamentoContatti.Persona;
import it.TracciamentoContatti.Prenotazione;
import it.TracciamentoContatti.Ristorante;
import it.TracciamentoContatti.Statistica;
import it.TracciamentoContatti.Tavolo;
import it.TracciamentoContatti.dao.ClienteDAO;
import it.TracciamentoContatti.dao.PrenotazioniDAO;
import it.TracciamentoContatti.dao.RistoranteDAO;
import it.TracciamentoContatti.dao.SalaDAO;
import it.TracciamentoContatti.dao.StatisticaGiornalieraDAO;
import it.TracciamentoContatti.dao.StatisticaMensileDAO;
import it.TracciamentoContatti.dao.TavoliDAO;
import it.TracciamentoContatti.dao.TracciaContattiDAO;
import it.TracciamentoContatti.dao.loginDAO;
import it.TracciamentoContatti.view.HomePageView;
import it.TracciamentoContatti.view.LoginPageView;
import it.TracciamentoContatti.view.PrenotazioneView;
import it.TracciamentoContatti.view.StatisticaGiornalieraView;
import it.TracciamentoContatti.view.StatisticaMensileView;
import it.TracciamentoContatti.view.TavolataNonPrenotataView;
import it.TracciamentoContatti.view.TavolataPrenotataView;
import it.TracciamentoContatti.view.TracciaContattiView;


public class Controller {
	
	private LoginPageView login;
	private HomePageView frame;
	private Integer codiceLogin;
	private TracciaContattiView tracciaContatti ;
	private RistoranteDAO ristoranteDao;
	private TavolataPrenotataView tavolataPrenotataView;
	private PrenotazioneView prenotazioneView;
	private TavolataNonPrenotataView tavolataNonPrenotataView;
	private StatisticaGiornalieraView statiscticaGiornaliera;
	private StatisticaMensileView statisticaMensile;
	private PrenotazioniDAO prenotazioneDao;
	private Integer codicePrenotazione;
	private TracciaContattiDAO tracciaContattiDao;
	private ClienteDAO clienteDao;
	private SalaDAO saleDao;
	private String nomeSala;
	private TavoliDAO tavoliDao;
	private StatisticaGiornalieraDAO statiscticaGiornalieraDao;
	private StatisticaMensileDAO statiscticaMensileDao ;
	
	
	public Controller() {
		
	}
	
	/**
	 * Creo La finestra login e la rendo visibile
	 */
	public void creaLogin() {
		login = new LoginPageView();
		login.setResizable(false);
		login.setVisible(true);	
		
	}
	
	/** 
	 * controllo i dati di accesso userName e password se corretti apro la HomePageView
	 * @param userName   credenziali forniti in ingresso
	 * @param password   password fornita in ingresso
	 */
	public void login(String userName, String password, LoginPageView login) {
	
		codiceLogin = loginDAO.login(userName, password);		
		
		if(codiceLogin != null) {
		
	        frame = new HomePageView();	
	        login.setVisible(false);
	        frame.setResizable(false);
	        frame.setVisible(true);		     
	       
		}else {
	        
			JOptionPane.showMessageDialog(null,  "Username o Password errati o non presenti in base dati!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	/**
	 * imolementazione dele funzioni per una prenotazione
	 * @param e
	 * @param home
	 */
	public void actionPrenota(ActionEvent e , HomePageView home) {		
        
		ristoranteDao = new RistoranteDAO();
		home.setVisible(false);
		// visualizzo le informazioni sui ristoranti
		List<Ristorante> ristoranti = ristoranteDao.getRistoranti();		
			
		prenotazioneView = new PrenotazioneView(ristoranti);	

	}
	
	/**
	 * implementazione delle funziamalit?? per una tavolata non prenotata
	 * @param e
	 * @param home
	 */
	public void actionTavolataNonPrenotata(ActionEvent e, HomePageView home) {
		ristoranteDao = new RistoranteDAO();
		//recupero le informazioni sui ristoranti
		List<Ristorante> ristoranti = ristoranteDao.getRistoranti();	
		//creo la finestra relativa e la rendo visibile
		tavolataNonPrenotataView = new TavolataNonPrenotataView(ristoranti);
		home.setVisible(false);
	}
	
    /**
     * 
     * implementazione delle funzionalit?? per una tavolata di cui ?? presente una prenotazione
     * @param e
     * @param home
     */
	public void actionTavolataPrenotata(ActionEvent e, HomePageView home) {
		
		//creo la relativa finestra e la rendo visibile
		tavolataPrenotataView = new TavolataPrenotataView();
		home.setVisible(false);
	}
	
	/**
	 * iplementazione delle funzionalit?? per il tracciamento dei contatti
	 * @param e
	 * @param home
	 */
	public void actionTracciaContatti(ActionEvent e, HomePageView home) {
		// creo la relativa finestra e la rndo visibile
		tracciaContatti = new TracciaContattiView();
		home.setVisible(false);
	}
	
	
	/**
	 * implementazione delle funzionalit?? per una statistica giornaliera
	 * @param e
	 * @param home
	 */
	public void actionStatisticaGiornaliera(ActionEvent e, HomePageView home) {
		//creo la relativa finestra e la rendo visibile
		statiscticaGiornaliera = new StatisticaGiornalieraView();
		home.setVisible(false);
	}
	
	/**
	 * implementazione delle funzionalit?? per una statistica mensile
	 * @param e
	 * @param home
	 */
	public void actionStatisticaMensile(ActionEvent e, HomePageView home) {
		//creo la relativa finestra e la rendo visibile
		statisticaMensile = new StatisticaMensileView();
		home.setVisible(false);
	}

	/**
	 * implementazione delle funzionalit?? per effettuare una prenotazione
	 * @param prenotazione
	 * @param textCodiceRistorante
	 */
	public void effettuaPrenotazione(Prenotazione prenotazione, JTextField textCodiceRistorante) {
	
		Integer codiceRistorante = Integer.parseInt(textCodiceRistorante.getText());
		String cognome = prenotazione.getCognome();
		String nome = prenotazione.getNome();
		String telefono = prenotazione.getTelefono();
		Integer numeroPersone = prenotazione.getNumeroPersone();
	    Date data =  prenotazione.getData();
	    
	    //cerco i tavoli liberi
		List<Tavolo> tavoliLiberi = getTavoloDisponibile(codiceRistorante, data, numeroPersone);
		
		if(tavoliLiberi.size()>0) {
            Integer codiceTavoloDisponibile = tavoliLiberi.get(0).getCodice();	
		
		   //scelgo il ristorante recupero il codice invocando il metodi getCodiceRistorante e il cognome, nome, ecc....		
	       Integer codicePrenotazione = creaPrenotazione(codiceTavoloDisponibile, cognome, nome, telefono, numeroPersone, data);
	       //prenotazione effettuata
	       JOptionPane.showMessageDialog(null, "Tavolo prenotato per il : "+data
	    		   +"\ncodice prenotazione "+codicePrenotazione
	    		   +"\ncodice tavolo assegnato "+codiceTavoloDisponibile, "Prenotazione effettuata!!!", JOptionPane.INFORMATION_MESSAGE);

		}else {
			//tavolo non disponibile per quel giorno
			JOptionPane.showMessageDialog(null,  "Tavolo non disponibile per quel giorno", "Attenzione!!!", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// cerco la prenotazione in base dati
	public Integer creaPrenotazione(Integer codiceTavoloDisponibile, String cognome,
         String nome, String telefono, Integer numeroPersone, Date data) {

         prenotazioneDao = new PrenotazioniDAO();
         codicePrenotazione = prenotazioneDao.creaPrenotazione(codiceTavoloDisponibile, cognome, nome, telefono, numeroPersone, data);

        return codicePrenotazione;
	}
	//visualizzo iristoranti presenti in base dati
	public void stampaRistoranti(TextArea textAreaRistoranti) {
		
		ristoranteDao = new RistoranteDAO();
		List<Ristorante> ristoranti = ristoranteDao.getRistoranti();
		
		for(Ristorante risto:ristoranti) {
			textAreaRistoranti.append(risto.getCodice()+" ");
			textAreaRistoranti.append(risto.getNome()+" ");
			textAreaRistoranti.append(risto.getCitta()+" ");			
			textAreaRistoranti.append(risto.getIndirizzo()+" ");
			textAreaRistoranti.append(risto.getProvincia()+" ");
			textAreaRistoranti.append(risto.getTelefono()+"\n");			
			
		}
		
	}
	
	/**
	 * il metodo effettua il tracciamento di contatti in caso di positivit??
	 * 
	 * @param cartaIdentita     carta di identit?? del contagiato
	 * @param data				data della tavolata
	 * @param textAreaTraccia
	 * @throws IOException
	 */
	public void tracciaContatti(String cartaIdentita, String data, TextArea textAreaTraccia) throws IOException {
			
		tracciaContattiDao = new TracciaContattiDAO();			
			
		//traccia contatti in caso di contagio simulando uno scenario di contagio
		List<Persona> personeDaContattare =  tracciaContattiDao.tracciaContatti(cartaIdentita, data); // passare anche la data come pararmetro
		
		setPeroneDaContattare(personeDaContattare, textAreaTraccia);

	}
	
	/**
	 * visualizzazione delle persone da cointattare
	 * 
	 * @param personeDaContattare
	 * @param textAreaTraccia
	 */
	public void setPeroneDaContattare(List<Persona> personeDaContattare,TextArea textAreaTraccia){
		if(personeDaContattare.size() > 0) {
			
		  	   for (Persona p : personeDaContattare) {		
				   textAreaTraccia.append(p.getNome()+" ");
				   textAreaTraccia.append(p.getCognome()+" ");
				   textAreaTraccia.append(p.getTelefono()+" ");
				   textAreaTraccia.append("\t"+"("+p.getTipo()+")"+"\n");
			   }
			}else {
				JOptionPane.showMessageDialog(null,  "Nessuna tavolata presente in quel giorno", "Attenzione!!!", JOptionPane.INFORMATION_MESSAGE);
				
			}
	}

	/**
	 * il metodo effettua l' inserimento in base dati di un nuovo cliente
	 * @param cliente                 generalita di un cliente
	 * @param textAreaClientiInseriti
	 */
	public void inserisciCliente(Cliente cliente, TextArea textAreaClientiInseriti) {
		
		clienteDao = new ClienteDAO();					
		
		Integer codiceTavoloPrenotato = cliente.getCodiceTavolo();
		String cognome = cliente.getCognome();
		String nome = cliente.getNome();
		String cartaIdentita = cliente.getNumeroCartaIdentita();
		String telefono = cliente.getTelefono();
		Date data = cliente.getData();		
		
		clienteDao.inserisciCliente(codiceTavoloPrenotato, cognome, nome, cartaIdentita, telefono, data);
					
	
		textAreaClientiInseriti.append(cliente.getNome()+" ");
		textAreaClientiInseriti.append(cliente.getCognome()+" ");
		textAreaClientiInseriti.append(cliente.getTelefono()+" ");
		textAreaClientiInseriti.append(cliente.getNumeroCartaIdentita()+"\n");			
		
	}
   
	/**
	 * il metodo effettua la ricerca di una prenotazione
	 * @param data					data della prenotazione
	 * @param cognome				cognome del cliente che ha effettuato la prenotazione
	 * @param textAreaPrenotazione
	 */
	public void cercaPrenotazione(String data, String cognome,TextArea textAreaPrenotazione) {
          
		prenotazioneDao = new PrenotazioniDAO();
		List<Prenotazione> prenotazione = prenotazioneDao.cercaPrenotazione(data, cognome);
		
		if(prenotazione.size() > 0) {
				
		    for(Prenotazione p : prenotazione) {
		    	Integer codice = p.getCodice();
		    	String nomeSala = cercaNomeSala(codice);
		    	textAreaPrenotazione.append("Codice prenotazione "+p.getCodice()+"\n");
			    textAreaPrenotazione.append("Prenotazione a nome di \n"+p.getCognome()+" ");
			    textAreaPrenotazione.append(p.getNome()+" - ");
			    textAreaPrenotazione.append("tel : "+p.getTelefono()+" - ");
			    textAreaPrenotazione.append("n.ro persone prenotate "+p.getNumeroPersone()+" - ");
			    textAreaPrenotazione.append("in data "+ p.getData()+"\n");
			    textAreaPrenotazione.append("tavolo prenotato "+p.getCodiceTavolo() +"\n");
			    textAreaPrenotazione.append("Sala prenotata : "+ nomeSala);
		
		   }
		}else {
			JOptionPane.showMessageDialog(null,  "prenotazione non presente in base dati!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

		}
		
	}
	
	/**
	 * ricerca del nome della sala del ristorante in cui ?? presente una prenotazione
	 * @param codice
	 * @return
	 */
	public String cercaNomeSala(Integer codice) {
		
		saleDao = new SalaDAO();
		
		nomeSala = saleDao.cercaNomeSala(codice);
		
		return nomeSala;
		
	}

	/**
	 * ricerca di un tavolo libero
	 * @param e
	 * @param textCodiceRistorante
	 * @param dateChooser
	 * @param textNumeroPersone
	 * @param textAreaClienti
	 * @param textArea
	 */
	public void cercaTavoloLibero(ActionEvent e, JTextField textCodiceRistorante, JDateChooser dateChooser, JTextField textNumeroPersone
								 ,TextArea textAreaClienti, JTextArea textArea) {
		
		
		Integer codiceRistorante = Integer.parseInt(textCodiceRistorante.getText());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String theDate = dateFormat.format(dateChooser.getDate());	
		
		Date data = Date.valueOf(theDate);
		Integer numeroPersone = Integer.parseInt(textNumeroPersone.getText());
		
		if(numeroPersone > 6) {
			JOptionPane.showMessageDialog(null,  "numero di persone deve essere al pi?? 6 ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			return;
		}
		//cerco il primo tavolo disponibile
		List<Tavolo> tavoliLiberi = getTavoloDisponibile(codiceRistorante, data, numeroPersone);
		if(tavoliLiberi.size() > 0) {
		   Integer tavoloLibero = tavoliLiberi.get(0).getCodice();		  		
		  
		   if(tavoloLibero != null) {
			   //visualizzo il messaggio del tavolo libero con il suo codice e il nome della sala
			   String nomeSala = cercaNomeSalaNonPrenotata(tavoloLibero, codiceRistorante);
//			   textArea.append("tavolo disponibile "+ Integer.toString(tavoloLibero) + "\n");
//			   textArea.append("nome della sala "+ nomeSala);
			   setVisualizzaTavoloLiberoSala(tavoloLibero,nomeSala,textArea);
		    }
		}
		else {
     	    //tavolo non disponibile per quel giorno
			JOptionPane.showMessageDialog(null,  "nessun tavolo disponibile ", "Attenzione!!!", JOptionPane.INFORMATION_MESSAGE);
		} 
			
	}
	/*
	 * ricerca del nome della sala di un ristorante in cui non ?? presente una prenotazione
	 */
	public String cercaNomeSalaNonPrenotata(Integer tavoloLibero, Integer codiceRistorante) {
		
		saleDao = new SalaDAO();
		
		nomeSala = saleDao.cercaNomeSalaNonPrenotata(tavoloLibero, codiceRistorante);
		
		return nomeSala;
	}

	
	/**
	 * ricerca dei tavoli disponibili per una tavolata
	 * @param codiceRistorante   codice del ristorante in cui si vuole cenare
	 * @param data			     data della cena
	 * @param numeroPersone		 numero delle persone che ceneranno
	 * @return
	 */
	public List<Tavolo> getTavoloDisponibile(Integer codiceRistorante, Date data, Integer numeroPersone) {
		//___________________________Cerco eventuali tavoli disponibili
		tavoliDao = new TavoliDAO();
		
		List<Tavolo> tavoliLiberi = tavoliDao.getTavoloDisponibile(codiceRistorante, data, numeroPersone);	
		
		//return codiceTavoloDisponibile;
		return tavoliLiberi;
	}
	
	/**
	 * visualizzo le informazioni sul tavolo libero
	 * @param tavoloLibero
	 * @param nomeSala
	 * @param textArea
	 */
	public void setVisualizzaTavoloLiberoSala(Integer tavoloLibero,String nomeSala,JTextArea textArea) {
		textArea.append("tavolo disponibile "+ Integer.toString(tavoloLibero) + "\n");
		textArea.append("nome della sala "+ nomeSala);
	}
	

	public void statiscticaGiornaliera(String codiceRistorante, TextArea textAreaStatistica) {
		textAreaStatistica.setText("");
	
		List<Statistica> statistica = statisticaGiornaliera(codiceRistorante);		
    	
	    for(Statistica s : statistica) {
	      textAreaStatistica.append("In data " +s.getData()+" ");
	      textAreaStatistica.append("totale avventori "+s.getTotaleAvventori()+"\n");
	    }
			
		
	}

	/**
	 * implementazione della funzionalit?? per la statistca mensile
	 * @param codiceRistorante
	 * @param textAreaStatistica
	 */
	public void statiscticaMensile(String codiceRistorante, TextArea textAreaStatistica) {
		
		textAreaStatistica.setText("");
		
		List<Statistica> statistica = statisticaMensile(codiceRistorante);		
    	String themounth = null;
	    
    	for(Statistica s : statistica) {
	      Integer mese = s.getData().getMonth()+1;
	     
	      switch (mese) {
	         case 1 : themounth = "gennaio";
	         break;
	         
	         case 2 : themounth = "febbraio";
	         break;
	         
	         case 3 : themounth = "marzo";
	         break;
	         
	         case 4 : themounth = "aprile";
	         break;
	         
	         case 5 : themounth = "maggio";
	         break;
	         
	         case 6 : themounth = "giugno";
	         break;
	         
	         case 7 : themounth = "luglio";
	         break;
	         
	         case 8 : themounth = "agosto";
	         break;
	         
	         case 9 : themounth = "settembre";
	         break;
	         
	         case 10 : themounth = "ottobre";
	         break;
	         
	         case 11 : themounth = "novembre";
	         break;
	         
	         case 12 : themounth = "dicembre";
	         break;
	      }
	      textAreaStatistica.append("Nel mese di " +themounth+" ");
	      textAreaStatistica.append("totale avventori "+s.getTotaleAvventori()+"\n");
	    }
	}	
	
	/**
	 * implementazione delle funzionalit?? per la statisrica giornaliera
	 * @param codiceRistorante
	 * @return
	 */
	public List<Statistica> statisticaGiornaliera(String codiceRistorante) {
		
		
		statiscticaGiornalieraDao = new StatisticaGiornalieraDAO();
		
		List<Statistica> statistica = statiscticaGiornalieraDao.totaliAvventoriGiornalieri(codiceRistorante);
				
		
		return statistica;
	     
		
	}

	public List<Statistica> statisticaMensile(String codiceRistorante) {
		statiscticaMensileDao = new StatisticaMensileDAO();
		
		List<Statistica> statistica = statiscticaMensileDao.totaliAvventoriGiornalieri(codiceRistorante);
				
		
		return statistica;
	     
	}

	
}
	
	

	

	
	
	
	
	

	



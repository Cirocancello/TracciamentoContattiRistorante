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

import it.TracciamentoContatti.model.Cliente;
import it.TracciamentoContatti.model.Prenotazione;
import it.TracciamentoContatti.model.Ristorante;
import it.TracciamentoContatti.model.Statistica;
import it.TracciamentoContatti.model.Tavolo;
import it.TracciamentoContatti.view.HomePageView;
import it.TracciamentoContatti.view.PrenotazioneView;
import it.TracciamentoContatti.view.StatisticaGiornalieraView;
import it.TracciamentoContatti.view.StatisticaMensileView;
import it.TracciamentoContatti.view.TavolataNonPrenotataView;
import it.TracciamentoContatti.view.TavolataPrenotataView;
import it.TracciamentoContatti.view.TracciaContattiView;
import it.model.Model;
import javafx.scene.chart.PieChart.Data;
import it.TracciamentoContatti.model.Statistica;


public class Controller {
	
	private HomePageView frame;
	private Model model;
	private PrenotazioneView prenotazioneView;	

	
	public Controller() {
		
	}
	
	public void login(String userName, String password) {
		Model model = new Model();
		
		Integer codiceLogin = null;
		codiceLogin = model.login(userName, password);
		
		if(codiceLogin != null) {
	        HomePageView frame = new HomePageView();					
	
	        frame.setResizable(false);
	        frame.setVisible(true);		

		}else {
	        
			JOptionPane.showMessageDialog(null,  "Username o Password non presenti in base dati!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

		}
	}
	
	
	public void actionPrenota(ActionEvent e) {		
		
			Model model = new Model();
			List<Ristorante> ristoranti = model.getRistoranti();					
			
			PrenotazioneView prenotazioneView = new PrenotazioneView(ristoranti);	

	}
	
	public void actionTavolataNonPrenotata(ActionEvent e) {
		Model model = new Model();
		List<Ristorante> ristoranti = model.getRistoranti();	
		TavolataNonPrenotataView tavolataNonPrenotataView = new TavolataNonPrenotataView();
	}
	

	public void actionTavolataPrenotata(ActionEvent e) {
		Model model = new Model();
		List<Ristorante> ristoranti = model.getRistoranti();	
		TavolataPrenotataView tavolataPrenotataView = new TavolataPrenotataView();
		
	}
	
	public void actionTracciaContatti(ActionEvent e) {
		Model model = new Model();
		List<Ristorante> ristoranti = model.getRistoranti();
		TracciaContattiView tracciaContatti = new TracciaContattiView();
	}
	

	public void actionStatisticaGiornaliera(ActionEvent e) {
		Model model = new Model();
		List<Ristorante> ristoranti = model.getRistoranti();
		StatisticaGiornalieraView statiscticaGiornaliera = new StatisticaGiornalieraView();
		
	}
	

	public void actionStatisticaMensile(ActionEvent e) {
		Model model = new Model();
		List<Ristorante> ristoranti = model.getRistoranti();
		StatisticaMensileView statisticaMensile = new StatisticaMensileView();
		
	}

	public void effettuaPrenotazione(Prenotazione prenotazione, JTextField textCodiceRistorante) {
	
		Model model = new Model();		
	
		Integer codiceRistorante = Integer.parseInt(textCodiceRistorante.getText());
		String cognome = prenotazione.getCognome();
		String nome = prenotazione.getNome();
		String telefono = prenotazione.getTelefono();
		Integer numeroPersone = prenotazione.getNumeroPersone();
	    Date data =  prenotazione.getData(); 
	    
		List<Tavolo> tavoliLiberi = model.getTavoloDisponibile(codiceRistorante, data, numeroPersone);
		
		if(tavoliLiberi.size()>0) {
            Integer codiceTavoloDisponibile = tavoliLiberi.get(0).getCodice();	
		
		   //scelgo il ristorante recupero il codice invocando il metodi getCodiceRistorante e il cognome, nome, ecc....		
	       Integer codicePrenotazione = model.creaPrenotazione(codiceTavoloDisponibile, cognome, nome, telefono, numeroPersone, data);
	       //prenotazione effettuata
	       JOptionPane.showMessageDialog(null, "Tavolo prenotato per il : "+data
	    		   +"\ncodice prenotazione "+codicePrenotazione
	    		   +"\ncodice tavolo assegnato "+codiceTavoloDisponibile, "Prenotazione effettuata!!!", JOptionPane.INFORMATION_MESSAGE);

		}else {
			//tavolo non disponibile per quel giorno
			JOptionPane.showMessageDialog(null,  "Tavolo non disponibile per quel giorno", "Attenzione!!!", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void stampaRistoranti(TextArea textAreaRistoranti) {
		
		Model model = new Model();
		
		List<Ristorante> ristoranti = model.getRistoranti();			
		
		for(Ristorante risto:ristoranti) {
			textAreaRistoranti.append(risto.getCodice()+" ");
			textAreaRistoranti.append(risto.getNome()+" ");
			textAreaRistoranti.append(risto.getCitta()+" ");			
			textAreaRistoranti.append(risto.getIndirizzo()+" ");
			textAreaRistoranti.append(risto.getProvincia()+" ");
			textAreaRistoranti.append(risto.getTelefono()+"\n");			
			
		}
		
	}
	

	public void tracciaContatti(String cartaIdentita, String data, TextArea textAreaTraccia) throws IOException {
		Model model = new Model();		
	
		List<Cliente> clientidaContattare = model.tracciaContatti(cartaIdentita, data); 		
		
		if(clientidaContattare.size() > 0) {
		
	  	   for(Cliente c : clientidaContattare) {			
			   textAreaTraccia.append(c.getNome()+" ");
			   textAreaTraccia.append(c.getCognome()+" ");
			   textAreaTraccia.append(c.getTelefono()+"\n");			
		   }
		}else {
			JOptionPane.showMessageDialog(null,  "Nessuna tavolata presente in quel giorno", "Attenzione!!!", JOptionPane.INFORMATION_MESSAGE);
			
		}
			
		
	}

	public void inserisciCliente(Cliente cliente, TextArea textAreaClientiInseriti) {
		
		Model model = new Model();			
		
		Integer codiceTavoloPrenotato = cliente.getCodiceTavolo();
		String cognome = cliente.getCognome();
		String nome = cliente.getNome();
		String cartaIdentita = cliente.getNumeroCartaIdentita();
		String telefono = cliente.getTelefono();
		Date data = cliente.getData();		
		
		model.InserisciCliente(codiceTavoloPrenotato,cognome,
				               nome,cartaIdentita,telefono,data);		
		
		textAreaClientiInseriti.append(cliente.getNome()+" ");
		textAreaClientiInseriti.append(cliente.getCognome()+" ");
		textAreaClientiInseriti.append(cliente.getTelefono()+" ");
		textAreaClientiInseriti.append(cliente.getNumeroCartaIdentita()+"\n");			
		
	}

	public void cercaPrenotazione(String data, String cognome,TextArea textAreaPrenotazione) {
          
		Model model = new Model();				
		
		List<Prenotazione> prenotazione = model.cercaPrenotazione(data, cognome);
		
		if(prenotazione.size() > 0) {
				
		    for(Prenotazione p : prenotazione) {
		    	Integer codice = p.getCodice();
		    	String nomeSala = model.cercaNomeSala(codice);
		    	textAreaPrenotazione.append("Codcie pernotazione "+p.getCodice()+"\n");
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

	public void cercaTavoloLibero(ActionEvent e, JTextField textCodiceRistorante, JDateChooser dateChooser, JTextField textNumeroPersone
								 ,TextArea textAreaClienti, JTextArea textArea) {
		
		Model model = new Model();
		Integer codiceRistorante = Integer.parseInt(textCodiceRistorante.getText());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String theDate = dateFormat.format(dateChooser.getDate());	
		
		Date data = Date.valueOf(theDate);
		Integer numeroPersone = Integer.parseInt(textNumeroPersone.getText());
		
		if(numeroPersone > 6) {
			JOptionPane.showMessageDialog(null,  "numero di persone deve essere al più 6 ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			return;
		}
		//cerco il primo tavolo disponibile
		List<Tavolo> tavoliLiberi = model.getTavoloDisponibile(codiceRistorante, data, numeroPersone);
		if(tavoliLiberi.size() > 0) {
		   Integer tavoloLibero = tavoliLiberi.get(0).getCodice();
		  		
		   if(tavoloLibero != null) {
			   //visualizzo il messaggio del tavolo libero con il suo codice e il nome della sala
			   String nomeSala = model.cercaNomeSalaNonPrenotata(tavoloLibero, codiceRistorante);
			   textArea.append("tavolo disponibile "+ Integer.toString(tavoloLibero) + "\n");
			   textArea.append("nome della sala "+ nomeSala);
		    }
		}
		else {
     	    //tavolo non disponibile per quel giorno
			JOptionPane.showMessageDialog(null,  "nessun tavolo disponibile ", "Attenzione!!!", JOptionPane.INFORMATION_MESSAGE);
		} 
			
	}

	public void statiscticaGiornaliera(String codiceRistorante, TextArea textAreaStatistica) {
		Model model = new Model();
		
		textAreaStatistica.setText("");
	
		List<Statistica> statistica = model.statisticaGiornaliera(codiceRistorante);		
    	
	    for(Statistica s : statistica) {
	      textAreaStatistica.append("In data " +s.getData()+" ");
	      textAreaStatistica.append("totale avventori "+s.getTotaleAvventori()+"\n");
	    }
			
		
	}

	public void statiscticaMensile(String codiceRistorante, TextArea textAreaStatistica) {
		
		Model model = new Model();
		
		textAreaStatistica.setText("");
		
		List<Statistica> statistica = model.statisticaMensile(codiceRistorante);		
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
	
}
	
	

	

	
	
	
	
	

	



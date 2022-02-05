package it.TracciamentoContatti;

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
import it.TracciamentoContatti.model.Model;
import it.TracciamentoContatti.model.Prenotazione;
import it.TracciamentoContatti.model.Ristorante;
import it.TracciamentoContatti.model.Statistica;
import it.TracciamentoContatti.model.Tavolo;
import javafx.scene.chart.PieChart.Data;
import it.TracciamentoContatti.model.Statistica;


public class Controller {
	
	private HomePageView frame;
	private Model model;
	
	private PrenotazioneView prenotazioneView;
	
	
	public Controller(HomePageView frame, Model model) {
	    this.frame = frame;
	    this.model = model;
	}
	
	public Controller() {
		
	}
	
	
	public void Actionperformed(ActionEvent e) {
		
		if(e.getSource() == frame.btnPrenota) {			
			Model model = new Model();
			List<Ristorante> ristoranti = model.getRistoranti();					
			
			PrenotazioneView prenotazioneView = new PrenotazioneView(ristoranti);	
		}			
		
		if(e.getSource() == frame.btnTracciaContatti) {
			TracciaContattiView tracciaContatti = new TracciaContattiView();
		}
		
		if(e.getSource() == frame.btnNuovoRistorante) {
			StatisticaView ristoranteView = new StatisticaView();
		}
		
		if(e.getSource() == frame.btnTavolataPrenotata) {
			
			TavolataPrenotataView tavolataPrenotataView = new TavolataPrenotataView();
			
		}
		
		if(e.getSource() == frame.btnTavolataNonPrenotata) {
			
			TavolataNonPrenotataView tavolataNonPrenotataView = new TavolataNonPrenotataView();
		}

	}

	public void effettuaPrenotazione(Prenotazione prenotazione, JTextField textCodiceRistorante) {
	
		Model model = new Model();		
	
		Integer codiceRistorante = Integer.parseInt(textCodiceRistorante.getText());
		String cognome = prenotazione.getCognome();
		String nome = prenotazione.getNome();
		String telefono = prenotazione.getTelefono();
		Integer numeroPersone = prenotazione.getNumeroPersone();
	    Date data =  prenotazione.getData(); 
	    
		List<Tavolo> tavoliLiberi = model.getTavoliDisponibili(codiceRistorante, data, numeroPersone);
		
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

	public void StampaRistoranti(TextArea textAreaRistoranti) {
		
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
	

	public void TracciaContatti(String cartaIdentita, String data, TextArea textAreaTraccia) throws IOException {
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
		List<Tavolo> tavoliLiberi = model.getTavoliDisponibili(codiceRistorante, data, numeroPersone);
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
	
		List<Statistica> statistica = model.statisticaGiornaliera(codiceRistorante);		
    	
	    for(Statistica s : statistica) {
	      textAreaStatistica.append("In data " +s.getData()+" ");
	      textAreaStatistica.append("totale avventori "+s.getTotaleAvventori()+"\n");
	    }
			
		
	}

	public void statiscticaMensile(String codiceRistorante, TextArea textAreaStatistica) {
		
		Model model = new Model();
		
		textAreaStatistica.append("");
		
		List<Statistica> statistica = model.statisticaMensile(codiceRistorante);		
    	
	    for(Statistica s : statistica) {
	      textAreaStatistica.append("In data " +s.getData()+" ");
	      textAreaStatistica.append("totale avventori "+s.getTotaleAvventori()+"\n");
	    }
	}

	
	
	
	
}
	
	

	

	
	
	
	
	

	



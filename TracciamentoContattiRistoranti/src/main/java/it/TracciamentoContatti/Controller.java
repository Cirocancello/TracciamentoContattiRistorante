package it.TracciamentoContatti;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import it.TracciamentoContatti.model.Cliente;
import it.TracciamentoContatti.model.Model;
import it.TracciamentoContatti.model.Prenotazione;
import it.TracciamentoContatti.model.Ristorante;
import it.TracciamentoContatti.model.Tavolo;

public class Controller {
	
	private View frame;
	private Model model;
	
	private PrenotazioneView prenotazioneView;
	
	
	public Controller(View frame, Model model) {
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
			RistoranteView ristoranteView = new RistoranteView();
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
        Integer codiceTavoloDisponibile = tavoliLiberi.get(0).getCodice();
		
		if (codiceTavoloDisponibile != null) {
		   //scelgo il ristorante recupero il codice invocando il metodi getCodiceRistorante e il cognome, nome, ecc....		
	       Integer codicePrenotazione = model.creaPrenotazione(codiceTavoloDisponibile, codiceRistorante, cognome, nome, telefono, numeroPersone, data);
	       //prenotazione effettuata
	       JOptionPane.showMessageDialog(null, "Tavolo prenotato per il : "+data
	    		   +"\ncodice prenotazione "+codicePrenotazione
	    		   +"\ncodice tavolo assegnato "+codiceTavoloDisponibile, "Prenotazione effettuata!!!", JOptionPane.INFORMATION_MESSAGE);

		}
		else {
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
	

	public void TracciaContatti(JTextField textCartaIdentita, JTextField textData, TextArea textAreaTraccia) throws IOException {
		Model model = new Model();
		String cartaIdentita = textCartaIdentita.getText();
		String data = textData.getText();
		
		List<Cliente> clientidaContattare = model.tracciaContatti(cartaIdentita, Date.valueOf(data)); 		
			
		for(Cliente c : clientidaContattare) {			
			textAreaTraccia.append(c.getNome()+" ");
			textAreaTraccia.append(c.getCognome()+" ");
			textAreaTraccia.append(c.getTelefono()+"\n");			
		}			
		
	}

	public void inserisciCliente(Cliente cliente, JTextArea textAreaClientiInseriti) {
		
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

	public void cercaPrenotazione(Integer codicePrenotazione, JTextArea textAreaPrenotazione) {
          
		Model model = new Model();
		
		List<Prenotazione> prenotazione = model.cercaPrenotazione(codicePrenotazione);
		
		if(prenotazione.size() > 0) {
			String nomeSala = model.cercaNomeSala(codicePrenotazione);		
		    for(Prenotazione p : prenotazione) {
		    	
		    	//textAreaPrenotazione.append(p.getCodice()+" ");
			    textAreaPrenotazione.append("Prenotazione a nome di \n"+p.getCognome()+" ");
			    textAreaPrenotazione.append(p.getNome()+" - ");
			    textAreaPrenotazione.append("tel : "+p.getTelefono()+" - ");
			    textAreaPrenotazione.append("n.ro persone prenotate "+p.getNumeroPersone()+" - ");
			    textAreaPrenotazione.append("in data "+ p.getData()+"\n");
			    textAreaPrenotazione.append("tavolo prenotato "+p.getCodiceTavolo() +"   ");
			    textAreaPrenotazione.append("Sala prenotata : "+ nomeSala);
		
		   }
		}else {
			JOptionPane.showMessageDialog(null,  "prenotazione non presente in base dati!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

		}
		
	}

	public void cercaTavoloLibero(ActionEvent e, JTextField textCodiceRistorante, JTextField textData, JTextField textNumeroPersone
								 ,JTextArea textAreaClienti) {
		
		Model model = new Model();
		Integer codiceRistorante = Integer.parseInt(textCodiceRistorante.getText());
		Date data = Date.valueOf(textData.getText());
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
		       JOptionPane.showMessageDialog(null,  "codice tavolo libero  "+tavoloLibero
		    		  +"\nnome della sala "+nomeSala, "Tavolo disponibile !!!", JOptionPane.INFORMATION_MESSAGE);
		    }
		}
		else {
     	    //tavolo non disponibile per quel giorno
			JOptionPane.showMessageDialog(null,  "nessun tavolo disponibile ", "Attenzione!!!", JOptionPane.INFORMATION_MESSAGE);
		} 
			
	}

	
	
	
	
}
	
	

	

	
	
	
	
	

	



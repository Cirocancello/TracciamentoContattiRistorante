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

import it.TracciamentoContatti.db.PrenotazioniDAO;
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
		
		if(e.getSource() == frame.btnTavolata) {
			TavolataView tavolataView = new TavolataView();
		}
		
		if(e.getSource() == frame.btnNuovoRistorante) {
			RistoranteView ristoranteView = new RistoranteView();
		}
	}

	public void effettuaPrenotazione(Prenotazione prenotazione, JTextField textCodiceRistorante) {
		System.out.println("Ciao");
		System.out.println(textCodiceRistorante.getText());
		System.out.println(prenotazione.getCognome());			
		System.out.println(prenotazione.getNome());
		System.out.println(prenotazione.getTelefono());		
		System.out.println(prenotazione.getNumeroPersone());
		System.out.println(prenotazione.getData());
		
		Model model = new Model();

		PrenotazioniDAO prenotazioneDao = new PrenotazioniDAO();
		//LocalDate data1 = LocalDate.of(2022, 01, 21);
		Integer codiceRistorante = Integer.parseInt(textCodiceRistorante.getText());
		String cognome = prenotazione.getCognome();
		String nome = prenotazione.getNome();
		String telefono = prenotazione.getTelefono();
		Integer numeroPersone = prenotazione.getNumeroPersone();
	    Date data =  prenotazione.getData(); 
	  
	    
		Integer codiceTavoloDisponibile = model.getTavoliDisponibili(codiceRistorante, data, numeroPersone);
        
		if (codiceTavoloDisponibile != null) {
		   //scelgo il ristorante recupero il codice invocando il metodi getCodiceRistorante e il cognome, nome, ecc....		
	       Integer codicePrenotazione = prenotazioneDao.creaPrenotazione(codiceTavoloDisponibile, codiceRistorante, cognome, nome, telefono, numeroPersone, data);
	       //prenotazione effettuata
	       JOptionPane.showMessageDialog(null,  "Tavolo prenotato per il : "+data+"\ncodice tavolo assegnato "+codiceTavoloDisponibile, "Prenotazione effettuata!!!", JOptionPane.INFORMATION_MESSAGE);

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

	
	
}
	
	

	

	
	
	
	
	

	



package it.polito.tdp.TracciamentoContatti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import it.polito.tdp.TracciamentoContatti.model.Model;

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
			PrenotazioneView prenotazioneView = new PrenotazioneView();			
		}
		
		if(e.getSource() == frame.btnTracciaContatti) {
			TracciaContattiView tracciaContatti = new TracciaContattiView();
		}
		if(e.getSource() == frame.btnTavolata) {
			TavolataView tavolataView = new TavolataView();
		}
		
	//	if(e.getSource() == frame.btnNuovoRistorante) {
	//		model.Stampa(prenotazioneView.getTextPrenotaCognome());
		}
		
	}
	
	

	

	
	
	
	
	

	



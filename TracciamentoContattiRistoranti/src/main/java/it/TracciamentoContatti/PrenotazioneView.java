package it.TracciamentoContatti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.model.Model;
import it.TracciamentoContatti.model.Prenotazione;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.Scrollbar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollBar;

public class PrenotazioneView extends JFrame {

	private JPanel contentPane;
	private JTextField textPrenotaCognome;
	private JTextField textPrenotaNome;
	private JTextField textPrenotaTelefono;
	private JTextField textPrenotaNumeroPersone;	
	
	private Controller controller;
	private View frame;
	private JButton btnEffettuaPrenotazione;
	private Model model;
	private Prenotazione prenotazione;


	/**
	 * Create the frame.
	 */
	public PrenotazioneView() {
		
		setResizable(false);
		setVisible(true);
		
		setFont(null);
		setTitle("Prenotazione");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 375, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(57, 67, 79, 14);
		contentPane.add(lblCognome);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(57, 98, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(57, 129, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblNumeroPersone = new JLabel("Numero di persone");
		lblNumeroPersone.setBounds(57, 160, 90, 14);
		contentPane.add(lblNumeroPersone);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(57, 196, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblRistorante = new JLabel("Ristorante");
		lblRistorante.setBounds(179, 196, 66, 14);
		contentPane.add(lblRistorante);
		
		textPrenotaCognome = new JTextField();
		textPrenotaCognome.setBounds(168, 64, 126, 20);
		contentPane.add(textPrenotaCognome);
		textPrenotaCognome.setColumns(10);
		
		textPrenotaNome = new JTextField();
		textPrenotaNome.setBounds(168, 95, 126, 20);
		contentPane.add(textPrenotaNome);
		textPrenotaNome.setColumns(10);
		
		textPrenotaTelefono = new JTextField();
		textPrenotaTelefono.setBounds(168, 126, 126, 20);
		contentPane.add(textPrenotaTelefono);
		textPrenotaTelefono.setColumns(10);
		
		textPrenotaNumeroPersone = new JTextField();
		textPrenotaNumeroPersone.setBounds(168, 157, 125, 20);
		contentPane.add(textPrenotaNumeroPersone);
		textPrenotaNumeroPersone.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(168, 192, 127, 22);
		contentPane.add(comboBox);
		
		btnEffettuaPrenotazione = new JButton("Effettua prenotazione");
		btnEffettuaPrenotazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
			
				//model.Stampa(textPrenotaCognome.getText());
				System.out.println("Cognome "+textPrenotaCognome.getText());
				dispose();
							
			}
		});
		btnEffettuaPrenotazione.setBounds(126, 240, 190, 23);
		contentPane.add(btnEffettuaPrenotazione);
		
		JLabel lblNewLabel_6 = new JLabel("Prenotazione");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_6.setBounds(126, 24, 119, 14);
		contentPane.add(lblNewLabel_6);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(104, 178, 17, 48);
		contentPane.add(scrollBar);
	}


	public JTextField getTextPrenotaCognome() {
		return textPrenotaCognome;
	}


	public JTextField getTextPrenotaNome() {
		return textPrenotaNome;
	}


	public JTextField getTextPrenotaTelefono() {
		return textPrenotaTelefono;
	}


	public JTextField getTextPrenotaNumeroPersone() {
		return textPrenotaNumeroPersone;
	}

	
	
	
}

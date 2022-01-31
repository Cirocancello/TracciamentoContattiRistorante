package it.TracciamentoContatti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.model.Prenotazione;
import it.TracciamentoContatti.model.Ristorante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.Scrollbar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class PrenotazioneView extends JFrame {

	private JPanel contentPane;
    private JTextField textPrenotaCognome;
	private JTextField textPrenotaNome;
	private JTextField textPrenotaTelefono;
	private JTextField textPrenotaNumeroPersone;	
	
	private Controller controller;	
	private JButton btnEffettuaPrenotazione;
	
	private Prenotazione prenotazione;
	private JTextField textCodiceRistorante;
	private JTextArea textArea;
	private JDateChooser dateChooser;
	
	/**
	 * Create the frame.
	 */
	public PrenotazioneView(List<Ristorante> ristoranti) {  
		
		setResizable(false);
		setVisible(true);
		
		setFont(null);
		setTitle("Prenotazione");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 562, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(34, 39, 75, 14);
		contentPane.add(lblCognome);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(274, 39, 75, 14);
		contentPane.add(lblNome);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(34, 70, 75, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblNumeroPersone = new JLabel("Numero di persone");
		lblNumeroPersone.setBounds(274, 70, 126, 14);
		contentPane.add(lblNumeroPersone);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(34, 108, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblRistoranti = new JLabel("Ristoranti");
		lblRistoranti.setForeground(Color.BLACK);
		lblRistoranti.setEnabled(false);
		lblRistoranti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblRistoranti.setBounds(235, 150, 114, 14);
		contentPane.add(lblRistoranti);
		
		textPrenotaCognome = new JTextField();
		textPrenotaCognome.setBounds(119, 36, 126, 20);
		contentPane.add(textPrenotaCognome);
		textPrenotaCognome.setColumns(10);
		
		textPrenotaNome = new JTextField();
		textPrenotaNome.setBounds(409, 36, 126, 20);
		contentPane.add(textPrenotaNome);
		textPrenotaNome.setColumns(10);
		
		textPrenotaTelefono = new JTextField();
		textPrenotaTelefono.setBounds(119, 67, 126, 20);
		contentPane.add(textPrenotaTelefono);
		textPrenotaTelefono.setColumns(10);
		
		textPrenotaNumeroPersone = new JTextField();
		textPrenotaNumeroPersone.setBounds(409, 67, 125, 20);
		contentPane.add(textPrenotaNumeroPersone);
		textPrenotaNumeroPersone.setColumns(10);
	
		btnEffettuaPrenotazione = new JButton("Effettua prenotazione");
		btnEffettuaPrenotazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    Controller controller = new Controller();
				
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
			    String data = null;
				try {
				   data = dateFormat.format(dateChooser.getDate());
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,  "Devi inserire una data valida!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String cognome = textPrenotaCognome.getText();;
			   
				if(cognome.length() == 0) {			           
					JOptionPane.showMessageDialog(null,  "Campo cognome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
 
			    String nome = textPrenotaNome.getText();
			    if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo nome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
			    String telefono = textPrenotaTelefono.getText();
			    if(telefono.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo telefono vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
			    String numeroPersone = textPrenotaNumeroPersone.getText();
			    if(numeroPersone.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo numero persone vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
			    String codiceRistorante = textCodiceRistorante.getText();
			    if(codiceRistorante.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo codice ristorante vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;

			    }
			    
			    Prenotazione prenotazione = new Prenotazione(cognome, nome, telefono, Integer.valueOf(numeroPersone), Date.valueOf(data));
			    
				controller.effettuaPrenotazione(prenotazione,textCodiceRistorante);				
				
				dispose();
							
			}

		
		});
		btnEffettuaPrenotazione.setBounds(333, 399, 190, 23);
		contentPane.add(btnEffettuaPrenotazione);
		
		JLabel lblNewLabel_6 = new JLabel("Prenotazione");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_6.setBounds(230, 11, 119, 14);
		contentPane.add(lblNewLabel_6);
		
		textArea = new JTextArea();
		textArea.setBounds(20, 175, 503, 201);
		for(Ristorante r : ristoranti) {
			textArea.append("codice "+ r.getCodice()+", ");
			textArea.append(r.getNome()+", ");		
			textArea.append(r.getIndirizzo()+", ");
			textArea.append(r.getCitta()+", ");
			textArea.append(r.getProvincia()+" ");
			textArea.append(r.getTelefono()+"\n");
		}
		contentPane.add(textArea);
		
		
		JLabel lblNewLabel = new JLabel("Codice ristrorante ");
		lblNewLabel.setBounds(274, 108, 139, 14);
		contentPane.add(lblNewLabel);
		
		textCodiceRistorante = new JTextField();
		textCodiceRistorante.setBounds(409, 105, 86, 20);
		contentPane.add(textCodiceRistorante);
		textCodiceRistorante.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(119, 108, 126, 20);
		contentPane.add(dateChooser);

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

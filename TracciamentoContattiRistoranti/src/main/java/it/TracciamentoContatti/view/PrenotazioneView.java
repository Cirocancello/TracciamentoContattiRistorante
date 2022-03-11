package it.TracciamentoContatti.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.Prenotazione;
import it.TracciamentoContatti.Ristorante;
import it.controller.Controller;

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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PrenotazioneView extends JFrame {

	private JPanel contentPane;
    private JTextField textPrenotaCognome;
	private JTextField textPrenotaNome;
	private JTextField textPrenotaTelefono;
	private JTextField textPrenotaNumeroPersone;	
	private JTextField textCodiceRistorante;
	
	private JButton btnEffettuaPrenotazione;
	
	private JTextArea textArea;
	private JDateChooser dateChooser;	
	private String codiceRistorante;	
	private String numeroPersone; 
	private JLabel lblCognome;
	private JLabel lblNome;
	private JLabel lblTelefono;
	private JLabel lblNumeroPersone;
	private JLabel lblData;
	private JLabel lblRistoranti;
	private JLabel lblcodicdeRistorante;
	
	private  String telefono ;
	private String cognome;
	private String nome;
	private String data;
	
	private Controller controller;
	private JButton btnChiudi;
	private HomePageView homePage ;
	
	/**
	 * Create the frame. creazione della finestra grafica della prenotazione
	 */
	public PrenotazioneView(List<Ristorante> ristoranti) {  
		
		setResizable(false);
		setVisible(true);
		
		setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		setTitle("Prenotazione");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 200, 562, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(34, 39, 75, 14);
		contentPane.add(lblCognome);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(274, 39, 75, 14);
		contentPane.add(lblNome);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(34, 70, 75, 14);
		contentPane.add(lblTelefono);
		
		lblNumeroPersone = new JLabel("Numero di persone");
		lblNumeroPersone.setBounds(274, 70, 126, 14);
		contentPane.add(lblNumeroPersone);
		
		lblData = new JLabel("Data");
		lblData.setBounds(34, 108, 46, 14);
		contentPane.add(lblData);
		
		lblRistoranti = new JLabel("Ristoranti");
		lblRistoranti.setForeground(Color.BLACK);
		lblRistoranti.setEnabled(false);
		lblRistoranti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRistoranti.setBounds(235, 150, 114, 14);
		contentPane.add(lblRistoranti);
		
		textPrenotaCognome = new JTextField();
		textPrenotaCognome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {			
				
				//JTextField to accept only alfabets
				//code for JTextField that acept letter whitespace and delete backspace key only
				char c = e.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//ISOControl for edit operation (delete key and backspace key allow)
					//if enter character is letter, space and isocontrol char than allow to edit
					textPrenotaCognome.setEditable(true);					
				}else {
					textPrenotaCognome.setEditable(false);
				}				
				
			}
		});
		textPrenotaCognome.setBounds(119, 36, 126, 20);
		contentPane.add(textPrenotaCognome);
		textPrenotaCognome.setColumns(10);
		
		textPrenotaNome = new JTextField();
		textPrenotaNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//JTextField to accept only alfabets
				//code for JTextField that acept letter whitespace and delete backspace key only
				char c = e.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//ISOControl for edit operation (delete key and backspace key allow)
					//if enter character is letter, space and isocontrol char than allow to edit
					textPrenotaNome.setEditable(true);					
				}else {
					textPrenotaNome.setEditable(false);
				}
				nome = textPrenotaNome.getText();
				
			}
		});
		textPrenotaNome.setBounds(409, 36, 126, 20);
		contentPane.add(textPrenotaNome);
		textPrenotaNome.setColumns(10);
		
		textPrenotaTelefono = new JTextField();
		textPrenotaTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			    
			    //JTextField phone number validation/ accept only numbers
			    //action when key is press
			    //get JTextField string
				telefono = textPrenotaTelefono.getText();
			    //get length of string
			    int length = telefono.length();
			    
			    char c = e.getKeyChar();
			    //check for number 0 to 9
			    if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
			    	//check for length not more than 10 digit
			    	if(length<10) {
			    		//editable true
			    		textPrenotaTelefono.setEditable(true);
			    	}else {
			    		textPrenotaTelefono.setEditable(false);
			    	}
			    	
			    }else {
			    	//now allow for keys 'back space' and 'delete' for edit
			    	if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
			    		//than allow editable
			    		textPrenotaTelefono.setEditable(true);
			    	}else {
			    		textPrenotaTelefono.setEditable(false);
			    	}
			    }		  
				
			}
		});
		textPrenotaTelefono.setBounds(119, 67, 126, 20);
		contentPane.add(textPrenotaTelefono);
		textPrenotaTelefono.setColumns(10);
		
		textPrenotaNumeroPersone = new JTextField();
		textPrenotaNumeroPersone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//JTextField to accept only numbers
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)) {
					//can't able to enter in textField if enter char is not number
					textPrenotaNumeroPersone.setEditable(false);
					JOptionPane.showMessageDialog(null,  "Devi iserire solo numeri!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

				}else {
					textPrenotaNumeroPersone.setEditable(true);
				}
			}
		});
		textPrenotaNumeroPersone.setBounds(409, 67, 125, 20);
		contentPane.add(textPrenotaNumeroPersone);
		textPrenotaNumeroPersone.setColumns(10);
	
		btnEffettuaPrenotazione = new JButton("Effettua prenotazione");
		btnEffettuaPrenotazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			    controller = new Controller();
				
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
			    data = null;
				try {
				   data = dateFormat.format(dateChooser.getDate());
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,  "Devi inserire una data valida!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				} 		   
			
				cognome = textPrenotaCognome.getText();
				if (cognome.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo cognome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

				}
				
				nome = textPrenotaNome.getText();
				if (nome.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo nome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

				}
			    
			    numeroPersone = textPrenotaNumeroPersone.getText();
			    if(numeroPersone.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo numero persone vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
			    
			    codiceRistorante = textCodiceRistorante.getText();
			    if(codiceRistorante.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo codice ristorante vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;

			    }
			    
			    Prenotazione prenotazione = new Prenotazione(cognome, nome, telefono, Integer.valueOf(numeroPersone), Date.valueOf(data));
			    
				controller.effettuaPrenotazione(prenotazione,textCodiceRistorante);				
				homePage = new HomePageView();
				homePage.setVisible(true);
				dispose();
							
			}

		
		});
		btnEffettuaPrenotazione.setBounds(34, 399, 190, 23);
		contentPane.add(btnEffettuaPrenotazione);
		
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
		
		
		lblcodicdeRistorante = new JLabel("Codice ristrorante ");
		lblcodicdeRistorante.setBounds(274, 108, 139, 14);
		contentPane.add(lblcodicdeRistorante);
		
		textCodiceRistorante = new JTextField();
		textCodiceRistorante.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				codiceRistorante = textCodiceRistorante.getText().trim();
				//JTextField phone number validation/ accept only numbers
			    //action when key is press
			    //get JTextField string			   
			    
			    int length = codiceRistorante.length();
			    
			    char c = e.getKeyChar();
			    //check for number 0 to 9
			    if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
			    	//check for length not more than 2 digit
			    	if(length<2) {
			    		//editable true
			    		textCodiceRistorante.setEditable(true);
			    	}else {
			    		textCodiceRistorante.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Il codice riatorante max 2 cifre!!!", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    	
			    }else {
			    	//now allow for keys 'back space' and 'delete' for edit
			    	if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
			    		//than allow editable
			    		textCodiceRistorante.setEditable(true);
			    	}else {
			    		textCodiceRistorante.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Devi iserire solo numeri!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    }
			}
			
		});
		textCodiceRistorante.setBounds(409, 105, 86, 20);
		contentPane.add(textCodiceRistorante);
		textCodiceRistorante.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(119, 108, 126, 20);
		contentPane.add(dateChooser);
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePageView homePage = new HomePageView();
				homePage.setVisible(true);
				dispose();
			}
		});
		btnChiudi.setBounds(434, 399, 89, 23);
		contentPane.add(btnChiudi);

	}
}

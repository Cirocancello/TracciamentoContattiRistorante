package it.TracciamentoContatti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.model.Cliente;
import it.TracciamentoContatti.model.Prenotazione;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

public class TavolataPrenotataView extends JFrame {

	private JPanel contentPane;
	private JTextField textCognome;
	private JTextField textNome;
	private JTextField textCartaIdentita;
	private JTextField textTelefono;
	private JTextField textCodiceTavolo;
	private JTextArea textAreaClientiInseriti; 
	private JTextArea textAreaPrenotazione;
	private JButton btnCercaPrenotazione;
	private JLabel lblNewLabel_8;
	private JDateChooser dateChooser;
	private JTextField textCognome1;
	
	/**
	 * Create the frame.
	 */
	public TavolataPrenotataView() {
		
		setResizable(false);
		setVisible(true);
		setTitle("Tavolata Prenotata");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 558, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome");
		lblNewLabel_1.setBounds(302, 19, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(27, 237, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Carta di identità");
		lblNewLabel_3.setBounds(279, 267, 95, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(279, 237, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		textCognome = new JTextField();
		textCognome.setBounds(396, 16, 108, 20);
		contentPane.add(textCognome);
		textCognome.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(130, 234, 121, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCartaIdentita = new JTextField();
		textCartaIdentita.setBounds(383, 264, 121, 20);
		contentPane.add(textCartaIdentita);
		textCartaIdentita.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(384, 234, 121, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnInserisciClienti = new JButton("Inserisci cliente");
		btnInserisciClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controller controller = new Controller();			
				
				String codiceTavolo = textCodiceTavolo.getText().trim();
				if(codiceTavolo.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo codice tavolo vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String cognome1 = textCognome1.getText().trim();
				if(cognome1.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo cognome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String nome = textNome.getText().trim();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo nome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}	
				
				String telefono = textTelefono.getText().trim();
				if(telefono.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo telefono vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String cartaIdentita = textCartaIdentita.getText().trim();
				if(cartaIdentita.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo carta identità vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String theDate = dateFormat.format(dateChooser.getDate());
			
				Cliente cliente = new Cliente(Integer.parseInt(codiceTavolo),cognome1, nome, cartaIdentita, telefono, Date.valueOf(theDate));
			    controller.inserisciCliente(cliente, textAreaClientiInseriti);
				
			    //textCodiceTavolo.setText("");
			    textCognome.setText("");
			    textCognome1.setText("");
			    textNome.setText("");
			    textTelefono.setText("");
			    textCartaIdentita.setText("");
			
				
			}
		});
		btnInserisciClienti.setBounds(381, 295, 137, 23);
		contentPane.add(btnInserisciClienti);
		
		textAreaClientiInseriti = new JTextArea();
		textAreaClientiInseriti.setBounds(27, 329, 477, 91);
		contentPane.add(textAreaClientiInseriti);
		
		textAreaPrenotazione = new JTextArea();
		textAreaPrenotazione.setBounds(27, 80, 477, 92);
		contentPane.add(textAreaPrenotazione);
		
		textCodiceTavolo = new JTextField();
		textCodiceTavolo.setBounds(198, 264, 53, 20);
		contentPane.add(textCodiceTavolo);
		textCodiceTavolo.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Codice tavolo assegnato");
		lblNewLabel_7.setBounds(27, 267, 149, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("Clienti inseriti");
		lblNewLabel.setBounds(27, 304, 90, 14);
		contentPane.add(lblNewLabel);
		
		btnCercaPrenotazione = new JButton("cerca prenotazione");
		btnCercaPrenotazione.addActionListener(new ActionListener() {
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
				
				String cognome = textCognome.getText();;
				   
				if(cognome.length() == 0) {			           
					JOptionPane.showMessageDialog(null,  "Campo cognome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
				
				controller.cercaPrenotazione(data, cognome, textAreaPrenotazione);
			}
		});
		btnCercaPrenotazione.setBounds(367, 46, 149, 23);
		contentPane.add(btnCercaPrenotazione);
		
		lblNewLabel_8 = new JLabel("Inserisci i dati dei clienti ");
		lblNewLabel_8.setBounds(27, 183, 184, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnChiudi.setBounds(415, 433, 89, 23);
		contentPane.add(btnChiudi);
		
	    dateChooser = new JDateChooser();
		dateChooser.setBounds(157, 16, 121, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_6 = new JLabel("Date Prenotazione");
		lblNewLabel_6.setBounds(39, 19, 108, 14);
		contentPane.add(lblNewLabel_6);
		
		textCognome1 = new JTextField();
		textCognome1.setBounds(130, 205, 121, 20);
		contentPane.add(textCognome1);
		textCognome1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cognome");
		lblNewLabel_5.setBounds(27, 208, 64, 14);
		contentPane.add(lblNewLabel_5);
	}
}

package it.TracciamentoContatti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.model.Cliente;
import it.TracciamentoContatti.model.Prenotazione;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import javax.swing.JTextArea;

public class ClienteView extends JFrame {

	private JPanel contentPane;
	private JTextField textCognome;
	private JTextField textNome;
	private JTextField textCartaIdentita;
	private JTextField textTelefono;
	private JTextField textData;
	private JTextField textCodiceTavolo;
	private JTextArea textAreaClientiInseriti; 
	private JTextArea textAreaPrenotazione;
	private JTextField textCodicePrenotazione;
	private JButton btnCercaPrenotazione;
	private JLabel lblNewLabel_8;
	
	/**
	 * Create the frame.
	 */
	public ClienteView() {
		
		setResizable(false);
		setVisible(true);
		setTitle("Inserimento Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 558, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome");
		lblNewLabel_1.setBounds(29, 138, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(279, 138, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Carta di identità");
		lblNewLabel_3.setBounds(279, 197, 95, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setBounds(279, 172, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Data");
		lblNewLabel_5.setBounds(29, 184, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textCognome = new JTextField();
		textCognome.setBounds(111, 135, 121, 20);
		contentPane.add(textCognome);
		textCognome.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(383, 135, 121, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCartaIdentita = new JTextField();
		textCartaIdentita.setBounds(383, 194, 121, 20);
		contentPane.add(textCartaIdentita);
		textCartaIdentita.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(383, 163, 121, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnInserisciClienti = new JButton("Inserisci cliente");
		btnInserisciClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controller controller = new Controller();
				String codicePrenotazione = textCodicePrenotazione.getText();
				String codiceTavolo = textCodiceTavolo.getText();
				String cognome = textCognome.getText();
				String nome = textNome.getText();
				String telefono = textTelefono.getText();
				String cartaIdentita = textCartaIdentita.getText();				    
				String data = textData.getText();
				    
				Cliente cliente = new Cliente(Integer.parseInt(codiceTavolo),cognome, nome, telefono, cartaIdentita, Date.valueOf(data));
			    controller.inserisciCliente(cliente, textAreaClientiInseriti);
				
			    textCodiceTavolo.setText(" ");
			    textCognome.setText(" ");
			    textNome.setText(" ");
			    textTelefono.setText(" ");
			    textCartaIdentita.setText(" ");
			    textData.setText(" ");
				//dispose();
			}
		});
		btnInserisciClienti.setBounds(369, 244, 137, 23);
		contentPane.add(btnInserisciClienti);
		
		textData = new JTextField();
		textData.setBounds(109, 181, 86, 20);
		contentPane.add(textData);
		textData.setColumns(10);
		
		textAreaClientiInseriti = new JTextArea();
		textAreaClientiInseriti.setBounds(27, 283, 477, 148);
		contentPane.add(textAreaClientiInseriti);
		
		textAreaPrenotazione = new JTextArea();
		textAreaPrenotazione.setBounds(39, 42, 455, 50);
		contentPane.add(textAreaPrenotazione);
		
		JLabel lblNewLabel_6 = new JLabel("Codice Prenotazione");
		lblNewLabel_6.setBounds(39, 17, 144, 14);
		contentPane.add(lblNewLabel_6);
		
		textCodiceTavolo = new JTextField();
		textCodiceTavolo.setBounds(193, 213, 86, 20);
		contentPane.add(textCodiceTavolo);
		textCodiceTavolo.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Codice tavolo assegnato");
		lblNewLabel_7.setBounds(27, 216, 120, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("Clienti inseriti");
		lblNewLabel.setBounds(27, 259, 90, 14);
		contentPane.add(lblNewLabel);
		
		textCodicePrenotazione = new JTextField();
		textCodicePrenotazione.setBounds(204, 14, 86, 20);
		contentPane.add(textCodicePrenotazione);
		textCodicePrenotazione.setColumns(10);
		
		btnCercaPrenotazione = new JButton("cerca prenotazione");
		btnCercaPrenotazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controller controller = new Controller();
				Integer codicePrenotazione = Integer.parseInt(textCodicePrenotazione.getText());
				controller.cercaPrenotazione(codicePrenotazione,textAreaPrenotazione);
			}
		});
		btnCercaPrenotazione.setBounds(321, 13, 149, 23);
		contentPane.add(btnCercaPrenotazione);
		
		lblNewLabel_8 = new JLabel("Inserisci i dati dei clienti ");
		lblNewLabel_8.setBounds(29, 103, 184, 14);
		contentPane.add(lblNewLabel_8);
	}
}

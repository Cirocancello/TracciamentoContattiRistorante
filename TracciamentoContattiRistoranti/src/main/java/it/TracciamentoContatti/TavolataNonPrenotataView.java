package it.TracciamentoContatti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.model.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Label;

public class TavolataNonPrenotataView extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField textNumeroPersone;
	private JTextField textCartaIdentita;
	private JTextField textTelefono;
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textData;
	private JTextField textCodiceTavoloAssegnato;
	private JTextArea textAreaClienti;
	private JButton btnChiudi;
	private JButton btnAggiungiCliente;
	private JButton btnCercaTavoloLibero;
	private JTextField textCodiceRistorante;
	private JLabel lblNewLabel;
	
	
	/**
	 * Create the frame.
	 */
	public TavolataNonPrenotataView() {
		
		setResizable(false);
		setVisible(true);
		
		setTitle("Tavolata non prenotata");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 459, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAggiungiCliente = new JButton("Aggiungi cliente");
		btnAggiungiCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controller controller = new Controller();					
				
				String codiceTavolo = textCodiceTavoloAssegnato.getText();
				String cognome = textCognome.getText();
				String nome = textNome.getText();
				String telefono = textTelefono.getText();
				String cartaIdentita = textCartaIdentita.getText();				    
				String data = textData.getText();
				    
				Cliente cliente = new Cliente(Integer.parseInt(codiceTavolo),cognome, nome, telefono, cartaIdentita, Date.valueOf(data));
			    controller.inserisciCliente(cliente, textAreaClienti);
				
			    textCodiceTavoloAssegnato.setText(" ");
			    textCognome.setText(" ");
			    textNome.setText(" ");
			    textTelefono.setText(" ");
			    textCartaIdentita.setText(" ");
			    textData.setText(" ");
				
				
			}
		});
		btnAggiungiCliente.setBounds(276, 205, 150, 23);
		contentPane.add(btnAggiungiCliente);
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//dispose(); è la stessa cosa
			}
		});
		btnChiudi.setBounds(337, 412, 89, 23);
		contentPane.add(btnChiudi);
		
		JLabel lblNewLabel_1 = new JLabel("Numero persone");
		lblNewLabel_1.setBounds(21, 11, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		textNumeroPersone = new JTextField();
		textNumeroPersone.setBounds(121, 8, 48, 20);
		contentPane.add(textNumeroPersone);
		textNumeroPersone.setColumns(10);
		
		textAreaClienti = new JTextArea();
		textAreaClienti.setBounds(21, 241, 405, 160);
		contentPane.add(textAreaClienti);
		
		Label label = new Label("Clienti inseriti");
		label.setBounds(21, 212, 96, 22);
		contentPane.add(label);
		
		textCartaIdentita = new JTextField();
		textCartaIdentita.setBounds(324, 143, 102, 20);
		contentPane.add(textCartaIdentita);
		textCartaIdentita.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(100, 178, 102, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(100, 143, 102, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCognome = new JTextField();
		textCognome.setColumns(10);
		textCognome.setBounds(100, 112, 102, 20);
		contentPane.add(textCognome);
		
		textData = new JTextField();
		textData.setColumns(10);
		textData.setBounds(100, 52, 70, 20);
		contentPane.add(textData);
		
		textCodiceTavoloAssegnato = new JTextField();
		textCodiceTavoloAssegnato.setColumns(10);
		textCodiceTavoloAssegnato.setBounds(370, 174, 56, 20);
		contentPane.add(textCodiceTavoloAssegnato);
		
		Label label_1 = new Label("Cognome");
		label_1.setBounds(21, 110, 62, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Nome");
		label_2.setBounds(21, 141, 62, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Telefono");
		label_3.setBounds(21, 178, 62, 22);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Carta di identità");
		label_4.setBounds(228, 141, 89, 22);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Data");
		label_5.setBounds(21, 50, 48, 22);
		contentPane.add(label_5);
		
		Label label_6 = new Label("Codice tavolo assegnato");
		label_6.setBounds(228, 178, 138, 22);
		contentPane.add(label_6);
		
		btnCercaTavoloLibero = new JButton("Cerca tavolo libero");
		btnCercaTavoloLibero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controller controller = new Controller();
				controller.cercaTavoloLibero(e, textCodiceRistorante, textData, textNumeroPersone,textAreaClienti);
					
			}
		});
		btnCercaTavoloLibero.setBounds(221, 51, 145, 23);
		contentPane.add(btnCercaTavoloLibero);
		
		textCodiceRistorante = new JTextField();
		textCodiceRistorante.setBounds(318, 8, 48, 20);
		contentPane.add(textCodiceRistorante);
		textCodiceRistorante.setColumns(10);
		
		lblNewLabel = new JLabel("Codice Ristorante");
		lblNewLabel.setBounds(195, 11, 113, 14);
		contentPane.add(lblNewLabel);
	}
}

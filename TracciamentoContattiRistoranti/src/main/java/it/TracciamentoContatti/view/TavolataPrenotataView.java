package it.TracciamentoContatti.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.Cliente;
import it.TracciamentoContatti.Prenotazione;
import it.controller.Controller;

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
import java.awt.TextArea;

import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TavolataPrenotataView extends JFrame {

	private JPanel contentPane;
	private JTextField textCognome;
	private JTextField textNome;
	private JTextField textCartaIdentita;
	private JTextField textTelefono;
	private JTextField textCodiceTavoloAssegnato;
	private TextArea textAreaClientiInseriti; 
	private TextArea textAreaPrenotazione;
	private JButton btnCercaPrenotazione;
	private JLabel lblInserisciDatiClienti;
	private JDateChooser dateChooser;
	private JTextField textCognomeCliente;
	private String telefono;
	private String cognome;
	private String nome;
	private String cognomeCliente;
	private String cartaIdentita;
	private String  codiceTavolo;
	private JLabel lblcognome;
	private JLabel lblNome;
	private JLabel lblCartaIdentita;
	private JLabel lblTelefono;
	private JButton btnInserisciCliente;
	private JLabel lblCodiceTavoloAssegnato;
	private JLabel lblClientiInseriti;
	private JButton btnChiudi;
	private JLabel lblDataPrenotazione;
	private JLabel lblCognomeCliente;
	private JLabel lblPrenotazione;
	
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
		
		lblcognome = new JLabel("Cognome");
		lblcognome.setBounds(313, 19, 72, 14);
		contentPane.add(lblcognome);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(274, 236, 46, 14);
		contentPane.add(lblNome);
		
		lblCartaIdentita = new JLabel("Carta di identità");
		lblCartaIdentita.setBounds(32, 270, 95, 14);
		contentPane.add(lblCartaIdentita);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(274, 270, 64, 14);
		contentPane.add(lblTelefono);
		
		textCognome = new JTextField();
		textCognome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//JTextField to accept only alfabets
				//code for JTextField that acept letter whitespace and delete backspace key only
				char c = e.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//ISOControl for edit operation (delete key and backspace key allow)
					//if enter character is letter, space and isocontrol char than allow to edit
					textCognome.setEditable(true);					
				}else {
					textCognome.setEditable(false);
				}
				cognome = textCognome.getText();
				
			}
		});
		textCognome.setBounds(396, 16, 108, 20);
		contentPane.add(textCognome);
		textCognome.setColumns(10);
		
		textNome = new JTextField();
		textNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//JTextField to accept only alfabets
				//code for JTextField that acept letter whitespace and delete backspace key only
				char c = e.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//ISOControl for edit operation (delete key and backspace key allow)
					//if enter character is letter, space and isocontrol char than allow to edit
					textNome.setEditable(true);					
				}else {
					textNome.setEditable(false);
				}
				nome = textNome.getText();
				
				
				
			}
		});
		textNome.setBounds(383, 233, 121, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCartaIdentita = new JTextField();
		textCartaIdentita.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				  cartaIdentita = textCartaIdentita.getText().trim();
				  int length = cartaIdentita.length();
				    
				    char c = e.getKeyChar();
				    //check for number 0 to 9 or letter
				    if(Character.isLetterOrDigit(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
						//ISOControl for edit operation (delete key and backspace key allow)
						//if enter character is letter, space and isocontrol char than allow to edit
				    	if(length<9) {
				    		//editable true
				    		textCartaIdentita.setEditable(true);
				    	}else {
				    		textCartaIdentita.setEditable(false);
				    	}
				    	
				    }else {
				    	//now allow for keys 'back space' and 'delete' for edit
				    	if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
				    		//than allow editable
				    		textCartaIdentita.setEditable(true);
				    	}else {
				    		textCartaIdentita.setEditable(false);
				    	}
				    }
			}
		});
		textCartaIdentita.setBounds(130, 267, 121, 20);
		contentPane.add(textCartaIdentita);
		textCartaIdentita.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
							
				//JTextField phone number validation/ accept only numbers
			    //action when key is press
			    //get JTextField string
			    telefono = textTelefono.getText().trim();
			    //get length of string
			    int length = telefono.length();
			    
			    char c = e.getKeyChar();
			    //check for number 0 to 9
			    if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
			    	//check for length not more than 10 digit
			    	if(length<10) {
			    		//editable true
			    		textTelefono.setEditable(true);
			    	}else {
			    		textTelefono.setEditable(false);
			    	}
			    	
			    }else {
			    	//now allow for keys 'back space' and 'delete' for edit
			    	if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
			    		//than allow editable
			    		textTelefono.setEditable(true);
			    	}else {
			    		textTelefono.setEditable(false);
			    	}
			    }
				
				
			}
		});
		textTelefono.setBounds(383, 264, 121, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		btnInserisciCliente = new JButton("Inserisci cliente");
		btnInserisciCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controller controller = new Controller();			
				
				codiceTavolo = textCodiceTavoloAssegnato.getText().trim();
				if(codiceTavolo.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo codice tavolo vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				cognomeCliente = textCognomeCliente.getText().trim();
				if(cognomeCliente.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo cognome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				nome = textNome.getText().trim();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo nome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				cartaIdentita = textCartaIdentita.getText().trim();
				if(cartaIdentita.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo carta identità vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String theDate = dateFormat.format(dateChooser.getDate());
			
				Cliente cliente = new Cliente(Integer.parseInt(codiceTavolo),cognomeCliente, nome, telefono,  cartaIdentita, Date.valueOf(theDate));
			    controller.inserisciCliente(cliente, textAreaClientiInseriti);
				
			    textCognomeCliente.setText("");
			    textNome.setText("");
			    textTelefono.setText("");
			    textCartaIdentita.setText("");
			    textCognomeCliente.setEditable(true);	
			    textNome.setEditable(true);
			    textTelefono.setEditable(true);
			    textCartaIdentita.setEditable(true);			
				
			}
		});
		btnInserisciCliente.setBounds(381, 295, 137, 23);
		contentPane.add(btnInserisciCliente);
		
		textAreaClientiInseriti = new TextArea();
		textAreaClientiInseriti.setBounds(27, 329, 477, 91);
		contentPane.add(textAreaClientiInseriti);
		
		textAreaPrenotazione = new TextArea();
		textAreaPrenotazione.setBounds(27, 80, 477, 102);
		contentPane.add(textAreaPrenotazione);
		
		textCodiceTavoloAssegnato = new JTextField();
		textCodiceTavoloAssegnato.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				codiceTavolo = textCodiceTavoloAssegnato.getText().trim();
				//JTextField phone number validation/ accept only numbers
			    //action when key is press
			    //get JTextField string			   
			    
			    int length = codiceTavolo.length();
			    
			    char c = e.getKeyChar();
			    //check for number 0 to 9
			    if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
			    	//check for length not more than 2 digit
			    	if(length<3) {
			    		//editable true
			    		textCodiceTavoloAssegnato.setEditable(true);
			    	}else {
			    		textCodiceTavoloAssegnato.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Devi iserire al max 3 numeri!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    	
			    }else {
			    	//now allow for keys 'back space' and 'delete' for edit
			    	if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
			    		//than allow editable
			    		textCodiceTavoloAssegnato.setEditable(true);
			    	}else {
			    		textCodiceTavoloAssegnato.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Devi iserire solo numeri!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    }
			}
			
		});
		textCodiceTavoloAssegnato.setBounds(446, 205, 53, 20);
		contentPane.add(textCodiceTavoloAssegnato);
		textCodiceTavoloAssegnato.setColumns(10);
		
		lblCodiceTavoloAssegnato = new JLabel("Codice tavolo assegnato");
		lblCodiceTavoloAssegnato.setBounds(274, 208, 149, 14);
		contentPane.add(lblCodiceTavoloAssegnato);
		
		lblClientiInseriti = new JLabel("Clienti inseriti");
		lblClientiInseriti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblClientiInseriti.setBounds(27, 304, 189, 14);
		contentPane.add(lblClientiInseriti);
		
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
		
		lblInserisciDatiClienti = new JLabel("Inserisci i dati dei clienti ");
		lblInserisciDatiClienti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblInserisciDatiClienti.setBounds(32, 208, 184, 14);
		contentPane.add(lblInserisciDatiClienti);
		
		btnChiudi = new JButton("Chiudi");
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
		
		lblDataPrenotazione = new JLabel("Data Prenotazione");
		lblDataPrenotazione.setBounds(39, 19, 108, 14);
		contentPane.add(lblDataPrenotazione);
		
		textCognomeCliente = new JTextField();
		textCognomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//JTextField to accept only alfabets
				//code for JTextField that acept letter whitespace and delete backspace key only
				char c = e.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//ISOControl for edit operation (delete key and backspace key allow)
					//if enter character is letter, space and isocontrol char than allow to edit
					textCognomeCliente.setEditable(true);					
				}else {
					textCognomeCliente.setEditable(false);
				}
				cognomeCliente = textNome.getText();
				
			}				
			
		});
		textCognomeCliente.setBounds(130, 234, 121, 20);
		contentPane.add(textCognomeCliente);
		textCognomeCliente.setColumns(10);		
		
		lblCognomeCliente = new JLabel("Cognome");
		lblCognomeCliente.setBounds(32, 237, 64, 14);
		contentPane.add(lblCognomeCliente);
		
		lblPrenotazione = new JLabel("Prenotazione");
		lblPrenotazione.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPrenotazione.setBounds(27, 46, 224, 28);
		contentPane.add(lblPrenotazione);
	}
}

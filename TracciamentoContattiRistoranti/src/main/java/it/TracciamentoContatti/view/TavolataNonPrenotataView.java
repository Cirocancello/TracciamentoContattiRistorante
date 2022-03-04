package it.TracciamentoContatti.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.model.Cliente;
import it.controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.TextArea;
import java.awt.Label;
import com.toedter.calendar.JDateChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TavolataNonPrenotataView extends JFrame {

	private JPanel contentPane;
	
	private JTextField textNumeroPersone;
	private JTextField textCartaIdentita;
	private JTextField textTelefono;
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textCodiceTavoloAssegnato;
	private TextArea textAreaClienti;
	private JButton btnChiudi;
	private JButton btnAggiungiCliente;
	private JButton btnCercaTavoloLibero;
	private JTextField textCodiceRistorante;
	private JLabel lblCodiceRistorante;
	private JDateChooser dateChooser;
	private String data;
	private String telefono;
	private String cognome;
	private String nome;
	private String codiceTavolo;
	private String cartaIdentita;
	private String numeroPersone;
	private String codiceRistorante;
	private JTextArea textArea;
	private JLabel lblInserisciDatiClienti;
	private JLabel lblClientiInseriti;
	private JLabel lblNumeroPersone;
	private JLabel lblCognome;
	
	private JLabel lblNome;
	private JLabel lblTelefono;
	private JLabel lblCartaIdentita;
	private JLabel lblData;
	private JLabel lblCodiceTavoloAssegnato;
	
	
	
	/**
	 * Create the frame.
	 */
	public TavolataNonPrenotataView() {
		
		setResizable(false);
		setVisible(true);
		
		setTitle("Tavolata non prenotata");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 180, 567, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAggiungiCliente = new JButton("Aggiungi cliente");
		btnAggiungiCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controller controller = new Controller();					
				
				codiceTavolo = textCodiceTavoloAssegnato.getText();			
				   
				if(codiceTavolo.length() == 0) {			           
					JOptionPane.showMessageDialog(null,  "Campo codice tavolo vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
				cognome = textCognome.getText();
				if(cognome.length() == 0) {			           
					JOptionPane.showMessageDialog(null,  "Campo cognome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
		
				nome = textNome.getText();
				if(nome.length() == 0) {			           
					JOptionPane.showMessageDialog(null,  "Campo nome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
				
				telefono = textTelefono.getText();
				if(telefono.length() == 0) {			           
					JOptionPane.showMessageDialog(null,  "Campo telefono vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
				
				cartaIdentita = textCartaIdentita.getText();	
				if(cartaIdentita.length() == 0) {			           
					JOptionPane.showMessageDialog(null,  "Campo carta identità vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }			
	
				
				
				Date theData = Date.valueOf(data);
				    
				Cliente cliente = new Cliente(Integer.parseInt(codiceTavolo),cognome, nome, telefono, cartaIdentita, theData);
			    controller.inserisciCliente(cliente, textAreaClienti);
				
			  //  textCodiceTavoloAssegnato.setText("");
			    textCognome.setText("");
			    textNome.setText("");
			    textTelefono.setText("");
			    textCartaIdentita.setText("");
			    textTelefono.setEditable(true);
			    textCartaIdentita.setEditable(true);  
			    textCognome.setEditable(true);
			    textNome.setEditable(true);
			    
			}
		});
		btnAggiungiCliente.setBounds(376, 234, 150, 23);
		contentPane.add(btnAggiungiCliente);
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			
			}
		});
		btnChiudi.setBounds(437, 443, 89, 23);
		contentPane.add(btnChiudi);
		
		lblNumeroPersone = new JLabel("Numero persone");
		lblNumeroPersone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumeroPersone.setBounds(21, 39, 102, 14);
		contentPane.add(lblNumeroPersone);
		
		textNumeroPersone = new JTextField();
		textNumeroPersone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				numeroPersone = textNumeroPersone.getText().trim();
				//JTextField phone number validation/ accept only numbers
			    //action when key is press
			    //get JTextField string			   
			    
			    int length = numeroPersone.length();
			    
			    char c = e.getKeyChar();
			    //check for number 0 to 9
			    if(e.getKeyChar()>='0' && e.getKeyChar()<='6') {
			    	//check for length not more than 10 digit
			    	if(length<1) {
			    		//editable true
			    		textNumeroPersone.setEditable(true);
			    	}else {
			    		textNumeroPersone.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Devi iserire un solo numero!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    	
			    }else {
			    	//now allow for keys 'back space' and 'delete' for edit
			    	if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
			    		//than allow editable
			    		textNumeroPersone.setEditable(true);
			    	}else {
			    		textNumeroPersone.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Devi iserire solo numeri!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    }
			}
		});
		textNumeroPersone.setBounds(123, 36, 48, 20);
		contentPane.add(textNumeroPersone);
		textNumeroPersone.setColumns(10);
		
		textAreaClienti = new TextArea();
		textAreaClienti.setBounds(21, 277, 505, 160);
		contentPane.add(textAreaClienti);
		
		lblClientiInseriti = new JLabel("Clienti inseriti");
		lblClientiInseriti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblClientiInseriti.setBounds(21, 249, 150, 22);
		contentPane.add(lblClientiInseriti);
		
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
		textCartaIdentita.setBounds(167, 184, 102, 20);
		contentPane.add(textCartaIdentita);
		textCartaIdentita.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				telefono = textTelefono.getText().trim();
				//JTextField phone number validation/ accept only numbers
			    //action when key is press
			    //get JTextField string			   
			    
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
		textTelefono.setBounds(424, 184, 102, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
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
		textNome.setBounds(424, 151, 102, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
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
		textCognome.setColumns(10);
		textCognome.setBounds(167, 151, 102, 20);
		contentPane.add(textCognome);
		
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
		textCodiceTavoloAssegnato.setColumns(10);
		textCodiceTavoloAssegnato.setBounds(219, 212, 48, 20);
		contentPane.add(textCodiceTavoloAssegnato);
		
		lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(21, 151, 62, 22);
		contentPane.add(lblCognome);		
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(298, 149, 62, 22);
		contentPane.add(lblNome);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(298, 184, 62, 22);
		contentPane.add(lblTelefono);
		
		lblCartaIdentita = new JLabel("Carta di identità");
		lblCartaIdentita.setBounds(21, 184, 89, 22);
		contentPane.add(lblCartaIdentita);
		
		lblData = new JLabel("Data");
		lblData.setBounds(21, 70, 48, 22);
		contentPane.add(lblData);
		
		lblCodiceTavoloAssegnato = new JLabel("Codice tavolo assegnato");
		lblCodiceTavoloAssegnato.setBounds(20, 210, 164, 22);
		contentPane.add(lblCodiceTavoloAssegnato);
		
		btnCercaTavoloLibero = new JButton("Cerca tavolo libero");
		btnCercaTavoloLibero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
								
				Controller controller = new Controller();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				data = null;
				try {
				   data = dateFormat.format(dateChooser.getDate());
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,  "Devi inserire una data valida!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				numeroPersone = textNumeroPersone.getText();;
				   
				if(numeroPersone.length() == 0) {			           
					JOptionPane.showMessageDialog(null,  "Campo numero persone vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
				
				codiceRistorante = textCodiceRistorante.getText();;
				   
				if(codiceRistorante.length() == 0) {			           
					JOptionPane.showMessageDialog(null,  "Campo codice ristorante vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
			    }
				
				controller.cercaTavoloLibero(e, textCodiceRistorante, dateChooser, textNumeroPersone,textAreaClienti, textArea);
					
			}
		});
		btnCercaTavoloLibero.setBounds(191, 70, 145, 23);
		contentPane.add(btnCercaTavoloLibero);
		
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
						JOptionPane.showMessageDialog(null,  "Il codice riatorante max 2 cifre!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

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
		textCodiceRistorante.setBounds(276, 36, 48, 20);
		contentPane.add(textCodiceRistorante);
		textCodiceRistorante.setColumns(10);
		
		lblCodiceRistorante = new JLabel("Codice Ristorante");
		lblCodiceRistorante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodiceRistorante.setBounds(181, 39, 113, 14);
		contentPane.add(lblCodiceRistorante);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(69, 72, 102, 20);
		contentPane.add(dateChooser);
		
		textArea = new JTextArea();
		textArea.setBounds(354, 11, 172, 82);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		lblInserisciDatiClienti = new JLabel("Inserisci i dati dei clienti");
		lblInserisciDatiClienti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblInserisciDatiClienti.setBounds(25, 124, 212, 14);
		contentPane.add(lblInserisciDatiClienti);
	}
}

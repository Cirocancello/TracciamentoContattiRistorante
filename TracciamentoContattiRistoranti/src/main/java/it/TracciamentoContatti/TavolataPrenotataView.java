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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private String telefono;
	private String cognome;
	private String nome;
	private String cognome1;
	private String cartaIdentita;
	private String  codiceTavolo;
	
	
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
		textNome.setBounds(130, 234, 121, 20);
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
		textCartaIdentita.setBounds(383, 264, 121, 20);
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
		textTelefono.setBounds(384, 234, 121, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JButton btnInserisciClienti = new JButton("Inserisci cliente");
		btnInserisciClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controller controller = new Controller();			
				
				codiceTavolo = textCodiceTavolo.getText().trim();
				if(codiceTavolo.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo codice tavolo vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				cognome1 = textCognome1.getText().trim();
				if(cognome1.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Campo cognome vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//TODO aggiungi anche i controlli sugli altri campi che non devono essere vuoti come il cognome1
				
				cartaIdentita = textCartaIdentita.getText().trim();
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
		textCodiceTavolo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				codiceTavolo = textCodiceTavolo.getText().trim();
				//JTextField phone number validation/ accept only numbers
			    //action when key is press
			    //get JTextField string			   
			    
			    int length = codiceTavolo.length();
			    
			    char c = e.getKeyChar();
			    //check for number 0 to 9
			    if(e.getKeyChar()>='0' && e.getKeyChar()<='9') {
			    	//check for length not more than 2 digit
			    	if(length<2) {
			    		//editable true
			    		textCodiceTavolo.setEditable(true);
			    	}else {
			    		textCodiceTavolo.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Devi iserire al max 2 numeri!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    	
			    }else {
			    	//now allow for keys 'back space' and 'delete' for edit
			    	if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
			    		//than allow editable
			    		textCodiceTavolo.setEditable(true);
			    	}else {
			    		textCodiceTavolo.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Devi iserire solo numeri!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    }
			}
			
		});
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
		textCognome1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//JTextField to accept only alfabets
				//code for JTextField that acept letter whitespace and delete backspace key only
				char c = e.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//ISOControl for edit operation (delete key and backspace key allow)
					//if enter character is letter, space and isocontrol char than allow to edit
					textCognome1.setEditable(true);					
				}else {
					textCognome1.setEditable(false);
				}
				cognome1 = textNome.getText();
				
			}				
			
		});
		textCognome1.setBounds(130, 205, 121, 20);
		contentPane.add(textCognome1);
		textCognome1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cognome");
		lblNewLabel_5.setBounds(27, 208, 64, 14);
		contentPane.add(lblNewLabel_5);
	}
}

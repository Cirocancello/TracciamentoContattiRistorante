package it.TracciamentoContatti.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.Ristorante;
import it.controller.Controller;

import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JMonthChooser;

import java.awt.Font;


public class StatisticaGiornalieraView extends JFrame {

	private JPanel contentPane;
	
	private JButton btnRistoranti;
	private JButton btnChiudi;
	private JButton btnVisualizzaStatistica;
	
	private TextArea textAreaRistoranti;
	private JTextField textCodiceRistorante;
	private TextArea textAreaStatistica;

	private JLabel lblRistoranti;
	private JLabel lblCodiceRistorante;
	private JLabel lblNumeroAvventori;
	
	private String codiceRistorante;	
	private Integer length;
	private Controller controller;
	private HomePageView homePage;
	
	/**
	 * Create the frame.  creazione della finestra grafica della statistica giornaliera
	 */
	public StatisticaGiornalieraView() {
		setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		setTitle("Statistiche giornaliere");
		
		setResizable(false);
		setVisible(true);
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 450, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRistoranti = new JButton("ristoranti");
		btnRistoranti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				controller = new Controller();
				
				controller.stampaRistoranti(textAreaRistoranti);
				
				
			}
		});
		btnRistoranti.setBounds(320, 11, 89, 23);
		contentPane.add(btnRistoranti);
		
		textAreaRistoranti = new TextArea();
		textAreaRistoranti.setBounds(28, 40, 380, 110);
		contentPane.add(textAreaRistoranti);		
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage = new HomePageView();
				homePage.setVisible(true);
				dispose();
			}
		});
		btnChiudi.setBounds(320, 410, 89, 23);
		contentPane.add(btnChiudi);
		
		lblRistoranti = new JLabel("Ristoranti presenti in base dati");
		lblRistoranti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblRistoranti.setBounds(28, 13, 214, 21);
		contentPane.add(lblRistoranti);
		
		lblCodiceRistorante = new JLabel("Codice ristorante");
		lblCodiceRistorante.setBounds(28, 159, 116, 14);
		contentPane.add(lblCodiceRistorante);
		
		textCodiceRistorante = new JTextField();
		textCodiceRistorante.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				codiceRistorante = textCodiceRistorante.getText().trim();
				//JTextField phone number validation/ accept only numbers
			    //action when key is press
			    //get JTextField string			   
			    
			    length = codiceRistorante.length();
			    
			    char c = e.getKeyChar();
			    //check for number 0 to 9
			    if(e.getKeyChar()>='0' && e.getKeyChar()<='4') {
			    	//check for length not more than 2 digit
			    	if(length<2) {
			    		//editable true
			    		textCodiceRistorante.setEditable(true);
			    	}else {
			    		textCodiceRistorante.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Il codice ristorante troppo lungo!!!", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    	
			    }else {
			    	//now allow for keys 'back space' and 'delete' for edit
			    	if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
			    		//than allow editable
			    		textCodiceRistorante.setEditable(true);
			    	}else {
			    		textCodiceRistorante.setEditable(false);
						JOptionPane.showMessageDialog(null,  "Il codice ristorante errato!!!", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);

			    	}
			    }
			
			}
		});
		textCodiceRistorante.setBounds(153, 156, 51, 20);
		contentPane.add(textCodiceRistorante);
		textCodiceRistorante.setColumns(10);
		
		btnVisualizzaStatistica = new JButton("Visualizza Statistica");
		btnVisualizzaStatistica.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			controller = new Controller();				
			
			codiceRistorante = textCodiceRistorante.getText();
			if(codiceRistorante.length() == 0) {
				JOptionPane.showMessageDialog(null,  "Campo codice ristorante vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
				return;
			}
		
			controller.statiscticaGiornaliera(codiceRistorante, textAreaStatistica);
			
		}
		});
		btnVisualizzaStatistica.setBounds(247, 190, 152, 23);
		contentPane.add(btnVisualizzaStatistica);
		
		textAreaStatistica = new TextArea();
		textAreaStatistica.setBounds(28, 244, 380, 160);
		contentPane.add(textAreaStatistica);
		
		lblNumeroAvventori = new JLabel("numero totale di avventori ");
		lblNumeroAvventori.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNumeroAvventori.setBounds(28, 224, 229, 14);
		contentPane.add(lblNumeroAvventori);		
		
		
	}
}

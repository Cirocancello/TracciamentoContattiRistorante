package it.TracciamentoContatti;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.model.Model;
import it.TracciamentoContatti.model.Ristorante;

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

public class StatisticaView extends JFrame {

	private JPanel contentPane;
	
	private Controller controller;
	private JButton btnRistoranti;
	private TextArea textAreaRistoranti;
	private JTextField textCodiceRistorante;
	private String codiceRistorante;
	private JDateChooser dateChooser;
	private TextArea textAreaStatisctica;

	/**
	 * Create the frame.
	 */
	public StatisticaView() {
		
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
				
				Controller controller = new Controller();
				
				controller.StampaRistoranti(textAreaRistoranti);
				
				
			}
		});
		btnRistoranti.setBounds(320, 11, 89, 23);
		contentPane.add(btnRistoranti);
		
		textAreaRistoranti = new TextArea();
		textAreaRistoranti.setBounds(28, 40, 380, 110);
		contentPane.add(textAreaRistoranti);		
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnChiudi.setBounds(320, 410, 89, 23);
		contentPane.add(btnChiudi);
		
		JLabel lblNewLabel = new JLabel("Ristoranti presenti in base dati");
		lblNewLabel.setBounds(28, 11, 176, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data");
		lblNewLabel_1.setBounds(28, 192, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codice ristorante");
		lblNewLabel_2.setBounds(28, 156, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(84, 186, 116, 20);
		contentPane.add(dateChooser);
		
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
		textCodiceRistorante.setBounds(153, 156, 51, 20);
		contentPane.add(textCodiceRistorante);
		textCodiceRistorante.setColumns(10);
		
		JButton btnGiornaliera = new JButton("Giornaliera");
		btnGiornaliera.addActionListener(new ActionListener() {
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
					
			codiceRistorante = textCodiceRistorante.getText();
			if(codiceRistorante.length() == 0) {
				JOptionPane.showMessageDialog(null,  "Campo codice ristorante vuoto!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
//			controller.statiscticaGiornaliera(codiceRistorante, data, textAreaStatisctica);
			
		}
		});
		btnGiornaliera.setBounds(310, 155, 99, 23);
		contentPane.add(btnGiornaliera);
		
		JButton btnMensile = new JButton("Mensile");
		btnMensile.setBounds(310, 188, 99, 23);
		contentPane.add(btnMensile);
		
		textAreaStatisctica = new TextArea();
		textAreaStatisctica.setBounds(28, 244, 380, 160);
		contentPane.add(textAreaStatisctica);
		
		JLabel lblNewLabel_3 = new JLabel("numero totale di avventori ");
		lblNewLabel_3.setBounds(28, 224, 147, 14);
		contentPane.add(lblNewLabel_3);
		
		
		
		
	}
}

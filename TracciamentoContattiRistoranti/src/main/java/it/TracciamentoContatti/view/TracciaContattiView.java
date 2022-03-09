package it.TracciamentoContatti.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Choice;
import java.awt.TextArea;
import com.toedter.calendar.JDateChooser;

import it.controller.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TracciaContattiView extends JFrame {

	private JPanel contentPane;
	private JTextField textCartaIdentita;
	private JButton btnTraccia;
	private TextArea textAreaTraccia;
	
	private JDateChooser dateChooser;
	private JLabel lblClientiDaContattare;
	private JLabel lblData ;
	private JLabel lblCartaIdentita;		
	private JLabel lblTracciaContatti ;
	private JButton btnTornaAlMenu;
	
	private String cartaIdentita;
	private String data;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public TracciaContattiView() {
		
		setResizable(false);
		setVisible(true);
		setTitle("Tracciamento Contatti");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(455, 200, 501, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		textCartaIdentita.setBounds(131, 70, 138, 20);
		contentPane.add(textCartaIdentita);
		textCartaIdentita.setColumns(10);
		
		btnTraccia = new JButton("Traccia");
		btnTraccia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller = new Controller();
				
				cartaIdentita = textCartaIdentita.getText();
				if (cartaIdentita.length() == 0) {
					JOptionPane.showMessageDialog(null,  "Devi inserire una carta di identità valida!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				data = null;
				try {
				   data = dateFormat.format(dateChooser.getDate());
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,  "Devi inserire una data valida!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					controller.tracciaContatti(cartaIdentita, data, textAreaTraccia);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,  "Devi inserire una data valida!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);
					return;					
				}
			}
					
					
				
			
		});
		btnTraccia.setBounds(361, 103, 89, 23);
		contentPane.add(btnTraccia);
		
		lblData = new JLabel("Data");
		lblData.setBounds(279, 73, 46, 14);
		contentPane.add(lblData);
				
		lblCartaIdentita = new JLabel("Carta di identità");
		lblCartaIdentita.setBounds(25, 73, 108, 14);
		contentPane.add(lblCartaIdentita);
		
		lblTracciaContatti = new JLabel("Tracciamento contatti, in seguito contagio covid-19");
		lblTracciaContatti.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTracciaContatti.setBounds(70, 11, 354, 33);
		contentPane.add(lblTracciaContatti);
		
		btnTornaAlMenu = new JButton("Torna al menu principale");
		btnTornaAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnTornaAlMenu.setBounds(260, 396, 215, 23);
		contentPane.add(btnTornaAlMenu);
		
		textAreaTraccia = new TextArea();
		textAreaTraccia.setBounds(25, 148, 436, 230);
		contentPane.add(textAreaTraccia);
		
		lblClientiDaContattare = new JLabel("Clienti da contattare");
		lblClientiDaContattare.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblClientiDaContattare.setBounds(25, 127, 159, 14);
		contentPane.add(lblClientiDaContattare);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(342, 70, 108, 20);
		contentPane.add(dateChooser);
	}
}

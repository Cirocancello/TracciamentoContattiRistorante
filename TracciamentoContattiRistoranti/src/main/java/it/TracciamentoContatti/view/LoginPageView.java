package it.TracciamentoContatti.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.controller.Controller;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginPageView extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JButton btnChiudi;
	private JButton btnCancella;
	private Controller controller;
	private String userName;
	private String password;

	/**
	 * Create the frame. creazione della finestra grafica della login page
	 */
	public LoginPageView() {
		final LoginPageView self = this;
		
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		setTitle("Login page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 323, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(55, 48, 89, 14);
		contentPane.add(lblUserName);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(55, 97, 89, 14);
		contentPane.add(lblPassword);
		
		textUserName = new JTextField();
		textUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				userName = textUserName.getText();
				int length = userName.length();			
				
				//JTextField to accept only alfabets
				//code for JTextField that acept letter whitespace and delete backspace key only
				char c = e.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//ISOControl for edit operation (delete key and backspace key allow)
					//if enter character is letter, space and isocontrol char than allow to edit
								   
				   //check for length not more than 8 digit
				   if(length<8) {
				      //editable true
				      textUserName.setEditable(true);
				   }else {
				      textUserName.setEditable(false);
				   } 
				}else {
			       //now allow for keys 'back space' and 'delete' for edit
			       if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
			    	 //than allow editable
			    	 textUserName.setEditable(true);
			       }else {
			       	 textUserName.setEditable(false);
			       }
				}
			}
		  
		});
		textUserName.setBounds(177, 47, 86, 20);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    userName = textUserName.getText();
				password = passwordField.getText();
				
				controller = new Controller();
				controller.login(userName, password, self);
				
			}
		});
		btnLogin.setBounds(174, 142, 89, 23);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		passwordField.setBounds(177, 96, 86, 20);
		contentPane.add(passwordField);
		
		btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUserName.setText("");
				passwordField.setText("");				
				
			}
		});
		btnCancella.setBounds(43, 142, 89, 23);
		contentPane.add(btnCancella);
		
		btnChiudi = new JButton("Chiudi");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnChiudi.setBounds(174, 198, 89, 23);
		contentPane.add(btnChiudi);
	}
}

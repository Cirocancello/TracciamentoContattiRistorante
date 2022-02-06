package it.TracciamentoContatti;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.model.Model;

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

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		setTitle("Login page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 323, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(55, 48, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(55, 97, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		textUserName = new JTextField();
		textUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//JTextField to accept only alfabets
				//code for JTextField that acept letter whitespace and delete backspace key only
				char c = e.getKeyChar();
				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
					//ISOControl for edit operation (delete key and backspace key allow)
					//if enter character is letter, space and isocontrol char than allow to edit
					textUserName.setEditable(true);					
				}else {
					textUserName.setEditable(false);
				}				
				
				
			}
		});
		textUserName.setBounds(177, 47, 86, 20);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textUserName.getText();
				String password = passwordField.getText();
				Integer codiceLogin = null;
		
				Model models = new Model();
				codiceLogin = models.login(userName, password);
				//System.out.println( codiceLogin);
				
				if(codiceLogin != null) {
			        HomePageView frame = new HomePageView();					
			        Model model = new Model();
			        Controller controller = new Controller(frame, model);
	  
			        frame.setController(controller);
			
			        frame.setResizable(false);
			        frame.setVisible(true);		

				}else {
			        
					JOptionPane.showMessageDialog(null,  "Username o Password non presenti in base dati!!! ", "Attenzione!!!", JOptionPane.ERROR_MESSAGE);


				}
				
			}
		});
		btnLogin.setBounds(40, 144, 89, 23);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 96, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUserName.setText("");
				passwordField.setText("");				
				
			}
		});
		btnDelete.setBounds(174, 144, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(174, 190, 89, 23);
		contentPane.add(btnNewButton);
	}
}

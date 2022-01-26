package it.TracciamentoContatti;

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
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TracciaContattiView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;


	/**
	 * Create the frame.
	 */
	public TracciaContattiView() {
		
		setResizable(false);
		setVisible(true);
		setTitle("Tracciamento Contatti");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(455, 300, 501, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 86, 138, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Traccia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(366, 85, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setBounds(282, 88, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Carta di identità");
		lblNewLabel_1.setBounds(23, 89, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(322, 70, 17, 50);
		contentPane.add(scrollbar);
		
		JLabel lblNewLabel_2 = new JLabel("Tracciamento contatti, in seguito contagio covid-19");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(70, 30, 354, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Torna al menu principale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton_1.setBounds(240, 129, 215, 23);
		contentPane.add(btnNewButton_1);
	}

}

package it.polito.tdp.TracciamentoContatti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.Scrollbar;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;

public class View extends JFrame {

	private JPanel contentPane;
		
	public Controller controller;

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Sistema tracciamento contatti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema di tracciamento contatti nei ristoranti");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(54, 27, 370, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Prenotazione");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrenotazioneView prenotazioneView = new PrenotazioneView();	
				prenotazioneView.setResizable(false);
				prenotazioneView.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(54, 101, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nuovo ristorante");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ciao");
			}
		});
		btnNewButton_1.setBounds(237, 146, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tracia contatti");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TracciaContattiView tracciaContatti = new TracciaContattiView();
				tracciaContatti.setResizable(false);
				tracciaContatti.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(236, 101, 120, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tavolata");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TavolataView tavolataView = new TavolataView();
				tavolataView.setResizable(false);
				tavolataView.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(54, 146, 119, 23);
		contentPane.add(btnNewButton_3);
	}
	
	public void setController(Controller controller) {
		
		this.controller = controller;
		
		
	}
}

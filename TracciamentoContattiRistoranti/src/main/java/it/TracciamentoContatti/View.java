package it.TracciamentoContatti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.TracciamentoContatti.model.Model;

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
	
	public JButton btnPrenota;
	public JButton btnTracciaContatti;
	public JButton btnTavolataPrenotata;
	public JButton btnNuovoRistorante;
	public JButton btnTavolataNonPrenotata;	

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
		
		btnPrenota = new JButton("Prenotazione");
		btnPrenota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ePrenota) {	
			
				controller.Actionperformed(ePrenota);
				
				
			}
		});
		btnPrenota.setBounds(44, 101, 162, 23);
		contentPane.add(btnPrenota);
		
		btnNuovoRistorante = new JButton("Nuovo ristorante");
		btnNuovoRistorante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				controller.Actionperformed(e);
			}
		});
		btnNuovoRistorante.setBounds(44, 186, 162, 23);
		contentPane.add(btnNuovoRistorante);
		
		btnTracciaContatti = new JButton("Traccia contatti");
		btnTracciaContatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.Actionperformed(e);
				
			}
		});
		btnTracciaContatti.setBounds(44, 146, 162, 23);
		contentPane.add(btnTracciaContatti);
		
		btnTavolataPrenotata = new JButton("Tavolata prenotata");
		btnTavolataPrenotata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				controller.Actionperformed(e);
			
			}
		});
		btnTavolataPrenotata.setBounds(211, 101, 174, 23);
		contentPane.add(btnTavolataPrenotata);
		
		btnTavolataNonPrenotata = new JButton("Tavolata non prenotata");
		btnTavolataNonPrenotata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.Actionperformed(e);
			}
		});
		btnTavolataNonPrenotata.setBounds(211, 146, 174, 23);
		contentPane.add(btnTavolataNonPrenotata);
		
		JButton btnNewButton = new JButton("Chiudi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		btnNewButton.setBounds(324, 215, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void setController(Controller controller) {
		
		this.controller = controller;		
		
	}
}

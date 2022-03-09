package it.TracciamentoContatti.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.controller.Controller;

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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class HomePageView extends JFrame {

	private JPanel contentPane;
		
	public Controller controller;
	private JMenuBar menuBar;
	private JMenu prenotazione;
	private JMenuItem effettuaPrenotazione;
	private JMenu tavolata;
	private JMenuItem tavolataPrenotata;
	private JMenuItem tavolataNonPrenotata;
	private JMenu tracciaContatti;
	private JMenuItem traccia;
	private JMenu statistiche;
	private JMenuItem mensile;
	private JMenuItem giornaliera;
	private JMenu esci;
	private JMenuItem exit;
	private JLabel label1;
	private JLabel label2;

	/**
	 * Create the frame.
	 */
	public HomePageView() {
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 246);
		
		
		controller = new Controller();
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		prenotazione = new JMenu("Prenotazione");
		menuBar.add(prenotazione);
		
		effettuaPrenotazione = new JMenuItem("Effettua prenotazione");
		effettuaPrenotazione.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ePrenota) {
				
				controller.actionPrenota(ePrenota);
			}
		});
		prenotazione.add(effettuaPrenotazione);
		
		tavolata = new JMenu("Tavolata");
		menuBar.add(tavolata);
		
		tavolataNonPrenotata = new JMenuItem("Tavolata non prenotata");
		tavolataNonPrenotata.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent eTavNonPrenotata) {
			
				controller.actionTavolataNonPrenotata(eTavNonPrenotata);
			}
		});
		tavolata.add(tavolataNonPrenotata);
		
		tavolataPrenotata = new JMenuItem("Tavolata prenotata");
		tavolataPrenotata.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent eTavPrenotata) {
				controller.actionTavolataPrenotata(eTavPrenotata);
				
			}
			
		});
		tavolata.add(tavolataPrenotata);
		
		tracciaContatti = new JMenu("Traccia contatti");
		menuBar.add(tracciaContatti);
		
		traccia = new JMenuItem("Traccia");
		traccia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent eTracciaContatti) {
				controller.actionTracciaContatti(eTracciaContatti);
			}
		});
		tracciaContatti.add(traccia);
		
		statistiche = new JMenu("Statistiche");
		menuBar.add(statistiche);
		
		giornaliera = new JMenuItem("Giornaliera");
		giornaliera.addActionListener(new ActionListener() {
			@Override			
			public void actionPerformed(ActionEvent eStatisticaGiornaliera) {
				controller.actionStatisticaGiornaliera(eStatisticaGiornaliera);
			}
		});
		statistiche.add(giornaliera);
		
		mensile = new JMenuItem("Mensile");
		mensile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eStatisticaMensile) {
				controller.actionStatisticaMensile(eStatisticaMensile);
				
			}
		});
		statistiche.add(mensile);
		
		esci = new JMenu("Esci");
		menuBar.add(esci);
		
		exit = new JMenuItem("Esci");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		esci.add(exit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label1 = new JLabel("Sistema di tracciamento contatti covid-19 ");
		label1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label1.setBounds(38, 24, 414, 42);
		contentPane.add(label1);
		
		label2 = new JLabel("in ristoranti");
		label2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label2.setBounds(164, 64, 154, 14);
		contentPane.add(label2);
	}
	
}

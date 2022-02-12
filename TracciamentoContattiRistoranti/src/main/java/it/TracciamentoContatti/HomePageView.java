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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class HomePageView extends JFrame {

	private JPanel contentPane;
		
	public Controller controller;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem_8;
	private JLabel lblNewLabel_1;

	/**
	 * Create the frame.
	 */
	public HomePageView() {
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 246);
		
		final Controller controller = new Controller();
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Prenotazione");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Effettua prenotazione");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ePrenota) {
				
				controller.Actionperformed(ePrenota);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Tavolata");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Tavolata non prenotata");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent eTavNonPrenotata) {
			
				controller.Actionperformed1(eTavNonPrenotata);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_1 = new JMenuItem("Tavolata prenotata");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent eTavPrenotata) {
				controller.Actionperformed2(eTavPrenotata);
				
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mnNewMenu_2 = new JMenu("Traccia contatti");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Traccia");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent eTracciaContatti) {
				controller.Actionperformed3(eTracciaContatti);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		mnNewMenu_3 = new JMenu("Statistiche");
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_5 = new JMenuItem("Giornaliera");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			@Override			
			public void actionPerformed(ActionEvent eStatisticaGiornaliera) {
				controller.Actionperformed4(eStatisticaGiornaliera);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		mntmNewMenuItem_4 = new JMenuItem("Mensile");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eStatisticaMensile) {
				controller.Actionperformed5(eStatisticaMensile);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		mnNewMenu_4 = new JMenu("Esci");
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem_8 = new JMenuItem("Esci");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema di tracciamento contatti nei ristoranti");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(20, 21, 414, 42);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("covid-19");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(164, 64, 154, 14);
		contentPane.add(lblNewLabel_1);
	}
	
}

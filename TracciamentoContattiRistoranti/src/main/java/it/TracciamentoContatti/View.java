package it.TracciamentoContatti;

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
	
	public JButton btnPrenota;
	public JButton btnTracciaContatti;
	public JButton btnTavolata;
	public JButton btnNuovoRistorante;

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
			public void actionPerformed(ActionEvent e) {	
				
				controller.Actionperformed(e);
				
			}
		});
		btnPrenota.setBounds(54, 101, 119, 23);
		contentPane.add(btnPrenota);
		
		btnNuovoRistorante = new JButton("Nuovo ristorante");
		btnNuovoRistorante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ciao");
				controller.Actionperformed(e);
			}
		});
		btnNuovoRistorante.setBounds(237, 146, 119, 23);
		contentPane.add(btnNuovoRistorante);
		
		btnTracciaContatti = new JButton("Tracia contatti");
		btnTracciaContatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.Actionperformed(e);
				
			}
		});
		btnTracciaContatti.setBounds(236, 101, 120, 23);
		contentPane.add(btnTracciaContatti);
		
		btnTavolata = new JButton("Tavolata");
		btnTavolata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.Actionperformed(e);
			
			}
		});
		btnTavolata.setBounds(54, 146, 119, 23);
		contentPane.add(btnTavolata);
	}
	
	public void setController(Controller controller) {
		
		this.controller = controller;		
		
	}
	
}

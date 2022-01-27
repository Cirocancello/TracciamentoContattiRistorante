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
import javax.swing.JComboBox;

public class RistoranteView extends JFrame {

	private JPanel contentPane;
	
	private Controller controller;
	private JButton btnRistoranti;
	private TextArea textAreaRistoranti;
	


	/**
	 * Create the frame.
	 */
	public RistoranteView() {
		
		setResizable(false);
		setVisible(true);
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRistoranti = new JButton("ristoranti");
		btnRistoranti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Model model = new Model();
				
				Controller controller = new Controller();
				
				controller.StampaRistoranti(textAreaRistoranti);
				
				
			}
		});
		btnRistoranti.setBounds(164, 33, 89, 23);
		contentPane.add(btnRistoranti);
		
		textAreaRistoranti = new TextArea();
		textAreaRistoranti.setBounds(29, 77, 380, 160);
		contentPane.add(textAreaRistoranti);		
		
		
		
		
	}
}

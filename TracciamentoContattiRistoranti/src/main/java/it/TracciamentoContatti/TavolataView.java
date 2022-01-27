package it.TracciamentoContatti;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class TavolataView extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	/**
	 * Create the frame.
	 */
	public TavolataView() {
		
		setResizable(false);
		setVisible(true);
		
		setTitle("Tavolata");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 466, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tavolata");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(176, 24, 102, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(32, 60, 384, 192);
		contentPane.add(textArea);
		
		JButton btnAggiungiCliente = new JButton("Aggiungi cliente");
		btnAggiungiCliente.setBounds(32, 273, 150, 23);
		contentPane.add(btnAggiungiCliente);
		
		JButton btnChiudi = new JButton("Chiudi");
		btnChiudi.setBounds(327, 273, 89, 23);
		contentPane.add(btnChiudi);
	}
}

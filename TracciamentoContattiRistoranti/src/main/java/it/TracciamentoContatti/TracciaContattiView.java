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
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.TextArea;

public class TracciaContattiView extends JFrame {

	private JPanel contentPane;
	private JTextField textCartaIdentita;
	private JButton btnTraccia;
	private JTextField textData;
	private TextArea textAreaTraccia;

	/**
	 * Create the frame.
	 */
	public TracciaContattiView() {
		
		setResizable(false);
		setVisible(true);
		setTitle("Tracciamento Contatti");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(455, 200, 501, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textCartaIdentita = new JTextField();
		textCartaIdentita.setBounds(131, 70, 138, 20);
		contentPane.add(textCartaIdentita);
		textCartaIdentita.setColumns(10);
		
		btnTraccia = new JButton("Traccia");
		btnTraccia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller controller = new Controller();
				try {
					controller.TracciaContatti(textCartaIdentita, textData, textAreaTraccia);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTraccia.setBounds(361, 103, 89, 23);
		contentPane.add(btnTraccia);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(279, 73, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblCartaIdentita = new JLabel("Carta di identità");
		lblCartaIdentita.setBounds(25, 73, 108, 14);
		contentPane.add(lblCartaIdentita);
		
		JLabel lblTracciaContatti = new JLabel("Tracciamento contatti, in seguito contagio covid-19");
		lblTracciaContatti.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTracciaContatti.setBounds(70, 30, 354, 14);
		contentPane.add(lblTracciaContatti);
		
		JButton btnTornaAlMenu = new JButton("Torna al menu principale");
		btnTornaAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnTornaAlMenu.setBounds(260, 396, 215, 23);
		contentPane.add(btnTornaAlMenu);
		
		Choice choice = new Choice();
		choice.setBounds(216, 96, 89, 20);
		contentPane.add(choice);
		
		textAreaTraccia = new TextArea();
		textAreaTraccia.setBounds(25, 148, 436, 230);
		contentPane.add(textAreaTraccia);
		
		textData = new JTextField();
		textData.setBounds(338, 70, 86, 20);
		contentPane.add(textData);
		textData.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Clienti da contattare");
		lblNewLabel.setBounds(25, 127, 159, 14);
		contentPane.add(lblNewLabel);
	}
}

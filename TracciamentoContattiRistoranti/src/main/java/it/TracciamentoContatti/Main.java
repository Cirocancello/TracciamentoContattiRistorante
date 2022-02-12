package it.TracciamentoContatti;

import java.awt.EventQueue;

import it.TracciamentoContatti.Controller;
import it.TracciamentoContatti.model.Model;

public class Main {		
		private Model model;
		private Controller controller;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						LoginPage login = new LoginPage();
						login.setResizable(false);
						login.setVisible(true);
				
      			        Model model = new Model();
					    Controller controller = new Controller();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		}
	
}

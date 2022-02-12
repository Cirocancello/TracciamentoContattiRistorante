package it.TracciamentoContatti.view;

import java.awt.EventQueue;

import it.TracciamentoContatti.model.Model;
import it.TracciamentoContatti.view.Controller;

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

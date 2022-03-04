package it.main;

import java.awt.EventQueue;

import it.TracciamentoContatti.view.LoginPageView;
import it.controller.Controller;
import it.model.Model;

//utilizzo username root e password root

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
						
						LoginPageView login = new LoginPageView();
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

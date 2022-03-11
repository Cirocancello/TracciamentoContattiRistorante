package it.main;

import java.awt.EventQueue;

import it.TracciamentoContatti.view.LoginPageView;
import it.controller.Controller;

//utilizzo username root e password root

public class Main {			
		private Controller controller;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
      			      
					    Controller controller = new Controller();
					    controller.creaLogin();
					    
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		}
	
}

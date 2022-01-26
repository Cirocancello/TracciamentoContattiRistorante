package it.polito.tdp.TracciamentoContatti;

import java.awt.EventQueue;

import it.polito.tdp.TracciamentoContatti.Controller;
import it.polito.tdp.TracciamentoContatti.model.Model;

public class Main {		
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						View frame = new View();					
      					Model model = new Model();
					    Controller controller = new Controller(frame, model);
				  	//	Controller controller = new Controller();
						frame.setController(controller);						
						frame.setResizable(false);
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		}
	
}

package it.TracciamentoContatti;

import java.awt.EventQueue;

import it.TracciamentoContatti.Controller;
import it.TracciamentoContatti.model.Model;

public class Main {		
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						
						HomePageView frame = new HomePageView();					
      					Model model = new Model();
					    Controller controller = new Controller(frame, model);
				  
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

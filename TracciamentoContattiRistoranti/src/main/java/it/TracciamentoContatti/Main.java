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
						
						LoginPage login = new LoginPage();
						login.setResizable(false);
						login.setVisible(true);
//						HomePageView frame = new HomePageView();					
//      			    Model model = new Model();
//					    Controller controller = new Controller(frame, model);
//				  
//						frame.setController(controller);
//						
//						frame.setResizable(false);
//						frame.setVisible(true);
//						
//TODO dopo aver fatto il login recuperare il codice riastorante con la query
// SELECT r.Nome
//FROM login l, ristoranti r
//WHERE l.ID = r.CodiceLogin;

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		}
	
}

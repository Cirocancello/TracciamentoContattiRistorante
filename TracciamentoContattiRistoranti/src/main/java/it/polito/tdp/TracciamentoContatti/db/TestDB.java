package it.polito.tdp.TracciamentoContatti.db;

import java.util.List;

import it.polito.tdp.TracciamentoContatti.model.Ristorante;
import it.polito.tdp.TracciamentoContatti.model.Sala;

	public class TestDB {
		public static void main(String[] args) {			
		
			RistoranteDAO dao = new RistoranteDAO();
	
			List<Ristorante> ristoranti = dao.readRistoranti() ;
	
			for(Ristorante risto: ristoranti) {		
				System.out.println(risto);
			}
		}		

}

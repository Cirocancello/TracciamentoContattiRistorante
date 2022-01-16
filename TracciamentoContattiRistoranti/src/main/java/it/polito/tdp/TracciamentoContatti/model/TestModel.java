package it.polito.tdp.TracciamentoContatti.model;

import java.util.List;

import it.polito.tdp.TracciamentoContatti.db.RistoranteDAO;

public class TestModel {

	public static void main(String[] args) {
			
		RistoranteDAO dao = new RistoranteDAO();
		
		List<Ristorante> ristoranti = dao.readRistoranti() ;
		
		for(Ristorante risto: ristoranti) {		
			System.out.println(risto);
		}
	}		
}




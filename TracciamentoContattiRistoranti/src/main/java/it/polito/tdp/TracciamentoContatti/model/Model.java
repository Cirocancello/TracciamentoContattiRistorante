package it.polito.tdp.TracciamentoContatti.model;

import java.util.List;

import it.polito.tdp.TracciamentoContatti.db.RistoranteDAO;


public class Model {

   private List<Ristorante> ristoranti = null ;
	
  public List<Ristorante> getRistoranti() {
		if (this.ristoranti==null) {
			RistoranteDAO dao = new RistoranteDAO() ;
			this.ristoranti = dao.readRistoranti() ;
		}
		return this.ristoranti;
	}
	
}

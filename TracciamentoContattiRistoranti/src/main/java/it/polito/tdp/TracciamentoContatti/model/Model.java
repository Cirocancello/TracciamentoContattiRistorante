package it.polito.tdp.TracciamentoContatti.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.TracciamentoContatti.db.RistoranteDAO;
import it.polito.tdp.TracciamentoContatti.db.StcrDAO;


public class Model {

   private List<Ristorante> ristoranti = null ;
	
  public List<Ristorante> getRistoranti() {
		if (this.ristoranti==null) {
			RistoranteDAO dao = new RistoranteDAO() ;
			this.ristoranti = dao.getRistoranti() ;
		}
		return this.ristoranti;
	}
	

  
   
}

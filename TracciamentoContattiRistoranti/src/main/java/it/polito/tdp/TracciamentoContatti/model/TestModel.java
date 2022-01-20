package it.polito.tdp.TracciamentoContatti.model;

import java.util.List;
import java.util.Locale;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import it.polito.tdp.TracciamentoContatti.db.RistoranteDAO;

public class TestModel {

	public static void main(String[] args) {
			
		RistoranteDAO dao = new RistoranteDAO();
		
		List<Ristorante> ristoranti = dao.readRistoranti() ;
		
		for(Ristorante risto: ristoranti) {		
			System.out.println(risto);
		}
		
//		
//		LocalDate localDate = LocalDate.of(2022, 1, 20);
//		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
//		System.out.println(localDate.format(formatter)); // stampa 01/01/2016
//	
//		System.out.println(Date.valueOf(localDate)); // converte in formato SQL
//		
//		String data = "1975-12-12";
//		System.out.println(Date.valueOf(data));
//		
//		String d = "2022-01-19";		
//		System.out.println(LocalDate.parse(d)); // converte in formato SQL una string 
//	
//		//res.getDate datecolumn toLocalDate    estrae dal db la data

	
		
	}		
}




package it.TracciamentoContatti.model;

import java.sql.Date;

public class Statistica {
	private Date data;
	private Integer totaleAvventori;
	
	public Statistica(Date data, Integer totaleAvventori) {
			this.data = data;
		    this.totaleAvventori = totaleAvventori;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getTotaleAvventori() {
		return totaleAvventori;
	}

	public void setTotaleAvventori(Integer totaleAvventori) {
		this.totaleAvventori = totaleAvventori;
	}

	@Override
	public String toString() {
		return data +"  "  + totaleAvventori;
	}
	
	

}

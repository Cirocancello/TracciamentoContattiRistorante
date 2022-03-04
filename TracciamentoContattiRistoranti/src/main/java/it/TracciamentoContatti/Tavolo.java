package it.TracciamentoContatti;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Tavolo {
	
	private Integer codice;
	private Integer codiceSala;
	private  String nome;
	private Integer capacitaMassima;
	
	private Sala sala;
	private Prenotazione prenotazione;
	
	private List<Tavolo> tavoliAdiccenti = new LinkedList<>();
	
	
	public Tavolo(Integer codice, Integer codiceSale, String nome, Integer capacitaMassima) {
		this.codice = codice;
		this.codiceSala = codiceSale;
		this.nome = nome;
		this.capacitaMassima = capacitaMassima;
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public Integer getCodiceSala() {
		return codiceSala;
	}

	public void setCodiceSala(Integer codiceSale) {
		this.codiceSala = codiceSale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCapacitaMassima() {
		return capacitaMassima;
	}

	public void setCapacitaMassima(Integer capacitaMassima) {
		this.capacitaMassima = capacitaMassima;
	}

	@Override
	public String toString() {
		return "codice tavolo = " + codice + ", codice sala a cui appartiene = " + codiceSala + ", nome = " + nome 
				+ ", capacitaMassima = " + capacitaMassima ;
	}
	
	

}

package it.TracciamentoContatti.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Tavolo {
	
	private int codice;
	private int codiceSala;
	private  String nome;
	private int capacitaMassima;
	
	private List<Prenotazione> prenotazione = new LinkedList<>();
	
	private List<Tavolo> tavoliAdiccenti = new LinkedList<>();
	
	public Tavolo(int codice, int codiceSale, String nome, int capacitaMassima) {
		this.codice = codice;
		this.codiceSala = codiceSale;
		this.nome = nome;
		this.capacitaMassima = capacitaMassima;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public int getCodiceSala() {
		return codiceSala;
	}

	public void setCodiceSala(int codiceSale) {
		this.codiceSala = codiceSale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapacitaMassima() {
		return capacitaMassima;
	}

	public void setCapacitaMassima(int capacitaMassima) {
		this.capacitaMassima = capacitaMassima;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		return codice == other.codice;
	}

	@Override
	public String toString() {
		return "codice tavolo = " + codice + ", codice sala a cui appartiene = " + codiceSala + ", nome = " + nome 
				+ ", capacitaMassima = " + capacitaMassima ;
	}
	
	

}

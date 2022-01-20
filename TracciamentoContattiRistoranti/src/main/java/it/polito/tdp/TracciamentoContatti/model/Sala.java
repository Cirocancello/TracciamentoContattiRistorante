package it.polito.tdp.TracciamentoContatti.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import it.polito.tdp.TracciamentoContatti.model.Sala;

public class Sala {
	
	private Integer codice;
	private Integer codiceRistorante;
	private String nome;
	
	private List<Tavolo> tavoli = new LinkedList<>();
	private List<Cameriere> camerieri = new LinkedList<>();
	
	public Sala(Integer codice, Integer codiceRistorante, String nome) {

		this.codice = codice;
		this.codiceRistorante = codiceRistorante;
		this.nome = nome;		
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public Integer getCodiceRistorante() {
		return codiceRistorante;
	}

	public void setCodiceRistorante(Integer codiceRistorante) {
		this.codiceRistorante = codiceRistorante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Tavolo> getTavoli() {
		return tavoli;
	}

	public void setTavoli(List<Tavolo> tavoli) {
		this.tavoli = tavoli;
	}

	public List<Cameriere> getCamerieri() {
		return camerieri;
	}

	public void setCamerieri(List<Cameriere> camerieri) {
		this.camerieri = camerieri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice, codiceRistorante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(codice, other.codice) && Objects.equals(codiceRistorante, other.codiceRistorante);
	}

	@Override
	public String toString() {
		return "Sala [codice=" + codice + ", codiceRistorante=" + codiceRistorante + ", nome=" + nome + ", tavoli="
				+ tavoli + ", camerieri=" + camerieri + "]";
	}
	
	
	
}
package it.polito.tdp.TracciamentoContatti.model;

import java.util.Objects;

import it.polito.tdp.TracciamentoContatti.model.Sala;

public class Sala {
	
	private Integer codice;
	private Integer codiceRistorante;
	private String nome;
	
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

	public Integer etCodiceRistorante() {
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
		Sala other = (Sala) obj;
		return Objects.equals(codice, other.codice);
	}

	@Override
	public String toString() {
		return "Sala codice=" + codice + ", codiceRistorante=" + codiceRistorante 
				+ ", nome=" + nome;
	}

	
	
	
	

}


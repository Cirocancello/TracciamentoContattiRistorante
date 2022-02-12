package it.TracciamentoContatti.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Cameriere {

	private int codice;
	private String nome;
	private String cognome;
	
	private List<Sala> saleCamerieri = new LinkedList<>();
	
	public Cameriere(int codice, String nome, String cognome) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	@Override
	public String toString() {
		return "Cameriere [codice=" + codice + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
}

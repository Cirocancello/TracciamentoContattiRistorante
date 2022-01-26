package it.TracciamentoContatti.model;

import java.time.LocalDate;

public class Cliente {
	
	private int codice;
	private int codiceTavolo;
	private String cognome;
	private String nome;
	private String numeroCartaIdentita;
	private String telefono;
	private LocalDate data;
	
	
	private Tavolo codTavolo;
	
	public Cliente(String cognome, String nome, String telefono) {
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
	}
	
	public Cliente(int codice, int codiceTavolo, String cognome, String nome, String numeroCartaIdentita,
			String telefono, LocalDate data) {

		this.codice = codice;
		this.codiceTavolo = codiceTavolo;
		this.cognome = cognome;
		this.nome = nome;
		this.numeroCartaIdentita = numeroCartaIdentita;
		this.telefono = telefono;
		this.data = data;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public int getCodiceTavolo() {
		return codiceTavolo;
	}

	public void setCodiceTavolo(int codiceTavolo) {
		this.codiceTavolo = codiceTavolo;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroCartaIdentita() {
		return numeroCartaIdentita;
	}

	public void setNumeroCartaIdentita(String numeroCartaIdentita) {
		this.numeroCartaIdentita = numeroCartaIdentita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	

	@Override
	public String toString() {
		return "Cliente [codice=" + codice + ", codiceTavolo=" + codiceTavolo + ", codnome=" + cognome + ", nome="
				+ nome + ", numeroCartaIdentita=" + numeroCartaIdentita + ", telefono=" + telefono + ", data=" + data
				+ "]";
	}
	
	

}

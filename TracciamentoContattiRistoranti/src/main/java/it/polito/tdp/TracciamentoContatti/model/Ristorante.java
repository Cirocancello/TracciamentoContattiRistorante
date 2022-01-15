package it.polito.tdp.TracciamentoContatti.model;

import java.util.Objects;

import it.polito.tdp.TracciamentoContatti.model.Ristorante;

public class Ristorante {
	
	private String codice;
	private String nome;
	private String indirizzo;
	private String citta;
	private String provincia;
	private String telefono;
	
	public Ristorante(String codice, String nome, String indirizzo, String citta, String provincia, String telefono) {	
		this.codice = codice;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.telefono = telefono;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		Ristorante other = (Ristorante) obj;
		return Objects.equals(codice, other.codice);
	}

	@Override
	public String toString() {
		return codice 	+ " " +	 nome + " " + indirizzo + " " + citta
				+ " " + provincia + " " + telefono;
	}
	
	
	

}


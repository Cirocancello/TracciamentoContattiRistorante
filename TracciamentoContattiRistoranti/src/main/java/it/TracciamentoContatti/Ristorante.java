package it.TracciamentoContatti;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import it.TracciamentoContatti.Ristorante;

public class Ristorante {
	
	private Integer codice;
	private String nome;
	private String indirizzo;
	private String citta;
	private String provincia;
	private String telefono;
	
	private List<Sala> sale = new LinkedList<>();	
	private Prenotazione prenotazione;
	
	
	public Ristorante(Integer codice, String nome, String indirizzo, String citta, String provincia, String telefono) {
		this.codice = codice;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia; 
		this.telefono = telefono;
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
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
	public String toString() {
		return "codice ristorante = "+ codice + ", " + nome + ", " + indirizzo + ", " + citta + ", " + provincia + ", telefono = " + telefono ;
	}	

	
}


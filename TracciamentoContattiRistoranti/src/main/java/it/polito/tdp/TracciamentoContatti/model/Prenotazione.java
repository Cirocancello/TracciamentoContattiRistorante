package it.polito.tdp.TracciamentoContatti.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Prenotazione {
	
	private int codice;
	private String cognome;
	private String nome;
	private String telefono;
	private int numeroPersone;
	private String data;

	private Cliente cliente;
	private List<Tavolo> tavoliPrenotati = new LinkedList<>();
	
	public Prenotazione(int codice, String cognome, String nome, String telefono, int numeroPersone, String data) {
		this.codice = codice;
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.numeroPersone = numeroPersone;
		this.data = data;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
		Prenotazione other = (Prenotazione) obj;
		return codice == other.codice;
	}

	@Override
	public String toString() {
		return "Prenotazione [codice=" + codice + ", cognome=" + cognome + ", nome=" + nome + ", telefono=" + telefono
				+ ", numeroPersone=" + numeroPersone + ", data=" + data + "]";
	}
	
	
	

}

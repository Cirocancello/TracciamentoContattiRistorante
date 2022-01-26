package it.TracciamentoContatti.model;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Prenotazione {	
	
	private int codice;
	private String cognome;
	private String nome;
	private String telefono;
	private int numeroPersone;
	private Date data;

	private Cliente cliente;
	private List<Tavolo> tavoliPrenotati = new LinkedList<>();
	
	public Prenotazione(int codice, String cognome, String nome, String telefono, int numeroPersone, Date data) {
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



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public List<Tavolo> getTavoliPrenotati() {
		return tavoliPrenotati;
	}



	public void setTavoliPrenotati(List<Tavolo> tavoliPrenotati) {
		this.tavoliPrenotati = tavoliPrenotati;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "Prenotazione a nome di " + cognome + ", " + nome + ", " + telefono
				+ ", numeroPersone prenotate " + numeroPersone + ", in data " + data ;
	}
	
	
	

}

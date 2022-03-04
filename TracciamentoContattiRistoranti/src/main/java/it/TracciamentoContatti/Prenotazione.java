package it.TracciamentoContatti;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Prenotazione {	
	
	private Integer codice;
	private Integer codiceTavolo;
	private String cognome;
	private String nome;
	private String telefono;
	private Integer numeroPersone;
	private Date data;

	private List<Cliente> cliente;
	private Tavolo tavoloPrenotato;
	private Ristorante ristorante;
	//_______________________________________________________________
	public Prenotazione(Integer codice, Integer codiceTavolo, String cognome, String nome, String telefono, Integer numeroPersone, Date data) {
		this.codice = codice;
		this.codiceTavolo = codiceTavolo;
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.numeroPersone = numeroPersone;
		this.data = data;
	}

	public Prenotazione(String cognome, String nome, String telefono, Integer numeroPersone, Date data) {
		
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.numeroPersone = numeroPersone;
		this.data = data;
	}
	
	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public Integer getCodiceTavolo() {
		return codiceTavolo;
	}

	public void setCodiceTavolo(Integer codiceTavolo) {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getNumeroPersone() {
		return numeroPersone;
	}

	public void setNumeroPersone(Integer numeroPersone) {
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
				+ ", numeroPersone prenotate " + numeroPersone + ", in data " + data +", "+ codice;
	}
	
	
	

}

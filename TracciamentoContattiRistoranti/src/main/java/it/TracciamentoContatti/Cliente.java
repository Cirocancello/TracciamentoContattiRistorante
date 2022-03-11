package it.TracciamentoContatti;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Implementazione dell' entità cliente
 * la classe fornisce il metodo costruttore e i getter e setter per definire un cliente
 * 
 * @author Ciro Cancello
 *
 */
public class Cliente {
	
	private Integer codice;
	private Integer codiceTavolo;
	private String cognome;
	private String nome;	
	private String numeroCartaIdentita;
	private String telefono;
	private Date data;
	
	
	private Tavolo codTavolo;
	
	public Cliente(String cognome, String nome, String telefono,Date data) {
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		
	}
	
	public Cliente(Integer codiceTavolo, String cognome, String nome,String telefono,
			String numeroCartaIdentita, Date data) {
		
		this.codiceTavolo = codiceTavolo;
		this.cognome = cognome;
		this.nome = nome;
		this.numeroCartaIdentita = numeroCartaIdentita;
		this.telefono = telefono;
		this.data = data;
	}	

	public Integer getCodice() {
		return codice;
	}

	public Integer getCodiceTavolo() {
		return codiceTavolo;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getNumeroCartaIdentita() {
		return numeroCartaIdentita;
	}

	public String getTelefono() {
		return telefono;
	}

	public Date getData() {
		return data;
	}

	public Tavolo getCodTavolo() {
		return codTavolo;
	}

	@Override
	public String toString() {
		return "Cliente [codice=" + codice + ", codiceTavolo=" + codiceTavolo + ", codnome=" + cognome + ", nome="
				+ nome + ", numeroCartaIdentita=" + numeroCartaIdentita + ", telefono=" + telefono + ", data=" + data
				+ "]";
	}
	
	

}

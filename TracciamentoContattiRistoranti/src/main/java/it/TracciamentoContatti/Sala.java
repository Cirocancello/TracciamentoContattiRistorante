package it.TracciamentoContatti;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import it.TracciamentoContatti.Sala;

/**
 * Implementazione dell' entità sala
 * la classe fornisce il metodo costruttore e i getter e setter per definire un sala
 * 
 * @author Ciro Cancello
 *
 */
public class Sala {
	
	private Integer codice;
	private Integer codiceRistorante;
	private String nome;
	
	private List<Tavolo> tavoli = new LinkedList<>();
	private List<Cameriere> camerieri = new LinkedList<>();
	private Ristorante ristorante;
	
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
	
	@Override
	public String toString() {
		return "codice = " + codice + ", codice Ristorante =" + codiceRistorante + ", nome =" + nome ;
				
	}	
	
	
}
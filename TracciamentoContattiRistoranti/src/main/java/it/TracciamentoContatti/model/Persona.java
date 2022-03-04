package it.TracciamentoContatti.model;

public class Persona {
	private String cognome;
	private String nome;
	private String telefono;
	private String tipo;
	
	
	public Persona(String cognome, String nome, String telefono, String tipo) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.tipo=tipo;
		
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
	
		
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Persona cognome=" + cognome + ", nome=" + nome + ", telefono=" + telefono + ", tipo = "+tipo;
	}
	
	
	
}

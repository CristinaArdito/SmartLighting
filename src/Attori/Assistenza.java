package Attori;

public class Assistenza {
	/*
	 *  Nome servizio di assistenza 
	 */
	private String nome;
	
	/*
	 * Indirizzo
	 */
	private String indirizzo;
	
	/*
	 * Indirizzo email
	 */
	private String email;
	
	/*
	 * Numero di telefono
	 */
	private String telefono;
	
	/**
	 * Costruttore della classe Assistenza
	 * @param nome			nome servizio di assistenza
	 * @param indirizzo		indirizzo
	 * @param email			indirizzo email	
	 * @param telefono		numero di telefono
	 */
	public Assistenza(String nome, String indirizzo, String email, String telefono) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.telefono = telefono;
	}

	/**
	 * Ritorna il nome del servizio di assistenza
	 * @return	nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Inserisce il nome del servizio di assistenza
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Ritorna l'indirizzo
	 * @return	indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Inserisce l'indirizzo
	 * @param indirizzo
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Ritorna l'indirizzo email
	 * @return	email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Inserisce l'indirizzo email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Ritorna il numero di telefono
	 * @return	telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Inserisce il numero di telefono
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}

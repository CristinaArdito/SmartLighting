package Attori;

public class Cliente {
	/*
	 * Nome del cliente 
	 */
	private String nome;
	
	/* 
	 * Cognome del cliente 
	 */
	private String cognome;
	
	/* 
	 * Telefono 
	 */
	private String tel;
	
	/* 
	 * Indirizzo email 
	 */
	private String mail;
	
	/* 
	 * Indirizzo 
	 */
	private String indirizzo;
	
	/**
	 * Costruttore del Cliente
	 * @param nome			nome del cliente
	 * @param cognome		cognome del cliente
	 * @param tel			numero di telefono
	 * @param mail			indirizzo email
	 * @param indirizzo		indirizzo
	 */
	public Cliente(String nome, String cognome, String tel, String mail, String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.tel = tel;
		this.mail = mail;
		this.indirizzo = indirizzo;
	}

	/**
	 * Ritorna il nome del cliente
	 * @return	nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Inserisce il nome del cliente 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Ritorna il cognome del cliente
	 * @return	cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Inserisce il cognome del cliente
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Ritorna il numero di telefono del cliente
	 * @return	tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Inserisce il numero di telefono del cliente
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * Ritorna l'email del cliente
	 * @return	mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Inserisce la mail del cliente
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Ritorna l'indirizzo del cliente
	 * @return	indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Inserisce l'indirizzo del cliente
	 * @param indirizzo
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/** 
	 * Il cliente può richiedere l'attivazione del sistema
	 * @return	true
	 */
	public boolean richiediSmartLighting() {
		return true;
	};
	
	/**
	 * Al bisogno, il cliente è in grado di richiedere l'intervento dell'assistenza
	 * @return	true
	 */
	public boolean richiediAssistenza() {
		return true;
	}
}

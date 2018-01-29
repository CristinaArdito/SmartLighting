package sistema;

public class Luce {
	/*
	 * Id della luce
	 */
	private int id;
	
	/*
	 * Codice: accessa: 1,  spenta: -1
	 */
	private int codice;
	
	/*
	 * Consumo in watt
	 */
	private double consumo;
	
	/*
	 * Flag per verificare in base alla configurazione se la luce
	 * pu� essere accesa/spenta/messa in standby dal sistema
	 */
	private boolean pu�EssereAccesa, pu�EssereSpenta;
	
	/**
	 * Costruttore della luce
	 * @param id			id
	 * @param codice		codice
	 * @param consumo		consumo orario
	 */
	public Luce(int id, int codice, double consumo, boolean pu�EssereAccesa, boolean pu�EssereSpenta) {
		super();
		this.id = id;
		this.codice = codice;
		this.consumo = consumo;
		this.pu�EssereAccesa = pu�EssereAccesa;
		this.pu�EssereSpenta = pu�EssereSpenta;
	}
	
	/**
	 * Ritorna l'id della luce
	 * @return	id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Inserisce l'id della luce
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Ritorna il codice della luce
	 * @return	codice
	 */
	public int getCodice() {
		return codice;
	}
	
	/**
	 * Inserisce il codice della luce
	 * @param codice
	 */
	public void setCodice(int codice) {
		if((codice == -1) || (codice == 1))
		this.codice = codice;
	}
	
	/**
	 * Ritorna il consumo orario della luce
	 * @return	consumo
	 */
	public double getConsumo() {
		return consumo;
	}

	/**
	 * Inserisce il consumo orario della luce
	 * @param consumo
	 */
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	/**
	 * Verifica se la luce pu� essere accesa in base alla configurazione
	 * @return	boolean
	 */
	public boolean pu�EssereAccesa() {
		return pu�EssereAccesa;
	}
	
	/**
	 * Verifica se la luce pu� essere spenta in base alla configurazione
	 * @return	boolean
	 */
	public boolean pu�EssereSpenta() {
		return pu�EssereSpenta;
	}
	
	
}
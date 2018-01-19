package toAssign;

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
	 * può essere accesa/spenta/messa in standby dal sistema
	 */
	private boolean puòEssereAccesa, puòEssereSpenta, puòEssereMessaInStandby;
	
	/**
	 * Costruttore della luce
	 * @param id			id
	 * @param codice		codice
	 * @param consumo		consumo orario
	 */
	public Luce(int id, int codice, double consumo) {
		super();
		this.id = id;
		this.codice = codice;
		this.consumo = consumo;
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
	 * Verifica se la luce può essere accesa in base alla configurazione
	 * @return	boolean
	 */
	public boolean puòEssereAccesa() {
		return puòEssereAccesa;
	}
	
	/**
	 * Verifica se la luce può essere spenta in base alla configurazione
	 * @return	boolean
	 */
	public boolean puòEssereSpenta() {
		return puòEssereSpenta;
	}
	
	/**
	 * Verifica se la luce può essere messa in standby in base alla configurazione
	 * @return	boolean
	 */
	public boolean puòEssereMessaInStandby() {
		return puòEssereMessaInStandby;
	}
	
}

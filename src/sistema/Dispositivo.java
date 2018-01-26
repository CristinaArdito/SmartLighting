package sistema;

public class Dispositivo {
	/*
	 * Tipologia dispositivo
	 */
	private String tipo;
	
	/*
	 * Codice: accesso: 1, standby: 0, spento: -1
	 */
	private byte codice;
	
	/*
	 * Id
	 */
	private int id;
	
	/*
	 * Flag per verificare in base alla configurazione se il dispositivo
	 * può essere acceso/spento/messo in standby dal sistema
	 */
	private boolean puòEssereAcceso, puòEssereSpento, puòEssereMessoInStandby;
	
	/*
	 * Consumo orario del dispositivo
	 */
	private double consumo;
	
	/**
	 * Costruttore dispositivo
	 * @param tipo			tipo del dispositivo
	 * @param codice		codice del dispositivo
	 * @param id			id del dispositivo
	 * @param consumo		consumo medio orario
	 */
	public Dispositivo(String tipo, int codice, int id, double consumo, boolean puòEssereAcceso, boolean puòEssereSpento, boolean puòEssereMessoInStandby) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.consumo = consumo;
		this.puòEssereAcceso = puòEssereAcceso;
		this.puòEssereMessoInStandby = puòEssereMessoInStandby;
		this.puòEssereSpento = puòEssereSpento;
	}
	
	/**
	 * Ritorna l'id del dispositivo
	 * @return	id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Ritorna il tipo del dispositivo
	 * @return	tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Inserisce il tipo di dispositivo
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Ritorna il codice del dispositivo
	 * @return	codice
	 */
	public int getCodice() {
		return codice;
	}

	/**
	 * Inserisce il codice del dispositivo
	 * @param codice
	 */
	public void setCodice(int codice) {
		if((codice >= -1) && (codice <= 1)) {
			this.codice = (byte) codice;
		}
	}
	
	/**
	 * Ritorna il consumo del dispositivo
	 * @return	consumo
	 */
	public double getConsumo() {
		return consumo;
	}

	/**
	 * Inserisce il consumo del dispositivo
	 * @param consumo
	 */
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	/**
	 * Verifica se può essere acceso
	 * @return	boolean
	 */
	public boolean puòEssereAcceso() {
		return puòEssereAcceso;
	}
	
	/**
	 * Verifica se può essere spento
	 * @return	boolean
	 */
	public boolean puòEssereSpento() {
		return puòEssereSpento;
	}
	
	/**
	 * Verifica se può essere messo in standby
	 * @return	boolean
	 */
	public boolean puòEssereMessoInStandby() {
		return puòEssereMessoInStandby;
	}
	
	/**
	 * Imposta il dispositivo come accendibile
	 * @return	boolean
	 */
	public boolean impostaAcceso(boolean valore) {
		if(puòEssereAcceso != valore) {
			puòEssereAcceso = valore;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Imposta il flag per mettere il dispositivo in standby
	 * @return	boolean
	 */
	public boolean impostaStandby(boolean valore) {
		if(puòEssereMessoInStandby != valore) {
			puòEssereMessoInStandby = valore;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Imposta il dispositivo come spegnibile
	 * @return	boolean
	 */
	public boolean impostaSpento(boolean valore) {
		if(puòEssereSpento != valore) {
			puòEssereSpento = valore;
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Tipo: "+tipo+" - ID: "+id+" - Consumo: "+consumo+" watt";
	}
}

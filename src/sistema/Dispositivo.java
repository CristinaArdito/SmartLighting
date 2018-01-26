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
	 * pu� essere acceso/spento/messo in standby dal sistema
	 */
	private boolean pu�EssereAcceso, pu�EssereSpento, pu�EssereMessoInStandby;
	
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
	public Dispositivo(String tipo, int codice, int id, double consumo, boolean pu�EssereAcceso, boolean pu�EssereSpento, boolean pu�EssereMessoInStandby) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.consumo = consumo;
		this.pu�EssereAcceso = pu�EssereAcceso;
		this.pu�EssereMessoInStandby = pu�EssereMessoInStandby;
		this.pu�EssereSpento = pu�EssereSpento;
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
	 * Verifica se pu� essere acceso
	 * @return	boolean
	 */
	public boolean pu�EssereAcceso() {
		return pu�EssereAcceso;
	}
	
	/**
	 * Verifica se pu� essere spento
	 * @return	boolean
	 */
	public boolean pu�EssereSpento() {
		return pu�EssereSpento;
	}
	
	/**
	 * Verifica se pu� essere messo in standby
	 * @return	boolean
	 */
	public boolean pu�EssereMessoInStandby() {
		return pu�EssereMessoInStandby;
	}
	
	/**
	 * Imposta il dispositivo come accendibile
	 * @return	boolean
	 */
	public boolean impostaAcceso(boolean valore) {
		if(pu�EssereAcceso != valore) {
			pu�EssereAcceso = valore;
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
		if(pu�EssereMessoInStandby != valore) {
			pu�EssereMessoInStandby = valore;
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
		if(pu�EssereSpento != valore) {
			pu�EssereSpento = valore;
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Tipo: "+tipo+" - ID: "+id+" - Consumo: "+consumo+" watt";
	}
}

package sistema;

import simulazione.AmbienteDiSimulazione;

public class ControlloreDispositivo {
	/*
	 * Tipologia dispositivo
	 */
	private String tipo;

	/*
	 * Codice: accesso: 1, standby: 0, spento: -1
	 */
	private int codice;

	/*
	 * Id
	 */
	private int id;

	/*
	 * Flag per verificare in base alla configurazione se il dispositivo pu� essere
	 * acceso/spento/messo in standby dal sistema
	 */
	private boolean pu�EssereAcceso, pu�EssereSpento, pu�EssereMessoInStandby;

	/*
	 * Consumo orario del dispositivo
	 */
	private double consumo;

	/*
	 * Indica se il componente � guasto
	 */
	private boolean guasto;

	/*
	 * Contatore del tempo in cui � rimasto acceso il dispositivo
	 */
	private int tempoAcceso;

	/*
	 * Ora di accensione del dispositivo
	 */
	private int oraAccensione;

	/**
	 * Costruttore dispositivo
	 * 
	 * @param tipo
	 *            tipo del dispositivo
	 * @param codice
	 *            codice del dispositivo
	 * @param id
	 *            id del dispositivo
	 * @param consumo
	 *            consumo medio orario
	 */
	public ControlloreDispositivo(String tipo, int codice, int id, double consumo, boolean pu�EssereAcceso,
			boolean pu�EssereSpento, boolean pu�EssereMessoInStandby) {
		super();
		this.codice = codice;
		this.id = id;
		this.tipo = tipo;
		this.consumo = consumo;
		this.pu�EssereAcceso = pu�EssereAcceso;
		this.pu�EssereMessoInStandby = pu�EssereMessoInStandby;
		this.pu�EssereSpento = pu�EssereSpento;
		this.guasto = false;
		this.tempoAcceso = 0;
	}

	/**
	 * Costruttore dispositivo
	 * 
	 * @param tipo
	 *            tipo del dispositivo
	 * @param codice
	 *            codice del dispositivo
	 * @param id
	 *            id del dispositivo
	 * @param consumo
	 *            consumo medio orario
	 * @param tempoOn
	 *            tempo di utilizzo del dispositivo
	 */
	public ControlloreDispositivo(String tipo, int codice, int id, double consumo, boolean pu�EssereAcceso,
			boolean pu�EssereSpento, boolean pu�EssereMessoInStandby, int tempoOn) {
		super();
		this.codice = codice;
		this.id = id;
		this.tipo = tipo;
		this.consumo = consumo;
		this.pu�EssereAcceso = pu�EssereAcceso;
		this.pu�EssereMessoInStandby = pu�EssereMessoInStandby;
		this.pu�EssereSpento = pu�EssereSpento;
		this.guasto = false;
		this.tempoAcceso = tempoOn;
	}

	/**
	 * Ritorna l'id del dispositivo
	 * 
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Ritorna il tipo del dispositivo
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Inserisce il tipo di dispositivo
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Ritorna il codice del dispositivo
	 * 
	 * @return codice
	 */
	public int getCodice() {
		return codice;
	}

	/**
	 * Inserisce il codice del dispositivo
	 * 
	 * @param codice
	 */
	public void setCodice(int codice) {
		if ((codice >= -1) && (codice <= 1)) {
			if (this.codice == 1) {
				// Incremento il tempo di accensione del dispositivo
				this.tempoAcceso = this.tempoAcceso + (AmbienteDiSimulazione.getOra() - oraAccensione);
			} else {
				// Ottengo l'ora in cui il dispositivo � stato acceso
				oraAccensione = AmbienteDiSimulazione.getOra();
			}
			this.codice = (byte) codice;
		}
	}

	/**
	 * Ritorna il consumo del dispositivo
	 * 
	 * @return consumo
	 */
	public double getConsumo() {
		return (consumo / 60) * tempoAcceso;
	}

	/**
	 * Ritorna il consumo parziale
	 * 
	 * @return consumo
	 */
	public double getConsumoParziale() {
		return (consumo / 60) * (tempoAcceso + (AmbienteDiSimulazione.getOra() - oraAccensione));
	}

	public int getTempoParziale() {
		return tempoAcceso + (AmbienteDiSimulazione.getOra() - oraAccensione);
	}

	/**
	 * Inserisce il consumo del dispositivo
	 * 
	 * @param consumo
	 */
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	/**
	 * Verifica se pu� essere acceso
	 * 
	 * @return boolean
	 */
	public boolean pu�EssereAcceso() {
		return pu�EssereAcceso;
	}

	/**
	 * Verifica se pu� essere spento
	 * 
	 * @return boolean
	 */
	public boolean pu�EssereSpento() {
		return pu�EssereSpento;
	}

	/**
	 * Verifica se pu� essere messo in standby
	 * 
	 * @return boolean
	 */
	public boolean pu�EssereMessoInStandby() {
		return pu�EssereMessoInStandby;
	}

	/**
	 * Imposta il dispositivo come accendibile
	 * 
	 * @return boolean
	 */
	public boolean impostaAcceso(boolean valore) {
		if (pu�EssereAcceso != valore) {
			pu�EssereAcceso = valore;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Imposta il flag per mettere il dispositivo in standby
	 * 
	 * @return boolean
	 */
	public boolean impostaStandby(boolean valore) {
		if (pu�EssereMessoInStandby != valore) {
			pu�EssereMessoInStandby = valore;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Imposta il dispositivo come spegnibile
	 * 
	 * @return boolean
	 */
	public boolean impostaSpento(boolean valore) {
		if (pu�EssereSpento != valore) {
			pu�EssereSpento = valore;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Imposta il valore dell'attributo "guasto"
	 * 
	 * @param valore
	 *            - valore che indica se il dispositivo � guasto
	 */
	public void setGuasto(boolean valore) {
		this.guasto = valore;
	}

	/**
	 * Restituisce il valore di "guasto"
	 * 
	 * @return boolean
	 */
	public boolean isGuasto() {
		return guasto;
	}

	/**
	 * Restituisce il tempo in cui il dispositivo � stato attivo
	 * 
	 * @return tempoAcceso
	 */
	public int getTempoAttivo() {
		return tempoAcceso;
	}

	/**
	 * Ridefinizione toString()
	 */
	public String toString() {
		return "Tipo: " + tipo + " - ID: " + id + " - Consumo: " + consumo + " watt";
	}
}

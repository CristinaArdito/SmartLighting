package sistema;

public class Sensore {
	/*
	 * Codice del sensore: 1 presente, -1 non presente
	 */
	private int code;
	
	/**
	 * Costruttore
	 * @param code	codice del sensore
	 */
	public Sensore(int code) {
		setSensore(code);
	}
	
	/**
	 * Inserisce il codice del sensore
	 * @param code
	 */
	public void setSensore(int code) {
		// Controlla che il codice sia corretto
		if(code == -1 || code == 1 )
		this.code = code;
	}
	
	/**
	 * Ritorna il sensore
	 * @return
	 */
	public Sensore getSensore() {
		return this;
	}
	
	/**
	 * Ritorna il codice del sensore
	 * @return	code
	 */
	public int getCodice() {
		return this.code;
	}
}

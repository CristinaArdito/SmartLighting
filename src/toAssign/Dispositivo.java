package toAssign;

public class Dispositivo {
	private String tipo;
	private int codice;
	private boolean puòEssereAcceso, puòEssereSpento, puòEssereMessoInStandby;
	
	/*
	 * Codice: accesso: 1, standby: 0, spento: -1
	 */
	
	public Dispositivo(String tipo, int codice) {
		super();
		this.tipo = tipo;
		this.codice = codice;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		if((codice >= -1) && (codice <= 1)) {
			this.codice = codice;
		}
	}
	
	public boolean puòEssereAcceso() {
		return puòEssereAcceso;
	}
	
	public boolean puòEssereSpento() {
		return puòEssereSpento;
	}
	
	public boolean puòEssereMessoInStandby() {
		return puòEssereMessoInStandby;
	}
}

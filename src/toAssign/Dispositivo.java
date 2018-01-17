package toAssign;

public class Dispositivo {
	private String tipo;
	private int codice;
	private boolean pu�EssereAcceso, pu�EssereSpento, pu�EssereMessoInStandby;
	
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
	
	public boolean pu�EssereAcceso() {
		return pu�EssereAcceso;
	}
	
	public boolean pu�EssereSpento() {
		return pu�EssereSpento;
	}
	
	public boolean pu�EssereMessoInStandby() {
		return pu�EssereMessoInStandby;
	}
}

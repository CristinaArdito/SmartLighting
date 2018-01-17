package toAssign;

public class Dispositivo {
	private String tipo;
	private byte codice;
	private int id;
	private boolean puòEssereAcceso, puòEssereSpento, puòEssereMessoInStandby;
	
	/*
	 * Codice: accesso: 1, standby: 0, spento: -1
	 */
	
	public Dispositivo(String tipo, int codice, int id) {
		super();
		this.id = id;
		this.tipo = tipo;
		setCodice(codice);
	}
	
	public int getId() {
		return this.id;
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
			this.codice = (byte) codice;
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
	
	public boolean impostaAcceso(boolean valore) {
		if(puòEssereAcceso != valore) {
			puòEssereAcceso = valore;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean impostaStandby(boolean valore) {
		if(puòEssereMessoInStandby != valore) {
			puòEssereMessoInStandby = valore;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean impostaSpento(boolean valore) {
		if(puòEssereSpento != valore) {
			puòEssereSpento = valore;
			return true;
		}else {
			return false;
		}
	}
}

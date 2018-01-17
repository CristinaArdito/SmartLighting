package toAssign;

public class Dispositivo {
	private String tipo;
	private byte codice;
	private int id;
	private boolean pu�EssereAcceso, pu�EssereSpento, pu�EssereMessoInStandby;
	
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
	
	public boolean pu�EssereAcceso() {
		return pu�EssereAcceso;
	}
	
	public boolean pu�EssereSpento() {
		return pu�EssereSpento;
	}
	
	public boolean pu�EssereMessoInStandby() {
		return pu�EssereMessoInStandby;
	}
	
	public boolean impostaAcceso(boolean valore) {
		if(pu�EssereAcceso != valore) {
			pu�EssereAcceso = valore;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean impostaStandby(boolean valore) {
		if(pu�EssereMessoInStandby != valore) {
			pu�EssereMessoInStandby = valore;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean impostaSpento(boolean valore) {
		if(pu�EssereSpento != valore) {
			pu�EssereSpento = valore;
			return true;
		}else {
			return false;
		}
	}
}

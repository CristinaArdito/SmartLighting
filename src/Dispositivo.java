
public class Dispositivo {
	private String tipo;
	private int codice;
	
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
	
	
}

package toAssign;

public class Sensore {
	private String tipo;
	private int code;
	
	public Sensore(String tipo, int code) {
		this.setTipo(tipo);
		this.code = code;
	}
	
	public void setSensore(String tipo, int code) {
		this.setTipo(tipo);
		this.code = code;
	}
	
	public Sensore getSensore() {
		return this;
	}
	
	public int getCodice() {
		return this.code;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

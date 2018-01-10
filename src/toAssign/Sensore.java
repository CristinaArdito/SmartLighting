package toAssign;

public class Sensore {
	private String tipo;
	private int code;
	
	public Sensore(String tipo, int code) {
		this.tipo = tipo;
		this.code = code;
	}
	
	public void setSensore(String tipo, int code) {
		this.tipo = tipo;
		this.code = code;
	}
	
	public Sensore getSensore() {
		return this;
	}
	
	public int getCodice() {
		return this.code;
	}
}


public class Sensor {
	private String tipo;
	private int code;
	
	public Sensor(String tipo, int code) {
		this.tipo = tipo;
		this.code = code;
	}
	
	public void setSensore(String tipo, int code) {
		this.tipo = tipo;
		this.code = code;
	}
	
	public Sensor getSensore() {
		return this;
	}
	
	public int getCodice() {
		return this.code;
	}
}

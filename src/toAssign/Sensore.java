package toAssign;

public class Sensore {
	private int code;
	
	/*
	 * Codice: presente: 1, non presente: -1
	 */
	
	public Sensore(int code) {
		setSensore(code);
	}
	
	public void setSensore(int code) {
		if(code == -1 || code == 1 )
		this.code = code;
	}
	
	public Sensore getSensore() {
		return this;
	}
	
	public int getCodice() {
		return this.code;
	}
}

package toAssign;

public class Luce {
	private int id;
	private int codice;
	private double consumo;
	private boolean puòEssereAccesa, puòEssereSpenta, puòEssereMessaInStandby;
	
	/*
	 * Codice: accessa: 1,  spenta: -1
	 */
	
	public Luce(int id, int codice) {
		super();
		this.id = id;
		this.codice = codice;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCodice() {
		return codice;
	}
	
	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	
	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public boolean puòEssereAccesa() {
		return puòEssereAccesa;
	}
	
	public boolean puòEssereSpenta() {
		return puòEssereSpenta;
	}
	
	public boolean puòEssereMessaInStandby() {
		return puòEssereMessaInStandby;
	}
	
}

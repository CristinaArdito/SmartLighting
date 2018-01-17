package toAssign;

public class Luce {
	private int id;
	private int codice;
	private double consumo;
	private boolean pu�EssereAccesa, pu�EssereSpenta, pu�EssereMessaInStandby;
	
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

	public boolean pu�EssereAccesa() {
		return pu�EssereAccesa;
	}
	
	public boolean pu�EssereSpenta() {
		return pu�EssereSpenta;
	}
	
	public boolean pu�EssereMessaInStandby() {
		return pu�EssereMessaInStandby;
	}
	
}

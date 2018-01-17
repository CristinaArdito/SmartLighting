package toAssign;

import java.util.List;

public class Stanza {
	private int codice;
	private String nome;
	private List<Luce> luci;
	private List<Dispositivo> dispositivi;
	private Sensore sensore;
	
	public Stanza(int codice, List<Dispositivo> listaDispositivi, Sensore sensore) {
		setDispositivi(listaDispositivi);
		setSensore(sensore);
		setCodice(codice);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	public List<Dispositivo> getDispositivi() {
		return dispositivi;
	}
	
	public void setDispositivi(List<Dispositivo> dispositivi) {
		this.dispositivi = dispositivi;
	}
	
	public Sensore getSensore() {
		return sensore;
	}
	
	public void setSensore(Sensore sensori) {
		this.sensore = sensori;
	}

	public List<Luce> getLuci() {
		return luci;
	}
	
	public void setLuci(List<Luce> luci) {
		this.luci = luci;
	}
}

package toAssign;

import java.util.ArrayList;
import java.util.List;

import toAssign.Dispositivo;
import toAssign.Luce;
import toAssign.Sensore;

public class Stanza {
	private int codice;
	private String nome;
	private List<Dispositivo> dispositivi;
	private List<Luce> luci;
	private Sensore sensore;
	
	public Stanza(int codice, String nome, List<Dispositivo> listaDispositivi, Sensore sensore) {
		setDispositivi(listaDispositivi);
		setSensore(sensore);
		setCodice(codice);
		setNome(nome);
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
		this.dispositivi = new ArrayList<Dispositivo>();
		this.dispositivi.addAll(dispositivi);
	}
	
	public List<Luce> getLuci() {
		return luci;
	}
	
	public void setLuci(List<Luce> luci) {
		this.luci = luci;
	}
	
	public Sensore getSensore() {
		return sensore;
	}
	
	public void setSensore(Sensore sensori) {
		this.sensore = sensori;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
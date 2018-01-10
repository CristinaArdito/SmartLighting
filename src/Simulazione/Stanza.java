package Simulazione;

import java.util.List;

import toAssign.Dispositivo;
import toAssign.Sensore;

public class Stanza {
	private List<Dispositivo> dispositivi;
	private Sensore sensori;
	
	public Stanza(List<Dispositivo> listaDispositivi, Sensore sensore) {
		setDispositivi(listaDispositivi);
		setSensori(sensore);
	}
	
	public List<Dispositivo> getDispositivi() {
		return dispositivi;
	}
	
	public void setDispositivi(List<Dispositivo> dispositivi) {
		this.dispositivi = dispositivi;
	}
	
	public Sensore getSensori() {
		return sensori;
	}
	
	public void setSensori(Sensore sensori) {
		this.sensori = sensori;
	}
}

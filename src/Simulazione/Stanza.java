package Simulazione;

import java.util.List;

import toAssign.Dispositivo;
import toAssign.Sensore;

public class Stanza {
	private List<Dispositivo> dispositivi;
	private List<Sensore> sensori;
	
	public Stanza(List<Dispositivo> listaDispositivi, List<Sensore> listaSensori) {
		setDispositivi(listaDispositivi);
		setSensori(listaSensori);
	}
	
	public List<Dispositivo> getDispositivi() {
		return dispositivi;
	}
	
	public void setDispositivi(List<Dispositivo> dispositivi) {
		this.dispositivi = dispositivi;
	}
	
	public List<Sensore> getSensori() {
		return sensori;
	}
	
	public void setSensori(List<Sensore> sensori) {
		this.sensori = sensori;
	}
	
	
}

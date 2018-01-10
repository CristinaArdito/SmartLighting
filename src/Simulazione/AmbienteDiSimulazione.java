package Simulazione;

import java.util.List;

import toAssign.Dispositivo;
import toAssign.Sensore;

public class AmbienteDiSimulazione {
	private List<Sensore> sensori;
	private List<Dispositivo> dispositivi;
	private List<Stanza> stanze;
	
	public List<Sensore> getSensori() {
		return sensori;
	}
	
	public void setSensori(List<Sensore> sensori) {
		this.sensori = sensori;
	}
	
	public List<Dispositivo> getDispositivi() {
		return dispositivi;
	}
	
	public void setDispositivi(List<Dispositivo> dispositivi) {
		this.dispositivi = dispositivi;
	}
	
	public List<Stanza> getStanze() {
		return stanze;
	}
	
	public void setStanze(List<Stanza> stanze) {
		this.stanze = stanze;
	}
	
	public static void main(String args[]) {
		
	}
}

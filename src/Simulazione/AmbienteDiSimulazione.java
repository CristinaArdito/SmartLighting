package Simulazione;

import java.util.ArrayList;
import java.util.List;

import toAssign.Dispositivo;
import toAssign.Sensore;

public class AmbienteDiSimulazione {
	private List<Stanza> stanze;
	
	public AmbienteDiSimulazione() {
		stanze = new ArrayList<Stanza>();
	}
	
	public List<Stanza> getStanze() {
		return stanze;
	}
	
	public void setStanze(List<Stanza> stanze) {
		this.stanze = stanze;
	}
	
	public Dispositivo generaDispositivo() {
		String[] nomi = {"Televisore", "Computer", "Radio", "Forno", "Luci", "Stereo", "Condizionatore"};
		return new Dispositivo(nomi[(int) Math.random()], -1);
	};
	
	public Sensore generaSensore() {
		return new Sensore(-1);
	};
	
	public static void main(String args[]) {
		AmbienteDiSimulazione simulazione = new AmbienteDiSimulazione();
		List<Stanza> stanze = new ArrayList<Stanza>();
		List<Dispositivo> dispositivi = new ArrayList<Dispositivo>();
		int random;
		
		for(int j=0; j<5; j++) {
			random = (int) Math.random()*4;
				for(int i=0;i<random;i++) {
					dispositivi.add(simulazione.generaDispositivo());
				}
			stanze.add(new Stanza(dispositivi, simulazione.generaSensore()));
		}
		
	}
}

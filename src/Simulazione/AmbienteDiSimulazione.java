package Simulazione;

import java.util.ArrayList;
import java.util.List;

import InterfacciaGrafica.Interfaccia;
import toAssign.Dispositivo;
import toAssign.Sensore;
import toAssign.Stanza;

public class AmbienteDiSimulazione {
	private List<Stanza> stanze;
	private int idCorrente = 0;
	
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
		Dispositivo temporaneo = new Dispositivo(nomi[(int) Math.random()*7], -1, idCorrente, 40);
		idCorrente++;
		return temporaneo;
	};
	
	public Sensore generaSensore() {
		return new Sensore(-1);
	};
	
	public static List<Stanza> generaStanze(){
		AmbienteDiSimulazione simulazione = new AmbienteDiSimulazione();
		List<Stanza> stanze = new ArrayList<Stanza>();
		List<Dispositivo> dispositivi = new ArrayList<Dispositivo>();
		int random;
		
		for(int j=0; j<5; j++) {
			random = (int) (Math.random()*5)+1;
//			System.out.println(random);
			for(int i=0;i<random;i++) {
				dispositivi.add(simulazione.generaDispositivo());
			}
			stanze.add(new Stanza(j,"Stanza "+j, dispositivi, simulazione.generaSensore()));
			dispositivi.clear();
		}
		return stanze;
	}
	
	public static void main(String args[]) {
		Interfaccia frame = new Interfaccia();
		frame.setVisible(true);
	}
}

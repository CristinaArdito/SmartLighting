package Simulazione;

import java.util.ArrayList;
import java.util.List;

import InterfacciaGrafica.Interfaccia;
import toAssign.Sensore;

public class AmbienteDiSimulazione {
	
	public static List<Integer> ottieniSensori(){
		List<Integer> listaSensori = new ArrayList<Integer>();
		for(int i=0;i<25;i++) {
			listaSensori.add(new Integer(i));
		}
		return listaSensori;
	}
	
	public Sensore generaSensore() {
		return new Sensore(-1);
	};
	
	public static void main(String args[]) {
		Interfaccia frame = new Interfaccia();
		frame.setVisible(true);
	}
}

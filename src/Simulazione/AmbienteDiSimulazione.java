package Simulazione;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Attori.Cliente;
import InterfacciaGrafica.Interfaccia;
import toAssign.Dispositivo;
import toAssign.Luce;
import toAssign.Sensore;
import toAssign.Stanza;

public class AmbienteDiSimulazione {
	
	public static List<Integer> ottieniSensori(){
		List<Integer> listaSensori = new ArrayList<Integer>();
		for(int i=0;i<25;i++) {
			listaSensori.add(new Integer(i));
		}
		return listaSensori;
	}
	
	public static Sensore generaSensore() {
		return new Sensore(-1);
	};
	
	public static List<Luce> ottieniLuci() {
		List<Luce> listaLuci = new ArrayList<Luce>();
		listaLuci.add(new Luce(1, -1, 10.00, true, true));
		listaLuci.add(new Luce(2, 1, 5.00, true, true));
		return listaLuci;
	} 
	
	public static List<Dispositivo> ottiniDispositivi() {
		List<Dispositivo> listaDispositivi = new ArrayList<Dispositivo>();
		listaDispositivi.add(new Dispositivo("Tv", 1, 00, 120.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Minitor", 1, 01, 90.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Computer", 0, 02, 20.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Lavatrice", -1, 03, 220.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Radio", 0, 04, 10.00, true, false, false));
		return listaDispositivi;
	}
	
	public void posizionaCliente() {
		Cliente c = new Cliente("Rosario", "Culmone", "0737666666", "rosario.culmone@polmoni.it", "Via Merelli 1");
	}
	
	public void generaStanze() {
		List<Stanza> stanze = new ArrayList<Stanza>();		
		stanze.add(new Stanza(0, "Cucina", ottiniDispositivi(), ottieniLuci(), new Sensore(1)));
		stanze.add(new Stanza(1, "Bagno", ottiniDispositivi(), ottieniLuci(), new Sensore(-1)));
	}
	
	public static void main(String args[]) throws IOException {
		Interfaccia frame = new Interfaccia();
		frame.setVisible(true);
		
		
	}
}

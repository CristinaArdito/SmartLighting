package Simulazione;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import InterfacciaGrafica.Interfaccia;
import toAssign.Dispositivo;
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
	
	public static List<Dispositivo> ottiniDispositivi() {
		List<Dispositivo> listaDispositivi = new ArrayList<Dispositivo>();
		listaDispositivi.add(new Dispositivo("Tv", 1, 00, 120.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Minitor", 1, 01, 90.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Computer", 0, 02, 20.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Lavatrice", -1, 03, 220.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Radio", 0, 04, 10.00, true, false, false));
		return listaDispositivi;
	}
	
	public static void main(String args[]) throws FileNotFoundException, MalformedURLException {
		Interfaccia frame = new Interfaccia();
		frame.setVisible(true);
		
		/*
		Stanza s = new Stanza(0, "Cucina", ottiniDispositivi(), generaSensore());
		File file = new File("Stanza.txt");
		s.writeStanzaOnFile(file);
		Stanza s1 = s.readStanzaFromFile(file);
		System.out.println(s1.getNome());
		System.out.println(s1.getCodice());
		System.out.println("dispositivi:");
		List<Dispositivo> list = s1.getDispositivi();
		Dispositivo d;
		Iterator<Dispositivo> i = list.iterator();
		while(i.hasNext()) {
			d = i.next();
			System.out.println(d.getTipo() + d.getCodice() + d.getId() + d.puòEssereAcceso() + d.puòEssereSpento() + d.puòEssereMessoInStandby() + d.getConsumo());
		}
		System.out.println(s1.getSensore().getCodice());
		*/
		
	}
}

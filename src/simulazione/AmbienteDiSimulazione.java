package simulazione;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import attori.Cliente;
import interfacciaGrafica.Interfaccia;
import sistema.Dispositivo;
import sistema.Luce;
import sistema.Sensore;
import sistema.Stanza;

public class AmbienteDiSimulazione {

	private List<Integer> listaIdDispositivi = new ArrayList<Integer>();
	private static int NUMERO_MASSIMO_DISPOSITIVI = 40;
	private static int ora = 0; //Ora logica della simulazione

	public AmbienteDiSimulazione() {
		populateListaIdDispositivi();
	}

	public List<Integer> getListaIdDispositivi() {
		return listaIdDispositivi;
	}
	
	public static int getOra() {
		return ora;
	}
	
	public static void setOra(int ora) {
		if(ora>24) {
			AmbienteDiSimulazione.ora = 0;
		}else {
			AmbienteDiSimulazione.ora = ora;
		}
	}

	public static List<Integer> ottieniSensori() {
		List<Integer> listaSensori = new ArrayList<Integer>();
		for (int i = 0; i < 25; i++) {
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

	public static List<Dispositivo> ottieniDispositivi() {
		List<Dispositivo> listaDispositivi = new ArrayList<Dispositivo>();
		listaDispositivi.add(new Dispositivo("Tv", 1, 00, 120.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Monitor", 1, 01, 90.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Computer", 0, 02, 20.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Lavatrice", -1, 03, 220.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Radio", 0, 04, 10.00, true, false, false));
		return listaDispositivi;
	}

	public void posizionaCliente() {
		Cliente c = new Cliente("Rosario", "Culmone", "0737666666", "rosario.culmone@polmoni.it", "Via Merelli 1");
		c.getNome();
	}

	public void generaStanze() {
		List<Stanza> stanze = new ArrayList<Stanza>();
		stanze.add(new Stanza(0, "Cucina", ottieniDispositivi(), ottieniLuci(), new Sensore(1)));
		stanze.add(new Stanza(1, "Bagno", ottieniDispositivi(), ottieniLuci(), new Sensore(-1)));
	}

	public void populateListaIdDispositivi() {
		for (int i = 0; i < NUMERO_MASSIMO_DISPOSITIVI; i++) {
			listaIdDispositivi.add(i);
		}
	}

	public void populateRisparmioEnergetico() {

	}

	public static void main(String args[]) throws IOException, ParseException {
		AmbienteDiSimulazione ambiente = new AmbienteDiSimulazione();
		Interfaccia frame = new Interfaccia(ambiente.getListaIdDispositivi());
		frame.setVisible(true);

		/*
		 * File file = new File("RisparmioEnergetico.txt"); Configurazione c = new
		 * Configurazione(ottieniDispositivi()); RisparmioEnergetico re0 = null;
		 */

		/*
		 * DEBUG DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); LocalDate localDate
		 * = LocalDate.now(); String data =
		 * DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate); Date d =
		 * df.parse(data); RisparmioEnergetico re = new RisparmioEnergetico(re0, c, d,
		 * 200); re.writeRisparmioEnergetico(file); RisparmioEnergetico prova; prova =
		 * re.readRisparmioEnergetico(file); System.out.println("data"+prova.getData());
		 * System.out.println("risparmio"+prova.getRisparmio()); c =
		 * prova.getConfigurazione(); Dispositivo disp; List<Dispositivo> dispositivi =
		 * c.getDispositivi(); Iterator<Dispositivo> i = dispositivi.iterator();
		 * while(i.hasNext()) { disp = i.next(); System.out.println(disp.getTipo() +
		 * disp.getCodice() + disp.getId() + disp.puòEssereAcceso() +
		 * disp.puòEssereSpento() + disp.puòEssereMessoInStandby() + disp.getConsumo());
		 * }
		 * 
		 */
	}
}

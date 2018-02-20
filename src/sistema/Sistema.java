package sistema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sistema extends Thread {

	/*
	 * Lista delle stanze monitorate dal sistema
	 */
	private List<Stanza> stanze;

	/*
	 * Configurazione corrente impostata dal cliente
	 */
	private Configurazione configurazione;

	/*
	 * Risparmio energetico ottenuto dal cliente mediante l'uso del sistema
	 */
	private RisparmioEnergetico risparmio;

	/*
	 * Consumo totale dei dispositivi e delle luci
	 */
	private double consumoTot;

	/*
	 * Consumo giornaliero effettivo dei dispositivi e delle luci
	 */
	private double consumoGiornaliero;

	/*
	 * Verifica la presenza del cliente nella stanza
	 */
	private boolean[] eraNellaStanza;

	/*
	 * Verifica che il sistema sia in funzione
	 */
	private boolean operativo;
	
	/*
	 * Verifica se il dispositivo è guasto
	 */
	private boolean guasto;

	/**
	 * Inizializza il sistema con la lista delle stanze presenti nell'appartamento e
	 * la configurazione scelta dal cliente
	 * 
	 * @param stanze
	 *            lista delle stanze
	 * @param config
	 *            configurazione
	 */
	public Sistema(List<Stanza> stanze, Configurazione config) {
		// Imposta le stanze
		setStanze(stanze);
		// Imposta la configurazione
		setConfigurazione(config);
		/*
		 * Crea un array della dimensione delle stanze per
		 * verificare se l'utente è presente nelle stanze
		 */
		eraNellaStanza = new boolean[stanze.size()];
		for (int i = 0; i < stanze.size(); i++) {
			eraNellaStanza[i] = false;
		}
		operativo = true;
		guasto = true;
	}

	/**
	 * Verifica se vi è un guasto
	 * @return		boolean
	 */
	public boolean isOperativo() {
		return guasto;
	}

	/**
	 * Ferma il sistema
	 */
	public void stopControllo() {
		this.operativo = false;
	}

	/**
	 * Ritorna le stanze monitorate dal sistema
	 * 
	 * @return stanze
	 */
	public List<Stanza> getStanze() {
		return stanze;
	}

	/**
	 * Inserisce le stanze che il sistema deve monitorare
	 * 
	 * @param stanze
	 */
	public void setStanze(List<Stanza> stanze) {
		this.stanze = stanze;
	}

	/**
	 * Ritorna la configurazione corrente
	 * 
	 * @return configurazione
	 */
	public Configurazione getConfigurazione() {
		return configurazione;
	}

	/**
	 * Inserisce la configurazione scelta dal cliente
	 * 
	 * @param configurazione
	 */
	public void setConfigurazione(Configurazione configurazione) {
		this.configurazione = configurazione;
	};

	/**
	 * Ritorna il risparmio energetico ottenuto
	 * 
	 * @return risparmio
	 */
	public RisparmioEnergetico getRisparmio() {
		return risparmio;
	}

	/**
	 * Inserisce il risparmio
	 * 
	 * @param risparmio
	 */
	public void setRisparmio(RisparmioEnergetico risparmio) {
		this.risparmio = risparmio;
	}

	/**
	 * Crea un thread che agisce come demone e controlla continuativamente le stanze
	 * e l'eventuale presenza delle persone nelle suddette stanze
	 */
	public void Control() {
		System.out.println("Creazione Thread");
		this.start(); // Avvio il thread
	}

	public void run() {
		System.out.println("Thread Attivo");
		operativo = true;

			while (operativo) {
				// Creo un iteratore delle stanze
				Iterator<Stanza> i = stanze.iterator();
				Stanza st; // Creo un stanza d'appoggio
				int j = 0; // Indice
				while (i.hasNext()) {
					st = i.next();
					/*
					 * Se il sensore di ogni stanza ha codice 1, significa che vi è almeno una
					 * persona dentro la stanza quindi avvio i dispositivi e le luci presenti nella
					 * stanza
					 */
					if (st.getSensore().getCodice() == 1) {

						if (eraNellaStanza[j] == false) {
							// Avvio i dispositivi
							deviceOn(j);
							// Avvio le luci
							lightOn(j);
							eraNellaStanza[j] = true;
						}
						j++;
					} else {
						if (eraNellaStanza[j] == true) {
							// Spengo i dispositivi
							deviceOff(j);
							// Spengo le luci
							lightOff(j);
							eraNellaStanza[j] = false;
						}
						j++;
					}
				}
				// Inizializzo l'iteratore
				i = stanze.iterator();
				j = 0;
				try {
					Sistema.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}

	/**
	 * Accendo i dispositivi presenti nella stanza
	 * 
	 * @param i
	 *            indice di stanza
	 */
	public void deviceOn(int i) {
		// Ottengo la stanza
		Stanza st = stanze.get(i);
		// Creo un dispositivo d'appoggio
		Dispositivo d;
		// Ottengo la lista dei dispositivi presenti nella stanza
		List<Dispositivo> dispositivi = st.getDispositivi();
		// Creo un iteratore dei dispositivi
		Iterator<Dispositivo> j = dispositivi.iterator();
		while (j.hasNext()) {
			d = j.next();
			if (d.isGuasto() == true) {
				guasto = false;
				this.interrupt();
			}
			/*
			 * Verifico se il dispositivo può essere acceso ed, in tal caso, lo accendo
			 */
			if (d.puòEssereAcceso() == true)
				d.setCodice(1);
		}
	}

	/**
	 * Spengo i dispositivi presenti nella stanza
	 * 
	 * @param i
	 *            indice di stanza
	 */
	public void deviceOff(int i) {
		// Ottengo la stanza
		Stanza st = stanze.get(i);
		// Creo un dispositivo d'appoggio
		Dispositivo d;
		// Ottengo la lista dei dispositivi
		List<Dispositivo> dispositivi = st.getDispositivi();
		// Creo un iteratore dei dispositivi
		Iterator<Dispositivo> j = dispositivi.iterator();
		while (j.hasNext()) {
			d = j.next();
			if (d.isGuasto() == true) {
				guasto = false;
				this.interrupt();
			}
			/*
			 * Verifico se il dispositivo può essere spento ed, in tal caso, lo spengo
			 */
			if (d.puòEssereSpento() == true)
				d.setCodice(-1);
			else if (d.puòEssereMessoInStandby() == true)
				d.setCodice(0);
		}
	}

	/**
	 * Accende le luci nella stanza
	 * 
	 * @param i
	 *            indice di stanza
	 */
	public void lightOn(int i) {
		// Ottengo la stanza
		Stanza st = stanze.get(i);
		// Creo una luce di appoggio
		Luce l;
		// Creo una lista di luci presenti nella stanza
		List<Luce> luci = st.getLuci();
		// Creo un iteratore delle luci
		Iterator<Luce> j = luci.iterator();
		while (j.hasNext()) {
			l = j.next();
			/*
			 * Verifico se la luce può essere accesa ed, in tal caso, la accendo
			 */
			if (l.puòEssereAccesa() == true)
				l.setCodice(1);
		}
	}

	/**
	 * Spegne le luci nella stanza
	 * 
	 * @param i
	 *            indice di stanza
	 */
	public void lightOff(int i) {
		// Ottengo la stanza
		Stanza st = stanze.get(i);
		// Creo una luce di appoggio
		Luce l;
		// Creo una lista di luci presenti nella stanza
		List<Luce> luci = st.getLuci();
		// Creo un iteratore delle luci
		Iterator<Luce> j = luci.iterator();
		while (j.hasNext()) {
			l = j.next();
			/*
			 * Verifico se la luce può essere spenta ed, in tal caso, la spengo
			 */
			if (l.puòEssereSpenta() == true)
				l.setCodice(-1);
		}
	}

	/**
	 * Calcola il consumo totale dei dispositivi sommati alle luci presenti nella
	 * casa
	 */
	public void setConsumoTot() {
		// Creo l'iteratore delle stanze
		Iterator<Stanza> i = stanze.iterator();
		Stanza st; // Creo un stanza d'appoggio
		Dispositivo d; // Dispositivo di appoggio
		Luce l;
		while (i.hasNext()) { // Itero le stanze
			st = i.next();
			// Creo una lista di dispositivi presenti nella stanza
			List<Dispositivo> dispositivi = st.getDispositivi();
			// Creo un iteratore dei dispositivi
			Iterator<Dispositivo> j = dispositivi.iterator();
			while (j.hasNext()) {
				d = j.next();
				// Sommo il consumo di ogni singolo dispositivo della stanza
				this.consumoTot += d.getConsumo();
			}
			// Creo una lista delle luci presenti nella stanza
			List<Luce> luci = st.getLuci();
			// Creo un iteratore
			Iterator<Luce> z = luci.iterator();
			while (z.hasNext()) {
				l = z.next();
				// Sommo il consumo di ogni singola luce della stanza
				this.consumoTot += l.getConsumo();
			}
		}
	}
	
	/**
	 * Ritorna il consumo totale
	 * 
	 * @return consumoTot
	 */
	public double getConsumoTot() {
		return consumoTot;
	}

	/**
	 * Calcola il consumo giornaliero dei vari dispositivi e delle luci tenute
	 * accese durante la giornata
	 */
	public void setConsumoGiornaliero() {
		
	}

	/**
	 * Ritorna il consumo giornaliero
	 * 
	 * @return
	 */
	public double getConsumoGiornaliero() {
		return this.consumoGiornaliero;
	}

	/**
	 * Controlla i dispositivi per individuare guasti
	 * @return
	 */
	public static List<Dispositivo> controlloDispostivi(Configurazione config) {
		// Crea una lista di dispositivi guasti
		List<Dispositivo> listaDispositiviGuasti = new ArrayList<Dispositivo>();
		for (Dispositivo disp : config.getDispositivi()) {
			if (disp.isGuasto() == true)
				listaDispositiviGuasti.add(disp);
		}
		return listaDispositiviGuasti;
	}
}

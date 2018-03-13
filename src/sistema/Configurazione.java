package sistema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Configurazione {
	/*
	 * Lista dispositivi 
	 */
	private List<ControlloreDispositivo> dispositivi;
	
	/**
	 * Costruttore della Configurazione con parametri
	 * @param dispositivi
	 */
	public Configurazione(List<ControlloreDispositivo> dispositivi) {
		super();
		this.dispositivi = new ArrayList<ControlloreDispositivo>();
		this.dispositivi.addAll(dispositivi);
	}
	
	/**
	 * Costruttore Configurazione senza parametri
	 */
	public Configurazione() {
		super();
		this.dispositivi = new ArrayList<ControlloreDispositivo>();
	}

	/**
	 * Ritorna la lista dei dispositivi della configurazione
	 * @return		dispositivi
	 */
	public List<ControlloreDispositivo> getDispositivi() {
		return dispositivi;
	}

	/**
	 * Inserisce i dispositivi delle stanze della casa
	 * @param stanze		stanze della casa
	 */
	public void setDispositivi(List<Stanza> stanze) {
		// Creo un iteratore
		Iterator<Stanza> i = stanze.iterator();
		// Dispositivo di appoggio
		ControlloreDispositivo d;
		// Stanza di appoggio
		Stanza stanza;
		
		// Itero le stanze
		while(i.hasNext()) {
			stanza = i.next();
			// Ottengo i vari dispositivi della stanza
			List<ControlloreDispositivo> listdisp = stanza.getDispositivi();
			// Itero i dispositivi
			Iterator<ControlloreDispositivo> j = listdisp.iterator();
			while(j.hasNext()) {
				d = j.next();
				// Aggiungo i dispositivi alla lista
				dispositivi.add(d);
			}
		}
		
	}
	
	/**
	 * Inserisce la configurazione
	 * @param dispositivi
	 */
	public void setConfigurazione(List<ControlloreDispositivo> dispositivi) {
		this.dispositivi = dispositivi;
	}
	
	/**
	 * Ritorna la configurazione corrente
	 * @return		Configurazione
	 */
	public Configurazione getConfigurazione() {
		return this;
	}
	
	/**
	 * Ritorna il dispositivo in base al suo id
	 * @param idDispositivo
	 * @return		dispositivo
	 */
	public ControlloreDispositivo getDispositivo(int idDispositivo) {
		for (ControlloreDispositivo dispositivo : dispositivi) {
			if(dispositivo.getId() == idDispositivo) {
				return dispositivo;
			}
		}
		return null;
	}
	
	/**
	 * Aggiunge un dispositivo alla lista
	 * @param dispositivo
	 * @return
	 */
	public boolean addDispositivo(ControlloreDispositivo dispositivo) {
		try {
			dispositivi.add(dispositivo);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * Configura un dispositivo	
	 * @param id			id del dispositivo
	 * @param stato			stato del dispositivo
	 * @param attributo		attributo
	 * @return		true/false
	 */
	public boolean configuraDispositivo(int id, int stato, boolean attributo) {
		for (ControlloreDispositivo dispositivo : dispositivi) {
			 if(dispositivo.getId() == id) {
				 switch(stato) {
				 case 1: dispositivo.impostaAcceso(attributo);
				 	 	 return true;
				 case 2: dispositivo.impostaStandby(attributo);
				 		 return true;
				 case 3: dispositivo.impostaSpento(attributo);
				 		 return true;
				 }
			 }
		}
		return false;
	}
}

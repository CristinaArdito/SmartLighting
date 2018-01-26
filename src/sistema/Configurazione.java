package sistema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Configurazione {
	private List<Dispositivo> dispositivi;
	
	public Configurazione(List<Dispositivo> dispositivi) {
		super();
		this.dispositivi = new ArrayList<Dispositivo>();
		this.dispositivi.addAll(dispositivi);
	}
	
	public Configurazione() {
		super();
		this.dispositivi = new ArrayList<Dispositivo>();
	}

	public List<Dispositivo> getDispositivi() {
		return dispositivi;
	}

	public void setDispositivi(List<Stanza> stanze) {
		Iterator<Stanza> i = stanze.iterator();
		Dispositivo d;
		Stanza stanza;
		
		while(i.hasNext()) {
			stanza = i.next();
			List<Dispositivo> listdisp = stanza.getDispositivi();
			Iterator<Dispositivo> j = listdisp.iterator();
			while(j.hasNext()) {
				d = j.next();
				dispositivi.add(d);
			}
		}
		
	}
	
	public void setConfigurazione(List<Dispositivo> dispositivi, List<Dispositivo> eccezioni) {
		this.dispositivi = dispositivi;
	}
	
	public Configurazione getConfigurazione() {
		return this;
	}
	
	public Dispositivo getDispositivo(int idDispositivo) {
		for (Dispositivo dispositivo : dispositivi) {
			if(dispositivo.getId() == idDispositivo) {
				return dispositivo;
			}
		}
		return null;
	}
	
	public boolean addDispositivo(Dispositivo dispositivo) {
		try {
		dispositivi.add(dispositivo);
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean ConfiguraDispositivo(int id, int stato, boolean attributo) {
		for (Dispositivo dispositivo : dispositivi) {
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

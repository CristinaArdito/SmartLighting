package toAssign;

import java.util.List;

public class Configurazione {
	private List<Dispositivo> dispositivi;
	private List<Dispositivo> eccezioni;
	
	public Configurazione(List<Dispositivo> dispositivi, List<Dispositivo> eccezioni) {
		super();
		this.dispositivi = dispositivi;
		this.eccezioni = eccezioni;
	}

	public List<Dispositivo> getDispositivi() {
		return dispositivi;
	}

	public void setDispositivi(List<Dispositivo> dispositivi) {
		this.dispositivi = dispositivi;
	}

	public List<Dispositivo> getEccezioni() {
		return eccezioni;
	}

	public void setEccezioni(List<Dispositivo> eccezioni) {
		this.eccezioni = eccezioni;
	}
	
	public void setConfigurazione(List<Dispositivo> dispositivi, List<Dispositivo> eccezioni) {
		this.dispositivi = dispositivi;
		this.eccezioni = eccezioni;
	}
	
	public Configurazione getConfigurazione() {
		return this;
	}
	
	
}

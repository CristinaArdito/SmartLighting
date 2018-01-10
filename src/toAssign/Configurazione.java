package toAssign;

public class Configurazione {
	private Dispositivo dispositivi;
	private Dispositivo eccezioni;
	
	public Configurazione(Dispositivo dispositivi, Dispositivo eccezioni) {
		super();
		this.dispositivi = dispositivi;
		this.eccezioni = eccezioni;
	}

	public Dispositivo getDispositivi() {
		return dispositivi;
	}

	public void setDispositivi(Dispositivo dispositivi) {
		this.dispositivi = dispositivi;
	}

	public Dispositivo getEccezioni() {
		return eccezioni;
	}

	public void setEccezioni(Dispositivo eccezioni) {
		this.eccezioni = eccezioni;
	}
	
	public void setConfigurazione(Dispositivo dispositivi, Dispositivo eccezioni) {
		this.dispositivi = dispositivi;
		this.eccezioni = eccezioni;
	}
	
	public Configurazione getConfigurazione() {
		return this;
	}
}

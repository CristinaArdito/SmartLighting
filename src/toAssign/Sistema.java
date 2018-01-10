package toAssign;
import java.util.List;

import Simulazione.Stanza;

public class Sistema {
	private List<Stanza> stanze;
	private Configurazione configurazione;
	private RisparmioEnergetico risparmio;
	
	public Sistema(List<Stanza> stanze, Configurazione config) {
		setStanze(stanze);
		setConfigurazione(config);
	}

	public List<Stanza> getStanze() {
		return stanze;
	}

	public void setStanze(List<Stanza> stanze) {
		this.stanze = stanze;
	}

	public Configurazione getConfigurazione() {
		return configurazione;
	}

	public void setConfigurazione(Configurazione configurazione) {
		this.configurazione = configurazione;
	};
	
	public RisparmioEnergetico getRisparmio() {
		return risparmio;
	}

	public void setRisparmio(RisparmioEnergetico risparmio) {
		this.risparmio = risparmio;
	}

	public void lightOn() {
		
	}
	
	public void lightOff() {
		
	}
	
	public void Control() {
	
	}
	
	public void deviceOn() {
	
	}
	
	public void deviceOff() {
		
	}
	
	public void deviceStandBy() {
		
	}
	
	public void setConsumo() {
		
	}
	
	public void getConsumo() {
		
	}
}

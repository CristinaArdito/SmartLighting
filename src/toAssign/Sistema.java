package toAssign;
import java.util.List;

public class Sistema {
	private List<Sensore> sensori;
	private Configurazione configurazione;
	private RisparmioEnergetico risparmio;
	
	public Sistema() {
		
	}

	public List<Sensore> getSensori() {
		return sensori;
	}

	public void setSensori(List<Sensore> sensori) {
		this.sensori = sensori;
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

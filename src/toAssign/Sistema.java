package toAssign;
import java.util.Iterator;
import java.util.List;
import Simulazione.Stanza;

public class Sistema implements Runnable{
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
		Thread t = new Thread();
		t.setDaemon(true);
		t.start();
	}
	
	public void run() {
		if(Thread.currentThread().isDaemon()){ 
			Iterator<Stanza> i = stanze.iterator();
			Stanza st;
			int j = 0;
			while(true) {
				while(i.hasNext()) {
					st = i.next();
					if(st.getSensore().getCodice() == 1) {
						j++;
						System.out.println("l'omino � qui");
						deviceOn(j);
					}
				}
				i = stanze.iterator();
			}
		}
	}
	
	public void deviceOn(int i) {
		Stanza st = stanze.get(i);
		List<Dispositivo> dispositivi = st.getDispositivi();

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

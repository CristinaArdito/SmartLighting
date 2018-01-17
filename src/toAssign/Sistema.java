package toAssign;
import java.util.Iterator;
import java.util.List;

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
						System.out.println("l'omino è qui");
						deviceOn(j);
						lightOn(j);
					}
				}
				i = stanze.iterator();
			}
		}
	}
	
	public void deviceOn(int i) {
		Stanza st = stanze.get(i);
		Dispositivo d;
		List<Dispositivo> dispositivi = st.getDispositivi();
		Iterator<Dispositivo> j = dispositivi.iterator();
		while(j.hasNext()) {
			d = j.next();
			if(d.puòEssereAcceso() == true) d.setCodice(1);
		}
	}
	
	public void deviceOff(int i) {
		Stanza st = stanze.get(i);
		Dispositivo d;
		List<Dispositivo> dispositivi = st.getDispositivi();
		Iterator<Dispositivo> j = dispositivi.iterator();
		while(j.hasNext()) {
			d = j.next();
			if(d.puòEssereSpento() == true) d.setCodice(-1);
		}
	}
	
	public void deviceStandBy(int i) {
		Stanza st = stanze.get(i);
		Dispositivo d;
		List<Dispositivo> dispositivi = st.getDispositivi();
		Iterator<Dispositivo> j = dispositivi.iterator();
		while(j.hasNext()) {
			d = j.next();
			if(d.puòEssereMessoInStandby() == true) d.setCodice(0);
		}
	}
	
	public void lightOn(int i) {
		Stanza st = stanze.get(i);
		Luce l;
		List<Luce> luci = st.getLuci();
		Iterator<Luce> j = luci.iterator();
		while(j.hasNext()) {
			l = j.next();
			if(l.puòEssereAccesa() == true) l.setCodice(1);
		}
	}
	
	public void lightOff(int i) {
		Stanza st = stanze.get(i);
		Luce l;
		List<Luce> luci = st.getLuci();
		Iterator<Luce> j = luci.iterator();
		while(j.hasNext()) {
			l = j.next();
			if(l.puòEssereSpenta() == true) l.setCodice(-1);
		}
	}
	
	public void setConsumo() {
		
	}
	
	public void getConsumo() {
		
	}
}

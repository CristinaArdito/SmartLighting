package sistema;
import java.util.*;

public class RisparmioEnergetico {
	private RisparmioEnergetico statoPrecedente;
	private Configurazione configurazione;
	private Date data;
	private int risparmio;
	
	public RisparmioEnergetico(RisparmioEnergetico statoPrecedente, Configurazione configurazione, Date data, int risparmio) {
		super();
		this.statoPrecedente = statoPrecedente;
		this.configurazione = configurazione;
		this.data = data;
		this.risparmio = risparmio;
	}
	
	public RisparmioEnergetico getStatoPrecedente() {
		return statoPrecedente;
	}
	
	public void setStatoPrecedente(RisparmioEnergetico statoPrecedente) {
		this.statoPrecedente = statoPrecedente;
	}
	
	public Configurazione getConfigurazione() {
		return configurazione;
	}
	
	public void setConfigurazione(Configurazione configurazione) {
		this.configurazione = configurazione;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getRisparmio() {
		return risparmio;
	}
	
	public void setRisparmio(int risparmio) {
		this.risparmio = risparmio;
	}
	
	
	
}

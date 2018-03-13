package sistema;

import java.util.ArrayList;
import java.util.List;

import sistema.ControlloreDispositivo;
import sistema.ControlloreLuce;
import sistema.Sensore;

public class Stanza {
	/*
	 * Codice stanza
	 */
	private int codice;
	
	/*
	 * Nome della stanza
	 */
	private String nome;
	
	/*
	 * Lista dispositivi presenti nella stanza
	 */
	private List<ControlloreDispositivo> dispositivi;
	
	/*
	 * Lista delle luci presenti nella stanza
	 */
	private List<ControlloreLuce> luci;
	
	/*
	 * Sensore della stanza
	 */
	private Sensore sensore;
	
	/**
	 * Costruttore della stanza
	 * @param codice				codice stanza
	 * @param nome					nome stanza
	 * @param listaDispositivi		lista dei dispositivi presenti nella stanza
	 * @param sensore				sensore della stanza
	 */
	public Stanza(int codice, String nome, List<ControlloreDispositivo> listaDispositivi, List<ControlloreLuce> listaLuci, Sensore sensore) {
		setLuci(listaLuci);
		setDispositivi(listaDispositivi);
		setSensore(sensore);
		setCodice(codice);
		setNome(nome);
	}
	
	/**
	 * Ritorna il codice della stanza
	 * @return	codice
	 */
	public int getCodice() {
		return codice;
	}

	/**
	 * Inserisce il codice della stanza
	 * @param codice
	 */
	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	/**
	 * Ritorna la lista dei dispositivi presenti nella stanza
	 * @return	dispositivi
	 */
	public List<ControlloreDispositivo> getDispositivi() {
		return dispositivi;
	}
	
	/**
	 * Inserisce la lista dei dispositivi presenti nella stanza
	 * @param dispositivi
	 */
	public void setDispositivi(List<ControlloreDispositivo> dispositivi) {
		this.dispositivi = new ArrayList<ControlloreDispositivo>();
		this.dispositivi.addAll(dispositivi);
	}
	
	/**
	 * Ritorna la lista delle luci presenti nella stanza
	 * @return
	 */
	public List<ControlloreLuce> getLuci() {
		return luci;
	}
	
	/**
	 * Inserisce la lista delle luci presenti nella stanza
	 * @param luci
	 */
	public void setLuci(List<ControlloreLuce> luci) {
		this.luci = new ArrayList<ControlloreLuce>();
		this.luci.addAll(luci);
	}
	
	/**
	 * Ritorna il sensore
	 * @return	sensore
	 */
	public Sensore getSensore() {
		return sensore;
	}
	
	/**
	 * Inserisce il sensore della stanza
	 * @param sensori
	 */
	public void setSensore(Sensore sensori) {
		this.sensore = sensori;
	}

	/**
	 * Ritorna il nome della stanza
	 * @return
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Inserisce il nome della stanza
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
package toAssign;

import java.util.ArrayList;
import java.util.List;
import toAssign.Dispositivo;
import toAssign.Luce;
import toAssign.Sensore;

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
	private List<Dispositivo> dispositivi;
	
	/*
	 * Lista delle luci presenti nella stanza
	 */
	private List<Luce> luci;
	
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
	public Stanza(int codice, String nome, List<Dispositivo> listaDispositivi, List<Luce> listaLuci, Sensore sensore) {
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
	public List<Dispositivo> getDispositivi() {
		return dispositivi;
	}
	
	/**
	 * Inserisce la lista dei dispositivi presenti nella stanza
	 * @param dispositivi
	 */
	public void setDispositivi(List<Dispositivo> dispositivi) {
		this.dispositivi = new ArrayList<Dispositivo>();
		this.dispositivi.addAll(dispositivi);
	}
	
	/**
	 * Ritorna la lista delle luci presenti nella stanza
	 * @return
	 */
	public List<Luce> getLuci() {
		return luci;
	}
	
	/**
	 * Inserisce la lista delle luci presenti nella stanza
	 * @param luci
	 */
	public void setLuci(List<Luce> luci) {
		this.luci = luci;
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
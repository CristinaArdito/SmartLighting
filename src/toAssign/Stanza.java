package toAssign;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.net.MalformedURLException;
import java.net.URI;

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
	public Stanza(int codice, String nome, List<Dispositivo> listaDispositivi, Sensore sensore) {
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
	
	// stanza: int codice, String nome, List<Dispositivo> listaDispositivi, Sensore sensore
	// dispositivo: string tipo, byte codice, int id, boolean (puòEssereAcceso, puòEssereSpento, puòEssereMessoInStandby), double consumo
	// sensore: codice
	
	public void writeStanzaOnFile(File file) throws FileNotFoundException, MalformedURLException{
		Iterator<Dispositivo> i = dispositivi.iterator();
		Dispositivo d;
		
	    try {
		    FileOutputStream output = new FileOutputStream(file);
		    PrintStream write = new PrintStream(output); 
		    
		    write.println("{");
		    write.println("Nome: " + this.getNome() + " ,");
		    write.println("Codice: " + this.getCodice() + " ,");
		    write.print("Lista Dispositivi: ");
		    write.println();
		    while(i.hasNext()) {
		    	d = i.next();
		    	write.println("{");
		    	write.println("Tipo: " + d.getTipo() + " ,");
		    	write.println("Codice: " + d.getCodice() + " ,");
		    	write.println("Id: " + d.getId() + " ,");
		    	write.println("PuòEssereAcceso: " + d.puòEssereAcceso() + " ,");
		    	write.println("PuòEssereSpento: " + d.puòEssereSpento() + " ,");
		    	write.println("PuòEssereMessoInStandby: " + d.puòEssereMessoInStandby() + " ,");
		    	write.println("Consumo: " + d.getConsumo());
		    	write.println("},");
		    }
		    write.println("Sensore: " + this.getSensore().getCodice());
		    write.print("};");		    
		    write.close();
	    }
	    catch (IOException e) {
		    System.out.println(e.getMessage());
	    }
	    catch (Exception e) {
		    System.out.println(e.getMessage());		   
	    } 
	}   
	
	public Stanza readStanzaFromFile(File file) throws FileNotFoundException{
    	URI uri = file.toURI();		/* Restituisce un URI assoluto con uno schema uguale al file */
    	byte[] bytes = null;		/* Creo un array di bytes */
    	List<Dispositivo> list = new ArrayList<Dispositivo>();
    	int codice = 0, id = 0;
    	boolean on = false, off = false, stand = false;
    	double consumo = 0;
    	String tipo = new String();
        try {
        	/* Leggo tutti i byte del file */
            bytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(uri));
        }catch(IOException e) { 
        	e.printStackTrace(); 
        }
        /* Trasformo l'array di byte in una stringa */
        String stanza =  new String(bytes);
        String[] lines = stanza.split(System.getProperty("line.separator"));       
        for(String line : lines) {
        	String[] words = line.split("\\s+");
        	if(line.contains("Nome") == true) {
        		this.setNome(words[1]);
        	}
        	else if(line.contains("Codice") == true) {
        		this.setCodice(Integer.parseInt(words[1]));
        	}
        	else if(line.contains("Tipo") == true) {
        		tipo = words[1];
        	}
        	else if(line.contains("Codice") == true) {
        		codice = Integer.parseInt(words[1]);
        	}
        	else if(line.contains("Id") == true) {
        		id = Integer.parseInt(words[1]);
        	}
        	else if(line.contains("PuòEssereAcceso") == true) {
        		on = Boolean.parseBoolean(words[1]);
        	}
        	else if(line.contains("PuòEssereSpento") == true) {
        		off = Boolean.parseBoolean(words[1]);
        	}
        	else if(line.contains("PuòEssereMessoInStandby ") == true) {
        		stand = Boolean.parseBoolean(words[1]);
        	}
        	else if(line.contains("Consumo") == true) {
        		consumo = Double.parseDouble(words[1]);
        		list.add(new Dispositivo(tipo, codice, id, consumo, on, off, stand));
        	}
        	else if(line.contains("Sensore") == true) {
        		this.setSensore(new Sensore(Integer.parseInt(words[1])));
        	}
        }
        return this;
	}
	
}
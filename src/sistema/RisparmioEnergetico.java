package sistema;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	public void writeRisparmioEnergetico(File file) {
		try {
		    FileOutputStream output = new FileOutputStream(file);
		    PrintStream write = new PrintStream(output); 
		    write.println("{");
		    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String data = df.format(this.data);
		    write.println("Data: " + data + " ,");
		    write.println("Risparmio: " + this.risparmio + " ,");
		    write.println("Lista dispositivi : ");
		    write.println("{");
		    List<Dispositivo> dispositivi = configurazione.getDispositivi();
		    Iterator<Dispositivo> i = dispositivi.iterator();
		    Dispositivo d;
		    while(i.hasNext()) {
		    	d = i.next();
		    	write.println("Tipo: " + d.getTipo() + " ,");
		    	write.println("Codice: " + d.getCodice() + " ,");
		    	write.println("Id: " + d.getId() + " ,");
		    	write.println("PuòEssereAcceso: " + d.puòEssereAcceso() + " ,");
		    	write.println("PuòEssereSpento: " + d.puòEssereSpento() + " ,");
		    	write.println("PuòEssereMessoInStandby: " + d.puòEssereMessoInStandby() + " ,");
		    	write.println("Consumo: " + d.getConsumo());
		    	write.println("},");		    	
		    }
		    write.println("};");
			write.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());	
		}
	}
	
	public RisparmioEnergetico readRisparmioEnergetico(File file) throws ParseException {
		// Restituisce un URI assoluto con uno schema uguale al file 
    	URI uri = file.toURI();	
    	// Creo un array di bytes 
    	byte[] bytes = null;
    	RisparmioEnergetico re0 = null;
    	RisparmioEnergetico re = null;
    	RisparmioEnergetico re1 = null;
    	Dispositivo d;
    	List<Dispositivo> dispositivi = new ArrayList<>();
    	Configurazione c;
    	String data = new String();
    	Date data1 = new Date();
    	int codice = 0;
    	int risparmio = 0;
    	String tipo = new String();
    	int id = 0;
    	boolean on = false;
    	boolean off = false;
    	boolean stand = false;
    	double consumo = 0;
    	int counter = 0;
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
        	if(line.contains("Data") == true) {
        		data = words[1];
                SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
                data1 = parser.parse(data);
        	}
        	if(line.contains("Risparmio") == true) {
        		risparmio = Integer.parseInt(words[1]);	
        	}
        	if(line.contains("Tipo") == true) {
        		tipo = words[1];
        	}
        	if(line.contains("Codice") == true) {
        		codice = Integer.parseInt(words[1]);        		
        	}
        	if(line.contains("Id") == true) {
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
        		d = new Dispositivo(tipo, codice, id, consumo, on, off, stand);
        		dispositivi.add(d);
        	}
        	else if(line.contains("};") == true) {
        		c = new Configurazione(dispositivi);
        		if(counter == 0) {
        			re = new RisparmioEnergetico(re0, c, data1, risparmio);
        			re1 = re;
        		}
        		else {
        			re = new RisparmioEnergetico(re1, c, data1, risparmio);
        			re1 = re;
        		}
        	}
        }
        return re;
	}
	
}	

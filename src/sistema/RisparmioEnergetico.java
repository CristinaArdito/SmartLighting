package sistema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RisparmioEnergetico {
	/*
	 * Risparmio energetico precedente
	 */
	private RisparmioEnergetico statoPrecedente;

	/*
	 * Configurazione corrente
	 */
	private Configurazione configurazione;

	/*
	 * Data
	 */
	private Date data;

	/*
	 * Risparmio
	 */
	private double risparmio;

	/**
	 * Costruttore del risparmio energetico
	 * 
	 * @param statoPrecedente
	 *            risparmio precedente
	 * @param configurazione
	 *            configurazione corrente
	 * @param data
	 *            data
	 */
	public RisparmioEnergetico(RisparmioEnergetico statoPrecedente, Configurazione configurazione, Date data) {
		super();
		this.statoPrecedente = statoPrecedente;
		this.configurazione = configurazione;
		this.data = data;
		this.risparmio = 0;

		for (ControlloreDispositivo dispositivo : configurazione.getDispositivi()) {
			if (dispositivo.getCodice() == 1) {
				this.risparmio += dispositivo.getConsumoParziale();
			} else {
				this.risparmio += dispositivo.getConsumo();
			}
		}
	}

	public RisparmioEnergetico(RisparmioEnergetico statoPrecedente, Configurazione configurazione, Date data,
			double risparmio) {
		super();
		this.statoPrecedente = statoPrecedente;
		this.configurazione = configurazione;
		this.data = data;
		this.risparmio = risparmio;
	}

	/**
	 * Ritorna il risparmio energetico precedente
	 * 
	 * @return statoPrecedente
	 */
	public RisparmioEnergetico getStatoPrecedente() {
		return statoPrecedente;
	}

	/**
	 * Imposta lo stato precedente del risparmio
	 * 
	 * @param statoPrecedente
	 *            risparmio pregresso
	 */
	public void setStatoPrecedente(RisparmioEnergetico statoPrecedente) {
		this.statoPrecedente = statoPrecedente;
	}

	/**
	 * Ritorna la configurazione
	 * 
	 * @return configurazione
	 */
	public Configurazione getConfigurazione() {
		return configurazione;
	}

	/**
	 * Imposta la configurazione
	 * 
	 * @param configurazione
	 *            configurazione corrente
	 */
	public void setConfigurazione(Configurazione configurazione) {
		this.configurazione = configurazione;
	}

	/**
	 * Ritorna la data
	 * 
	 * @return data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Imposta la data
	 * 
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Ritorna il risparmio
	 * 
	 * @return risparmio
	 */
	public double getRisparmio() {
		return risparmio;
	}

	/**
	 * Imposta il risparmio
	 * 
	 * @param risparmio
	 */
	public void setRisparmio(double risparmio) {
		this.risparmio = risparmio;
	}

	/**
	 * Scrive il risparmio su file
	 * 
	 * @param file
	 *            file di scrittura
	 */
	public void writeRisparmioEnergetico(File file) {
		try {
			FileOutputStream output = new FileOutputStream(file);
			PrintStream write = new PrintStream(output);
			write.println("{");
			// Creo il formato per la data
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String data = df.format(this.data);
			write.println("Data: " + data + " ,");
			write.println("Risparmio: " + this.risparmio + " ,");
			write.println("Lista dispositivi : ");
			write.println("{");
			// Creo una lista dei dispositivi sulla base della configurazione corrente
			List<ControlloreDispositivo> dispositivi = configurazione.getDispositivi();
			// Iteratore per i dispositivi
			Iterator<ControlloreDispositivo> i = dispositivi.iterator();
			ControlloreDispositivo d;
			while (i.hasNext()) {
				d = i.next();
				write.println("Tipo: " + d.getTipo() + " ,");
				write.println("Codice: " + d.getCodice() + " ,");
				write.println("Id: " + d.getId() + " ,");
				write.println("PuòEssereAcceso: " + d.puòEssereAcceso() + " ,");
				write.println("PuòEssereSpento: " + d.puòEssereSpento() + " ,");
				write.println("PuòEssereMessoInStandby: " + d.puòEssereMessoInStandby() + " ,");
				if (d.getCodice() == 1) {
					write.println("TempoAcceso: " + d.getTempoParziale() + " ,");
					write.println("Consumo: " + d.getConsumoParziale());
				} else {
					write.println("TempoAcceso: " + d.getTempoAttivo() + " ,");
					write.println("Consumo: " + d.getConsumo());
				}

				write.println("},");
			}
			write.println("};");
			write.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lettura del risparmio memorizzato su file
	 * 
	 * @param file
	 *            file da leggere
	 * @return RisparmioEnergetico
	 * @throws ParseException
	 */
	public static RisparmioEnergetico readRisparmioEnergetico(File file) throws ParseException {
		// Restituisce un URI assoluto con uno schema uguale al file
		URI uri = file.toURI();
		// Creo un array di bytes
		byte[] bytes = null;
		// Variabili d'appoggio
		RisparmioEnergetico re0 = null;
		RisparmioEnergetico re = null;
		RisparmioEnergetico re1 = null;
		ControlloreDispositivo d;
		// Lista dei dispositivi
		List<ControlloreDispositivo> dispositivi = new ArrayList<>();
		Configurazione c;
		String data = new String();
		Date data1 = new Date();
		int codice = 0;
		String tipo = new String();
		int id = 0;
		double risparmio = 0;
		boolean on = false;
		boolean off = false;
		boolean stand = false;
		double consumo = 0;
		int tempoOn = 0;
		int counter = 0;
		try {
			/* Leggo tutti i byte del file */
			bytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(uri));
		} catch (IOException e) {
			return null;
		}
		/* Trasformo l'array di byte in una stringa */
		String stanza = new String(bytes);
		// Separo le linee del file
		String[] lines = stanza.split(System.getProperty("line.separator"));
		// Itero le varie linee
		for (String line : lines) {
			String[] words = line.split("\\s+");
			if (line.contains("Data") == true) {
				data = words[1];
				SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
				data1 = parser.parse(data);
			}
			if (line.contains("Risparmio") == true) {
				risparmio = Double.parseDouble(words[1]);
			}
			if (line.contains("Tipo") == true) {
				tipo = words[1];
			}
			if (line.contains("Codice") == true) {
				codice = Integer.parseInt(words[1]);
			}
			if (line.contains("Id") == true) {
				id = Integer.parseInt(words[1]);
			} else if (line.contains("PuòEssereAcceso") == true) {
				on = Boolean.parseBoolean(words[1]);
			} else if (line.contains("PuòEssereSpento") == true) {
				off = Boolean.parseBoolean(words[1]);
			} else if (line.contains("PuòEssereMessoInStandby") == true) {
				stand = Boolean.parseBoolean(words[1]);
			} else if (line.contains("TempoAcceso") == true) {
				tempoOn = Integer.parseInt(words[1]);
			} else if (line.contains("Consumo") == true) {
				consumo = Double.parseDouble(words[1]);
				// Creo un nuovo dispositivo
				d = new ControlloreDispositivo(tipo, codice, id, consumo, on, off, stand, tempoOn);
				// Lo aggiungo alla lista
				dispositivi.add(d);
			} else if (line.contains("};") == true) {
				// Creo una nuova configurazione
				c = new Configurazione(dispositivi);
				if (counter == 0) {
					// Se è la prima imposto lo stato precedente a null
					re = new RisparmioEnergetico(re0, c, data1, risparmio);
					re1 = re;
				} else {
					re = new RisparmioEnergetico(re1, c, data1, risparmio);
					re1 = re;
				}
			}
		}
		// Ritorno il risparmio
		return re;
	}

}

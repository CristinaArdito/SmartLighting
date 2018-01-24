package InterfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Simulazione.AmbienteDiSimulazione;
import toAssign.Configurazione;
import toAssign.Dispositivo;
import toAssign.Luce;
import toAssign.Sensore;
import toAssign.Sistema;
import toAssign.Stanza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;

public class Interfaccia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Stanza> stanze;
	private Configurazione config = new Configurazione();
	private static List<Integer> sensori = AmbienteDiSimulazione.ottieniSensori();
	private ModificaConfigurazione nuovaConfigurazione;
	
	public Interfaccia() throws FileNotFoundException, MalformedURLException {
		
		stanze = new ArrayList<Stanza>();
		
		stanze.add(new Stanza(0, "Cucina", ottiniDispositivi(), ottieniLuci(), new Sensore(1)));
		stanze.add(new Stanza(1, "Bagno", ottiniDispositivi(), ottieniLuci(), new Sensore(-1)));
		File file = new File("Stanze.txt");
		writeStanzaOnFile(file);
		List<Stanza> list1= readStanzaFromFile(file);
		Iterator<Stanza> j = list1.iterator();
		Stanza s1;
		while(j.hasNext()) {
			s1 = j.next();
			System.out.println(s1.getNome());
			System.out.println(s1.getCodice());
			System.out.println("dispositivi:");
			List<Dispositivo> list = s1.getDispositivi();
			Dispositivo d;
			Iterator<Dispositivo> i = list.iterator();
			while(i.hasNext()) {
				d = i.next();
				System.out.println(d.getTipo() + d.getCodice() + d.getId() + d.puòEssereAcceso() + d.puòEssereSpento() + d.puòEssereMessoInStandby() + d.getConsumo());
			}
			System.out.println(s1.getSensore().getCodice());
		}
		
		if(stanze.size() != 0) {
			for (Stanza stanza : stanze) {
				for (Dispositivo dispositivo : stanza.getDispositivi()) {
					config.addDispositivo(dispositivo);
				}
			}
		}
		
//		importaConfigurazione();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModificaConfigurazione = new JButton("Modifica Configurazione");
		btnModificaConfigurazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuovaConfigurazione = new ModificaConfigurazione(config, stanze);
				nuovaConfigurazione.setVisible(true);
				nuovaConfigurazione.addConfirmListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						nuovaConfigurazione.addConfirmListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								stanze = nuovaConfigurazione.getStanze();
							}
						});
					}
				});
			}
		});
		btnModificaConfigurazione.setBounds(10, 11, 464, 59);
		contentPane.add(btnModificaConfigurazione);
		
		JPanel panelloDati = new JPanel();
		panelloDati.setBounds(10, 76, 464, 537);
		contentPane.add(panelloDati);
		
		JButton btnAvvia = new JButton("Avvia");
		btnAvvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(stanze.size() == 0) {
					JOptionPane.showMessageDialog(null, "Configurazione inesistente, modificare la configurazione");
				}else {
					Sistema sistema = new Sistema(stanze, config);
					sistema.Control();
				}
			}
		});
		btnAvvia.setBounds(76, 624, 334, 59);
		contentPane.add(btnAvvia);
	}
	
	/*
	private void importaConfigurazione() {
		for (Stanza stanza : stanze) {
			for (Dispositivo dispositivo : stanza.getDispositivi()) {
				config.addDispositivo(dispositivo);
			}
		}
	}
	*/
	
	public static List<Integer> getSensori(){
		return sensori;
	}
	
	/**
	 * Scrittura della stanza su file
	 * @param file
	 * @throws FileNotFoundException
	 * @throws MalformedURLException
	 */
	public void writeStanzaOnFile(File file) throws FileNotFoundException, MalformedURLException {
    	// Scrittura su file
	    FileOutputStream output = new FileOutputStream(file);
	    PrintStream write = new PrintStream(output); 
		// Iteratore delle stanze
		Iterator<Stanza> j = stanze.iterator();
		// Creo un stanza di appoggio
		Stanza s;
		while(j.hasNext()) {
			s = j.next();
			// Ottengo i dispositivi della stanza
			List<Dispositivo> dispositivi = s.getDispositivi();
			// Creo un iteratore per i dispositivi
			Iterator<Dispositivo> i = dispositivi.iterator();
			Dispositivo d;
			Luce l;
			// Ottengo le luci della stanza
			List<Luce> luci = s.getLuci();
			// Creo un iteratore per le luci
			Iterator<Luce> z = luci.iterator();
			
		    try {
			    // Organizzo il file con una struttura json
			    write.println("{");
			    write.println("Nome: " + s.getNome() + " ,");
			    write.println("CodiceStanza: " + s.getCodice() + " ,");
			    write.println("Lista Dispositivi: ");
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
			    write.println("Lista Luci: ");
			    while(z.hasNext()) {
			    	l = z.next();
			    	write.println("{");
			    	write.println("CodiceLuce: " + l.getCodice() + " ,");
			    	write.println("IdLuce: " + l.getId() + " ,");
			    	write.println("PuòEssereAccesa: " + l.puòEssereAccesa() + " ,");
			    	write.println("PuòEssereSpenta: " + l.puòEssereSpenta() + " ,");
			    	write.println("ConsumoLuce: " + l.getConsumo());
			    	write.println("},");
			    }
			    write.println("Sensore: " + s.getSensore().getCodice());
			    write.println("};");		    
		    }
		    catch (Exception e) {
			    System.out.println(e.getMessage());		   
		    } 
		    write.close();
		}
	}  
	
	/**
	 * Lettura del file
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public List<Stanza> readStanzaFromFile(File file) throws FileNotFoundException{
		// Restituisce un URI assoluto con uno schema uguale al file 
    	URI uri = file.toURI();	
    	// Creo un array di bytes 
    	byte[] bytes = null;		
    	// Creo una lista per i dispositivi
    	List<Dispositivo> list = new ArrayList<Dispositivo>();
    	// Creo una lista per le luci
    	List<Luce> listluci = new ArrayList<Luce>();
    	// Creo variabili di appoggio per codice id e codice della stanza
    	int codice = 0;
    	int id = 0;
    	int codicestanza = 0;
    	// Creo variabili di appoggio per codice e id delle luci
    	int codiceluce = 0;
    	int idluce = 0;
    	// Creo i boolean per verificare se i dispositivi possono essere accesi spenti o messi in standby
    	boolean on = false, off = false, stand = false;
    	// Creo i boolean per verificare se le luci possono essere accese o spente
    	boolean luceon = false;
    	boolean luceoff = false;
    	double consumo = 0;
    	double consumoluce = 0;
    	String tipo = new String();
    	String nome = new String();
    	Sensore s;
    	List<Stanza> liststanze = new ArrayList<Stanza>();
    	if(file.length() == 0) {
    		return liststanze;
    	}
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
        		nome = words[1];
        	}
        	else if(line.contains("CodiceStanza") == true) {
        		codicestanza = Integer.parseInt(words[1]);
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
        	else if(line.contains("CodiceLuce") == true) {
        		codiceluce = Integer.parseInt(words[1]);
        	}
        	else if(line.contains("IdLuce") == true) {
        		idluce = Integer.parseInt(words[1]);
        	}
        	else if(line.contains("PuòEssereAccesa") == true) {
        		luceon = Boolean.parseBoolean(words[1]);
        	}
        	else if(line.contains("PuòEssereSpenta") == true) {
        		luceoff = Boolean.parseBoolean(words[1]);
        	}
        	else if(line.contains("ConsumoLuce") == true) {
        		consumoluce = Double.parseDouble(words[1]);
        		listluci.add(new Luce(idluce, codiceluce, consumoluce, luceon, luceoff));
        	}
        	else if(line.contains("Sensore") == true) {
        		s = new Sensore(Integer.parseInt(words[1]));
        		liststanze.add(new Stanza(codicestanza, nome, list, listluci, s));
        		list.clear();
        	}
        }
        return liststanze;
	}
	
	public static List<Dispositivo> ottiniDispositivi() {
		List<Dispositivo> listaDispositivi = new ArrayList<Dispositivo>();
		listaDispositivi.add(new Dispositivo("Tv", 1, 00, 120.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Minitor", 1, 01, 90.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Computer", 0, 02, 20.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Lavatrice", -1, 03, 220.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Radio", 0, 04, 10.00, true, false, false));
		return listaDispositivi;
	}
	
	public static List<Luce> ottieniLuci() {
		List<Luce> listaLuci = new ArrayList<Luce>();
		listaLuci.add(new Luce(1, -1, 10.00, true, true));
		listaLuci.add(new Luce(2, 1, 5.00, true, true));
		return listaLuci;
	}
}

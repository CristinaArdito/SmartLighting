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
import toAssign.Sensore;
import toAssign.Sistema;
import toAssign.Stanza;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.awt.event.ActionEvent;


import toAssign.Sistema;
import toAssign.Stanza;

public class Interfaccia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Stanza> stanze;
	private Configurazione config = new Configurazione();
	private static List<Integer> sensori = AmbienteDiSimulazione.ottieniSensori();
	private ModificaConfigurazione nuovaConfigurazione;
	private int indiceStanza = 0;

	public Interfaccia() throws FileNotFoundException, MalformedURLException {
		
		stanze = new ArrayList<Stanza>();
		stanze.add(new Stanza(0, "Cucina", ottiniDispositivi(), new Sensore(1)));
		stanze.add(new Stanza(1, "Bagno", ottiniDispositivi(), new Sensore(-1)));
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
				System.out.println(d.getTipo() + d.getCodice() + d.getId() + d.pu�EssereAcceso() + d.pu�EssereSpento() + d.pu�EssereMessoInStandby() + d.getConsumo());
			}
			System.out.println(s1.getSensore().getCodice());
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
								stanze = nuovaConfigurazione.getStanza();
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
		Iterator<Stanza> j = stanze.iterator();
		Stanza s;
		while(j.hasNext()) {
			s = j.next();
			List<Dispositivo> dispositivi = s.getDispositivi();
			Iterator<Dispositivo> i = dispositivi.iterator();
			Dispositivo d;
			
		    try {
			    FileOutputStream output = new FileOutputStream(file, true);
			    PrintStream write = new PrintStream(output); 
			    
			    write.println("{");
			    write.println("Nome: " + s.getNome() + " ,");
			    write.println("CodiceStanza: " + s.getCodice() + " ,");
			    write.print("Lista Dispositivi: ");
			    write.println();
			    while(i.hasNext()) {
			    	d = i.next();
			    	write.println("{");
			    	write.println("Tipo: " + d.getTipo() + " ,");
			    	write.println("Codice: " + d.getCodice() + " ,");
			    	write.println("Id: " + d.getId() + " ,");
			    	write.println("Pu�EssereAcceso: " + d.pu�EssereAcceso() + " ,");
			    	write.println("Pu�EssereSpento: " + d.pu�EssereSpento() + " ,");
			    	write.println("Pu�EssereMessoInStandby: " + d.pu�EssereMessoInStandby() + " ,");
			    	write.println("Consumo: " + d.getConsumo());
			    	write.println("},");
			    }
			    write.println("Sensore: " + s.getSensore().getCodice());
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
	}  
	
	public List<Stanza> readStanzaFromFile(File file) throws FileNotFoundException{
    	URI uri = file.toURI();		/* Restituisce un URI assoluto con uno schema uguale al file */
    	byte[] bytes = null;		/* Creo un array di bytes */
    	List<Dispositivo> list = new ArrayList<Dispositivo>();
    	int codice = 0, id = 0, codicestanza = 0;
    	boolean on = false, off = false, stand = false;
    	double consumo = 0;
    	String tipo = new String();
    	String nome = new String();
    	Stanza app = null;
    	Sensore s;
    	List<Stanza> liststanze = new ArrayList<Stanza>();
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
        	else if(line.contains("Pu�EssereAcceso") == true) {
        		on = Boolean.parseBoolean(words[1]);
        	}
        	else if(line.contains("Pu�EssereSpento") == true) {
        		off = Boolean.parseBoolean(words[1]);
        	}
        	else if(line.contains("Pu�EssereMessoInStandby ") == true) {
        		stand = Boolean.parseBoolean(words[1]);
        	}
        	else if(line.contains("Consumo") == true) {
        		consumo = Double.parseDouble(words[1]);
        		list.add(new Dispositivo(tipo, codice, id, consumo, on, off, stand));
        	}
        	else if(line.contains("Sensore") == true) {
        		s = new Sensore(Integer.parseInt(words[1]));
        		liststanze.add(new Stanza(codicestanza, nome, list, s));
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
}

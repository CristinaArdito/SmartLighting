package interfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import simulazione.AmbienteDiSimulazione;
import sistema.Configurazione;
import sistema.Dispositivo;
import sistema.Luce;
import sistema.Sensore;
import sistema.Sistema;
import sistema.Stanza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Interfaccia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Stanza> stanze;
	private Configurazione config = new Configurazione();
	private static List<Integer> sensori = AmbienteDiSimulazione.ottieniSensori();
	private ModificaConfigurazione nuovaConfigurazione;
	private JList<String> listaStanze;
	private DefaultListModel<String> modello = new DefaultListModel<String>();
	
	public Interfaccia(List<Integer> listaIdDispositivi) throws IOException {
		
		stanze = new ArrayList<Stanza>();
		
		stanze = readStanzaFromFile(new File("Stanze.txt"));
		
		//DEBUG
		
		if(stanze.size() != 0) {
			for (Stanza stanza : stanze) {
				for (Dispositivo dispositivo : stanza.getDispositivi()) {
					config.addDispositivo(dispositivo);
					listaIdDispositivi.remove(dispositivo.getId());
				}
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(236,248,250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		ImageIcon img = new ImageIcon("icon.png");
		this.setIconImage(img.getImage());
		BufferedImage myPicture = ImageIO.read(new File("sls_logo1.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(29, 11, 432, 86);
		getContentPane().add(picLabel);
		
		JButton btnModificaConfigurazione = new JButton("Modifica Configurazione");
		btnModificaConfigurazione.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModificaConfigurazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nuovaConfigurazione = new ModificaConfigurazione(config, stanze,listaIdDispositivi);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				nuovaConfigurazione.setVisible(true);
				nuovaConfigurazione.addConfirmListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								stanze = nuovaConfigurazione.getStanze();
								try {
									writeStanzaOnFile(new File("Stanze.txt"));
									modello.clear();
									for (Stanza stanza : stanze) {
										modello.addElement(stanza.getNome());
									}
									listaStanze.setModel(modello);
								} catch (FileNotFoundException | MalformedURLException e1) {
									e1.printStackTrace();
								}
								nuovaConfigurazione.dispose();
							}
						});
			}
		});
		btnModificaConfigurazione.setBounds(83, 108, 316, 59);
		contentPane.add(btnModificaConfigurazione);
		
		JPanel panelloDati = new JPanel();
		panelloDati.setBackground(new Color(236,248,250));
		panelloDati.setBounds(10, 167, 464, 436);
		panelloDati.setLayout(null);
		contentPane.add(panelloDati);
		
		JLabel lblConfigurazioneCorrente = new JLabel("La configurazione corrente contiene le seguenti stanze:");
		lblConfigurazioneCorrente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfigurazioneCorrente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConfigurazioneCorrente.setBounds(33, 27, 421, 31);
		panelloDati.add(lblConfigurazioneCorrente);
		
		if(stanze.size() != 0) {
			for (Stanza stanza : stanze) {
				modello.addElement(stanza.getNome());
			}
		}
		
		JButton btnRisparmioEnergetico = new JButton("Risparmio Energetico");
		btnRisparmioEnergetico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRisparmioEnergetico.setBounds(111, 388, 236, 48);
		panelloDati.add(btnRisparmioEnergetico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 69, 349, 306);
		panelloDati.add(scrollPane);
		
		listaStanze = new JList<String>();
		scrollPane.setViewportView(listaStanze);
		listaStanze.setFont(new Font("Tahoma", Font.ITALIC, 16));
		listaStanze.setModel(modello);
		
		JButton btnAvvia = new JButton("Avvia");
		btnAvvia.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
		btnAvvia.setBounds(29, 641, 191, 49);
		contentPane.add(btnAvvia);
		
		JLabel lblNewLabel = new JLabel("Ardito Cristina  Contigiani Mattia  \u00A92018 - All rights reserved. ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(121, 713, 266, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnSpegni = new JButton("Spegni");
		btnSpegni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSpegni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSpegni.setBounds(265, 641, 191, 49);
		contentPane.add(btnSpegni);

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
		try {
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
			    // Organizzo il file con una struttura json
			    write.println("{");
			    write.println("Nome: " + s.getNome() + " ,");
			    write.println("CodiceStanza: " + s.getCodice() + " ,");
			    write.println("Lista Dispositivi: ");
			    while(i.hasNext()) {
			    	d = i.next();
			    	write.println("{");
			    	write.println("Tipo: " + d.getTipo() + " ,");
			    	write.println("CodiceDispositivo: " + d.getCodice() + " ,");
			    	write.println("IdDispositivo: " + d.getId() + " ,");
			    	write.println("PuòEssereAcceso: " + d.puòEssereAcceso() + " ,");
			    	write.println("PuòEssereSpento: " + d.puòEssereSpento() + " ,");
			    	write.println("PuòEssereMessoInStandby: " + d.puòEssereMessoInStandby() + " ,");
			    	write.println("ConsumoDispositivo: " + d.getConsumo());
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
			write.close();
			}
			catch (IOException e) {
				System.out.println(e.getMessage());	
			}
		    catch (Exception e) {
			    System.out.println(e.getMessage());		   
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
        	else if(line.contains("CodiceDispositivo") == true) {
        		codice = Integer.parseInt(words[1]);
        	}
        	else if(line.contains("IdDispositivo") == true) {
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
        	else if(line.contains("ConsumoDispositivo") == true) {
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
        		listluci.clear();
        	}
        }
        return liststanze;
	}
	
	public static List<Dispositivo> ottiniDispositivi() {
		List<Dispositivo> listaDispositivi = new ArrayList<Dispositivo>();
		listaDispositivi.add(new Dispositivo("Tv", 1, 00, 120.00, true, false, false));
		/*listaDispositivi.add(new Dispositivo("Minitor", 1, 01, 90.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Computer", 0, 02, 20.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Lavatrice", -1, 03, 220.00, true, false, false));
		listaDispositivi.add(new Dispositivo("Radio", 0, 04, 10.00, true, false, false));*/
		return listaDispositivi;
	}
	
	public static List<Luce> ottieniLuci() {
		List<Luce> listaLuci = new ArrayList<Luce>();
		listaLuci.add(new Luce(1, -1, 10.00, true, true));
		listaLuci.add(new Luce(2, 1, 5.00, true, true));
		return listaLuci;
	}
}

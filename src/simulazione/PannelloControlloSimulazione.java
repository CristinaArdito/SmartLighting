package simulazione;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import sistema.Configurazione;
import sistema.Dispositivo;
import sistema.Luce;
import sistema.Sensore;
import sistema.Stanza;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

public class PannelloControlloSimulazione extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pannelloPrincipale;
	private JPanel pannelloSinistro;
	private JList<String> listaSensori = new JList<String>();
	private DefaultListModel<String> modelloSensori = new DefaultListModel<String>();
	private List<EspositoreStanze> espositoreStanze = new ArrayList<EspositoreStanze>();
	private List<Boolean> listaSensoriAttivi = new ArrayList<Boolean>();
	
	public PannelloControlloSimulazione(List<Stanza> stanze, Configurazione config) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 1024, 720);
		pannelloPrincipale = new JPanel();
		pannelloPrincipale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannelloPrincipale);
		pannelloPrincipale.setLayout(null);
		pannelloSinistro = new JPanel();
		pannelloSinistro.setBounds(0, 0, 250, 682);
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setLayout(null);
		splitPane.setBounds(0, 0, 1008, 682);
		splitPane.setDividerLocation(250);
		splitPane.setLeftComponent(pannelloSinistro);
		pannelloSinistro.setLayout(null);
		
		JButton btnInterruzioneCorrente = new JButton("Interruzione Corrente");
		btnInterruzioneCorrente.setBounds(10, 11, 230, 32);
		pannelloSinistro.add(btnInterruzioneCorrente);
		
		JButton btnSensoriGuasti = new JButton("Sensori guasti");
		listaSensori.setBounds(10, 94, 230, 500);
		listaSensori.setVisible(false);
		pannelloSinistro.add(listaSensori);
		btnSensoriGuasti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelloSensori.clear();
				
				for (Stanza stanza : stanze) {
					for (Dispositivo dispositivo : stanza.getDispositivi()) {
						modelloSensori.addElement("<html><div style='color:green'>"+dispositivo.getId()+" - "+dispositivo.getTipo()+" - ID: "+dispositivo.getId()+"</div></html>");
						listaSensoriAttivi.add(new Boolean(true));
					}
				}

				
				listaSensori.setModel(modelloSensori);
				listaSensori.setVisible(true);
			}
		});
		listaSensori.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					if(listaSensoriAttivi.get(listaSensori.getSelectedIndex()) == true) {
						listaSensoriAttivi.set(listaSensori.getSelectedIndex(), new Boolean(false));
						config.getDispositivi().get(listaSensori.getSelectedIndex()).setGuasto(false);
						modelloSensori.setElementAt("<html><div style='color:red'>"+config.getDispositivi().get(listaSensori.getSelectedIndex()).getId()
								+" - "+config.getDispositivi().get(listaSensori.getSelectedIndex()).getTipo()+" - ID: "
								+config.getDispositivi().get(listaSensori.getSelectedIndex()).getId()+"</div></html>", listaSensori.getSelectedIndex());
					}else {
						listaSensoriAttivi.set(listaSensori.getSelectedIndex(), new Boolean(true));
						config.getDispositivi().get(listaSensori.getSelectedIndex()).setGuasto(true);
						modelloSensori.setElementAt("<html><div style='color:green'>"+config.getDispositivi().get(listaSensori.getSelectedIndex()).getId()
								+" - "+config.getDispositivi().get(listaSensori.getSelectedIndex()).getTipo()+" - ID: "
								+config.getDispositivi().get(listaSensori.getSelectedIndex()).getId()+"</div></html>", listaSensori.getSelectedIndex());
					}	
				listaSensori.setModel(modelloSensori);
				}
			}
		});
		
		btnSensoriGuasti.setBounds(10, 54, 230, 32);
		pannelloSinistro.add(btnSensoriGuasti);
		pannelloPrincipale.add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 0, 758, 682);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		splitPane.add(scrollPane);
		
		JPanel pannelloDestro = new JPanel();
		pannelloDestro.setBounds(0, 0, 728, 682);
		pannelloDestro.setLayout(null);
		scrollPane.setViewportView(pannelloDestro);
		
		riempiStanze(pannelloDestro, stanze);
		
		Timer time = new Timer(4000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for (EspositoreStanze espositore : espositoreStanze) {
						espositore.setSpecifiche();
					}
//					System.out.println("Timer");
				}
			});
			time.start();
	}
	
	public void riempiStanze(JPanel pannelloDestro, List<Stanza> stanze) {
		int x = 20,y = 30;
		EspositoreStanze stanzaDiAppoggio;
		pannelloDestro.removeAll();
		espositoreStanze.clear();
		for (Stanza stanza : stanze) {
			stanzaDiAppoggio = new EspositoreStanze(stanza, stanza.getNome(),stanza.getDispositivi(),stanza.getLuci(),stanza.getSensore());
			espositoreStanze.add(stanzaDiAppoggio);
			//Modifica Jlabel del nome
			stanzaDiAppoggio.getNome().setBounds(x, y, 70, 20);
			pannelloDestro.add(stanzaDiAppoggio.getNome());
			//Modifica JList delle specifiche
			stanzaDiAppoggio.getSpecifiche().setBounds(x, y+25, 300, 200);
			stanzaDiAppoggio.getSpecifiche().setFocusable(false);
			pannelloDestro.add(stanzaDiAppoggio.getSpecifiche());
			//Modifica JCheckBox per la presenza dell'utente
			if(stanza.getSensore().getCodice() == 1) {
				stanzaDiAppoggio.getPresenza().setSelected(true);
			}else {
				stanzaDiAppoggio.getPresenza().setSelected(false);
			}
			stanzaDiAppoggio.getPresenza().setBounds(x+150, y+230, 20, 20);
			pannelloDestro.add(stanzaDiAppoggio.getPresenza());
			
			if(x+530 > pannelloDestro.getWidth()) {
				y += 280;
				x = 20;
			}else x += 330;
			
			if(y+280 > pannelloDestro.getHeight()) {
				pannelloDestro.setPreferredSize(new Dimension(pannelloDestro.getWidth(), pannelloDestro.getHeight()+300));
			}
		}
		
		setListeners(pannelloDestro, stanze);
	}
	
	public void setListeners(JPanel pannelloDestro, List<Stanza> stanze) {
		for (EspositoreStanze espositore : espositoreStanze) {
			espositore.getPresenza().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(espositore.getPresenza().isSelected()) {
						espositore.getStanza().getSensore().setSensore(1);
						espositore.setSpecifiche();
					}else {
						espositore.getStanza().getSensore().setSensore(-1);
						espositore.setSpecifiche();
					}
				}
			});
		}
	}
	
	private class EspositoreStanze {
		
		private JLabel nome = new JLabel();
		private JList<String> specifiche = new JList<String>();
		private DefaultListModel<String> modello = new DefaultListModel<String>();
		private JCheckBox presenzaUtente = new JCheckBox();
		private Stanza stanza;
		
		public EspositoreStanze(Stanza stanza, String nome, List<Dispositivo> dispositivi, List<Luce> luci, Sensore sensore) {
			this.nome.setText(nome);
			this.stanza = stanza;
			String temp = "";
			modello.addElement("Dispositivi:");
			for (Dispositivo dispositivo : dispositivi) {
				temp = "<html>";
				temp += dispositivo.getTipo();
				switch (dispositivo.getCodice()) {
				case -1:
					temp += " - Stato: <font color=red>spento</font>";
					break;
				case 0:
					temp += " - Stato: <font color=orange>standby</font>";
					break;
				case 1:
					temp += " - Stato: <font color=green>acceso</font>";
					break;
				}
				temp += "</html>";
				modello.addElement(temp);
				temp = "";
			}
			modello.addElement("Luci:");
			for (Luce luce : luci) {
				switch (luce.getCodice()) {
				case 1:
					modello.addElement("<html>Luce n: "+luce.getId()+" - Stato: <font color=green>accesa</font></html>");
					break;
				case -1:
					modello.addElement("<html>Luce n: "+luce.getId()+" - Stato: <font color=red>spenta</font></html>");
					break;
				}
			}
			switch (sensore.getCodice()) {
			case 1:
				modello.addElement("Utente presente");
				break;
			case -1:
				modello.addElement("Utente non presente");
				break;
			}
			
			specifiche.setModel(modello);
			
		}
		
		public JLabel getNome() {
			return this.nome;
		}
		
		public JList<String> getSpecifiche(){
			return specifiche;
		}
		
		public void setSpecifiche() {
			String temp = "";
			modello.clear();
			modello.addElement("Dispositivi:");
			for (Dispositivo dispositivo : stanza.getDispositivi()) {
				temp = "<html>";
				temp += dispositivo.getTipo();
				switch (dispositivo.getCodice()) {
				case -1:
					temp += " - Stato: <font color=red>spento</font>";
					break;
				case 0:
					temp += " - Stato: <font color=orange>standby</font>";
					break;
				case 1:
					temp += " - Stato: <font color=green>acceso</font>";
					break;
				}
				temp += "</html>";
				modello.addElement(temp);
				temp = "";
			}
			temp += "</html>";
			modello.addElement("Luci:");
			for (Luce luce : stanza.getLuci()) {
				switch (luce.getCodice()) {
				case 1:
					modello.addElement("<html>Luce n: "+luce.getId()+" - Stato: <font color=green>accesa</font></html>");
					break;
				case -1:
					modello.addElement("<html>Luce n: "+luce.getId()+" - Stato: <font color=red>spenta</font></html>");
					break;
				}
			}
			switch (stanza.getSensore().getCodice()) {
			case 1:
				modello.addElement("Utente presente");
				break;
			case -1:
				modello.addElement("Utente non presente");
				break;
			}	
			
			specifiche.setModel(modello);
		}
		
		public JCheckBox getPresenza() {
			return presenzaUtente;
		}
		
		public Stanza getStanza() {
			return stanza;
		}
	}

}

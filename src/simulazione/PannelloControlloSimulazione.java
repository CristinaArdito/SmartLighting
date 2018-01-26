package simulazione;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.Dispositivo;
import sistema.Luce;
import sistema.Sensore;
import sistema.Stanza;
import javax.swing.JSplitPane;

public class PannelloControlloSimulazione extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pannelloPrincipale;
	private List<EspositoreStanze> espostoreStanze = new ArrayList<EspositoreStanze>();
	
	public PannelloControlloSimulazione(List<Stanza> stanze) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 1024, 720);
		pannelloPrincipale = new JPanel();
		pannelloPrincipale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannelloPrincipale);
		pannelloPrincipale.setLayout(null);
		
		JPanel pannelloDestro = new JPanel();
		pannelloDestro.setBounds(250, 0, 758, 682);
		JPanel pannelloSinistro = new JPanel();
		pannelloSinistro.setBounds(0, 0, 250, 682);
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setLayout(null);
		splitPane.setBounds(0, 0, 1008, 682);
		splitPane.setDividerLocation(250);
		splitPane.setRightComponent(pannelloDestro);
		pannelloDestro.setLayout(null);
		splitPane.setLeftComponent(pannelloSinistro);
		pannelloSinistro.setLayout(null);
		pannelloPrincipale.add(splitPane);
		
		EspositoreStanze temp;	
		int x = 0,y = 30;
		for (Stanza stanza : stanze) {
			temp = new EspositoreStanze(stanza.getNome(),stanza.getDispositivi(),stanza.getLuci(),stanza.getSensore());
			espostoreStanze.add(temp);
			//Modifica Jlabel del nome
			temp.getNome().setBounds(x, y, 70, 20);
			pannelloDestro.add(temp.getNome());
			//Modifica JList delle specifiche
			temp.getSpecifiche().setBounds(x, y+25, 300, 200);
			pannelloDestro.add(temp.getSpecifiche());
			//Modifica JCheckBox per la presenza dell'utente
			temp.getPresenza().setBounds(x+150, y+230, 20, 20);
			pannelloDestro.add(temp.getPresenza());
			
			if(x+530 > pannelloDestro.getWidth()) {
				y += 330;
				x = 0;
			}else x += 330;
		}
		
	}
	
	private class EspositoreStanze {
		
		private JLabel nome = new JLabel();
		private JList<String> specifiche = new JList<String>();
		private DefaultListModel<String> modello = new DefaultListModel<String>();
		private JCheckBox presenzaUtente = new JCheckBox();
		
		public EspositoreStanze(String nome, List<Dispositivo> dispositivi, List<Luce> luci, Sensore sensore) {
			this.nome.setText(nome);
			String temp = "";
			modello.addElement("Dispositivi:");
			for (Dispositivo dispositivo : dispositivi) {
				temp += dispositivo.getTipo();
				switch (dispositivo.getCodice()) {
				case -1:
					temp += " - Stato: spento";
					break;
				case 0:
					temp += " - Stato: standby";
					break;
				case 1:
					temp += " - Stato: acceso";
					break;
				}
				modello.addElement(temp);
				temp = "";
			}
			modello.addElement("Luci:");
			for (Luce luce : luci) {
				switch (luce.getCodice()) {
				case 1:
					modello.addElement("Luce n: "+luce.getId()+" - Stato: accesa");
					break;
				case -1:
					modello.addElement("Luce n: "+luce.getId()+" - Stato: spenta");
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
		
		public JCheckBox getPresenza() {
			return presenzaUtente;
		}
	}
}

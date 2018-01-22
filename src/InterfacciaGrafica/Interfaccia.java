package InterfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Simulazione.AmbienteDiSimulazione;
import toAssign.Configurazione;
import toAssign.Sistema;
import toAssign.Stanza;

public class Interfaccia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Stanza> stanze;
	private Configurazione config = new Configurazione();
	private static List<Integer> sensori = AmbienteDiSimulazione.ottieniSensori();

	public Interfaccia() {
		
		stanze = new ArrayList<Stanza>();
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
				ModificaConfigurazione nuovaConfigurazione = new ModificaConfigurazione(config, stanze);
				nuovaConfigurazione.setVisible(true);
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
}

package interfacciaGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import simulazione.AmbienteDiSimulazione;
import sistema.Dispositivo;
import sistema.Luce;
import sistema.Stanza;

public class AggiungiStanza extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField nomeStanza;
	private JTextField numeroLuci;
	private AggiungiDispositivo aggiungiDispositivo;
	private List<Dispositivo> dispositivi = new ArrayList<Dispositivo>();
	private List<Luce> luci = new ArrayList<Luce>();
	private JList<String> listaDispositiviStanza;
	private DefaultListModel<String> modelloListaDispositiviStanza = new DefaultListModel<String>();
	private JButton button;

	public AggiungiStanza(List<Integer> listaIdDispositivi) {
		
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		button = new JButton("Conferma");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(28, 636, 179, 43);
		getContentPane().add(button);
		
		nomeStanza = new JTextField();
		nomeStanza.setBounds(74, 81, 171, 30);
		getContentPane().add(nomeStanza);
		nomeStanza.setColumns(10);
		
		numeroLuci = new JTextField();
		numeroLuci.setBounds(184, 506, 86, 30);
		getContentPane().add(numeroLuci);
		numeroLuci.setColumns(10);
		
		JLabel lblNumeroDiLuci = new JLabel("Numero di luci presenti:");
		lblNumeroDiLuci.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroDiLuci.setBounds(10, 504, 171, 30);
		getContentPane().add(lblNumeroDiLuci);
		
		JLabel lblListaDeiDispositivi = new JLabel("Lista dei dispositivi presenti");
		lblListaDeiDispositivi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListaDeiDispositivi.setBounds(10, 135, 200, 36);
		getContentPane().add(lblListaDeiDispositivi);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 79, 69, 30);
		getContentPane().add(lblNome);
		
		JLabel lblAggiungiUnaStanza = new JLabel("Aggiungi una stanza");
		lblAggiungiUnaStanza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAggiungiUnaStanza.setBounds(171, 11, 153, 30);
		getContentPane().add(lblAggiungiUnaStanza);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAnnulla.setBounds(269, 636, 179, 43);
		getContentPane().add(btnAnnulla);
		
		listaDispositiviStanza = new JList<String>();
		listaDispositiviStanza.setBounds(10, 170, 464, 266);
		getContentPane().add(listaDispositiviStanza);
		
		JButton btnAggiungiDispositivo = new JButton("Aggiungi");
		btnAggiungiDispositivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggiungiDispositivo = new AggiungiDispositivo(true,listaIdDispositivi);
				aggiungiDispositivo.setVisible(true);
				aggiungiDispositivo.addConfirmListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						 dispositivi.add(aggiungiDispositivo.getDispositivo());
						 modelloListaDispositiviStanza.clear();
						 for (Dispositivo dispositivo : dispositivi) {
							 modelloListaDispositiviStanza.addElement(dispositivo.toString());
						}
						listaDispositiviStanza.setModel(modelloListaDispositiviStanza);
						aggiungiDispositivo.dispose();
					}
				});
			}
		});
		
		btnAggiungiDispositivo.setBounds(355, 447, 119, 30);
		getContentPane().add(btnAggiungiDispositivo);
	}
	
	public void addConfirmListener(ActionListener listener) {
		button.addActionListener(listener);
	}
	
	public Stanza getStanza() {
		for(int i=0;i<Integer.parseInt(numeroLuci.getText());i++) {
			luci.add(new Luce(i, -1, 200, true, true));
		}
		return new Stanza(-1, nomeStanza.getText(), dispositivi, luci, AmbienteDiSimulazione.generaSensore());
	}
}

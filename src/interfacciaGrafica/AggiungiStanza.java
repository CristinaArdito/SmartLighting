package interfacciaGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
		getContentPane().setBackground(new Color(236,248,250));
		
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		button = new JButton("Conferma");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(29, 641, 191, 49);
		getContentPane().add(button);
		
		ImageIcon img = new ImageIcon("icon.png");
		this.setIconImage(img.getImage());
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("sls_logo1.png"));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(29, 11, 432, 86);
		getContentPane().add(picLabel);
		
		nomeStanza = new JTextField();
		nomeStanza.setBounds(70, 155, 171, 30);
		getContentPane().add(nomeStanza);
		nomeStanza.setColumns(10);
		
		numeroLuci = new JTextField();
		numeroLuci.setBounds(202, 561, 86, 30);
		getContentPane().add(numeroLuci);
		numeroLuci.setColumns(10);
		
		JLabel lblNumeroDiLuci = new JLabel("Numero di luci presenti:");
		lblNumeroDiLuci.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumeroDiLuci.setBounds(10, 558, 191, 30);
		getContentPane().add(lblNumeroDiLuci);
		
		JLabel lblListaDeiDispositivi = new JLabel("Lista dei dispositivi presenti:");
		lblListaDeiDispositivi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblListaDeiDispositivi.setBounds(10, 196, 231, 36);
		getContentPane().add(lblListaDeiDispositivi);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome.setBounds(10, 155, 69, 30);
		getContentPane().add(lblNome);
		
		JLabel lblAggiungiUnaStanza = new JLabel("Aggiungi una stanza");
		lblAggiungiUnaStanza.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAggiungiUnaStanza.setBounds(156, 100, 191, 30);
		getContentPane().add(lblAggiungiUnaStanza);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAnnulla.setBounds(261, 641, 191, 49);
		getContentPane().add(btnAnnulla);
		
		listaDispositiviStanza = new JList<String>();
		listaDispositiviStanza.setBounds(10, 243, 480, 266);
		getContentPane().add(listaDispositiviStanza);
		
		JButton btnAggiungiDispositivo = new JButton("Aggiungi");
		btnAggiungiDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		
		btnAggiungiDispositivo.setBounds(359, 520, 119, 30);
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

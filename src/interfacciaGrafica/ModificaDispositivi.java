package interfacciaGrafica;

import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;

import sistema.Configurazione;
import sistema.ControlloreDispositivo;
import sistema.Stanza;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ModificaDispositivi extends JDialog {

	private static final long serialVersionUID = 1L;
	private JList<String> listaDispositivi;
	DefaultListModel<String> modelloDispositivi;

	

	public ModificaDispositivi(int idStanza, List<Stanza> stanze, Configurazione config, List<Integer> listaIdDispositivi) {
		getContentPane().setBackground(new Color(236,248,250));
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		
		ImageIcon img = new ImageIcon("icon.png");
		this.setIconImage(img.getImage());
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("sls_logo.png"));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(27, 11, 432, 86);
		getContentPane().add(picLabel);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnConferma.setBounds(27, 654, 191, 49);
		getContentPane().add(btnConferma);
		JButton btnAggiungiDispositivo = new JButton("Aggiungi");
		btnAggiungiDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAggiungiDispositivo.setBounds(276, 654, 191, 49);
		getContentPane().add(btnAggiungiDispositivo);
		
		listaDispositivi = new JList<String>();
		listaDispositivi.setFont(new Font("Tahoma", Font.ITALIC, 16));
		listaDispositivi.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaDispositivi.setBounds(10, 133, 480, 487);
		getContentPane().add(listaDispositivi);
		modelloDispositivi = new DefaultListModel<String>();
		
		for (Stanza stanza : stanze) {
			if(stanza.getCodice() == idStanza) {
				for (ControlloreDispositivo dispositivo : stanza.getDispositivi()) {
					modelloDispositivi.addElement(dispositivo.getTipo()+" - ID:"+dispositivo.getId());
				}
				break;
			}
		}
		
		listaDispositivi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String nomeDispositivo = listaDispositivi.getSelectedValue().substring(0, listaDispositivi.getSelectedValue().lastIndexOf(" - ID:"));
				String idDispositivo = listaDispositivi.getSelectedValue().substring(listaDispositivi.getSelectedValue().lastIndexOf(" - ID:")+6, listaDispositivi.getSelectedValue().length());
				ConfiguraDispositivo configuraDispositivo = new ConfiguraDispositivo(nomeDispositivo, Integer.parseInt(idDispositivo), config);
				configuraDispositivo.setVisible(true);
			}
		});
		listaDispositivi.setModel(modelloDispositivi);
		
		JLabel lblAggiungiDispositivo = new JLabel("Aggiungi Dispositivo");
		lblAggiungiDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAggiungiDispositivo.setBounds(160, 96, 191, 26);
		getContentPane().add(lblAggiungiDispositivo);
		
		btnAggiungiDispositivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiDispositivo aggiungiDispositivo;
				aggiungiDispositivo = new AggiungiDispositivo(false, listaIdDispositivi);
				aggiungiDispositivo.setVisible(true);
				aggiungiDispositivo.addRoomListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						for (Stanza stanza : stanze) {
							if(stanza.getCodice() == idStanza) {
								ControlloreDispositivo temp = aggiungiDispositivo.getDispositivo();
								stanza.getDispositivi().add(temp);
								modelloDispositivi.addElement(temp.getTipo()+" - ID:"+temp.getId());
								listaDispositivi.setModel(modelloDispositivi);
							}
						}
					aggiungiDispositivo.dispose();
					}
				});
			}
		});
	}
}

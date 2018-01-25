package InterfacciaGrafica;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import toAssign.Configurazione;
import toAssign.Dispositivo;
import toAssign.Stanza;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class ModificaDispositivi extends JDialog {

	private static final long serialVersionUID = 1L;
	private JList<String> listaDispositivi;
	DefaultListModel<String> modelloDispositivi;
	

	public ModificaDispositivi(int idStanza, List<Stanza> stanze, Configurazione config, List<Integer> listaIdDispositivi) {
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		setUndecorated(true);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnConferma.setBounds(20, 629, 190, 52);
		getContentPane().add(btnConferma);
		JButton btnAggiungiDispositivo = new JButton("Aggiungi");
		btnAggiungiDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAggiungiDispositivo.setBounds(284, 629, 190, 52);
		getContentPane().add(btnAggiungiDispositivo);
		
		listaDispositivi = new JList<String>();
		listaDispositivi.setBounds(10, 52, 462, 566);
		getContentPane().add(listaDispositivi);
		modelloDispositivi = new DefaultListModel<String>();
		
		for (Stanza stanza : stanze) {
			if(stanza.getCodice() == idStanza) {
				for (Dispositivo dispositivo : stanza.getDispositivi()) {
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
		lblAggiungiDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAggiungiDispositivo.setBounds(161, 11, 180, 26);
		getContentPane().add(lblAggiungiDispositivo);
		
		btnAggiungiDispositivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiDispositivo aggiungiDispositivo = new AggiungiDispositivo(false, listaIdDispositivi);
				aggiungiDispositivo.setVisible(true);
				aggiungiDispositivo.addRoomListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						for (Stanza stanza : stanze) {
							if(stanza.getCodice() == idStanza) {
								Dispositivo temp = aggiungiDispositivo.getDispositivo();
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

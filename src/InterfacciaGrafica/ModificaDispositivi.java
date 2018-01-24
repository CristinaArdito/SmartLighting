package InterfacciaGrafica;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import toAssign.Configurazione;
import toAssign.Dispositivo;
import toAssign.Stanza;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ModificaDispositivi extends JDialog {

	private static final long serialVersionUID = 1L;

	public ModificaDispositivi(int idStanza, List<Stanza> stanze, Configurazione config) {
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnConferma.setBounds(20, 629, 190, 52);
		getContentPane().add(btnConferma);
		JButton btnAggiungiDispositivo = new JButton("Aggiungi Dispositivo");
		btnAggiungiDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAggiungiDispositivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiDispositivo aggiungiDispositivo = new AggiungiDispositivo();
				aggiungiDispositivo.setVisible(true);
			}
		});
		btnAggiungiDispositivo.setBounds(284, 629, 190, 52);
		getContentPane().add(btnAggiungiDispositivo);
		
		JList<String> listaDispositivi = new JList<String>();
		listaDispositivi.setBounds(10, 10, 462, 608);
		getContentPane().add(listaDispositivi);
		DefaultListModel<String> modelloDispositivi = new DefaultListModel<String>();
		
		for (Stanza stanza : stanze) {
			if(stanza.getCodice() == idStanza) {
				for (Dispositivo dispositivo : stanza.getDispositivi()) {
					modelloDispositivi.addElement(dispositivo.getTipo()+" - ID:"+dispositivo.getId());
				}
				break;
			}
		}
		listaDispositivi.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String nomeDispositivo = listaDispositivi.getSelectedValue().substring(0, listaDispositivi.getSelectedValue().lastIndexOf(" - ID:"));
					String idDispositivo = listaDispositivi.getSelectedValue().substring(listaDispositivi.getSelectedValue().lastIndexOf(" - ID:")+6, listaDispositivi.getSelectedValue().length());
					ConfiguraDispositivo configuraDispositivo = new ConfiguraDispositivo(nomeDispositivo, Integer.parseInt(idDispositivo), config);
					configuraDispositivo.setVisible(true);
				}
			}
		});
		listaDispositivi.setModel(modelloDispositivi);
	}
}

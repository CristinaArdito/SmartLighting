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

public class ModificaDispositivi extends JDialog {

	private static final long serialVersionUID = 1L;

	public ModificaDispositivi(int idStanza, List<Stanza> stanze, Configurazione config) {
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setBounds(12, 660, 226, 52);
		getContentPane().add(btnConferma);
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(248, 660, 226, 52);
		getContentPane().add(btnAnnulla);
		
		JList<String> listaDispositivi = new JList<String>();
		listaDispositivi.setBounds(10, 10, 462, 645);
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

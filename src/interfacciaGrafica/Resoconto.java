package interfacciaGrafica;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import sistema.Configurazione;
import sistema.Dispositivo;
import sistema.RisparmioEnergetico;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Resoconto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JList<String> resoconto;
	private DefaultListModel<String> modelloResoconto;

	public Resoconto(RisparmioEnergetico risparmio, Configurazione config) {
		setBounds(100, 100, 500, 750);
		contentPanel.setLayout(null);
		setUndecorated(true);
		getContentPane().setLayout(null);

		resoconto = new JList<String>();
		resoconto.setBounds(2, 2, 496, 713);

		for (int i = 0; i < config.getDispositivi().size(); i++) {
			
			Dispositivo attuale = config.getDispositivi().get(i);
			Dispositivo precedente = risparmio.getConfigurazione().getDispositivi().get(i);
			
			modelloResoconto
					.addElement("<html><div style='color: green'Tipo: " + attuale.getTipo()
							+ " - ID: " + attuale.getId() + "</div></html>\n"
							+ "Tempo attivo (precedente): "+precedente.getTempoAttivo()+" - Consumo (precedente): "+precedente.getConsumo()+"\n"
							+ "Tempo attivo (odierno): "+attuale.getTempoAttivo()+" - Consumo (odierno): "+attuale.getConsumo()+"\n");
		}

		getContentPane().add(resoconto);
		
		JButton btnSpegni = new JButton("Spegni");
		btnSpegni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSpegni.setBounds(200, 719, 89, 30);
		getContentPane().add(btnSpegni);

	}
}

package interfacciaGrafica;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import sistema.Configurazione;
import sistema.RisparmioEnergetico;

public class Resoconto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JList<String> resoconto;
	private DefaultListModel<String> modelloResoconto;

	public Resoconto(RisparmioEnergetico risparmio, Configurazione config) {
		setBounds(100, 100, 500, 750);
		contentPanel.setLayout(null);
		setUndecorated(true);
		
		
		
	}

}

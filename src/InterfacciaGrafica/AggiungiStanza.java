package InterfacciaGrafica;

import javax.swing.JDialog;

public class AggiungiStanza extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		try {
			AggiungiStanza dialog = new AggiungiStanza();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AggiungiStanza() {
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
	}

}

package InterfacciaGrafica;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ModificaSingoloDispositivo extends JDialog {

	private static final long serialVersionUID = 1L;

	public ModificaSingoloDispositivo(String nomeDispositivo, int idDispositivo) {
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 750);
		
		JLabel label = new JLabel(nomeDispositivo+" - ID:"+idDispositivo);
		label.setFont(new Font(label.getFont().getFontName(),label.getFont().getStyle(),22));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 11, 414, 35);
		getContentPane().add(label);
		
	}
}

package InterfacciaGrafica;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import toAssign.Configurazione;
import toAssign.Dispositivo;
import javax.swing.JCheckBox;

public class ModificaSingoloDispositivo extends JDialog {

	private static final long serialVersionUID = 1L;

	public ModificaSingoloDispositivo(String nomeDispositivo, int idDispositivo, Configurazione config) {
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 750);
		
		JLabel label = new JLabel(nomeDispositivo+" - ID:"+idDispositivo);
		label.setFont(new Font(label.getFont().getFontName(),label.getFont().getStyle(),22));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 11, 414, 35);
		getContentPane().add(label);
		
		Dispositivo dispositivo = config.getDispositivo(idDispositivo);
		if(dispositivo != null) {
		JLabel accendibile = new JLabel("Il dispositivo può essere acceso");
		accendibile.setBounds(10, 99, 290, 64);
		accendibile.setFont(new Font(label.getFont().getFontName(),label.getFont().getStyle(),18));
		getContentPane().add(accendibile);	
		
		JCheckBox checkAccendibile = new JCheckBox();
		checkAccendibile.setHorizontalAlignment(SwingConstants.CENTER);
		checkAccendibile.setBounds(357, 99, 121, 67);
		getContentPane().add(checkAccendibile);
		
		JLabel standBy = new JLabel("Il dispositivo può essere messo in standby");
		standBy.setBounds(10, 184, 344, 64);
		standBy.setFont(new Font(label.getFont().getFontName(),label.getFont().getStyle(),18));
		getContentPane().add(standBy);	
		
		JCheckBox checkStandBy = new JCheckBox();
		checkStandBy.setHorizontalAlignment(SwingConstants.CENTER);
		checkStandBy.setBounds(357, 181, 121, 67);
		getContentPane().add(checkStandBy);
		
		JLabel spegnibile = new JLabel("Il dispositivo può essere spento");
		spegnibile.setBounds(10, 271, 290, 64);
		spegnibile.setFont(new Font(label.getFont().getFontName(),label.getFont().getStyle(),18));
		getContentPane().add(spegnibile);	
		
		JCheckBox checkSpegnibile = new JCheckBox();
		checkSpegnibile.setHorizontalAlignment(SwingConstants.CENTER);
		checkSpegnibile.setBounds(357, 268, 121, 67);
		getContentPane().add(checkSpegnibile);
		
		
		}
		
	}
}

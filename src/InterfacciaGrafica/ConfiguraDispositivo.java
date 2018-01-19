package InterfacciaGrafica;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import toAssign.Configurazione;
import toAssign.Dispositivo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfiguraDispositivo extends JDialog {

	private static final long serialVersionUID = 1L;

	public ConfiguraDispositivo(String nomeDispositivo, int idDispositivo, Configurazione config) {
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		
		Dispositivo dispositivo = config.getDispositivo(idDispositivo);
		
		JLabel accendibile = new JLabel("Il dispositivo può essere acceso");
		accendibile.setBounds(10, 99, 290, 64);
		accendibile.setFont(new Font(accendibile.getFont().getFontName(),accendibile.getFont().getStyle(),18));
		getContentPane().add(accendibile);	
		
		JCheckBox checkAccendibile = new JCheckBox();
		checkAccendibile.setHorizontalAlignment(SwingConstants.CENTER);
		checkAccendibile.setBounds(357, 99, 121, 67);
		if(config.getDispositivo(idDispositivo).puòEssereAcceso() == true) checkAccendibile.setSelected(true);
		else checkAccendibile.setSelected(false);
		getContentPane().add(checkAccendibile);
		
		JLabel standBy = new JLabel("<html>Il dispositivo può essere messo in standby</html>");
		standBy.setBounds(10, 184, 344, 64);
		standBy.setFont(new Font(standBy.getFont().getFontName(),standBy.getFont().getStyle(),18));
		getContentPane().add(standBy);	
		
		JCheckBox checkStandBy = new JCheckBox();
		checkStandBy.setHorizontalAlignment(SwingConstants.CENTER);
		checkStandBy.setBounds(357, 181, 121, 67);
		if(config.getDispositivo(idDispositivo).puòEssereAcceso() == true) checkStandBy.setSelected(true);
		else checkStandBy.setSelected(false);
		getContentPane().add(checkStandBy);
		
		JLabel spegnibile = new JLabel("Il dispositivo può essere spento");
		spegnibile.setBounds(10, 271, 290, 64);
		spegnibile.setFont(new Font(spegnibile.getFont().getFontName(),spegnibile.getFont().getStyle(),18));
		getContentPane().add(spegnibile);	
		
		JCheckBox checkSpegnibile = new JCheckBox();
		checkSpegnibile.setHorizontalAlignment(SwingConstants.CENTER);
		checkSpegnibile.setBounds(357, 268, 121, 67);
		if(config.getDispositivo(idDispositivo).puòEssereAcceso() == true) checkSpegnibile.setSelected(true);
		else checkSpegnibile.setSelected(false);
		getContentPane().add(checkSpegnibile);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkAccendibile.isSelected()) dispositivo.impostaAcceso(true);
				else dispositivo.impostaAcceso(false);
				if(checkStandBy.isSelected()) dispositivo.impostaStandby(true);
				else dispositivo.impostaStandby(false);
				if(checkSpegnibile.isSelected()) dispositivo.impostaSpento(true);
				else dispositivo.impostaSpento(false);
				dispose();
			}
		});
		btnConferma.setBounds(10, 616, 225, 85);
		getContentPane().add(btnConferma);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnulla.setBounds(245, 616, 225, 85);
		getContentPane().add(btnAnnulla);
		
		JLabel labelNomeDispositivo = new JLabel(dispositivo.getTipo()+" - ID:"+dispositivo.getId());
		labelNomeDispositivo.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelNomeDispositivo.setBounds(0, 11, 470, 64);
		getContentPane().add(labelNomeDispositivo);
		
	}
}

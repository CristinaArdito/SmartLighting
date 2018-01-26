package interfacciaGrafica;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import sistema.Configurazione;
import sistema.Dispositivo;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ConfiguraDispositivo extends JDialog {

	private static final long serialVersionUID = 1L;

	public ConfiguraDispositivo(String nomeDispositivo, int idDispositivo, Configurazione config) {
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(37, 11, 432, 86);
		getContentPane().add(picLabel);
		
		Dispositivo dispositivo = config.getDispositivo(idDispositivo);
		
		JLabel accendibile = new JLabel("Il dispositivo può essere acceso");
		accendibile.setBounds(10, 215, 290, 64);
		accendibile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(accendibile);	
		
		JCheckBox checkAccendibile = new JCheckBox();
		checkAccendibile.setBackground(new Color(236,248,250));
		checkAccendibile.setHorizontalAlignment(SwingConstants.CENTER);
		checkAccendibile.setBounds(357, 212, 121, 67);
		if(config.getDispositivo(idDispositivo).puòEssereAcceso() == true) checkAccendibile.setSelected(true);
		else checkAccendibile.setSelected(false);
		getContentPane().add(checkAccendibile);
		
		JLabel standBy = new JLabel("<html>Il dispositivo può essere messo in standby</html>");
		standBy.setBounds(10, 307, 344, 64);
		standBy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(standBy);	
		
		JCheckBox checkStandBy = new JCheckBox();
		checkStandBy.setBackground(new Color(236,248,250));
		checkStandBy.setHorizontalAlignment(SwingConstants.CENTER);
		checkStandBy.setBounds(357, 307, 121, 67);
		if(config.getDispositivo(idDispositivo).puòEssereMessoInStandby() == true) checkStandBy.setSelected(true);
		else checkStandBy.setSelected(false);
		getContentPane().add(checkStandBy);
		
		JLabel spegnibile = new JLabel("Il dispositivo può essere spento");
		spegnibile.setBounds(10, 401, 290, 64);
		spegnibile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(spegnibile);	
		
		JCheckBox checkSpegnibile = new JCheckBox();
		checkSpegnibile.setBackground(new Color(236,248,250));
		checkSpegnibile.setHorizontalAlignment(SwingConstants.CENTER);
		checkSpegnibile.setBounds(357, 401, 121, 67);
		if(config.getDispositivo(idDispositivo).puòEssereSpento() == true) checkSpegnibile.setSelected(true);
		else checkSpegnibile.setSelected(false);
		getContentPane().add(checkSpegnibile);
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Sei sicuro di voler confermare le modifiche?", "Conferma modifiche",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if(checkAccendibile.isSelected()) config.ConfiguraDispositivo(idDispositivo, 1, true);
					else config.ConfiguraDispositivo(idDispositivo, 1, false);
					if(checkStandBy.isSelected()) config.ConfiguraDispositivo(idDispositivo, 2, true);
					else config.ConfiguraDispositivo(idDispositivo, 2, false);
					if(checkSpegnibile.isSelected()) config.ConfiguraDispositivo(idDispositivo, 3, true);
					else config.ConfiguraDispositivo(idDispositivo, 3, false);
					dispose();
				}
			}
		});
		btnConferma.setBounds(27, 655, 191, 49);
		getContentPane().add(btnConferma);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnulla.setBounds(277, 655, 191, 49);
		getContentPane().add(btnAnnulla);
		
		JLabel labelNomeDispositivo = new JLabel(dispositivo.getTipo()+" - ID:"+dispositivo.getId());
		labelNomeDispositivo.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelNomeDispositivo.setBounds(10, 155, 470, 64);
		getContentPane().add(labelNomeDispositivo);
		
	}
}

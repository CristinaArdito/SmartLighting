package interfacciaGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import sistema.Configurazione;
import sistema.ControlloreDispositivo;
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
		getContentPane().setLayout(null);

		resoconto = new JList<String>();
		resoconto.setBounds(2, 2, 496, 713);
		modelloResoconto = new DefaultListModel<String>();

		ControlloreDispositivo precedente;
		ControlloreDispositivo attuale;

		for (int i = 0; i < config.getDispositivi().size(); i++) {

			attuale = config.getDispositivi().get(i);
			if (risparmio != null) {
				precedente = risparmio.getConfigurazione().getDispositivi().get(i);

				if (attuale.getCodice() == 1) {
					modelloResoconto.addElement("<html><div style='color: green'>Tipo: " + attuale.getTipo() + " - ID: "
							+ attuale.getId() + "</div></html>");
					modelloResoconto.addElement(
							"<html><div style='color: orange'>Tempo attivo (precedente): " + precedente.getTempoAttivo()
									+ " - Consumo (precedente): " + precedente.getConsumo() + "</div></html>");
					modelloResoconto.addElement(
							"<html><div style='color: blue'>Tempo attivo (odierno): " + attuale.getTempoParziale()
									+ " - Consumo (odierno): " + attuale.getConsumoParziale() + "</div></html>");
				} else {
					modelloResoconto.addElement("<html><div style='color: green'>Tipo: " + attuale.getTipo() + " - ID: "
							+ attuale.getId() + "</div></html>");
					modelloResoconto.addElement(
							"<html><div style='color: orange'>Tempo attivo (precedente): " + precedente.getTempoAttivo()
									+ " - Consumo (precedente): " + precedente.getConsumo() + "</div></html>");
					modelloResoconto.addElement(
							"<html><div style='color: blue'>Tempo attivo (odierno): " + attuale.getTempoAttivo()
									+ " - Consumo (odierno): " + attuale.getConsumo() + "</div></html>");
				}
			} else {
				if (attuale.getCodice() == 1) {
					modelloResoconto.addElement("<html><div style='color: green'>Tipo: " + attuale.getTipo() + " - ID: "
							+ attuale.getId() + "</div></html>");
					modelloResoconto.addElement(
							"<html><div style='color: orange'>Tempo attivo (precedente): Inesistente - Consumo (precedente): Inesistente"
									+ "</div></html>");
					modelloResoconto.addElement(
							"<html><div style='color: blue'>Tempo attivo (odierno): " + attuale.getTempoParziale()
									+ " - Consumo (odierno): " + attuale.getConsumoParziale() + "</div></html>");
				} else {
					modelloResoconto.addElement("<html><div style='color: green'>Tipo: " + attuale.getTipo() + " - ID: "
							+ attuale.getId() + "</div></html>");
					modelloResoconto.addElement(
							"<html><div style='color: orange'>Tempo attivo (precedente): Inesistente - Consumo (precedente): Inesistente"
									+ "</div></html>");
					modelloResoconto.addElement(
							"<html><div style='color: blue'>Tempo attivo (odierno): " + attuale.getTempoAttivo()
									+ " - Consumo (odierno): " + attuale.getConsumo() + "</div></html>");
				}
			}
		}

		modelloResoconto.addElement("");
		modelloResoconto.addElement("");
		
		if (risparmio == null) {
			modelloResoconto.addElement("<html><div style='color: orange; font-size: 20'>Consumo totale precedente: Non registrato");
		} else {
			modelloResoconto.addElement(
					"<html><div style='color: orange; font-size: 20'>Consumo totale precedente: " + risparmio.getRisparmio());
		}

		int consumoTot = 0;

		for (ControlloreDispositivo dispositivo : config.getDispositivi()) {
			if (dispositivo.getCodice() == 1) {
				consumoTot += dispositivo.getConsumoParziale();
			} else {
				consumoTot += dispositivo.getConsumo();
			}
		}
		modelloResoconto.addElement("<html><div style='color: blue; font-size: 20'> Consumo totale odierno: " + consumoTot);

		resoconto.setModel(modelloResoconto);
		getContentPane().add(resoconto);

		RisparmioEnergetico risp = new RisparmioEnergetico(risparmio, config, new Date());
		risp.writeRisparmioEnergetico(new File("Risparmio.txt"));

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

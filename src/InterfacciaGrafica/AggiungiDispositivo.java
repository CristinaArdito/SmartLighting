package InterfacciaGrafica;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import toAssign.Dispositivo;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AggiungiDispositivo extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField tipoDispositivo;
	private JTextField consumoDispositivo;
	private JComboBox<String> listaIDDispositivi;
	private JButton button;
	private List<Integer> listaID;
	private DefaultComboBoxModel<String> modelloIDDispositivi;

	public AggiungiDispositivo(boolean nuovaStanza, List<Integer> listaIdDispositivi) {
		getContentPane().setLayout(null);
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		this.listaID = listaIdDispositivi;
		
		JLabel lblModificaDispositivo = new JLabel("Aggiungi dispositivo");
		lblModificaDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModificaDispositivo.setBounds(158, 11, 217, 27);
		getContentPane().add(lblModificaDispositivo);
		
		JLabel lblInserisciLaTipologia = new JLabel("Inserisci la tipologia di dispositivo");
		lblInserisciLaTipologia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserisciLaTipologia.setBounds(10, 82, 217, 27);
		getContentPane().add(lblInserisciLaTipologia);
		
		tipoDispositivo = new JTextField();
		tipoDispositivo.setBounds(237, 81, 197, 27);
		getContentPane().add(tipoDispositivo);
		tipoDispositivo.setColumns(10);
		
		JLabel lblInserisciIlConsumo = new JLabel("Inserisci il consumo");
		lblInserisciIlConsumo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserisciIlConsumo.setBounds(10, 140, 217, 27);
		getContentPane().add(lblInserisciIlConsumo);
		
		consumoDispositivo = new JTextField();
		consumoDispositivo.setBounds(158, 145, 104, 20);
		getContentPane().add(consumoDispositivo);
		consumoDispositivo.setColumns(10);
		
		JLabel lblWatt = new JLabel("watt");
		lblWatt.setBounds(272, 148, 46, 14);
		getContentPane().add(lblWatt);
		
		button = new JButton("Conferma");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(27, 618, 179, 43);
		getContentPane().add(button);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAnnulla.setBounds(270, 618, 179, 43);
		getContentPane().add(btnAnnulla);
		
		listaIDDispositivi = new JComboBox<String>();
		listaIDDispositivi.setBounds(237, 191, 230, 27);
		modelloIDDispositivi = new DefaultComboBoxModel<String>();
		for (Integer id : listaID) {
			modelloIDDispositivi.addElement(id.toString());
		}
		listaIDDispositivi.setModel(modelloIDDispositivi);
		getContentPane().add(listaIDDispositivi);
		
		JLabel lblSceltaSensore = new JLabel("Scegliere sensore da collegare");
		lblSceltaSensore.setBounds(10, 191, 217, 27);
		lblSceltaSensore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblSceltaSensore);
		setBounds(100, 100, 500, 750);
	}
	
	public void addConfirmListener(ActionListener listener) {
		button.addActionListener(listener);
	}
	
	public void addRoomListener(ActionListener listener) {
		button.addActionListener(listener);
	}
	
	public Dispositivo getDispositivo() {
		int id;
		try {
			id = Integer.parseInt((String) listaIDDispositivi.getSelectedItem());
		}catch(Exception e) {
			id = Integer.parseInt((String) modelloIDDispositivi.getElementAt(0));
		}
		listaID.remove(id);
		return new Dispositivo(tipoDispositivo.getText(), -1, id, Double.parseDouble(consumoDispositivo.getText()), false,false,false);
	}
}

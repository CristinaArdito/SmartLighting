package InterfacciaGrafica;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AggiungiDispositivo extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	public AggiungiDispositivo() {
		getContentPane().setLayout(null);
		
		JLabel lblModificaDispositivo = new JLabel("Aggiungi dispositivo");
		lblModificaDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModificaDispositivo.setBounds(158, 11, 217, 27);
		getContentPane().add(lblModificaDispositivo);
		
		JLabel lblInserisciLaTipologia = new JLabel("Inserisci la tipologia di dispositivo");
		lblInserisciLaTipologia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserisciLaTipologia.setBounds(10, 82, 217, 27);
		getContentPane().add(lblInserisciLaTipologia);
		
		textField = new JTextField();
		textField.setBounds(237, 81, 197, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblInserisciIlConsumo = new JLabel("Inserisci il consumo");
		lblInserisciIlConsumo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserisciIlConsumo.setBounds(10, 140, 217, 27);
		getContentPane().add(lblInserisciIlConsumo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 145, 104, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblWatt = new JLabel("watt");
		lblWatt.setBounds(272, 148, 46, 14);
		getContentPane().add(lblWatt);
		
		JButton button = new JButton("Conferma");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(27, 618, 179, 43);
		getContentPane().add(button);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAnnulla.setBounds(270, 618, 179, 43);
		getContentPane().add(btnAnnulla);
		
		JComboBox<String> listaSensori = new JComboBox<String>();
		listaSensori.setBounds(237, 191, 230, 27);
		DefaultComboBoxModel<String> modelloSensori = new DefaultComboBoxModel<String>();
		for (Integer id : Interfaccia.getSensori()) {
			modelloSensori.addElement(id.toString());
		}
		listaSensori.setModel(modelloSensori);
		getContentPane().add(listaSensori);
		
		JLabel lblSceltaSensore = new JLabel("Scegliere sensore da collegare");
		lblSceltaSensore.setBounds(10, 191, 217, 27);
		lblSceltaSensore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblSceltaSensore);
		setBounds(100, 100, 500, 750);
	}
}

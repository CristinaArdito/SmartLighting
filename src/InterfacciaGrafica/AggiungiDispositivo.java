package InterfacciaGrafica;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AggiungiDispositivo extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public AggiungiDispositivo() {
		getContentPane().setLayout(null);
		
		JLabel lblModificaDispositivo = new JLabel("Modifica dispositivo");
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
		button.setBounds(158, 616, 179, 43);
		getContentPane().add(button);
		
		JLabel lblInserisciLaStanza = new JLabel("Inserisci la stanza in cui \u00E8 presente");
		lblInserisciLaStanza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserisciLaStanza.setBounds(10, 205, 252, 27);
		getContentPane().add(lblInserisciLaStanza);
		
		textField_2 = new JTextField();
		textField_2.setBounds(251, 205, 183, 25);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		setBounds(100, 100, 500, 750);
	}
}

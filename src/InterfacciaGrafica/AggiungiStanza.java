package InterfacciaGrafica;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class AggiungiStanza extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JButton button = new JButton("Conferma");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(28, 636, 179, 43);
		getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(74, 81, 171, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnTv = new JRadioButton("Tv");
		rdbtnTv.setBounds(10, 177, 109, 23);
		getContentPane().add(rdbtnTv);
		
		JRadioButton rdbtnComputer = new JRadioButton("Computer");
		rdbtnComputer.setBounds(10, 203, 109, 23);
		getContentPane().add(rdbtnComputer);
		
		JRadioButton rdbtnRadio = new JRadioButton("Radio");
		rdbtnRadio.setBounds(10, 232, 109, 23);
		getContentPane().add(rdbtnRadio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(174, 389, 86, 30);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNumeroDiLuci = new JLabel("Numero di luci presenti:");
		lblNumeroDiLuci.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroDiLuci.setBounds(10, 387, 200, 30);
		getContentPane().add(lblNumeroDiLuci);
		
		JLabel lblListaDeiDispositivi = new JLabel("Lista dei dispositivi presenti");
		lblListaDeiDispositivi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListaDeiDispositivi.setBounds(10, 134, 200, 36);
		getContentPane().add(lblListaDeiDispositivi);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 79, 69, 30);
		getContentPane().add(lblNome);
		
		JLabel lblAggiungiUnaStanza = new JLabel("Aggiungi una stanza");
		lblAggiungiUnaStanza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAggiungiUnaStanza.setBounds(171, 11, 153, 30);
		getContentPane().add(lblAggiungiUnaStanza);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAnnulla.setBounds(269, 636, 179, 43);
		getContentPane().add(btnAnnulla);
	}
}

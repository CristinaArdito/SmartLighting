package InterfacciaGrafica;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

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
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 535, 86, 30);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNumeroDiLuci = new JLabel("Numero di luci presenti:");
		lblNumeroDiLuci.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroDiLuci.setBounds(10, 533, 171, 30);
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
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAnnulla.setBounds(269, 636, 179, 43);
		getContentPane().add(btnAnnulla);
		
		JList<String> listaDispositiviStanza = new JList<String>();
		listaDispositiviStanza.setBounds(10, 169, 464, 266);
		getContentPane().add(listaDispositiviStanza);
		
		JButton btnAggiungiDispositivo = new JButton("Aggiungi");
		btnAggiungiDispositivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiDispositivo aggiungiDispositivo = new AggiungiDispositivo();
				aggiungiDispositivo.setVisible(true);
			}
		});
		btnAggiungiDispositivo.setBounds(355, 446, 119, 30);
		getContentPane().add(btnAggiungiDispositivo);
	}
}

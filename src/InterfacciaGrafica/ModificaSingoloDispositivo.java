package InterfacciaGrafica;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import toAssign.Configurazione;
import toAssign.Dispositivo;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModificaSingoloDispositivo extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	public ModificaSingoloDispositivo(String nomeDispositivo, int idDispositivo, Configurazione config) {
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
		textField.setBounds(237, 81, 197, 32);
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
		setBounds(100, 100, 500, 750);
		
		Dispositivo dispositivo = config.getDispositivo(idDispositivo);
		if(dispositivo != null) {
		JLabel accendibile = new JLabel("Il dispositivo può essere acceso");
		accendibile.setBounds(10, 99, 290, 64);
		accendibile.setFont(new Font(lblModificaDispositivo.getFont().getFontName(),lblModificaDispositivo.getFont().getStyle(),18));
		getContentPane().add(accendibile);	
		
		JCheckBox checkAccendibile = new JCheckBox();
		checkAccendibile.setHorizontalAlignment(SwingConstants.CENTER);
		checkAccendibile.setBounds(357, 99, 121, 67);
		getContentPane().add(checkAccendibile);
		
		JLabel standBy = new JLabel("Il dispositivo può essere messo in standby");
		standBy.setBounds(10, 184, 344, 64);
		standBy.setFont(new Font(lblModificaDispositivo.getFont().getFontName(),lblModificaDispositivo.getFont().getStyle(),18));
		getContentPane().add(standBy);	
		
		JCheckBox checkStandBy = new JCheckBox();
		checkStandBy.setHorizontalAlignment(SwingConstants.CENTER);
		checkStandBy.setBounds(357, 181, 121, 67);
		getContentPane().add(checkStandBy);
		
		JLabel spegnibile = new JLabel("Il dispositivo può essere spento");
		spegnibile.setBounds(10, 271, 290, 64);
		spegnibile.setFont(new Font(lblModificaDispositivo.getFont().getFontName(),lblModificaDispositivo.getFont().getStyle(),18));
		getContentPane().add(spegnibile);	
		
		JCheckBox checkSpegnibile = new JCheckBox();
		checkSpegnibile.setHorizontalAlignment(SwingConstants.CENTER);
		checkSpegnibile.setBounds(357, 268, 121, 67);
		getContentPane().add(checkSpegnibile);
		
		
		}
		
	}
}

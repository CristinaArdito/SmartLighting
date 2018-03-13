package interfacciaGrafica;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sistema.ControlloreDispositivo;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

	public AggiungiDispositivo(boolean nuovaStanza, List<Integer> listaIdDispositivi)  {
		getContentPane().setBackground(new Color(236,248,250));
		getContentPane().setLayout(null);
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		this.listaID = listaIdDispositivi;
		
		ImageIcon img = new ImageIcon("icon.png");
		this.setIconImage(img.getImage());
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("sls_logo.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(27, 22, 432, 86);
		getContentPane().add(picLabel);
		
		JLabel lblModificaDispositivo = new JLabel("Aggiungi dispositivo");
		lblModificaDispositivo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblModificaDispositivo.setBounds(158, 138, 217, 27);
		getContentPane().add(lblModificaDispositivo);
		
		JLabel lblInserisciLaTipologia = new JLabel("Inserisci la tipologia: ");
		lblInserisciLaTipologia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInserisciLaTipologia.setBounds(10, 201, 274, 27);
		getContentPane().add(lblInserisciLaTipologia);
		
		tipoDispositivo = new JTextField();
		tipoDispositivo.setBounds(180, 204, 197, 27);
		getContentPane().add(tipoDispositivo);
		tipoDispositivo.setColumns(10);
		
		JLabel lblInserisciIlConsumo = new JLabel("Inserisci il consumo:");
		lblInserisciIlConsumo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserisciIlConsumo.setBounds(10, 265, 217, 27);
		getContentPane().add(lblInserisciIlConsumo);
		
		consumoDispositivo = new JTextField();
		consumoDispositivo.setBounds(180, 270, 104, 20);
		getContentPane().add(consumoDispositivo);
		consumoDispositivo.setColumns(10);
		
		JLabel lblWatt = new JLabel("watt");
		lblWatt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWatt.setBounds(294, 268, 61, 19);
		getContentPane().add(lblWatt);
		
		button = new JButton("Conferma");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(27, 654, 191, 49);
		getContentPane().add(button);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnulla.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAnnulla.setBounds(268, 654, 191, 49);
		getContentPane().add(btnAnnulla);
		
		listaIDDispositivi = new JComboBox<String>();
		listaIDDispositivi.setBounds(270, 332, 189, 27);
		modelloIDDispositivi = new DefaultComboBoxModel<String>();
		for (Integer id : listaID) {
			modelloIDDispositivi.addElement(id.toString());
		}
		listaIDDispositivi.setModel(modelloIDDispositivi);
		getContentPane().add(listaIDDispositivi);
		
		JLabel lblSceltaSensore = new JLabel("Scegliere sensore da collegare: ");
		lblSceltaSensore.setBounds(10, 329, 249, 27);
		lblSceltaSensore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(lblSceltaSensore);
		setBounds(100, 100, 500, 750);
	}
	
	public void addConfirmListener(ActionListener listener) {
		button.addActionListener(listener);
	}
	
	public void addRoomListener(ActionListener listener) {
		button.addActionListener(listener);
	}
	
	/**
	 * Ritorna il dispositivo
	 * @return		dispositivo
	 */
	public ControlloreDispositivo getDispositivo() {
		int id;
		try {
			id = Integer.parseInt((String) listaIDDispositivi.getSelectedItem());
		}catch(Exception e) {
			id = Integer.parseInt((String) modelloIDDispositivi.getElementAt(0));
		}
		listaID.remove(id);
		return new ControlloreDispositivo(tipoDispositivo.getText(), -1, id, Double.parseDouble(consumoDispositivo.getText()), false,false,false);
	}
}

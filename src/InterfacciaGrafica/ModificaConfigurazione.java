package InterfacciaGrafica;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class ModificaConfigurazione extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtModificaConfigurazione;
	
	public ModificaConfigurazione() {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 750);
		
		txtModificaConfigurazione = new JTextField();
		txtModificaConfigurazione.setBackground(new Color(255, 255, 255));
		txtModificaConfigurazione.setHorizontalAlignment(SwingConstants.CENTER);
		txtModificaConfigurazione.setText("Modifica configurazione");
		getContentPane().add(txtModificaConfigurazione, BorderLayout.NORTH);
		txtModificaConfigurazione.setColumns(10);
		
		JButton button = new JButton("Conferma");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(button, BorderLayout.SOUTH);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
	};

}
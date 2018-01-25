package InterfacciaGrafica;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import toAssign.Configurazione;
import toAssign.Dispositivo;
import toAssign.Stanza;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificaConfigurazione extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Stanza> stanze;
	private JButton button;
	private DefaultListModel<String> model;
	private JList<String> listaStanze;
	private JLabel lblModificaConfigurazione;
	
	
	public ModificaConfigurazione(Configurazione config, List<Stanza> stanze, List<Integer> listaIdDispositivi) {
		this.stanze = stanze;
		
		getContentPane().setBackground(UIManager.getColor("Label.background"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		
		lblModificaConfigurazione = new JLabel("Modifica Configurazione");
		lblModificaConfigurazione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModificaConfigurazione.setBounds(161, 11, 180, 26);
		getContentPane().add(lblModificaConfigurazione);
		
		button = new JButton("Conferma");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(34, 633, 162, 52);
		getContentPane().add(button);
		
		JButton btnAggiungiStanza = new JButton("Aggiungi Stanza");
		btnAggiungiStanza.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAggiungiStanza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiStanza aggiungiStanza = new AggiungiStanza(listaIdDispositivi);
				aggiungiStanza.setVisible(true);
				aggiungiStanza.addConfirmListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Stanza s = aggiungiStanza.getStanza();
						if(stanze.size() == 0) s.setCodice(0);
						else s.setCodice(stanze.size());
						model.addElement(s.getNome()+" - ID:"+s.getCodice());
						listaStanze.setModel(model);
						stanze.add(s);
						for (Dispositivo dispositivo : s.getDispositivi()) {
							config.addDispositivo(dispositivo);
						}
						aggiungiStanza.dispose();
					}
				});
			}
		});
		btnAggiungiStanza.setBounds(265, 633, 185, 52);
		getContentPane().add(btnAggiungiStanza);
		
		listaStanze = new JList<String>();
		listaStanze.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String stringaTemporanea = listaStanze.getSelectedValue();
				String idStanza = stringaTemporanea.substring(stringaTemporanea.lastIndexOf("- ID:")+5, stringaTemporanea.length());
				ModificaDispositivi modificaDispositivo = new ModificaDispositivi(Integer.parseInt(idStanza), stanze, config, listaIdDispositivi);
				modificaDispositivo.setVisible(true);
			}
		});
		listaStanze.setBounds(10, 45, 464, 575);
		getContentPane().add(listaStanze);
		model = new DefaultListModel<String>();
		if(stanze.size() != 0) {
			for (Stanza stanza : stanze) {
				model.addElement(stanza.getNome()+" - ID:"+stanza.getCodice());
			}
		}
		listaStanze.setModel(model);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
	}
	
	public void addConfirmListener(ActionListener listener) {
		button.addActionListener(listener);
	}
	
	public List<Stanza> getStanze() {
		return stanze;
	}
}
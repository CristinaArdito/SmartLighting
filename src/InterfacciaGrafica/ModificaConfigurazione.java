package InterfacciaGrafica;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import toAssign.Configurazione;
import toAssign.Stanza;

import javax.swing.JList;

public class ModificaConfigurazione extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Stanza> stanze;
	private JTextField txtModificaConfigurazione;
	private JButton button;
	private DefaultListModel<String> model;
	private JList<String> listaStanze;
	
	
	public ModificaConfigurazione(Configurazione config, List<Stanza> stanze) {
		this.stanze = stanze;
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		
		txtModificaConfigurazione = new JTextField();
		txtModificaConfigurazione.setEditable(false);
		txtModificaConfigurazione.setBounds(0, 0, 484, 20);
		txtModificaConfigurazione.setBackground(new Color(255, 255, 255));
		txtModificaConfigurazione.setHorizontalAlignment(SwingConstants.CENTER);
		txtModificaConfigurazione.setText("Modifica configurazione");
		getContentPane().add(txtModificaConfigurazione);
		txtModificaConfigurazione.setColumns(10);
		
		button = new JButton("Conferma");
		button.setBounds(12, 660, 226, 52);
		getContentPane().add(button);
		
		listaStanze = new JList<String>();
		listaStanze.setBounds(10, 26, 464, 632);
		getContentPane().add(listaStanze);
		model = new DefaultListModel<String>();
		if(stanze.size() != 0) {
			for (Stanza stanza : stanze) {
				model.addElement(stanza.getNome()+" - ID:"+stanza.getCodice());
			}
		}
		listaStanze.setModel(model);
		
		JButton btnAggiungiStanza = new JButton("Aggiungi Stanza");
		btnAggiungiStanza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AggiungiStanza aggiungiStanza = new AggiungiStanza();
				aggiungiStanza.setVisible(true);
				aggiungiStanza.addConfirmListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Stanza s = aggiungiStanza.getStanza();
						if(stanze.size() == 0) s.setCodice(0);
						else s.setCodice(stanze.size());
						model.addElement(s.getNome()+" - ID:"+s.getCodice());
						listaStanze.setModel(model);
						stanze.add(s);
						aggiungiStanza.dispose();
					}
				});
			}
		});
		btnAggiungiStanza.setBounds(248, 660, 226, 52);
		getContentPane().add(btnAggiungiStanza);
		
		listaStanze.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
				String stringaTemporanea = listaStanze.getSelectedValue();
				String idStanza = stringaTemporanea.substring(stringaTemporanea.lastIndexOf("- ID:")+5, stringaTemporanea.length());
				ModificaDispositivi modificaDispositivo = new ModificaDispositivi(Integer.parseInt(idStanza), stanze, config);
				modificaDispositivo.setVisible(true);
				}
			}
		});
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
package interfacciaGrafica;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import sistema.Configurazione;
import sistema.Dispositivo;
import sistema.Stanza;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.border.LineBorder;

public class ModificaConfigurazione extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Stanza> stanze;
	private JButton button;
	private DefaultListModel<String> model;
	private JList<String> listaStanze;
	private JLabel lblModificaConfigurazione;
	
	
	public ModificaConfigurazione(Configurazione config, List<Stanza> stanze, List<Integer> listaIdDispositivi) throws IOException {
		this.stanze = stanze;
		
		getContentPane().setBackground(new Color(236,248,250));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 750);
		getContentPane().setLayout(null);
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		
		ImageIcon img = new ImageIcon("icon.png");
		this.setIconImage(img.getImage());
		BufferedImage myPicture = ImageIO.read(new File("sls_logo.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(29, 11, 432, 86);
		getContentPane().add(picLabel);
		

		lblModificaConfigurazione = new JLabel("Modifica Configurazione");
		lblModificaConfigurazione.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblModificaConfigurazione.setBounds(143, 97, 219, 26);
		getContentPane().add(lblModificaConfigurazione);
		
		button = new JButton("Conferma");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(28, 654, 191, 49);
		getContentPane().add(button);
		
		JButton btnAggiungiStanza = new JButton("Aggiungi Stanza");
		btnAggiungiStanza.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
		btnAggiungiStanza.setBounds(265, 654, 191, 49);
		getContentPane().add(btnAggiungiStanza);
		
		listaStanze = new JList<String>();
		listaStanze.setFont(new Font("Tahoma", Font.ITALIC, 16));
		listaStanze.setBorder(new LineBorder(new Color(0, 0, 0)));
		listaStanze.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String stringaTemporanea = listaStanze.getSelectedValue();
				String idStanza = stringaTemporanea.substring(stringaTemporanea.lastIndexOf("- ID:")+5, stringaTemporanea.length());
				ModificaDispositivi modificaDispositivo;
				modificaDispositivo = new ModificaDispositivi(Integer.parseInt(idStanza), stanze, config, listaIdDispositivi);
				modificaDispositivo.setVisible(true);
			}
		});
		listaStanze.setBounds(10, 134, 480, 486);
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
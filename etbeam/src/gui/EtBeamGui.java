package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class EtBeamGui extends JFrame implements EtBeamIF{
	private JPanel contentPane;
	
	
	
	public EtBeamGui() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 0, 607, 108);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(6, 6, 102, 98);
		lblNewLabel.setIcon(new ImageIcon(EtBeamGui.class.getResource("/images/res/logo_trans.png")));
		panel.add(lblNewLabel);
		
		JLabel lblEtbeam = new JLabel("&Beam");
		lblEtbeam.setBounds(120, 6, 129, 36);
		lblEtbeam.setFont(new Font("SansSerif", Font.BOLD, 30));
		panel.add(lblEtbeam);
		
		JLabel lblVousEnAvez = new JLabel("Vous en avez reve, &Beam l'a fait...");
		lblVousEnAvez.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		lblVousEnAvez.setBounds(120, 54, 481, 15);
		panel.add(lblVousEnAvez);
		
		JLabel lbletCommeIl = new JLabel("...et comme il faut!");
		lbletCommeIl.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		lbletCommeIl.setBounds(461, 89, 140, 15);
		panel.add(lbletCommeIl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 122, 652, 366);
		contentPane.add(panel_1);
		
		JSplitPane splitPane = new JSplitPane();
		panel_1.add(splitPane);
		
		JButton btnConsultationDesNotes = new JButton("Consultation UE");
		btnConsultationDesNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ConsultationMoy();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnConsultationDesNotes.setToolTipText("");
		btnConsultationDesNotes.setMnemonic('C');
		btnConsultationDesNotes.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnConsultationDesNotes.setIcon(new ImageIcon(EtBeamGui.class.getResource("/images/res/consultNotes.png")));
		btnConsultationDesNotes.setHorizontalAlignment(SwingConstants.TRAILING);
		splitPane.setLeftComponent(btnConsultationDesNotes);
		
		

		
		JSplitPane splitPane_1 = new JSplitPane();
		panel_1.add(splitPane_1);
		
		JButton button = new JButton("Consultation Etudiant");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ConsultationEtud();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		button.setToolTipText("");
		button.setMnemonic('C');
		button.setHorizontalAlignment(SwingConstants.TRAILING);
		button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		splitPane_1.setLeftComponent(button);
		
		JButton button_1 = new JButton("Modification des notes");
		button_1.setIcon(new ImageIcon(EtBeamGui.class.getResource("/images/res/modifNotes.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModificationNotes();
			}
		});
		button_1.setMnemonic('m');
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		splitPane_1.setRightComponent(button_1);


		
		
		JButton btnConsultationMatiere = new JButton("Consultation ECUE");
		btnConsultationMatiere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ConsultationECUE();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnConsultationMatiere.setToolTipText("");
		btnConsultationMatiere.setMnemonic('C');
		btnConsultationMatiere.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnConsultationMatiere.setIcon(new ImageIcon(EtBeamGui.class.getResource("/images/res/consultNotes.png")));
		btnConsultationMatiere.setHorizontalAlignment(SwingConstants.TRAILING);
		splitPane.setRightComponent(btnConsultationMatiere);
		
		
		this.setVisible(false);
		
		new Login(this);
	}

	@Override
	public void main() {
		// TODO Auto-generated method stub
		
	}

	public void connection() {
		this.setVisible(true);
	}
}
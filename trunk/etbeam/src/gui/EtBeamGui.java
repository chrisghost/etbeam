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
		setBounds(100, 100, 665, 760);
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
		panel_1.setBounds(12, 120, 639, 598);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		

		
		
		

		
		
		

		
		JButton button_1 = new JButton("Modification des notes");
		panel_1.add(button_1);
		button_1.setBounds(10, 166, 343, 109);
		button_1.setIcon(new ImageIcon(EtBeamGui.class.getResource("/images/res/modifNotes.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ModificationNotes();
			}
		});
		button_1.setMnemonic('m');
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));



		
		
		JButton btnConsultationMatiere = new JButton("Consultation ECUE");
		panel_1.add(btnConsultationMatiere);
		btnConsultationMatiere.setBounds(10, 11, 323, 109);
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
		
		
		
		JButton button = new JButton("Consultation Etudiant");
		button.setBounds(394, 166, 231, 109);
		panel_1.add(button);
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
		
		JButton btnConsultationDesNotes = new JButton("Consultation UE");
		btnConsultationDesNotes.setBounds(345, 11, 280, 109);
		panel_1.add(btnConsultationDesNotes);
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
		
		
		
		JButton button_3 = new JButton("Consultation Etudiant (ADMIN)");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ConsultationEtudAdmin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		button_3.setToolTipText("");
		button_3.setMnemonic('C');
		button_3.setHorizontalAlignment(SwingConstants.TRAILING);
		button_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		button_3.setBounds(327, 477, 298, 109);
		panel_1.add(button_3);
		
		JButton button_2 = new JButton("Suppression Etudiant (ADMIN)");
		button_2.setBounds(10, 477, 305, 109);
		panel_1.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new SupprEtud();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		button_2.setToolTipText("");
		button_2.setMnemonic('C');
		button_2.setHorizontalAlignment(SwingConstants.TRAILING);
		button_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton button_4 = new JButton("Point Jury Semestre");
		
		button_4.setBounds(10, 321, 260, 109);
		panel_1.add(button_4);
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ModificationMoySem();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		button_4.setMnemonic('P');
		button_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JButton button_5 = new JButton("Point Jury UE");
		button_5.setMnemonic('P');
		button_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		button_5.setBounds(374, 321, 251, 109);
		panel_1.add(button_5);
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ModificationValidations();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
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
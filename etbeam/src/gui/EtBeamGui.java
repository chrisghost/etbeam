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
		panel.setBackground(Color.WHITE);
		panel.setBounds(32, 0, 607, 108);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EtBeamGui.class.getResource("/images/res/logo.png")));
		panel.add(lblNewLabel);
		
		JLabel lblEtbeam = new JLabel("Il faut mettre une banniĂÂ¨re bien classe ici, ou de la pub");
		lblEtbeam.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		panel.add(lblEtbeam);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 122, 652, 366);
		contentPane.add(panel_1);
		
		JSplitPane splitPane = new JSplitPane();
		panel_1.add(splitPane);
		
		JButton btnConsultationDesNotes = new JButton("Consultation des moyennes");
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
		

		/*JButton btnModificationDesNotes = new JButton("Modification des notes");
=======
		JButton btnModificationDesNotes = new JButton("Modification des moyennes");
>>>>>>> .r197
		btnModificationDesNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ModificationMoy();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnModificationDesNotes.setMnemonic('m');
		btnModificationDesNotes.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnModificationDesNotes.setIcon(new ImageIcon(EtBeamGui.class.getResource("/images/res/modifNotes.png")));
		splitPane.setRightComponent(btnModificationDesNotes);
<<<<<<< .mine
*/
		

		
		JSplitPane splitPane_1 = new JSplitPane();
		panel_1.add(splitPane_1);
		
		JButton button = new JButton("Consultation des notes");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setToolTipText("");
		button.setMnemonic('C');
		button.setHorizontalAlignment(SwingConstants.TRAILING);
		button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		splitPane_1.setLeftComponent(button);
		
		JButton button_1 = new JButton("Modification des notes");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setMnemonic('m');
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		splitPane_1.setRightComponent(button_1);


		
		
		JButton btnConsultationMatičre = new JButton("Consultation matičre");
		btnConsultationMatičre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ConsultationECUE();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnConsultationMatičre.setToolTipText("");
		btnConsultationMatičre.setMnemonic('C');
		btnConsultationMatičre.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnConsultationMatičre.setIcon(new ImageIcon(EtBeamGui.class.getResource("/images/res/consultNotes.png")));
		btnConsultationMatičre.setHorizontalAlignment(SwingConstants.TRAILING);
		splitPane.setRightComponent(btnConsultationMatičre);
		
		
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
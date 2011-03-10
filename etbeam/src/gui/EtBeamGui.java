package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import bd.Facade;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import models.mysql.*;

public class EtBeamGui extends JFrame implements EtBeamIF {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtBeamGui frame = new EtBeamGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	public EtBeamGui()  {
	
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setTitle("Gestion UE - Consultation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 329);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gestion"}));
		comboBox.setToolTipText("choisir une U.E");
		comboBox.setBounds(284, 41, 183, 20);
		getContentPane().add(comboBox);
		
		JLabel lblChoixDeLue = new JLabel("3 - Choix UE");
		lblChoixDeLue.setBounds(329, 26, 85, 14);
		getContentPane().add(lblChoixDeLue);
		
		JButton btnValider = new JButton("Charger");
		btnValider.setBounds(183, 83, 95, 23); 
		getContentPane().add(btnValider);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"MATTIACI", "Kevin", "12", null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, Boolean.FALSE},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(41, 135, 376, 128);
		getContentPane().add(table);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNom.setBounds(75, 117, 46, 14);
		getContentPane().add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrnom.setBounds(160, 117, 70, 14);
		getContentPane().add(lblPrnom);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNote.setBounds(257, 118, 46, 14);
		getContentPane().add(lblNote);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(419, 135, 17, 128);
		getContentPane().add(scrollBar);
		
		JLabel lblValidationUe = new JLabel("Validation UE");
		lblValidationUe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValidationUe.setBounds(338, 117, 78, 14);
		getContentPane().add(lblValidationUe);
		
	
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"IG4"}));
		comboBox_1.setBounds(41, 41, 80, 20);
		getContentPane().add(comboBox_1); 
		
		JLabel lblChoix = new JLabel("1 - Choix ann\u00E9e");
		lblChoix.setBounds(41, 26, 89, 14);
		getContentPane().add(lblChoix);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2"}));
		comboBox_2.setBounds(188, 41, 46, 20);
		getContentPane().add(comboBox_2);
		
		JLabel lblChoix_1 = new JLabel("2 - Choix Semestre");
		lblChoix_1.setBounds(160, 26, 98, 14);
		getContentPane().add(lblChoix_1);
	}
}











/*package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class EtBeam{

	private Fenetre frame;

	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtBeam window = new EtBeam();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 *//*
	public EtBeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *//*
	private void initialize() {
		frame = new Fenetre();
		frame.setBounds(100, 100, 576, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
*/

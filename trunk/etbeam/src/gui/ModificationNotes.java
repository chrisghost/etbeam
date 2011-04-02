package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.CellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bd.Facade;

import models.Annee;
import models.Departement;
import models.ECUE;
import models.Etudiant;
import models.Semestre;
import models.UE;

public class ModificationNotes extends JFrame {
	private static Boolean alive = true;
	// Currently selected ressources
	// private Utilisateur user = null;
	private Departement dept = null;
	private Annee annee = null;
	private Semestre sem = null;
	private UE ue = null;
	private Annee an = null;
	private ECUE ecue = null;
	private JComboBox listdep = new JComboBox();
	private JComboBox listann = new JComboBox();
	private JComboBox listsem = new JComboBox();
	private JComboBox listue = new JComboBox();
	private JComboBox listecue = new JComboBox();
	private final JButton OK1 = new JButton("OK");
	private final JButton OK2 = new JButton("OK");
	private final JButton OK3 = new JButton("OK");
	private final JButton OK4 = new JButton("OK");
	private JTable table = new JTable();
	private DefaultTableModel modele = (DefaultTableModel) table.getModel();
	private JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblSlectionDpartement = new JLabel(
			"Selection Departement");
	private final JLabel lblSlectionAnne = new JLabel("Selection Annee");
	private final JLabel lblSlectionSemestre = new JLabel("Selection Semestre");
	private final JLabel lblSlectionUe = new JLabel("Selection UE");
	private final JLabel lblSlectionEcue = new JLabel("Selection ECUE");
	private final JLabel lblVousNavezPas = new JLabel("Vous n'avez pas les droits pour modifier ces informations");
	private JLabel lblEcue = new JLabel("ECUE");
	
	int colIndSession = 2;
	
	ArrayList<Etudiant> etudlist = new ArrayList<Etudiant>();	//liste des etudiants actuellemnt affiches



	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public ModificationNotes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EtBeamGui.class.getResource("/images/res/logo_trans.png")));
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 376);
		setTitle("Consultation Mati�re");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listdep.setFocusTraversalKeysEnabled(false);

		// Listes d�roulantes de s�lection
		listdep.setBounds(42, 53, 140, 20);
		contentPane.add(listdep);
		// listdep.addItem("");

		listann.setBounds(42, 94, 140, 20);
		contentPane.add(listann);

		listsem.setBounds(42, 142, 140, 20);
		contentPane.add(listsem);

		listue.setBounds(42, 192, 140, 20);
		contentPane.add(listue);

		listecue.setBounds(42, 239, 225, 20);
		contentPane.add(listecue);

		// Bouton de chargement
		JButton charger = new JButton("Charger");
		charger.setBounds(42, 280, 206, 32);
		contentPane.add(charger);

		OK2.setBounds(185, 53, 63, 20);
		contentPane.add(OK2);

		OK1.setBounds(183, 94, 65, 20);

		contentPane.add(OK1);
		OK3.setBounds(185, 142, 63, 20);

		contentPane.add(OK3);
		scrollPane.setBounds(273, 53, 462, 228);

		OK4.setBounds(185, 191, 63, 20);
		contentPane.add(OK4);

		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);

		table.setCellSelectionEnabled(false);
		table.setVisible(true);

		modele.addColumn("Nom");
		modele.addColumn("Prenom");
		modele.addColumn("Session 1");
		modele.addColumn("Session 2");

		table.setCellSelectionEnabled(false);

		lblSlectionDpartement.setBounds(42, 40, 170, 14);
		contentPane.add(lblSlectionDpartement);

		lblSlectionAnne.setBounds(42, 81, 160, 14);
		contentPane.add(lblSlectionAnne);

		lblSlectionSemestre.setBounds(42, 129, 152, 14);
		contentPane.add(lblSlectionSemestre);

		lblSlectionUe.setBounds(42, 179, 106, 14);
		contentPane.add(lblSlectionUe);

		lblSlectionEcue.setBounds(42, 227, 106, 14);
		contentPane.add(lblSlectionEcue);
		
		lblVousNavezPas.setForeground(Color.RED);
		lblVousNavezPas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVousNavezPas.setBounds(12, 0, 752, 15);
		
		contentPane.add(lblVousNavezPas);

		lblVousNavezPas.setVisible(false);
		
		lblEcue.setHorizontalAlignment(SwingConstants.CENTER);
		lblEcue.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEcue.setBounds(273, 23, 461, 27);
		contentPane.add(lblEcue);
		

		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// On termine le mode d'�dition de la cellule pour qu'on puisse obtenir la valeur modifi�e
				CellEditor c = table.getCellEditor(); 
				c.stopCellEditing();
				
				for(int i= 0; i<table.getModel().getRowCount();i++){
					for(int s = 1; s < 3; s++){	//s = numero de la session = {1,2}
						Float note = Float.parseFloat(table.getModel().getValueAt(i, colIndSession+(s-1)).toString());
						Facade.changeNoteEcue(ecue, etudlist.get(i), note, s);
						//(s-1) : 	session1 => 0 donc l indice de colonne = colIndSession+0
						//			session2 => 1 donc l indice de colonne = colIndSession+1
						
					}
				}
			}
		});
		btnSauvegarder.setBounds(583, 293, 152, 25);
		contentPane.add(btnSauvegarder);

		charger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVousNavezPas.setVisible(false);

				deleteTable(modele); // r�initialisation de la table

				// si l'un des quatres elements a choisir est nul, on refuse la
				// validation et on avertit l'utilisateur
				if (listdep.getSelectedItem() == null
						|| listann.getSelectedItem() == null
						|| listsem.getSelectedItem() == null
						|| listue.getSelectedItem() == null) {

					javax.swing.JOptionPane.showMessageDialog(null,
							"Veuillez bien selectionner tous les parametres");
				}
				else if(!Facade.getInstance().hasRights("write", "ECUE", (ECUE) listecue.getSelectedItem())){
					lblVousNavezPas.setVisible(true);
				}			
				// si tout est rempli
				else {
					ecue = (ECUE) listecue.getSelectedItem();
					etudlist = new ArrayList<Etudiant>();
					
					try {
						etudlist = Facade.getListeEtudECUE(ecue);

					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					for (Etudiant et : etudlist) {
						Vector rowData = new Vector();
						rowData.add(et.getNom());
						rowData.add(et.getPrenom());
						rowData.add(Facade.getEtudNote(ecue, et, 1));
						rowData.add(Facade.getEtudNote(ecue, et, 2));
						modele.addRow(rowData);
					}

					table.setModel(modele);
					table.repaint();
					setContentPane(contentPane);
					
					lblEcue.setText(ecue.getLibelleECUE());

				}

			}

		});

		for (Departement d : Facade.getListeDepartement())
			listdep.addItem(d);

		// ACTION DU BOUTON POUR VALIDER LE CHOIX DU DEPARTEMENT
		OK2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVousNavezPas.setVisible(false);

				listann.removeAllItems();
				listsem.removeAllItems();
				listue.removeAllItems();
				listecue.removeAllItems();

				dept = (Departement) listdep.getSelectedItem();
				ArrayList<Annee> a;

				a = Facade.getListeAnnee(dept);

				for (Iterator<Annee> i = a.iterator(); i.hasNext();) {
					Annee an = (Annee) i.next();
					listann.addItem(an);
				}

				a.clear(); // on vide l'arraylist pour �viter les doublons

			}
		});

		// ACTION DU BOUTON POUR VALIDER LE CHOIX DE l'ANNEE
		OK1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVousNavezPas.setVisible(false);

				listsem.removeAllItems();
				listue.removeAllItems();
				listecue.removeAllItems();

				an = (Annee) listann.getSelectedItem();
				ArrayList<Semestre> s;

				s = Facade.getListeSemestre(an);

				for (Iterator<Semestre> i = s.iterator(); i.hasNext();) {
					Semestre sem = (Semestre) i.next();
					listsem.addItem(sem);
				}

				s.clear(); // on vide l'arraylist pour �viter les doublons

			}
		});

		// ACTION DU BOUTON POUR VALIDER LE CHOIX DU SEMESTRE
		OK3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVousNavezPas.setVisible(false);

				listue.removeAllItems();
				listecue.removeAllItems();

				sem = (Semestre) listsem.getSelectedItem();
				ArrayList<UE> u;

				u = Facade.getListeUE(sem);

				for (Iterator<UE> i = u.iterator(); i.hasNext();) {
					UE ue = (UE) i.next();
					listue.addItem(ue);
				}

				u.clear(); // on vide l'arraylist pour �viter les doublons

			}
		});

		// ACTION DU BOUTON POUR VALIDER LE CHOIX DE l'UE
		OK4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVousNavezPas.setVisible(false);

				listecue.removeAllItems();
				ue = (UE) listue.getSelectedItem();
				ArrayList<ECUE> ecu;

				ecu = Facade.getListeECUE(ue);

				for (Iterator<ECUE> i = ecu.iterator(); i.hasNext();) {
					ECUE ecue = (ECUE) i.next();
					listecue.addItem(ecue);
				}

				ecu.clear(); // on vide l'arraylist pour �viter les doublons

			}
		});

		

		this.setVisible(true);

	}

	public boolean isCellEditale(int x, int y) {
		return false;
	}

	private void cleanList(JComboBox c) {
		c.removeAllItems();
		// c.addItem(new Model(""));
	}

	void deleteTable(DefaultTableModel mod) {
		while (mod.getRowCount() > 0)
			mod.removeRow(0);
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import bd.Facade;
import bd.MySQL;

import models.Annee;
import models.Departement;
import models.ECUE;
import models.EtudManager;
import models.Etudiant;
import models.Model;
import models.Semestre;
import models.UE;
import models.Utilisateur;
import models.mysql.EtudiantMySQL;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ConsultationMoy extends JFrame{
	private static Boolean alive = true;
	//Currently selected ressources
	//private Utilisateur user = null;
	private Departement dept = null;
	private Annee annee = null;
	private Semestre sem = null;
	private UE ue = null;
	private Annee an = null;
	//private ECUE ecue = null;
	private JComboBox listdep = new JComboBox();
	private JComboBox listann = new JComboBox();
	private JComboBox listsem = new JComboBox();
	private JComboBox listue = new JComboBox();
	private final JButton btnNewButton_1 = new JButton("OK");
	private final JButton btnNewButton = new JButton("OK");
	private final JButton btnNewButton_2 = new JButton("OK");
	private JTable table= new JTable();
	private DefaultTableModel modele = (DefaultTableModel)table.getModel();
	private JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblSlectionDpartement = new JLabel("Selection Departement");
	private final JLabel lblSlectionAnne = new JLabel("Selection Annee");
	private final JLabel lblSlectionSemestre = new JLabel("Selection Semestre");
	private final JLabel lblSlectionUe = new JLabel("Selection UE");
	private final JLabel lblVousNavezPas = new JLabel("Vous n'avez pas les droits pour consulter ces informations");

	
	public UE getUe() {
		return ue;
	}

	public void setUe(UE ue) {
		this.ue = ue;
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ConsultationMoy() throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EtBeamGui.class.getResource("/images/res/logo_trans.png")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 376);
		setTitle("Consultation Unite Enseignement");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listdep.setFocusTraversalKeysEnabled(false);
	
		// Listes d�roulantes de s�lection 
		listdep.setBounds(42, 53, 140, 20);
		contentPane.add(listdep);
		//listdep.addItem("");
		
		listann.setBounds(42, 94, 140, 20);
		contentPane.add(listann);

		listsem.setBounds(42, 142, 140, 20);
		contentPane.add(listsem);

		listue.setBounds(42, 192, 140, 20);
		contentPane.add(listue);
		
		//Bouton de chargement
		JButton charger = new JButton("Charger");
		charger.setBounds(42, 258, 206, 32);
		contentPane.add(charger);
		
		

		btnNewButton.setBounds(185, 53, 63, 20);
		contentPane.add(btnNewButton);

		btnNewButton_1.setBounds(183, 94, 65, 20);
		
		contentPane.add(btnNewButton_1);
		btnNewButton_2.setBounds(185, 142, 63, 20);
		
		contentPane.add(btnNewButton_2);
		scrollPane.setBounds(273, 28, 462, 284);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		table.setCellSelectionEnabled(false);
		table.setVisible(true);	

		modele.addColumn("Nom");
		modele.addColumn("Prenom");
		modele.addColumn("Moyenne");
		
		table.setCellSelectionEnabled(false);	
		

		lblSlectionDpartement.setBounds(42, 40, 170, 14);
		contentPane.add(lblSlectionDpartement);
		lblSlectionAnne.setBounds(42, 81, 160, 14);
		
		contentPane.add(lblSlectionAnne);
		lblSlectionSemestre.setBounds(42, 129, 152, 14);
		
		contentPane.add(lblSlectionSemestre);
		lblSlectionUe.setBounds(42, 179, 106, 14);
		
		lblVousNavezPas.setForeground(Color.RED);
		lblVousNavezPas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVousNavezPas.setBounds(12, 0, 752, 15);
		
		
		contentPane.add(lblSlectionUe);
		contentPane.add(lblVousNavezPas);
		

		lblVousNavezPas.setVisible(false);
		
		
		charger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVousNavezPas.setVisible(false);
						
				deleteTable(modele);

			
			// si l'un des quatres elements a choisir est nul, on refuse la validation et on avertit l'utilisateur
			if (listdep.getSelectedItem() == null || listann.getSelectedItem() == null|| listsem.getSelectedItem() == null
				|| listue.getSelectedItem() == null){
				
				javax.swing.JOptionPane.showMessageDialog(null,"Veuillez bien selectionner tous les parametres"); 
			}
			else if(!Facade.getInstance().hasRights("read", "UE", (UE) listue.getSelectedItem())){
				lblVousNavezPas.setVisible(true);
			}			
			//si tout est rempli
			else {
				ue = (UE) listue.getSelectedItem();

				ArrayList<Etudiant> etudlist= new ArrayList<Etudiant>();
				ArrayList<ECUE> lesecue = new ArrayList<ECUE>();
				lesecue = Facade.getListeECUE(ue);
				ArrayList<String> ine = new ArrayList<String>();
				
				for (ECUE mat : lesecue){
					ArrayList<Etudiant> letud = Facade.getListeEtudECUE(mat);
				for (Etudiant etud : letud/*mat.getListeEtud()*/){
					if(ine.contains(etud.getNumINE())==false){
						etudlist.add(etud);
						ine.add(etud.getNumINE());
					}
				}
				
				}
				for(Etudiant et : etudlist){
					Vector rowData = new Vector () ;
					rowData.add(et.getNom());
					rowData.add(et.getPrenom());
					rowData.add(Facade.moyenneEtudiantUE(ue, et));
					modele.addRow(rowData);
				}
				
				
				table.setModel(modele); 
	            table.repaint(); 
	         	setContentPane(contentPane);

			
			}
			
			}


				
			});
		
		
		for(Departement d : Facade.getListeDepartement())
			listdep.addItem(d);

		// ACTION DU BOUTON POUR VALIDER LE CHOIX DU DEPARTEMENT
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVousNavezPas.setVisible(false);
				
				listann.removeAllItems();
				listsem.removeAllItems();
				listue.removeAllItems();
				
				dept = (Departement) listdep.getSelectedItem();
                ArrayList<Annee> a;
    
                
                a = Facade.getListeAnnee(dept);
                
               
                for (Iterator<Annee> i =a.iterator(); i.hasNext();) {
                Annee an = (Annee)i.next();
                listann.addItem(an);}
                
                a.clear(); // on vide l'arraylist pour �viter les doublons
				
				
			}
		});
		
		// ACTION DU BOUTON POUR VALIDER LE CHOIX DE l'ANNEE
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVousNavezPas.setVisible(false);
				
				listsem.removeAllItems();
				listue.removeAllItems();
				an = (Annee) listann.getSelectedItem();
                ArrayList<Semestre> s;
    
                
                s = Facade.getListeSemestre(an);
                
               
                for (Iterator<Semestre> i =s.iterator(); i.hasNext();) {
                Semestre sem = (Semestre)i.next();
                listsem.addItem(sem);}
                
                s.clear(); // on vide l'arraylist pour �viter les doublons
				
				
				
			}
		});

		
		
		// ACTION DU BOUTON POUR VALIDER LE CHOIX DU SEMESTRE
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVousNavezPas.setVisible(false);
				
				listue.removeAllItems();
				sem = (Semestre) listsem.getSelectedItem();
                ArrayList<UE> u;
    
                
                u = Facade.getListeUE(sem);
                
               
                for (Iterator<UE> i =u.iterator(); i.hasNext();) {
                UE ue = (UE)i.next();
                listue.addItem(ue);}
                
                u.clear(); // on vide l'arraylist pour �viter les doublons
				
				
				
			}
		});
		
    
    this.setVisible(true);

    
}
	
	public boolean isCellEditale(int x, int y){
		return false;
	}
	
	private void cleanList(JComboBox c){
		c.removeAllItems();
//		c.addItem(new Model(""));
	}
	
	   void deleteTable(DefaultTableModel mod) 
	    { 
	 while (mod.getRowCount() > 0) 
	     mod.removeRow(0); 
	    } 
}

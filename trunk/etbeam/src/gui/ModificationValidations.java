package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.CellEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.tree.TreeCellEditor;
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

public class ModificationValidations extends JFrame{
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
	private final JLabel lblSlectionSemestre = new JLabel("S\u00E9lection Semestre");
	private final JLabel lblSlectionUe = new JLabel("Selection UE");
	private final JButton button = new JButton("Sauvegarder");
	int colIndSession = 4;
	
	ArrayList<Etudiant> etudlist = new ArrayList<Etudiant>();	//liste des etudiants actuellemnt affiches
	 

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ModificationValidations() throws Exception {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 376);
		setTitle("Validation Unite d'Enseignement(points jury)");
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
		charger.setBounds(42, 302, 206, 32);
		contentPane.add(charger);

		

		btnNewButton.setBounds(185, 53, 63, 20);
		contentPane.add(btnNewButton);

		btnNewButton_1.setBounds(183, 94, 65, 20);
		
		contentPane.add(btnNewButton_1);
		btnNewButton_2.setBounds(185, 142, 63, 20);
		
		contentPane.add(btnNewButton_2);
		scrollPane.setBounds(273, 28, 462, 256);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);


		
		table.setCellSelectionEnabled(false);

		
		table.setVisible(true);	

		modele.addColumn("INE");
		modele.addColumn("Nom");
		modele.addColumn("Prenom");
		modele.addColumn("Moyenne");
		modele.addColumn("Points jury");
		modele.addColumn("Validation");
		

		lblSlectionDpartement.setBounds(42, 40, 170, 14);
		contentPane.add(lblSlectionDpartement);
		lblSlectionAnne.setBounds(42, 81, 160, 14);
		
		contentPane.add(lblSlectionAnne);
		lblSlectionSemestre.setBounds(42, 129, 152, 14);
		
		contentPane.add(lblSlectionSemestre);
		lblSlectionUe.setBounds(42, 179, 106, 14);
		
		contentPane.add(lblSlectionUe);
		button.setBounds(529, 302, 206, 32);
		
		contentPane.add(button);

		
		
		charger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				deleteTable(modele);
			
				//this.setTitle("tableau r�capitulatif des moyennes");
				//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				//setContentPane(container);
				//contentPane.setLayout(new BorderLayout());
				//listdep.setFocusTraversalKeysEnabled(false);
			
			// si l'un des quatres elements a choisir est nul, on refuse la validation et on avertit l'utilisateur
			if (listdep.getSelectedItem() == null || listann.getSelectedItem() == null|| listsem.getSelectedItem() == null
				|| listue.getSelectedItem() == null){
				
				javax.swing.JOptionPane.showMessageDialog(null,"Veuillez bien selectionner tous les parametres"); 
			}
			
			//si tout est rempli
			else {
				ue = (UE) listue.getSelectedItem();
								
				etudlist= new ArrayList<Etudiant>();
				ArrayList<ECUE> lesecue = new ArrayList<ECUE>();
				lesecue = Facade.getListeECUE(ue);
				
				ArrayList<String> ine = new ArrayList<String>();
				
				for (ECUE mat : lesecue){
					ArrayList<Etudiant> letud = mat.getListeEtud();
				for (Etudiant etud : letud){
					if(ine.contains(etud.getNumINE())==false){
						etudlist.add(etud);
						ine.add(etud.getNumINE());
					}
				}
				
				}
				float moy = 0;
				float pts = 0;
				for(Etudiant et : etudlist){
					pts = Facade.getPtsJuryUE(ue, et);
					moy=(float) Facade.moyenneEtudiantUE(ue, et);
					Vector rowData = new Vector () ;
					rowData.add(et.getNumINE());
					rowData.add(et.getNom());
					rowData.add(et.getPrenom());
					rowData.add(moy);
					rowData.add(pts);
					if ((pts+moy)>=10){
					//rowData.add(new ImageIcon(EtBeamGui.class.getResource("/images/res/coche.gif")));
					rowData.add("ok");
					}
					else {
						rowData.add(" ");
					}
					
					modele.addRow(rowData);
				
				}
				
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						// On termine le mode d'�dition de la cellule pour qu'on puisse obtenir la valeur modifi�e
						CellEditor c = table.getCellEditor(); 
						c.stopCellEditing();
						
						for(int i= 0; i<table.getModel().getRowCount();i++){
							
								Float pts = Float.parseFloat((table.getModel().getValueAt(i, colIndSession)).toString());
								Facade.ajoutPointsUE(ue, etudlist.get(i), pts);
						}
					}
				});
				
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


 


package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class ConsultationECUE extends JFrame{
	private static Boolean alive = true;
	//Currently selected ressources
	//private Utilisateur user = null;
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
	private JTable table= new JTable();
	private DefaultTableModel modele = (DefaultTableModel)table.getModel();
	private JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblSlectionDpartement = new JLabel("S\u00E9lection D\u00E9partement");
	private final JLabel lblSlectionAnne = new JLabel("S\u00E9lection Ann\u00E9e");
	private final JLabel lblSlectionSemestre = new JLabel("S\u00E9lection Semestre");
	private final JLabel lblSlectionUe = new JLabel("S\u00E9lection UE");
	private final JLabel lblSlectionEcue = new JLabel("S\u00E9lection ECUE");
	
	
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
	public ConsultationECUE() throws Exception {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 376);
		setTitle("Consultation Matière");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listdep.setFocusTraversalKeysEnabled(false);
	
		// Listes dï¿½roulantes de sï¿½lection 
		listdep.setBounds(42, 53, 140, 20);
		contentPane.add(listdep);
		//listdep.addItem("");
		
		listann.setBounds(42, 94, 140, 20);
		contentPane.add(listann);

		listsem.setBounds(42, 142, 140, 20);
		contentPane.add(listsem);

		listue.setBounds(42, 192, 140, 20);
		contentPane.add(listue);
		
		listecue.setBounds(42, 239, 140, 20);
		contentPane.add(listecue);
		
		
		//Bouton de chargement
		JButton charger = new JButton("Charger");
		charger.setBounds(42, 280, 206, 32);
		contentPane.add(charger);
		
		

		OK2.setBounds(185, 53, 63, 20);
		contentPane.add(OK2);

		OK1.setBounds(183, 94, 65, 20);
		
		contentPane.add(OK1);
		OK3.setBounds(185, 142, 63, 20);
		
		contentPane.add(OK3);
		scrollPane.setBounds(273, 28, 462, 284);
		
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

		
		
		charger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				deleteTable(modele); //réinitialisation de la table

			
			// si l'un des quatres elements a choisir est nul, on refuse la validation et on avertit l'utilisateur
			if (listdep.getSelectedItem() == null || listann.getSelectedItem() == null|| listsem.getSelectedItem() == null
				|| listue.getSelectedItem() == null){
				
				javax.swing.JOptionPane.showMessageDialog(null,"Veuillez bien selectionner tous les parametres"); 
			}
			
			//si tout est rempli
			else {
				ecue = (ECUE) listecue.getSelectedItem();
				ArrayList<Etudiant> etudlist= new ArrayList<Etudiant>();
				try {
					etudlist = Facade.getListeEtudECUE(ecue);
					
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}


				for(Etudiant et : etudlist){
					Vector rowData = new Vector () ;
					rowData.add(et.getNom());
					rowData.add(et.getPrenom());
					rowData.add(ecue.getEtudiantNote(et, 1));
					rowData.add(ecue.getEtudiantNote(et, 2));
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
		OK2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listann.removeAllItems();
				listsem.removeAllItems();
				listue.removeAllItems();
				listecue.removeAllItems();
				
				dept = (Departement) listdep.getSelectedItem();
                ArrayList<Annee> a;
    
                
                a = Facade.getListeAnnee(dept);
                
               
                for (Iterator<Annee> i =a.iterator(); i.hasNext();) {
                Annee an = (Annee)i.next();
                listann.addItem(an);}
                
                a.clear(); // on vide l'arraylist pour ï¿½viter les doublons
				
				
			}
		});
		
		// ACTION DU BOUTON POUR VALIDER LE CHOIX DE l'ANNEE
		OK1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listsem.removeAllItems();
				listue.removeAllItems();
				listecue.removeAllItems();
				
				an = (Annee) listann.getSelectedItem();
                ArrayList<Semestre> s;
    
                
                s = Facade.getListeSemestre(an);
                
               
                for (Iterator<Semestre> i =s.iterator(); i.hasNext();) {
                Semestre sem = (Semestre)i.next();
                listsem.addItem(sem);}
                
                s.clear(); // on vide l'arraylist pour ï¿½viter les doublons
				
				
				
			}
		});

		
		
		// ACTION DU BOUTON POUR VALIDER LE CHOIX DU SEMESTRE
		OK3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listue.removeAllItems();
				listecue.removeAllItems();
				
				sem = (Semestre) listsem.getSelectedItem();
                ArrayList<UE> u;
    
                
                u = Facade.getListeUE(sem);
                
               
                for (Iterator<UE> i =u.iterator(); i.hasNext();) {
                UE ue = (UE)i.next();
                listue.addItem(ue);}
                
                u.clear(); // on vide l'arraylist pour ï¿½viter les doublons
				
				
				
			}
		});
		
		
		// ACTION DU BOUTON POUR VALIDER LE CHOIX DE l'UE
		OK4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listecue.removeAllItems();
				ue = (UE) listue.getSelectedItem();
                ArrayList<ECUE> ecu;
    
                
                ecu = Facade.getListeECUE(ue);
               
                for (Iterator<ECUE> i =ecu.iterator(); i.hasNext();) {
                ECUE ecue = (ECUE)i.next();
                listecue.addItem(ecue);}
                
                ecu.clear(); // on vide l'arraylist pour ï¿½viter les doublons
				
				
				
			}
		});

		
		/*listdep.addActionListener(new ActionListener () {
		
			public void actionPerformed(ActionEvent e) {
				
				  listann.removeAllItems();
				System.out.println("DEpt"+e.getActionCommand());

				dept = (Departement) listdep.getSelectedItem();
				

                ArrayList<Annee> a;
                
                
                // on efface le contenu des listes suivantes
                listann.removeAllItems();
                listsem.removeAllItems();
                listue.removeAllItems();
                

                 
                  
                
                a = Facade.getListeAnnee(dept);
                
               
                for (Iterator<Annee> i =a.iterator(); i.hasNext();) {
                Annee an = (Annee)i.next();
                listann.addItem(an);}
                
                a.clear(); // on vide l'arraylist pour ï¿½viter les doublons
		}});

        listann.addActionListener(new ActionListener () {
            
            public void actionPerformed(ActionEvent e) {
                    System.out.println("Annee"+e.getActionCommand());
                    
                    annee = (Annee) listann.getSelectedItem();
                    
                    cleanList(listsem);
                    cleanList(listue);              
                    
                    ArrayList<Semestre> s;
                   s = Facade.getListeSemestre(annee);
                    
                    
                    for (Iterator<Semestre> i =s.iterator(); i.hasNext();) {
                    Semestre sem = (Semestre)i.next();
                    listsem.addItem(sem);}
                    
                    s.clear(); // on vide l'arraylist pour ï¿½viter les doublons

        }
    });

    
    
    
    listsem.addActionListener(new ActionListener () {

            public void actionPerformed(ActionEvent e) {
                   /* System.out.println("Sem "+e.getActionCommand());
                    System.out.println("Sem "+e.getID());
                    System.out.println("Sem "+e.getSource().toString());
                    
                    sem = (Semestre) listsem.getSelectedItem();
                    
                    sem.load();

                    
                    cleanList(listue);
                    
                    for(UE ue : Facade.getListeUE(sem))
                            listue.addItem(ue);*/
	//}
   // });
    
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

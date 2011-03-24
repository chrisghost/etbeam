package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import bd.Facade;
import bd.MySQL;

import models.Annee;
import models.Departement;
import models.ECUE;
import models.EtudManager;
import models.Etudiant;
import models.Semestre;
import models.UE;
import models.Utilisateur;
import models.mysql.EtudiantMySQL;
import javax.swing.JButton;

public class EtBeamGui extends JFrame implements EtBeamIF {
	private static Boolean alive = true;
	private JPanel contentPane;
	//Currently selected ressources
	private Utilisateur user = null;
	private Departement dept = null;
	private Annee annee = null;
	private Semestre sem = null;
	private UE ue = null;
	private ECUE ecue = null;
	private JComboBox listdep = new JComboBox();
	private JComboBox listann = new JComboBox();
	private JComboBox listsem = new JComboBox();
	private JComboBox listue = new JComboBox();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			
			public void run() {
				try {
					
					
					login();
					//POUR LE TEST DU REMPLISSAGE deETUDMANAGER (a virer apres avoir fait la bonne fonction de load);

					loadetudman();
					
				//FIN
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
	 * @throws Exception 
	 */
	public EtBeamGui() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		// Listes d�roulantes de s�lection 
		listdep.setBounds(42, 53, 121, 20);
		contentPane.add(listdep);
		listdep.addItem("");
		
		listann.setBounds(204, 53, 129, 20);
		contentPane.add(listann);

		listsem.setBounds(382, 53, 140, 20);
		contentPane.add(listsem);

		listue.setBounds(570, 53, 160, 20);
		contentPane.add(listue);
		
		//Bouton de chargement
		JButton charger = new JButton("Charger");
		charger.setBounds(286, 98, 140, 32);
		contentPane.add(charger);

		charger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
						// si l'un des quatres �l�ments � choisir est nul, on refuse la validation et on avertit l'utilisateur
						if (listdep.getSelectedItem() == "" || listann.getSelectedItem() == ""|| listsem.getSelectedItem() == ""
							|| listue.getSelectedItem() == ""){
							
							javax.swing.JOptionPane.showMessageDialog(null,"Veuillez bien s�lectionner tout les param�tres"); 
						}
						
						else {
							

							String code, lib;
							lib = (String)listue.getSelectedItem();
							code = sem.getcodebylib(lib);
//							ue = Facade.makeUE(code, lib);
							ue = Facade.makeUE(code);
							
							ArrayList<UE> ue;
							
						}
				
			}
		});
		

		

		
		ArrayList<Departement> dep = Facade.getListeDepartement();
		//Ajout des d�partements
		
		for (Iterator<Departement> i =dep.iterator(); i.hasNext();) {
        	Departement depart = (Departement)i.next();
        	listdep.addItem(depart.getMnemo());
        	
          }
		
		

		
		
		listdep.addActionListener(new ActionListener () {
		
			public void actionPerformed(ActionEvent e) {
		        
				if (listdep.getSelectedItem() == ""){
					listann.removeAllItems();
					listsem.removeAllItems();
					listue.removeAllItems();		
				}
				else {
				dept = Facade.makeDepartement((String)listdep.getSelectedItem());
				
				ArrayList<Annee> a;
				
				
				// on efface le contenu des listes suivantes
				listann.removeAllItems();
				listsem.removeAllItems();
				listue.removeAllItems();
				
				
				try {
					a = Facade.getListeAnnee(dept);
					//Affichage des ann�es
					listann.addItem("");
					for (Iterator<Annee> i =a.iterator(); i.hasNext();) {
			        	Annee an = (Annee)i.next();
			        	listann.addItem(an.getMnemo());
			        	
			          }
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

		    	System.out.println(listdep.getSelectedItem());
		    	
		    }

		}});

		
		
		listann.addActionListener(new ActionListener () {
		
			public void actionPerformed(ActionEvent e) {
		        		
				if (listann.getSelectedItem() == ""){
					listsem.removeAllItems();
					listue.removeAllItems();		
				}
				else {
				//On a besoin du code annee pour executer la requ�te SQL 
				//Donc on appelle getcodebylib qui va renvoyer le code pour un libell�.
					
					String code, lib;
					lib = (String)listann.getSelectedItem();
					if (dept.getLesAnnees().isEmpty()){
					}
					System.out.println(lib);
					
					code = dept.getcodebylib(lib);
					annee = Facade.makeAnnee(code);
				//annee = Facade.makeAnnee((String)listann.getSelectedItem());
				
				ArrayList<Semestre> Sems ;
				
				
				// on efface le contenu des listes suivantes
				listsem.removeAllItems();
				listue.removeAllItems();

				
				
				try {
					Sems = Facade.getListeSemestre(annee);
					listsem.addItem("");
					
					//AFFICHAGE DES ETUDIANTS
					
					for (Iterator<Semestre> i =Sems.iterator(); i.hasNext();) {
			        	Semestre semestre = (Semestre)i.next();
			        	listsem.addItem(semestre.getLibelleSem());
			        	
			          }
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

		    	System.out.println(listsem.getSelectedItem());
		    	
		    }

		}});

		
		
		
		listsem.addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
		        
				
				if (listsem.getSelectedItem() == ""){
					listue.removeAllItems();		
				}
				else {
				
				
				String code, lib;
				lib = (String)listsem.getSelectedItem();
				code = annee.getcodebylib(lib);
				sem = Facade.makeSemestre(code);
				
				
				ArrayList<UE> ue;
				
				
				// on efface le contenu des listes suivantes
				listue.removeAllItems();

				
				
				try {
					ue = Facade.getListeUE(sem);
					listue.addItem("");
					sem.setLesUE(ue);
				
					//AFFICHAGE DES ETUDIANTS
					
					for (Iterator<UE> i =ue.iterator(); i.hasNext();) {
			        	UE unitens = (UE)i.next();
			        	listue.addItem(unitens.getLibelleUE());
			        	
			          }
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

		    	System.out.println(listue.getSelectedItem());
		    	
		    }

		}});
		
		
		
		


		
	}
	
	
	public static void loadetudman() throws SQLException{	
		//TEST POUR REMPLIR LE ETUDMANAGER
		//!!!penser a enlever les imports necessaires apres!!!
		MySQL base = (MySQL) Facade.getBD();
		ResultSet r,t = null;
		
			r = base.execute("SELECT num_ine FROM etudiant");
		
			
		
			while (r.next()){
				
				Etudiant etud = new EtudiantMySQL();
				
				t = base.execute("SELECT * FROM etudiant WHERE num_ine ="+r.getString("num_ine"));
				
				while (t.next()){
				etud.setNom(t.getString("nom"));
				etud.setPrenom(t.getString("prenom"));
				etud.setNumINE(t.getString("num_ine"));
				}

				EtudManager.getInstance().addEtudiant(etud);	
}
		
	}		// FIN DU TEST
	
	private static void login() {
		//String login = console.readLine("Login: ");
		char[] password;
		String str="b";
		password=str.toCharArray();
		
		System.out.println(password);
		Utilisateur u = Facade.makeUtilisateur("a",password);

		u.connect();

		alive = u.getLogged();
		
		if(alive){	//Utilisateure connecté
			//console.printf("Succesfully connected as "+u.getLogin()+"\n");
		}else{
			//console.printf("Bad login/password match for user "+u.getLogin()+"\n");
		}
	}

	@Override
	public void main() {
	}
}

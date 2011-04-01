package gui;


import java.awt.BorderLayout;
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
	import javax.swing.border.EmptyBorder;
	import javax.swing.event.ListDataListener;
	import javax.swing.table.DefaultTableModel;
	import javax.swing.JComboBox;

	import bd.Facade;
	import bd.FacadeAdmin;
	import bd.MySQL;

	import models.Annee;
	import models.Departement;
	import models.ECUE;
import models.Enseignant;
	import models.EtudManager;
	import models.Etudiant;
	import models.Model;
	import models.Semestre;
	import models.UE;
	import models.Enseignant;
	import models.Utilisateur;
	import models.mysql.EtudiantMySQL;
	import javax.swing.JButton;
	import javax.swing.JScrollPane;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
	
public class CompteUtilisateurAdmin  extends JFrame{
		
		private static Boolean alive = true;
		//Currently selected ressources
		//private Utilisateur user = null;
		private Departement dept = null;
		private Semestre sem = null;
		private UE ue = null;
		private Annee an = null;
		private ECUE ecue = null;
		private Enseignant enseignant;
		private Utilisateur u;
		private final JButton OK1 = new JButton("OK");
		private JPanel contentPane = new JPanel();
		private final JLabel login = new JLabel("Rentrer un login");
		private final JLabel mdp = new JLabel("Rentrer un mot de passe");
		private final JLabel identifiant = new JLabel("Rentrer un identifiant");
		private final JLabel id_enseignant = new JLabel("Rentrer l'id enseignant associe");
		private final JLabel lblPrnom = new JLabel("Prenom");
		private final JLabel lblNom = new JLabel("Nom");
		private final JLabel lblOption = new JLabel(" --------- Champs optionnels --------- ");
		private final JLabel lblEmail = new JLabel("Email");
		private final JTextField tlog = new JTextField();
		private final JTextField tmdp = new JTextField();
		private final JTextField tid = new JTextField();
		private final JTextField tid_ens = new JTextField();
		private final JTextField mail = new JTextField();
		private final JTextField nom = new JTextField();
		private final JTextField prenom = new JTextField();


		/**
		 * Create the frame.
		 * @throws Exception 
		 */
		public CompteUtilisateurAdmin() throws Exception {
			setIconImage(Toolkit.getDefaultToolkit().getImage(EtBeamGui.class.getResource("/images/res/logo_trans.png")));
			
			setBounds(100, 100, 448, 464);
			setTitle("Creation de compte utilisateur");
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			//Jpanel
			login.setBounds(47, 12, 170, 14);
			contentPane.add(login);
			
			mdp.setBounds(47, 49, 184, 14);
			contentPane.add(mdp);
			
			identifiant.setBounds(47, 86, 170, 14);
			contentPane.add(identifiant);
			
			id_enseignant.setBounds(47, 120, 239, 14);
			contentPane.add(id_enseignant);
			
			lblNom.setBounds(64, 231, 81, 14);
			contentPane.add(lblNom);
			
			lblPrnom.setBounds(64, 281, 81, 14);
			contentPane.add(lblPrnom);
			
			lblEmail.setBounds(64, 337, 81, 14);
			contentPane.add(lblEmail);
			
			
			lblOption.setBounds(64, 179, 334, 30);
			contentPane.add(lblOption);
			lblOption.setForeground(Color.BLUE);
			lblOption.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 14));
			
			//Jtext
			nom.setBounds(137, 227, 105, 23);
			nom.setColumns(10);
			contentPane.add(nom);
			
			tlog.setBounds(276, 8, 105, 23);
			tlog.setColumns(12);
			contentPane.add(tlog);
			
			tmdp.setBounds(276, 45, 105, 23);
			tmdp.setColumns(14);
			contentPane.add(tmdp);
			
			tid.setBounds(276, 82, 105, 23);
			tid.setColumns(15);
			contentPane.add(tid);
			
			tid_ens.setBounds(276, 116, 105, 23);
			tid_ens.setColumns(18);
			contentPane.add(tid_ens);
						
			prenom.setColumns(10);
			prenom.setBounds(137, 277, 117, 23);
			contentPane.add(prenom);
			
			mail.setColumns(10);
			mail.setBounds(132, 333, 154, 23);
			contentPane.add(mail);
			
			//bonton de validation
			OK1.setBounds(319, 391, 81, 23);
			contentPane.add(OK1);
			


			// ACTION DU BOUTON POUR VALIDER LA RECHERCHE
			OK1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
					
					//FacadeAdmin.saveEnseignant(enseignant, nom.getText(), prenom.getText(), mail.getText(), id_enseignant.getText());
					FacadeAdmin.saveUtilisateur(u, tlog.getText(), tmdp.getText(), tid.getText(), tid_ens.getText());;
				}});

	    
	    this.setVisible(true);

	    
	}
		
		public boolean isCellEditale(int x, int y){
			return false;
		}
		
		private void cleanList(JComboBox c){
			c.removeAllItems();
		}
		
		   void deleteTable(DefaultTableModel mod) 
		    { 
		 while (mod.getRowCount() > 0) 
		     mod.removeRow(0); 
		    } 
	}


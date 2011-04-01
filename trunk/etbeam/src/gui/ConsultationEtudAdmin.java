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
import bd.FacadeAdmin;
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
import javax.swing.JTextField;

public class ConsultationEtudAdmin extends JFrame{
	private static Boolean alive = true;
	//Currently selected ressources
	//private Utilisateur user = null;
	private Departement dept = null;
	private Semestre sem = null;
	private UE ue = null;
	private Annee an = null;
	private ECUE ecue = null;
	private final JButton OK2 = new JButton("OK");
	private final JButton OK1 = new JButton("OK");
	private JPanel contentPane = new JPanel();
	private final JLabel rechercheetud = new JLabel("Recherche Etudiant (Nom)");
	private JTextField recherche;
	private JComboBox listetud = new JComboBox();
	private final JTextField mail = new JTextField();
	private final JTextField numINE = new JTextField();
	private final JTextField nom = new JTextField();
	private final JTextField numetud = new JTextField();
	private final JTextField prenom = new JTextField();
	private final JTextField Toeic = new JTextField();
	private final JLabel lblScoreToeic = new JLabel("Score TOEIC");
	private final JTextField pjury = new JTextField();
	private final JLabel lblPointsJuryAnne = new JLabel("Points jury annee");
	private JTextField textField;
	private final JTextField provenance = new JTextField();
	private final JLabel lblProvenance = new JLabel("Provenance");
	private final JTextField comJury = new JTextField();
	private final JLabel lblCommentaireJury = new JLabel("Commentaire Jury");
	private final JTextField annee = new JTextField();
	private final JLabel lblAnnee = new JLabel("Annee");
	
	
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
	public ConsultationEtudAdmin() throws Exception {
		comJury.setBounds(64, 429, 268, 62);
		comJury.setColumns(10);
		Toeic.setBounds(258, 365, 105, 23);
		Toeic.setColumns(10);
		numetud.setBounds(258, 233, 116, 22);
		numetud.setColumns(10);
		nom.setBounds(64, 185, 105, 23);
		nom.setColumns(10);
		numINE.setBounds(64, 233, 105, 23);
		numINE.setColumns(10);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 549);
		setTitle("Consultation Etudiant");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		OK1.setBounds(258, 25, 81, 23);
		contentPane.add(OK1);


	
		rechercheetud.setBounds(75, 11, 170, 14);
		contentPane.add(rechercheetud);
		
		recherche = new JTextField();
		recherche.setBounds(75, 26, 173, 20);
		contentPane.add(recherche);
		recherche.setColumns(10);
		
		contentPane.add(numINE);
		
		contentPane.add(nom);
		
		contentPane.add(numetud);
		prenom.setColumns(10);
		prenom.setBounds(258, 185, 117, 23);
		
		contentPane.add(prenom);
		

		listetud.setBounds(75, 78, 170, 23);
		contentPane.add(listetud);
		
	
		OK2.setBounds(258, 78, 81, 23);
		contentPane.add(OK2);
		
		JLabel lblNumroIne = new JLabel("Numero INE");
		lblNumroIne.setBounds(64, 219, 170, 14);
		contentPane.add(lblNumroIne);
		
		JLabel lblNumroEtudiant = new JLabel("Numero Etudiant");
		lblNumroEtudiant.setBounds(258, 219, 82, 14);
		contentPane.add(lblNumroEtudiant);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(64, 169, 81, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Prenom");
		lblPrnom.setBounds(258, 169, 81, 14);
		contentPane.add(lblPrnom);
		
		contentPane.add(Toeic);
		lblScoreToeic.setBounds(258, 351, 81, 14);
		
		contentPane.add(lblScoreToeic);
		pjury.setColumns(10);
		pjury.setBounds(64, 365, 105, 23);
		
		contentPane.add(pjury);
		lblPointsJuryAnne.setBounds(64, 351, 116, 14);
		
		contentPane.add(lblPointsJuryAnne);
		
	
		mail.setColumns(10);
		mail.setBounds(65, 298, 154, 23);
		contentPane.add(mail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(64, 285, 81, 14);
		contentPane.add(lblEmail);
		provenance.setColumns(10);
		provenance.setBounds(258, 298, 81, 23);
		
		contentPane.add(provenance);
		lblProvenance.setBounds(258, 285, 81, 14);
		
		contentPane.add(lblProvenance);
		
		contentPane.add(comJury);
		lblCommentaireJury.setBounds(64, 415, 105, 14);
		
		contentPane.add(lblCommentaireJury);
		annee.setColumns(10);
		annee.setBounds(64, 135, 63, 23);
		
		contentPane.add(annee);
		lblAnnee.setBounds(64, 122, 81, 14);
		
		contentPane.add(lblAnnee);
		


		// ACTION DU BOUTON POUR VALIDER LA RECHERCHE
		OK1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cleanList(listetud);
				
				if (!(recherche.getText().isEmpty()))
				{
				ArrayList <Etudiant> resultat = new ArrayList();
				try {
					resultat = FacadeAdmin.getInstance().searchEtud(recherche.getText());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
    
           
                for (Iterator<Etudiant> i =resultat.iterator(); i.hasNext();) {
                Etudiant et = (Etudiant)i.next();
                listetud.addItem(et);}
                
                resultat.clear(); // on vide l'arraylist pour eviter les doublons
				
				
			}}
		});


		// ACTION DU BOUTON POUR VALIDER LE CHOIX DE L'ETUDIANT
		OK2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
				Etudiant et = (Etudiant)listetud.getSelectedItem();
				nom.setText(et.getNom());
				numetud.setText(et.getNumEtud());
				prenom.setText(et.getPrenom());
				Toeic.setText(String.valueOf(et.getScoreTOEIC()));
				pjury.setText(String.valueOf(et.getPtsJury()));	
				numINE.setText(et.getNumINE());
				mail.setText(et.getMail());
				provenance.setText(et.getProvenance());
				comJury.setText(et.getcomJury());
				annee.setText(et.getAnnee());
				
			}
		});

    
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

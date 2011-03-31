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

public class ConsultationEtud extends JFrame{
	private static Boolean alive = true;
	//Currently selected ressources
	//private Utilisateur user = null;
	private Departement dept = null;
	private Annee annee = null;
	private Semestre sem = null;
	private UE ue = null;
	private Annee an = null;
	private ECUE ecue = null;
	private final JButton OK2 = new JButton("OK");
	private final JButton OK1 = new JButton("OK");
	private JTable table= new JTable();
	private DefaultTableModel modele = (DefaultTableModel)table.getModel();
	private JPanel contentPane = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblSlectionDpartement = new JLabel("Recherche Etudiant (Nom)");
	private JTextField recherche;
	private JComboBox listetud = new JComboBox();
	private final JTextField numINE = new JTextField();
	private final JTextField nom = new JTextField();
	private final JTextField numetud = new JTextField();
	private final JTextField prenom = new JTextField();
	private final JTextField Toeic = new JTextField();
	private final JLabel lblScoreToeic = new JLabel("Score TOEIC");
	private final JTextField pjury = new JTextField();
	private final JLabel lblPointsJuryAnne = new JLabel("Points jury annee");
	
	
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
	public ConsultationEtud() throws Exception {
		Toeic.setBounds(64, 295, 105, 23);
		Toeic.setColumns(10);
		numetud.setBounds(258, 245, 116, 22);
		numetud.setColumns(10);
		nom.setBounds(64, 183, 105, 23);
		nom.setColumns(10);
		numINE.setBounds(64, 245, 105, 23);
		numINE.setColumns(10);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 540);
		setTitle("Consultation Etudiant");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		OK1.setBounds(258, 25, 81, 23);
		contentPane.add(OK1);
		scrollPane.setBounds(35, 342, 362, 149);
			
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
			
		table.setCellSelectionEnabled(false);
		table.setVisible(true);	

		modele.addColumn("Nom");
		modele.addColumn("Prenom");
		modele.addColumn("Session 1");
		modele.addColumn("Session 2");
		
		table.setCellSelectionEnabled(false);	
		
	
		lblSlectionDpartement.setBounds(101, 11, 170, 14);
		contentPane.add(lblSlectionDpartement);
		
		recherche = new JTextField();
		recherche.setBounds(75, 26, 173, 20);
		contentPane.add(recherche);
		recherche.setColumns(10);
		
		contentPane.add(numINE);
		
		contentPane.add(nom);
		
		contentPane.add(numetud);
		prenom.setColumns(10);
		prenom.setBounds(258, 183, 117, 23);
		
		contentPane.add(prenom);
		

		listetud.setBounds(75, 78, 170, 23);
		contentPane.add(listetud);
		
	
		OK2.setBounds(258, 78, 81, 23);
		contentPane.add(OK2);
		
		JLabel lblNumroIne = new JLabel("Numero INE");
		lblNumroIne.setBounds(90, 232, 170, 14);
		contentPane.add(lblNumroIne);
		
		JLabel lblNumroEtudiant = new JLabel("Numero Etudiant");
		lblNumroEtudiant.setBounds(270, 232, 82, 14);
		contentPane.add(lblNumroEtudiant);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(101, 169, 81, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Prenom");
		lblPrnom.setBounds(293, 169, 81, 14);
		contentPane.add(lblPrnom);
		
		contentPane.add(Toeic);
		lblScoreToeic.setBounds(88, 282, 81, 14);
		
		contentPane.add(lblScoreToeic);
		pjury.setColumns(10);
		pjury.setBounds(258, 296, 105, 23);
		
		contentPane.add(pjury);
		lblPointsJuryAnne.setBounds(268, 282, 116, 14);
		
		contentPane.add(lblPointsJuryAnne);
		


		// ACTION DU BOUTON POUR VALIDER LA RECHERCHE
		OK1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listetud.removeAllItems();
				
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
                
                resultat.clear(); // on vide l'arraylist pour �viter les doublons
				
				
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

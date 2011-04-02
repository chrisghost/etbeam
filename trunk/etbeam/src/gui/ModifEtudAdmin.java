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

public class ModifEtudAdmin extends JFrame{
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
	private final JTextField nom = new JTextField();
	private final JTextField prenom = new JTextField();
	private JTextField textField;
	private final JTextField provenance = new JTextField();
	private final JLabel lblProvenance = new JLabel("Provenance");
	private Etudiant selectedEtud;
	
	
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
	public ModifEtudAdmin() throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EtBeamGui.class.getResource("/images/res/logo_trans.png")));
		nom.setBounds(75, 139, 105, 23);
		nom.setColumns(10);
		setBounds(100, 100, 448, 290);
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
		
		contentPane.add(nom);
		prenom.setColumns(10);
		prenom.setBounds(269, 139, 117, 23);
		
		contentPane.add(prenom);
		

		listetud.setBounds(75, 78, 170, 23);
		contentPane.add(listetud);
		
	
		OK2.setBounds(258, 78, 81, 23);
		contentPane.add(OK2);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(75, 123, 81, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Prenom");
		lblPrnom.setBounds(269, 123, 81, 14);
		contentPane.add(lblPrnom);
		
	
		mail.setColumns(10);
		mail.setBounds(76, 187, 154, 23);
		contentPane.add(mail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(75, 174, 81, 14);
		contentPane.add(lblEmail);
		provenance.setColumns(10);
		provenance.setBounds(269, 187, 81, 23);
		
		contentPane.add(provenance);
		lblProvenance.setBounds(269, 174, 176, 14);
		
		contentPane.add(lblProvenance);
		
		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Etudiant e = Facade.getInstance().makeEtudiant();
				e.setNom(nom.getText());
				e.setPrenom(prenom.getText());
				e.setMail(mail.getText());
				e.setNumINE(selectedEtud.getNumINE());
				e.setProvenance(provenance.getText());
				e.save();
				
				EtudManager.getInstance().changeEtudiant(e);
			}
		});
		btnSauvegarder.setBounds(156, 222, 139, 25);
		contentPane.add(btnSauvegarder);
		


		// ACTION DU BOUTON POUR VALIDER LA RECHERCHE
		OK1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cleanList(listetud);
				
				if (!(recherche.getText().isEmpty()))
				{
				ArrayList <Etudiant> resultat = new ArrayList<Etudiant>();
				resultat = FacadeAdmin.getInstance().searchEtud(recherche.getText());
				 
    
           
                for (Iterator<Etudiant> i =resultat.iterator(); i.hasNext();) {
                Etudiant et = (Etudiant)i.next();
                listetud.addItem(et);}
                
                resultat.clear(); // on vide l'arraylist pour eviter les doublons
				
				
			}}
		});


		// ACTION DU BOUTON POUR VALIDER LE CHOIX DE L'ETUDIANT
		OK2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedEtud = (Etudiant)listetud.getSelectedItem();
				nom.setText(selectedEtud.getNom());
				prenom.setText(selectedEtud.getPrenom());
				mail.setText(selectedEtud.getMail());
				provenance.setText(selectedEtud.getProvenance());				
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

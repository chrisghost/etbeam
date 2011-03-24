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

import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
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

public class ConsultationNotes extends JFrame{
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
	 * Create the frame.
	 * @throws Exception 
	 */
	public ConsultationNotes() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listdep.setFocusTraversalKeysEnabled(false);
	
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
							

//							String code, lib;
//							lib = (String)listue.getSelectedItem();
//							code = sem.getcodebylib(lib);
////							ue = Facade.makeUE(code, lib);
//							ue = Facade.makeUE(code);
//							
//							ArrayList<UE> ue;
							
						}
				
			}
		});
		
		for(Departement d : Facade.getListeDepartement())
			listdep.addItem(d);


		listdep.addActionListener(new ActionListener () {
		
			public void actionPerformed(ActionEvent e) {
				System.out.println("DEpt"+e.getActionCommand());

				dept = (Departement) listdep.getSelectedItem();
				
				// on efface le contenu des listes suivantes
				cleanList(listann);
				cleanList(listsem);
				cleanList(listue);
				
				for(Annee annee : Facade.getListeAnnee(dept))
					listann.addItem(annee);
		}});

		
		
		listann.addActionListener(new ActionListener () {
		
			public void actionPerformed(ActionEvent e) {
				System.out.println("Annee"+e.getActionCommand());
				
				annee = (Annee) listann.getSelectedItem();
				
				cleanList(listsem);
				cleanList(listue);		
				
				for(Semestre s : Facade.getListeSemestre(annee))
					listsem.addItem(s);
		    }
		});

		
		
		
		listsem.addActionListener(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Sem "+e.getActionCommand());
				System.out.println("Sem "+e.getID());
				System.out.println("Sem "+e.getSource().toString());
				
				sem = (Semestre) listsem.getSelectedItem();
				
				sem.load();

				
				cleanList(listue);
				
				for(UE ue : Facade.getListeUE(sem))
					listue.addItem(ue);
		    }
		});
		
		this.setVisible(true);

		
	}
	
	private void cleanList(JComboBox c){
		c.removeAllItems();
//		c.addItem(new Model(""));
	}
}

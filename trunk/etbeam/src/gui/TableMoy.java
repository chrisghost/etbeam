package gui;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import models.ECUE;
import models.Etudiant;
import models.UE;

public class TableMoy extends JFrame{
	
	private UE ue;
	private JTable consult;
	private JPanel container;
	
	public TableMoy(JComboBox listdep, JComboBox listann, JComboBox listsem, JComboBox listue){
		this.setBounds(100, 100, 778, 376);
		container = new JPanel();
		this.setTitle("tableau r�capitulatif des moyennes");
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(container);
		container.setLayout(new BorderLayout());
		//listdep.setFocusTraversalKeysEnabled(false);
	
	// si l'un des quatres elements a choisir est nul, on refuse la validation et on avertit l'utilisateur
	if (listdep.getSelectedItem() == "" || listann.getSelectedItem() == ""|| listsem.getSelectedItem() == ""
		|| listue.getSelectedItem() == ""){
		
		javax.swing.JOptionPane.showMessageDialog(null,"Veuillez bien selectionner tous les parametres"); 
	}
	
	//si tout est rempli
	else {
		ue = (UE) listue.getSelectedItem();
		
			ue.load();
								
		
	String[] titreColonnes = {"matiere", 
			   "nom","prenom", "moyenne", "valid�e ?"};
	
	String[][] donnees = new String[10][6];
	for (Iterator<ECUE> i =ue.getLesECUE().iterator(); i.hasNext();){
		ECUE matiere =i.next();
		int ligne=0;
		int colonne=0;
		for (Iterator<Etudiant> ind =matiere.getListeEtud().iterator(); ind.hasNext();){
			Etudiant student = ind.next();
			donnees[ligne][colonne]=ue.getLibelleUE();
			colonne++;
			donnees[ligne][colonne]= student.getNom();
			colonne++;
			donnees[ligne][colonne]= student.getPrenom();
			colonne++;
			double moy = 0;

			moy = ue.getMoyenne(student);

			donnees[ligne][colonne]= Double.toString(moy);
			colonne++;
			if (moy>=10){
				donnees[ligne][colonne]="ACQ";
			}
			else {donnees[ligne][colonne]="nonACQ";}
			ligne++;
			colonne=0;
		}
	
	
	}
	consult = new JTable(donnees,titreColonnes);
	container.add(consult,BorderLayout.CENTER);
	
	this.setContentPane(container);
	
}
this.setVisible(true);	
}
}

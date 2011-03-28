package bd;

import java.sql.SQLException;
import java.util.ArrayList;

import models.*;

/*
 * 
 * ABSTRACT FACTORY
 * 
 */

public abstract class BD {
	
	// connexion
	public abstract boolean isConnected();
	public abstract String getConnectionInfos();
	
	
	//toutes les listes possibles



	public abstract ArrayList<Departement> getListeDepartement();
	public abstract ArrayList<ECUE> getListeECUE(UE ue);

	public abstract ArrayList<UE> getListeUE(Semestre sem);
	public abstract ArrayList<Etudiant> getListeEtudbyUE(UE ue);
	public abstract ArrayList<Semestre> getListeSemestre(Annee an);
	public abstract ArrayList<Annee> getListeAnnee() throws Exception;
	public abstract ArrayList<Annee> getListeAnnee(Departement d);
	public abstract ArrayList<Etudiant> getListeEtudECUE(ECUE ecue);
	
	
	// modification d'un etudiant : gestion etudiant
	public void setNom(Etudiant etud, String nom) throws SQLException{
		etud.setNom(nom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}
	public void setPrenom(Etudiant etud, String prenom) throws SQLException{
		etud.setPrenom(prenom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}
	
	
	//suppression d'un etudiant : gestion etudiant
//	public abstract void deleteEtudFromBD(Etudiant e) throws SQLException;
	
	
	
	//Obtention moyenne : gestion UE
	public double moyenneEtudiantUE(UE ue, Etudiant etud) throws SQLException {
		return ue.getMoyenne(etud);
	}
	
	//validation UE: gestion UE
	public abstract void validationUE(Etudiant etud, UE ue) throws SQLException;

	
	//modification coeff : gestion ECUE
	public void saveCoeff(ECUE mat) throws SQLException {
		mat.saveCoeff();
	}
	
	//modification note : gestion ECUE
	public void changeNoteEtudiantECUE(ECUE ecue, Etudiant etud, int numsess, float note) throws SQLException {
		ecue.changeNoteEtudiantECUE(etud,numsess,note);
	}
	
	// obtention note ECUE : gestion ECUE
	public abstract double noteEtudiantUE(ECUE ecue, Etudiant etud, int numsess) throws SQLException;
	
	// m�thodes make
	public abstract Annee makeAnnee(String versionEtape,String lib);
	public abstract UE makeUE(String code, String lib);
	public abstract Semestre makeSemestre(String sem, String lib);
	public abstract Etudiant makeEtudiant();
	public abstract Utilisateur makeUtilisateur(String login, char[] password);
	public abstract Departement makeDepartement(String mnemo);
	public abstract ECUE makeECUE(String ecue);
	
	
	/*public abstract ArrayList<Etudiant> loadEtudByAnnee(String an) throws Exception;
	public abstract ArrayList<Etudiant> loadEtudByUE(String ue);
	public abstract ArrayList<Annee> loadAnneeByDept(String Mnemo) throws Exception;
	public abstract ArrayList<Etudiant> loadEtudByECUE(String ecue) throws Exception;
	public abstract ArrayList<String> EnsembleAnnees(String Mnemo)throws Exception;
	*/
	
}
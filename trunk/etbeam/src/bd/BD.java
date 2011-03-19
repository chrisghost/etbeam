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
	public abstract ArrayList<Departement> getListeDepartement() throws Exception;
	public abstract ArrayList<ECUE> getListeECUE(UE ue) throws Exception;
	public abstract ArrayList<UE> getListeUE(Semestre sem) throws Exception ;
    public abstract ArrayList<Semestre> getListeSemestre(Annee an) throws Exception;
	public abstract ArrayList<Annee> getListeAnnee() throws Exception;
	public abstract ArrayList<Annee> getListeAnnee(Departement d) throws SQLException;
	
	
	
	// modification d'un etudiant : gestion etudiant
	public void setNom(Etudiant etud, String nom) throws SQLException{
		etud.setNom(nom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.saveInfoInBD();
	}
	public void setPrenom(Etudiant etud, String prenom) throws SQLException{
		etud.setPrenom(prenom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.saveInfoInBD();
	}
	
	//modification coeff : gestion ECUE
	public void saveCoeff(ECUE mat) throws SQLException {
		mat.saveCoeff();
	}
	
	
	
	// méthodes make
	public abstract Annee makeAnnee(String versionEtape);
	public abstract UE makeUE(String code);
	public abstract Semestre makeSemestre(String sem);
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
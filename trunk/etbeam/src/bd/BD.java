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
	
	public abstract boolean isConnected();
	public abstract String getConnectionInfos();
	
	public abstract ArrayList<Departement> getListeDepartement() throws Exception;
	
	public abstract ArrayList<ECUE> getListeECUE(UE ue) throws Exception;

	public abstract ArrayList<UE> getListeUE(Semestre sem) throws Exception ;

	//public abstract ArrayList<Etudiant> getListeEtudiantbyUE(UE ue);
	
    public abstract ArrayList<Semestre> getListeSemestre(Annee an) throws Exception;

	public abstract ArrayList<Annee> getListeAnnee() throws Exception;
	public abstract ArrayList<Annee> getListeAnnee(Departement d) throws SQLException;
	
	
	
	
	public abstract Annee makeAnnee(String versionEtape);

	public abstract UE makeUE(String code);

	public abstract Semestre makeSemestre(String sem);

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
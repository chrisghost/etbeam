package bd;

import java.util.ArrayList;

import models.*;

/*
 * 
 * ABSTRACT FACTORY
 * 
 */

public abstract class BD {
	
	public abstract ArrayList<Departement> getListeDepartement() throws Exception;
	
	public abstract ArrayList<ECUE> getListeECUE(UE ue) throws Exception;

	public abstract ArrayList<UE> getListeUE(Semestre sem) throws Exception ;

	public abstract ArrayList<Etudiant> getListeEtudiantbyUE(UE ue);
	
    public abstract ArrayList<Semestre> getListeSemestre(Annee an) throws Exception;
	
	/*public abstract ArrayList<Etudiant> loadEtudByAnnee(String an) throws Exception;
	public abstract ArrayList<Etudiant> loadEtudByUE(String ue);
	public abstract ArrayList<Annee> loadAnneeByDept(String Mnemo) throws Exception;
	public abstract ArrayList<Etudiant> loadEtudByECUE(String ecue) throws Exception;
	public abstract ArrayList<String> EnsembleAnnees(String Mnemo)throws Exception;
	*/
	
}
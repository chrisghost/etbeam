package bd;

import java.util.ArrayList;

import models.*;

public abstract class BD {
	
	public abstract ArrayList<Etudiant> loadEtudByAnnee(String an) throws Exception;
	public abstract ArrayList<Etudiant> loadEtudByUE(String ue);
	public abstract ArrayList<Annee> loadAnneeByDept(String Mnemo) throws Exception;
	public abstract ArrayList<Etudiant> loadEtudByECUE(String ecue) throws Exception;
	public abstract ArrayList<String> EnsembleAnnees(String Mnemo)throws Exception;
	
	
}

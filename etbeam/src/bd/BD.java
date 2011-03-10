package bd;

import java.util.ArrayList;

import models.*;

public interface BD {
	
	public ArrayList<Etudiant> loadEtudByAnnee(String an) throws Exception;
	public ArrayList<Etudiant> loadEtudByUE(String ue);
	public ArrayList<Annee> loadAnneeByDept(String Mnemo) throws Exception;
	public ArrayList<Etudiant> loadEtudByECUE(String ecue) throws Exception;
	public ArrayList<String> EnsembleAnnees(String Mnemo)throws Exception;
	
}

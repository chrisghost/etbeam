package bd;

import java.util.ArrayList;

import models.Etudiant;

public interface BD {
	
	public ArrayList<Etudiant> loadEtudByAnnee(String an) throws Exception;
	public ArrayList<Etudiant> loadEtudByUE(String ue);
	public ArrayList<Etudiant> loadEtudByECUE(String ecue) throws Exception;
	
}

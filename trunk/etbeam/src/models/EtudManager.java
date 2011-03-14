package models;

import java.util.ArrayList;
import java.util.Iterator;

public class EtudManager {
	 
    private static final EtudManager INSTANCE = new EtudManager();
 
    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    
    // Private constructor prevents instantiation from other classes
    private EtudManager() {
    	
    }
 
    public static EtudManager getInstance() {
        return INSTANCE;
    }
    
    public void addEtudiant(Etudiant e){
    	if (etudiants.isEmpty()){
    		etudiants.add(e);
    	}
    	else if (!etudiants.contains(e)){
    		etudiants.add(e);
    	}
    }
    
    public Etudiant searchEtudiant(String nom){
    	Etudiant e = null;
    	for (Iterator<Etudiant> i = etudiants.iterator(); i.hasNext();) {
    		if (((Etudiant)i.next()).getNom().equals(nom)){
    			e=(Etudiant)i.next();
    		}
		}
    	return e;
    }
    
    public Etudiant getEtudiant(String nom){
    	Etudiant e=null;
    	if (etudiants.isEmpty()){
    		return null;
    	}
    	else return searchEtudiant(nom);
    }
}

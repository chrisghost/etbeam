package models;

import java.util.ArrayList;
import java.util.Iterator;

import bd.Facade;

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
    
    public ArrayList<Etudiant> searchEtudiant(String nom){
    	Etudiant e = Facade.getInstance().makeEtudiant();
    	
    	ArrayList<String> l = e.getIdsByName(nom);
    	ArrayList<Etudiant> list = new ArrayList<Etudiant>();
    	
    	for(String ine : l){
    		list.add(this.getEtudiant(ine));
    	}
    	
    	return list;
    }
    
    public Etudiant getEtudiant(String ine){
    	Etudiant e = null;
    	for (Iterator<Etudiant> i = etudiants.iterator(); i.hasNext();) {
    		if (((Etudiant)i.next()).getNumINE().equals(ine)){
    			e=(Etudiant)i.next();
    		}
		}
    	if (e==null){
    		e.load(ine);
    		this.etudiants.add(e);
    	}
    	return e;
    }
}
 
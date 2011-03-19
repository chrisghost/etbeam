package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import bd.Facade;
import bd.FacadeAdmin;

public class EtudManager {
	 
    private static final EtudManager INSTANCE = new EtudManager();
 
    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    
    /***** constructeur *****/
    // Private constructor prevents instantiation from other classes
    private EtudManager() {
    	
    }
 
    /****** getter *****/
    public static EtudManager getInstance() {
        return INSTANCE;
    }
    
    
    /****** methodes ******/
    
    public void addEtudiant(Etudiant e){
    	if (etudiants.isEmpty()){
    		etudiants.add(e);
    	}
    	else if (!etudiants.contains(e)){
    		etudiants.add(e);
    	}
    }
    
    public ArrayList<Etudiant> searchEtudiant(String nom) throws SQLException{
    	
    	Facade.getInstance();
		Etudiant e = FacadeAdmin.makeEtudiant();
    	
    	ArrayList<String> listEtud = e.getIdsByName(nom);
    	ArrayList<Etudiant> list = new ArrayList<Etudiant>();
    	
    	for(String ine : listEtud){
    		list.add(this.getEtudiant(ine));
    	}
    	
    	return list;
    }
    
    public Etudiant getEtudiant(String ine) throws SQLException{
    	Etudiant e = null;
    	for (Iterator<Etudiant> i = etudiants.iterator(); i.hasNext();) {
    		if (((Etudiant)i.next()).getNumINE().equals(ine)){
    			e=(Etudiant)i.next();
    		}
		}
    	if (e==null){
    		e.load(ine);
    		this.addEtudiant(e);
    	}
    	return e;
    }
    
    //Suppression d'un etudiant : gestion etudiant
    public void deleteEtud(String ine) throws SQLException{
    	Etudiant e = null;
    	e = getEtudiant(ine);
    	etudiants.remove(e);
    	e.deleteFromBD();
    }

    // modification d'un etudiant : estion etudiant
	public void changeEtudiant(Etudiant etud) throws SQLException {
		String ine = etud.getNumINE();
		Etudiant e = getEtudiant(ine);
		etudiants.remove(e);
		etudiants.add(etud);
		
	}
	
	
	// modification note : gestion ECUE
	public ArrayList<Etudiant> loadEtudByIne(ArrayList<String> listINE) throws SQLException {
		ArrayList<Etudiant> listEtud = new ArrayList<Etudiant>();
		for (Iterator<String> i = listINE.iterator(); i.hasNext();){
			listEtud.add(getEtudiant(i.next()));
		}
		return listEtud;
	}

	
}
 
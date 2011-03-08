package models;

import java.util.ArrayList;

public class EtudManager {
	 
    private static final EtudManager INSTANCE = new EtudManager();
 
    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    
    // Private constructor prevents instantiation from other classes
    private EtudManager() {
    }
 
    public static EtudManager getInstance() {
        return INSTANCE;
    }
}

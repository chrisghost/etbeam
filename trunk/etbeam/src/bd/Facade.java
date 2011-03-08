package bd;

import java.awt.List;
import java.util.ArrayList;

import models.Annee;
import models.Etudiant;

public class Facade {
 
    private static final Facade INSTANCE = new Facade();
 
    private BD persistance;
    
    // Private constructor prevents instantiation from other classes
    private Facade() {
    }
 
    public static Facade getInstance() {
        return INSTANCE;
    }
    
    public void setBD(String bd){
    	if(bd.equalsIgnoreCase("mysql")){
			this.persistance = new MySQL();
    	}
    }
    
    public static BD getBD(){
    	return INSTANCE.persistance;
    }
    
    //ici les fonctions génériques:
    // Ex: loadListeEtud(Annee)
    
    public ArrayList<Etudiant> loadEtud(String an){
    	Annee A = new Annee();
    }
 
}

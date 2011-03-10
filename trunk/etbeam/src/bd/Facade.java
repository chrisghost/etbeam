package bd;



import java.util.ArrayList;

import models.*;

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
    
    public ArrayList<Etudiant> loadEtud(String an) throws Exception{
    	return this.persistance.loadEtudByAnnee(an);
    }
    
    public ArrayList<Annee> loadAnneeByDept(String mnemo) throws Exception{
    	return this.persistance.loadAnneeByDept(mnemo);
    }
 
    public ArrayList<String> EnsembleAnnees(String Mnemo)throws Exception{
    	return this.persistance.EnsembleAnnees(Mnemo);
    	
    }
}

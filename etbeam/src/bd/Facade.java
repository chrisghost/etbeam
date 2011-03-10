package bd;

import java.util.ArrayList;
import models.Etudiant;
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
    
    /******************************************************************************/
    
    
    public ArrayList<Etudiant> searchEtud(String name){};
    
    public ArrayList<Departement> getListeDepartement(){};
    
    public ArrayList<Annee> getListeAnnee(Departement dept){};
    
    public ArrayList<Semestre> getListeSemestre(Annee an){};
    
    public ArrayList<UE> getListeUE(Semestre sem){};
    
    public ArrayList<ECUE> getListe(UE ue){};
    
    public ArrayList<Etudiant> getListeEtudiantbyUE(UE);

    
    
    

    
    

    
   
	
}

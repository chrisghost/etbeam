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
    
    
    public ArrayList<Etudiant> searchEtud(String){};
    
    public ArrayList<Departement> getListeDepartement(){};
    
    public ArrayList<Departement> getListeAnnee(Dep){};
    
    public ArrayList<Semestre> getListeSemestre(Annee){};
    
    public ArrayList<UE> getListeUE(Semestre){};
    
    public ArrayList<Ecue> getListe(UE){};
    
    public ArrayList<Etudiant> getListeEtudiantbyUE(UE);

    
    
    

    
    

    
   
	
}

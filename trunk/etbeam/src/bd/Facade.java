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
    
    
    public ListeEtudiant searchEtud(String){};
    
    public ListeDep getListeDepartement(){};
    
    public ListeDep getListeAnnee(Dep){};
    
    public ListeSem getListeSemestre(Annee){};
    
    public ListeUE getListeUE(Semestre){};
    
    public ListeEcue getListe(UE){};
    
    public ListeEtud getListeEtudiantbyUE(UE);

    
    
    
    public ArrayList<Etudiant> loadEtudByAnnee(String an) throws Exception{
    	return  this.persistance.loadEtudByAnnee(an);
    }
    
    
    

    
   
	
}

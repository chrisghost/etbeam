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
    
    /******************************************************************************/
    
    
    public ArrayList<Etudiant> searchEtud(String name){}
    
    public ArrayList<Departement> getListeDepartement() throws Exception{
    	return getInstance().getBD().getListeDepartement();
    }
    
    public ArrayList<Annee> getListeAnnee(Departement dept){}
    
    public ArrayList<Semestre> getListeSemestre(Annee an) throws Exception{}
    
    public ArrayList<UE> getListeUE(Semestre sem) throws Exception{
    	return this.persistance.getListeUE(sem);
    }
    
    public ArrayList<ECUE> getListeECUE(UE ue) throws Exception{
    	return this.persistance.getListeECUE(ue);
    }
    
    public ArrayList<Semestre> getListeSemestre(Semestre sem) throws Exception{
    	return this.persistance.getListeSemestre(sem);
    }
    
    public ArrayList<Etudiant> getListeEtudiantbyUE(UE ue){
    	return this.persistance.getListeEtudiantbyUE(ue);
    }

    
    
    

    
    

    
   
	
}

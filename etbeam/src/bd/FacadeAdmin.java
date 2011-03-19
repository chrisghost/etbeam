package bd;
import java.sql.SQLException;

//import sun.security.jca.GetInstance;

import models.EtudManager;
import models.Etudiant;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Etudiant;

public class FacadeAdmin {
	private static final FacadeAdmin INSTANCE = new FacadeAdmin();
	 
    private BD persistance = null;
    
    
    /***** Private constructor prevents instantiation from other classes *****/
    
    private FacadeAdmin() {
    }
 
    
    /**** getter and setter ****/
    
    public static FacadeAdmin getInstance() {
        return INSTANCE;
    }
    
    public void setBD(String bd){
    	if(bd.equalsIgnoreCase("mysql")){
			this.persistance = new MySQL();
    	}
    }
    
    public static BD getBD(){
    	
    	if(INSTANCE.persistance == null)
    		INSTANCE.persistance = new MySQL();
    	
    	return INSTANCE.persistance;
    
    }
    
  /*****  methodes 
 * @throws SQLException ******/
    
    
    //Consultation/Recherche étudiant : gestion étudaint
    public ArrayList<Etudiant> searchEtud(String nom) throws SQLException{
    return EtudManager.getInstance().searchEtudiant(nom);
    }
    
    
    //Suppression d'un etudiant : gestion etudiant
    public void deleteEtud(String ine) throws SQLException{
 	   EtudManager.getInstance().deleteEtud(ine);
     }

    
    //modification/creation d'un etudiant : gestion etudiant
    public static Etudiant getEtudiant (String ine) throws SQLException{
    	return EtudManager.getInstance().getEtudiant(ine);    	
    }
    public static void setNom(Etudiant etud, String nom) throws SQLException {
		getInstance().getBD().setNom(etud, nom);
	}
    public static void setPrenom(Etudiant etud, String prenom) throws SQLException{
    	getInstance().getBD().setPrenom(etud,prenom);
    }
    
   
    //creation d'un etudiant : gestion etudiant
   public static Etudiant makeEtudiant(){
		return getInstance().getBD().makeEtudiant();
	}
    
  
}

    		
    
    


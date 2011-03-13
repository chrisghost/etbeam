package bd;

import java.sql.SQLException;
import java.util.ArrayList;
import models.*;

public class Facade {
 
    private static final Facade INSTANCE = new Facade();
 
    private BD persistance;

	private boolean debug = true;
    
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
    
    
    //public ArrayList<Etudiant> searchEtud(String name){}
    
    public static ArrayList<Departement> getListeDepartement() throws Exception{
    	return getInstance().getBD().getListeDepartement();
    }
    
    public static ArrayList<Annee> getListeAnnee() throws Exception{
       	return getInstance().getBD().getListeAnnee();
    }
        
    public static ArrayList<Annee> getListeAnnee(Departement d) throws Exception{
       	return getInstance().getBD().getListeAnnee(d);
    }
        
    
    public static ArrayList<UE> getListeUE(Semestre sem) throws Exception{
    	return getInstance().getBD().getListeUE(sem);
    }
    
    public static ArrayList<ECUE> getListeECUE(UE ue) throws Exception{
    	return getInstance().getBD().getListeECUE(ue);
    }
    
    public static ArrayList<Semestre> getListeSemestre(Annee an) throws Exception{
		return getInstance().getBD().getListeSemestre(an);
    }
    
    public static Annee makeAnnee(String versionEtape){
    	return getInstance().getBD().makeAnnee(versionEtape);
    }

	public static UE makeUE(String code) {
		return getInstance().getBD().makeUE(code);
	}

	public static Semestre makeSemestre(String sem) {
		return getInstance().getBD().makeSemestre(sem);
	}

	public void printDebug(String string) {
		if(this.debug )
			System.out.println("DEBUG : "+string);
	}

	public void printDebug(int i) {
		if(this.debug )
			System.out.println("DEBUG : "+i);
	}

	public static Utilisateur makeUtilisateur(String login, char[] password) {
		return getInstance().getBD().makeUtilisateur(login, password);
	}

	public static Departement makeDepartement(String mnemo) {
		return getInstance().getBD().makeDepartement(mnemo);
	}

	public static ECUE makeECUE(String ecue) {
		return getInstance().getBD().makeECUE(ecue);
	}

    

    
    

    
   
	
}

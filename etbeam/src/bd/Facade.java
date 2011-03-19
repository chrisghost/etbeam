package bd;

import java.sql.SQLException;
import java.util.ArrayList;
import models.*;
import bd.FacadeAdmin;

public class Facade {
 
    private static final Facade INSTANCE = new Facade();
 
    private BD persistance = null;

	private boolean debug = true;
	
	
    /***** constructeur *****/
    // Private constructor prevents instantiation from other classes
    private Facade() {
    }
 
    
    /**** getter and setter ****/
    public static Facade getInstance() {
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
    
    



	/****** methodes ******/
    
    // Toutes les listes possibles
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
    
    
    public static ArrayList<Etudiant> getListeEtudbyUE(UE ue) throws Exception{
		return getInstance().getBD().getListeEtudbyUE(ue);
    }
    
    public static ArrayList<Semestre> getListeSemestre(Annee an) throws Exception{
		return getInstance().getBD().getListeSemestre(an);
    }
    
	
	public static double moyenneEtudiantUE(UE ue, Etudiant etud) throws SQLException{
		return getInstance().getBD().moyenneEtudiantUE(ue,etud);
	}

    
    //modification coeff : gestion ECUE
    public static float getCoeff( ECUE matiere){
    	return matiere.getCoeff();
    }
    public static void setCoeeff(ECUE matiere, float coef) throws SQLException{
    	matiere.setCoeff(coef);
    	getInstance().getBD().saveCoeff(matiere);
    }
    
    
    //modification note : gestion ECUE
    public static ArrayList<String> getEtudiantsINE(ECUE mat) throws SQLException{
    	return mat.getEtudiantINE();
    }
    public static ArrayList<Etudiant> loadEtudByIne(ArrayList<String> listINE) throws SQLException{
    return EtudManager.getInstance().loadEtudByIne(listINE);
    }
    public static Etudiant getEtudiant(String ine) throws SQLException{
    return EtudManager.getInstance().getEtudiant(ine);
    }
  
    
    // methodes make
    public static Annee makeAnnee(String versionEtape){
    	return getInstance().getBD().makeAnnee(versionEtape);
    }

	public static UE makeUE(String code) {
		return getInstance().getBD().makeUE(code);
	}

	public static Semestre makeSemestre(String sem) {
		return getInstance().getBD().makeSemestre(sem);
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

    
	public static Etudiant makeEtudiant(){
		return getInstance().getBD().makeEtudiant();
	}
	
	
	
	
	/*****************************************/
	public void printDebug(String string) {
		if(this.debug )
			System.out.println("DEBUG : "+string);
	}

	public void printDebug(int i) {
		if(this.debug )
			System.out.println("DEBUG : "+i);
	}

	
    
	

    
   
	
}

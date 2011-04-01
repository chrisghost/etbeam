package bd;

import java.sql.SQLException;
import java.util.ArrayList;
import models.*;

public class Facade {
 
	
	/**	
     * La classe Facade est un Singleton       
     */	
    private static final Facade INSTANCE = new Facade();
 
    
    private BD persistance = null;

	private boolean debug = true;
	
	
    
    // Private constructor prevents instantiation from other classes
    private Facade() {
    }
 
    
    /**** getter and setter ****/
    
    
    /**	
     * rï¿½cupï¿½re l'instance de la facade
     * @return l'instance de la facade       
     */	
    public static Facade getInstance() {
        return INSTANCE;
    }
    
    
    /**	
     * Definir le type de la persistance      
     */	
    public void setBD(String bd){
    	if(bd.equalsIgnoreCase("mysql")){
			this.persistance = new MySQL();
    	}
    }
    
    
    /**	
     * Rï¿½cupï¿½rer l'instance de la persistance      
     */	
    public BD getBD(){
    	
    	if(INSTANCE.persistance == null)
    		INSTANCE.persistance = new MySQL();
    	
    	return INSTANCE.persistance;
    
    }
    

    
    
    //RECUPERATION DES LISTES
    
    /**	
     * rï¿½cupï¿½rer la liste des dï¿½partements
     * @return une liste d'objets Departement    
     */	    
    public static ArrayList<Departement> getListeDepartement(){
    	return getInstance().getBD().getListeDepartement();
    }
    
    
	/**	
     * permet de rï¿½cupï¿½rer la liste des ï¿½tudiants d'une ECUE
     * @param ecue l'ECUE pour laquelle on veut la liste des ï¿½tudiants
     * @return une liste d'objet Etudiant   
     */
	public static ArrayList<Etudiant> getListeEtudECUE(ECUE ecue) {
		return getInstance().getBD().getListeEtudECUE(ecue);
	}
    
	
    /**	
     * rï¿½cupï¿½rer la liste des annï¿½es
     * @return une liste d'objets Annee     
     */	
    public static ArrayList<Annee> getListeAnnee() throws Exception{
       	return getInstance().getBD().getListeAnnee();
    }
    
    
    /**	
     * rï¿½cupï¿½rer la liste des annï¿½es d'un dï¿½partement
     * @param d le dï¿½partement pour lequel on veut la liste des annï¿½es
     * @return une liste d'objets Annee   
     */	
    public static ArrayList<Annee> getListeAnnee(Departement d){
       	return getInstance().getBD().getListeAnnee(d);
    }
     
    
	/**	
     * permet de rï¿½cupï¿½rer le liste des ï¿½tudiants d'une UE
     * @param ue l'UE dont on veut la liste des ï¿½tudiants
     * @return une liste d'objet Etudiant    
     */
	public static ArrayList<Etudiant> getListeEtudbyUE(UE ue){
		return getInstance().getBD().getListeEtudbyUE(ue);
	}
	
    
    /**	
     * rï¿½cupï¿½rer la liste des UE d'un Semestre
     * @param sem le semestre pour lequel on veut les UE
     * @return une liste d'objets UE    
     */	
    public static ArrayList<UE> getListeUE(Semestre sem){
    	return getInstance().getBD().getListeUE(sem);
    }
    
    
    /**	
     * rï¿½cupï¿½rer la liste des ECUE d'une UE
     * @param ue l'UE pour laquelle on veut les ECUE
     * @return une liste d'objets ECUE   
     */	
    public static ArrayList<ECUE> getListeECUE(UE ue){
    	return getInstance().getBD().getListeECUE(ue);
    }
    
    
    /**	
     * rï¿½cupï¿½rer la liste semestres d'une annï¿½e
     * @param an l'annï¿½e pour laquelle on veut les semestres
     * @return une liste d'objets Semestre
     */	
    public static ArrayList<Semestre> getListeSemestre(Annee an){
		return getInstance().getBD().getListeSemestre(an);
    }
    
    
    //METHODE MAKE
    
	/**	
     * permet de crï¿½er un objet Annee
     * @param versionEtape le code caractï¿½risant l'Annee
     * @return un objet Annee     
     */
    public static Annee makeAnnee(String versionEtape){
    	return getInstance().getBD().makeAnnee(versionEtape, "");
    }

    
	/**	
     * permet de crï¿½er un objet UE
     * @param code le code caractï¿½risant l'UE
     * @return un objet UE    
     */
	public static UE makeUE(String code) {
		return getInstance().getBD().makeUE(code, "");
	}

	
	/**	
     * permet de crï¿½er un objet Semestre
     * @param sem le libellï¿½ du semestre
     * @return un objet Semestre     
     */
	public static Semestre makeSemestre(String sem) {
		return getInstance().getBD().makeSemestre(sem, "");
	}

	
	/**	
     * permet de crï¿½er un objet Utilisateur
     * @param login le login de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return un objet Utilisateur    
     */
	public static Utilisateur makeUtilisateur(String login, char[] password) {
		return getInstance().getBD().makeUtilisateur(login, password);
	}

	
	/**	
     * permet de crï¿½er un objet Departement
     * @param mnemo le mnemonique du dï¿½partement
     * @return un objet Departement   
     */
	public static Departement makeDepartement(String mnemo) {
		return getInstance().getBD().makeDepartement(mnemo);
	}

	
	/**	
     * permet de crï¿½er un objet ECUE
     * @param ecue le libellï¿½ de l'ECUE
     * @return un objet ECUE   
     */
	public static ECUE makeECUE(String ecue) {
		return getInstance().getBD().makeECUE(ecue);
	}

    
	/**	
     * permet de crï¿½er un objet Etudiant
     * @return un objet Etudiant   
     */
	public static Etudiant makeEtudiant(){
		return getInstance().getBD().makeEtudiant();
	}
    
	
	
	
	//METHODES
	
	/**	
     * permet de chercher un ou plusieurs ï¿½tudiants
     * @param nom le nom de l'ï¿½tudiant recherchï¿½
     * @return une liste d'objet Etudiant ayant le nom cherchï¿½   
     */
	public static ArrayList<Etudiant> searchEtudiant(String nom) throws SQLException{
		return EtudManager.getInstance().searchEtudiant(nom);
	}


	/**	
     * permet de rï¿½cupï¿½rer la moyenne obtenue ï¿½ l'UE par un ï¿½tudiant
     * @param ue l'UE pour laquelle on veut la moyenne
     * @param etud l'ï¿½tudiant dont on veut la moyenne
     * @return la moyenne obtenue par l'ï¿½tudiant   
     */
	public static double moyenneEtudiantUE(UE ue, Etudiant etud) {
		return getInstance().getBD().moyenneEtudiantUE(ue, etud);
	}

	
	/**	
     * permet de rï¿½cupï¿½rer la moyenne obtenue au semestre par un ï¿½tudiant
     * @param sem semestre pour lequel on veut la moyenne
     * @param etud l'ï¿½tudiant dont on veut la moyenne
     * @return la moyenne obtenue par l'ï¿½tudiant   
     */
	public static double moyenneEtudiantSem (Semestre sem, Etudiant et){
		return getInstance().getBD().moyenneEtudiantSem (sem, et);
	}
	
	
	/**	
     * permet de rï¿½cupï¿½rer la note d'un ï¿½tudiant ï¿½ une ECUE
     * @param ec l'ECUE pour laquelle on veut la note
     * @param et l'ï¿½tudiant dont on veut la note
     * @param session le numï¿½ro de session concernant la note
     * @return la note obtenue par l'ï¿½tudiant   
     */
	public static double getEtudNote(ECUE ec,Etudiant et, int session){
		return getInstance().getBD().getEtudNote(ec,et, session);
	}
	
	
	/**	
     * permet de rï¿½cupï¿½rer l'annï¿½e ï¿½ laquelle un ï¿½tudiant appartient
     * @param etud l'ï¿½tudiant dont on veut savoir son annï¿½e
     * @return le texte caractï¿½risant l'annï¿½e ï¿½ laquelle l'ï¿½tudiant appartient   
     */
	public static String getAnneeEtudiant(Etudiant etud) {
		return getInstance().getBD().getAnneeEtudiant(etud);
	}

	
	/**	
     * permet de rï¿½cupï¿½rer le nombre de points jury UE obtenus par l'ï¿½tudiant
     * @param ue l'UE pour laquelle on veut les points jury
     * @param e l'ï¿½tudiant dont on veut les points jury UE
     * @return le nombre de points jury   
     */
	public static float getPtsJuryUE(UE ue, Etudiant e){
		return getInstance().getBD().getPtsJuryUE(ue, e);
	}
	
		
	/**	
     * permet de rï¿½cupï¿½rer le nombre de points jury Semestre obtenus par l'ï¿½tudiant
     * @param se le Semestre pour lequel on veut les points jury
     * @param e l'ï¿½tudiant dont on veut les points jury Semestre
     * @return le nombre de points jury   
     */
	public static float getPtsJurySem(Semestre se, Etudiant e){
		return getInstance().getBD().getPtsJurySem(se, e);
	}
   
	
	
	
	/**	
     * permet la note obtenue à l'ECUE par l'étudiant
     * @param ec l'ECUE pour laquelle on veut changer la note
     * @param et l'étudiant dont on veut changer la note
     * @param note la note que l'on veut affecter à l'étudiant
     * @param session le numéro de session concernant la note  
     */
	public static void changeNoteEcue(ECUE ec, Etudiant et, double note, int session){
		getInstance().getBD().changeNoteEcue(ec, et, (float)note, session);
	}


	public static void ajoutPointsSem(Semestre sem, Etudiant etudiant, Float pts) {
		getInstance().getBD().ajoutPointsSem(sem, etudiant,pts);
		
	}
	
	public static void ajoutPointsUE(UE ue, Etudiant et, Float pts) {
		getInstance().getBD().ajoutPointsUE(ue, et, pts);
		
	}
	
	
	
	
	// METHODE AFFICHAGE DEBUG
	
	
	public void printDebug(String string) {
		if(this.debug )
			System.out.println("DEBUG : "+string);
	}

	public void printDebug(int i) {
		if(this.debug )
			System.out.println("DEBUG : "+i);
	}


	
	
}

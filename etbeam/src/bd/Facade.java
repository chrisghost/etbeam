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
     * récupère l'instance de la facade
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
     * Récupérer l'instance de la persistance      
     */	
    public BD getBD(){
    	
    	if(INSTANCE.persistance == null)
    		INSTANCE.persistance = new MySQL();
    	
    	return INSTANCE.persistance;
    
    }
    

    
    
    //RECUPERATION DES LISTES
    
    /**	
     * récupérer la liste des départements
     * @return une liste d'objets Departement    
     */	    
    public static ArrayList<Departement> getListeDepartement(){
    	return getInstance().getBD().getListeDepartement();
    }
    
    
	/**	
     * permet de récupérer la liste des étudiants d'une ECUE
     * @param ecue l'ECUE pour laquelle on veut la liste des étudiants
     * @return une liste d'objet Etudiant   
     */
	public static ArrayList<Etudiant> getListeEtudECUE(ECUE ecue) {
		return getInstance().getBD().getListeEtudECUE(ecue);
	}
    
	
    /**	
     * récupérer la liste des années
     * @return une liste d'objets Annee     
     */	
    public static ArrayList<Annee> getListeAnnee() throws Exception{
       	return getInstance().getBD().getListeAnnee();
    }
    
    
    /**	
     * récupérer la liste des années d'un département
     * @param d le département pour lequel on veut la liste des années
     * @return une liste d'objets Annee   
     */	
    public static ArrayList<Annee> getListeAnnee(Departement d){
       	return getInstance().getBD().getListeAnnee(d);
    }
     
    
	/**	
     * permet de récupérer le liste des étudiants d'une UE
     * @param ue l'UE dont on veut la liste des étudiants
     * @return une liste d'objet Etudiant    
     */
	public static ArrayList<Etudiant> getListeEtudbyUE(UE ue){
		return getInstance().getBD().getListeEtudbyUE(ue);
	}
	
    
    /**	
     * récupérer la liste des UE d'un Semestre
     * @param sem le semestre pour lequel on veut les UE
     * @return une liste d'objets UE    
     */	
    public static ArrayList<UE> getListeUE(Semestre sem){
    	return getInstance().getBD().getListeUE(sem);
    }
    
    
    /**	
     * récupérer la liste des ECUE d'une UE
     * @param ue l'UE pour laquelle on veut les ECUE
     * @return une liste d'objets ECUE   
     */	
    public static ArrayList<ECUE> getListeECUE(UE ue){
    	return getInstance().getBD().getListeECUE(ue);
    }
    
    
    /**	
     * récupérer la liste semestres d'une année
     * @param an l'année pour laquelle on veut les semestres
     * @return une liste d'objets Semestre
     */	
    public static ArrayList<Semestre> getListeSemestre(Annee an){
		return getInstance().getBD().getListeSemestre(an);
    }
    
    
    //METHODE MAKE
    
	/**	
     * permet de créer un objet Annee
     * @param versionEtape le code caractérisant l'Annee
     * @return un objet Annee     
     */
    public static Annee makeAnnee(String versionEtape){
    	return getInstance().getBD().makeAnnee(versionEtape, "");
    }

    
	/**	
     * permet de créer un objet UE
     * @param code le code caractérisant l'UE
     * @return un objet UE    
     */
	public static UE makeUE(String code) {
		return getInstance().getBD().makeUE(code, "");
	}

	
	/**	
     * permet de créer un objet Semestre
     * @param sem le libellé du semestre
     * @return un objet Semestre     
     */
	public static Semestre makeSemestre(String sem) {
		return getInstance().getBD().makeSemestre(sem, "");
	}

	
	/**	
     * permet de créer un objet Utilisateur
     * @param login le login de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return un objet Utilisateur    
     */
	public static Utilisateur makeUtilisateur(String login, char[] password) {
		return getInstance().getBD().makeUtilisateur(login, password);
	}

	
	/**	
     * permet de créer un objet Departement
     * @param mnemo le mnemonique du département
     * @return un objet Departement   
     */
	public static Departement makeDepartement(String mnemo) {
		return getInstance().getBD().makeDepartement(mnemo);
	}

	
	/**	
     * permet de créer un objet ECUE
     * @param ecue le libellé de l'ECUE
     * @return un objet ECUE   
     */
	public static ECUE makeECUE(String ecue) {
		return getInstance().getBD().makeECUE(ecue);
	}

    
	/**	
     * permet de créer un objet Etudiant
     * @return un objet Etudiant   
     */
	public static Etudiant makeEtudiant(){
		return getInstance().getBD().makeEtudiant();
	}
    
	
	
	
	//METHODES
	
	/**	
     * permet de chercher un ou plusieurs étudiants
     * @param nom le nom de l'étudiant recherché
     * @return une liste d'objet Etudiant ayant le nom cherché   
     */
	public static ArrayList<Etudiant> searchEtudiant(String nom) throws SQLException{
		return EtudManager.getInstance().searchEtudiant(nom);
	}


	/**	
     * permet de récupérer la moyenne obtenue à l'UE par un étudiant
     * @param ue l'UE pour laquelle on veut la moyenne
     * @param etud l'étudiant dont on veut la moyenne
     * @return la moyenne obtenue par l'étudiant   
     */
	public static double moyenneEtudiantUE(UE ue, Etudiant etud) {
		return getInstance().getBD().moyenneEtudiantUE(ue, etud);
	}

	
	/**	
     * permet de récupérer la moyenne obtenue au semestre par un étudiant
     * @param sem semestre pour lequel on veut la moyenne
     * @param etud l'étudiant dont on veut la moyenne
     * @return la moyenne obtenue par l'étudiant   
     */
	public static double moyenneEtudiantSem (Semestre sem, Etudiant et){
		return getInstance().getBD().moyenneEtudiantSem (sem, et);
	}
	
	
	/**	
     * permet de récupérer la note d'un étudiant à une ECUE
     * @param ec l'ECUE pour laquelle on veut la note
     * @param et l'étudiant dont on veut la note
     * @param session le numéro de session concernant la note
     * @return la note obtenue par l'étudiant   
     */
	public static double getEtudNote(ECUE ec,Etudiant et, int session){
		return getInstance().getBD().getEtudNote(ec,et, session);
	}
	
	
	/**	
     * permet de récupérer l'année à laquelle un étudiant appartient
     * @param etud l'étudiant dont on veut savoir son année
     * @return le texte caractérisant l'année à laquelle l'étudiant appartient   
     */
	public static String getAnneeEtudiant(Etudiant etud) {
		return getInstance().getBD().getAnneeEtudiant(etud);
	}

	
	/**	
     * permet de récupérer le nombre de points jury UE obtenus par l'étudiant
     * @param ue l'UE pour laquelle on veut les points jury
     * @param e l'étudiant dont on veut les points jury UE
     * @return le nombre de points jury   
     */
	public static float getPtsJuryUE(UE ue, Etudiant e){
		return getInstance().getBD().getPtsJuryUE(ue, e);
	}
	
		
	/**	
     * permet de récupérer le nombre de points jury Semestre obtenus par l'étudiant
     * @param se le Semestre pour lequel on veut les points jury
     * @param e l'étudiant dont on veut les points jury Semestre
     * @return le nombre de points jury   
     */
	public static float getPtsJurySem(Semestre se, Etudiant e){
		return getInstance().getBD().getPtsJurySem(se, e);
	}
   
	public static void changeNoteEcue(ECUE ec, Etudiant et, double note, int session){
		getInstance().getBD().changeNoteEcue(ec, et, (float)note, session);
	}


	public static void ajoutPointsSem(Semestre sem, Etudiant etudiant, Float pts) {
		getInstance().getBD().ajoutPointsSem(sem, etudiant,pts);
		
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

package bd;

import java.sql.SQLException;
import java.util.ArrayList;
import models.*;

public class Facade {
 
	
	/**	
     * La classe Facade est un Singleton       
     */	
    private static final Facade INSTANCE = new Facade();


	private static Utilisateur currentUser;
 
    
    private BD persistance = null;

	private boolean debug = false;
	
	
    
    // Private constructor prevents instantiation from other classes
    private Facade() {
    }
 
    
    /**** getter and setter ****/
    
    
    /**	
     * r�cup�re l'instance de la facade
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
     * R�cup�rer l'instance de la persistance      
     */	
    public BD getBD(){
    	
    	if(INSTANCE.persistance == null)
    		INSTANCE.persistance = new MySQL();
    	
    	return INSTANCE.persistance;
    
    }
    

    
    
    //RECUPERATION DES LISTES
    
    /**	
     * r�cup�rer la liste des d�partements
     * @return une liste d'objets Departement    
     */	    
    public static ArrayList<Departement> getListeDepartement(){
    	return getInstance().getBD().getListeDepartement();
    }
    
    
	/**	
     * permet de r�cup�rer la liste des �tudiants d'une ECUE
     * @param ecue l'ECUE pour laquelle on veut la liste des �tudiants
     * @return une liste d'objet Etudiant   
     */
	public static ArrayList<Etudiant> getListeEtudECUE(ECUE ecue) {
		return getInstance().getBD().getListeEtudECUE(ecue);
	}
    
	
    /**	
     * r�cup�rer la liste des ann�es
     * @return une liste d'objets Annee     
     */	
    public static ArrayList<Annee> getListeAnnee() throws Exception{
       	return getInstance().getBD().getListeAnnee();
    }
    
    
    /**	
     * r�cup�rer la liste des ann�es d'un d�partement
     * @param d le d�partement pour lequel on veut la liste des ann�es
     * @return une liste d'objets Annee   
     */	
    public static ArrayList<Annee> getListeAnnee(Departement d){
       	return getInstance().getBD().getListeAnnee(d);
    }
     
    
	/**	
     * permet de r�cup�rer le liste des �tudiants d'une UE
     * @param ue l'UE dont on veut la liste des �tudiants
     * @return une liste d'objet Etudiant    
     */
	public static ArrayList<Etudiant> getListeEtudbyUE(UE ue){
		return getInstance().getBD().getListeEtudbyUE(ue);
	}
	
    
    /**	
     * r�cup�rer la liste des UE d'un Semestre
     * @param sem le semestre pour lequel on veut les UE
     * @return une liste d'objets UE    
     */	
    public static ArrayList<UE> getListeUE(Semestre sem){
    	return getInstance().getBD().getListeUE(sem);
    }
    
    
    /**	
     * r�cup�rer la liste des ECUE d'une UE
     * @param ue l'UE pour laquelle on veut les ECUE
     * @return une liste d'objets ECUE   
     */	
    public static ArrayList<ECUE> getListeECUE(UE ue){
    	return getInstance().getBD().getListeECUE(ue);
    }
    
    
    /**	
     * r�cup�rer la liste semestres d'une ann�e
     * @param an l'ann�e pour laquelle on veut les semestres
     * @return une liste d'objets Semestre
     */	
    public static ArrayList<Semestre> getListeSemestre(Annee an){
		return getInstance().getBD().getListeSemestre(an);
    }
    
    
    //METHODE MAKE
    
	/**	
     * permet de cr�er un objet Annee
     * @param versionEtape le code caract�risant l'Annee
     * @return un objet Annee     
     */
    public static Annee makeAnnee(String versionEtape){
    	return getInstance().getBD().makeAnnee(versionEtape, "");
    }

    
	/**	
     * permet de cr�er un objet UE
     * @param code le code caract�risant l'UE
     * @return un objet UE    
     */
	public static UE makeUE(String code) {
		return getInstance().getBD().makeUE(code, "");
	}

	
	/**	
     * permet de cr�er un objet Semestre
     * @param sem le libell� du semestre
     * @return un objet Semestre     
     */
	public static Semestre makeSemestre(String sem) {
		return getInstance().getBD().makeSemestre(sem, "");
	}

	
	/**	
     * permet de cr�er un objet Utilisateur
     * @param login le login de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return un objet Utilisateur    
     */
	public static Utilisateur makeUtilisateur(String login, char[] password) {
		return getInstance().getBD().makeUtilisateur(login, password);
	}
	
	public static Utilisateur makeUtilisateur(String login, String password) {
		return Facade.getInstance().makeUtilisateur(login, password.toCharArray());
	}

	
	/**	
     * permet de cr�er un objet Departement
     * @param mnemo le mnemonique du d�partement
     * @return un objet Departement   
     */
	public static Departement makeDepartement(String mnemo) {
		return getInstance().getBD().makeDepartement(mnemo);
	}

	
	/**	
     * permet de cr�er un objet ECUE
     * @param ecue le libell� de l'ECUE
     * @return un objet ECUE   
     */
	public static ECUE makeECUE(String ecue) {
		return getInstance().getBD().makeECUE(ecue);
	}

    
	/**	
     * permet de cr�er un objet Etudiant
     * @return un objet Etudiant   
     */
	public static Etudiant makeEtudiant(){
		return getInstance().getBD().makeEtudiant();
	}
    
	
	
	
	//METHODES
	
	/**	
     * permet de chercher un ou plusieurs �tudiants
     * @param nom le nom de l'�tudiant recherch�
     * @return une liste d'objet Etudiant ayant le nom cherch�   
     */
	public static ArrayList<Etudiant> searchEtudiant(String nom) throws SQLException{
		return EtudManager.getInstance().searchEtudiant(nom);
	}


	/**	
     * permet de r�cup�rer la moyenne obtenue � l'UE par un �tudiant
     * @param ue l'UE pour laquelle on veut la moyenne
     * @param etud l'�tudiant dont on veut la moyenne
     * @return la moyenne obtenue par l'�tudiant   
     */
	public static double moyenneEtudiantUE(UE ue, Etudiant etud) {
		return getInstance().getBD().moyenneEtudiantUE(ue, etud);
	}

	
	/**	
     * permet de r�cup�rer la moyenne obtenue au semestre par un �tudiant
     * @param sem semestre pour lequel on veut la moyenne
     * @param etud l'�tudiant dont on veut la moyenne
     * @return la moyenne obtenue par l'�tudiant   
     */
	public static double moyenneEtudiantSem (Semestre sem, Etudiant et){
		return getInstance().getBD().moyenneEtudiantSem (sem, et);
	}
	
	
	/**	
     * permet de r�cup�rer la note d'un �tudiant � une ECUE
     * @param ec l'ECUE pour laquelle on veut la note
     * @param et l'�tudiant dont on veut la note
     * @param session le num�ro de session concernant la note
     * @return la note obtenue par l'�tudiant   
     */
	public static double getEtudNote(ECUE ec,Etudiant et, int session){
		return getInstance().getBD().getEtudNote(ec,et, session);
	}
	
	
	/**	
     * permet de r�cup�rer l'ann�e � laquelle un �tudiant appartient
     * @param etud l'�tudiant dont on veut savoir son ann�e
     * @return le texte caract�risant l'ann�e � laquelle l'�tudiant appartient   
     */
	public static String getAnneeEtudiant(Etudiant etud) {
		return getInstance().getBD().getAnneeEtudiant(etud);
	}

	
	/**	
     * permet de r�cup�rer le nombre de points jury UE obtenus par l'�tudiant
     * @param ue l'UE pour laquelle on veut les points jury
     * @param e l'�tudiant dont on veut les points jury UE
     * @return le nombre de points jury   
     */
	public static float getPtsJuryUE(UE ue, Etudiant e){
		return getInstance().getBD().getPtsJuryUE(ue, e);
	}
	
		
	/**	
     * permet de r�cup�rer le nombre de points jury Semestre obtenus par l'�tudiant
     * @param se le Semestre pour lequel on veut les points jury
     * @param e l'�tudiant dont on veut les points jury Semestre
     * @return le nombre de points jury   
     */
	public static float getPtsJurySem(Semestre se, Etudiant e){
		return getInstance().getBD().getPtsJurySem(se, e);
	}
   
	
	
	
	/**	
     * permet de changer la note obtenue � l'ECUE par l'�tudiant
     * @param ec l'ECUE pour laquelle on veut changer la note
     * @param et l'�tudiant dont on veut changer la note
     * @param note la note que l'on veut affecter � l'�tudiant
     * @param session le num�ro de session concernant la note  
     */
	public static void changeNoteEcue(ECUE ec, Etudiant et, double note, int session){
		getInstance().getBD().changeNoteEcue(ec, et, (float)note, session);
	}


	
	
	/**	
     * permet d'ajouter des points jury semestre � un �tudiant 
     * @param sem le semestre pour lequel on veut ajouter des points
     * @param et l'�tudiant � qui on veut ajouter les points
     * @param pts le nombre de points jury � affecter � l'�tudiant 
     */
	public static void ajoutPointsSem(Semestre sem, Etudiant etudiant, Float pts) {
		getInstance().getBD().ajoutPointsSem(sem, etudiant,pts);
		
	}
	
	
	/**	
     * permet d'ajouter des points jury UE � un �tudiant
     * @param ue l'UE pour laquelle on veut ajouter des points
     * @param et l'�tudiant � qui on veut ajouter des points
     * @param pts le nombre de points � ajouter
     */
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


	public static void setCurrentUser(Utilisateur u) {
		getInstance().currentUser = u;
	}


	public Utilisateur getCurrentUser() {
		return currentUser;
	}

	public boolean isAdmin(){
		return (currentUser.getRights() > 100);
	}


	public <T extends Model> boolean hasRights(String type, String field, T m) {
		return getInstance().getBD().hasRights(type, field, m);
	}


	
	
}

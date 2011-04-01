package bd;

import java.sql.SQLException;
import java.util.ArrayList;

import models.*;

/*
 * 
 * ABSTRACT FACTORY
 * 
 */

public abstract class BD {
	
	// CONNEXION
	
	/**	
     * vï¿½rifie si l'utilisateur est connectï¿½           
     */	
	public abstract boolean isConnected();
	
	
	/**	
     * Permet d'obtenir des informations sur la connection ï¿½ la base
     *            
     */	
	public abstract String getConnectionInfos();
	
	
	
	
	//TOUTES LES LISTES POSSIBLES

	/**	
     * permet d'obtenir la liste des dï¿½partements
     * @return la liste des dï¿½partements           
     */	
	public abstract ArrayList<Departement> getListeDepartement();
	
	
	/**	
     * permet d'obtenir la liste des ECUE contenues dans une UE donnï¿½e
     * @param ue l'UE dont on veut les ECUE
     * @return une liste des ECUE          
     */	
	public abstract ArrayList<ECUE> getListeECUE(UE ue);

	
	/**	
     * permet d'obtenir la liste des UE contenues dans un semestre
     * @param sem le semestre dont on veut les UE
     * @return une liste des UE          
     */	
	public abstract ArrayList<UE> getListeUE(Semestre sem);
	
	
	/**	
     * permet d'obtenir la liste ï¿½tudiants ï¿½tudiant une UE
     * @param ue l'UE dont on veut les ï¿½tudiants
     * @return une liste d'Etudiant        
     */	
	public abstract ArrayList<Etudiant> getListeEtudbyUE(UE ue);
	
		
	/**	
     * permet d'obtenir la liste des semestre appartenant ï¿½ une annï¿½e donnï¿½e
     * @param an l'annï¿½e dont on veut les semestres
     * @return une liste de Semestre         
     */	
	public abstract ArrayList<Semestre> getListeSemestre(Annee an);
	
	
	/**	
     * permet d'obtenir la liste de toutes les annï¿½es
     * @return une liste d'Annee         
     */	
	public abstract ArrayList<Annee> getListeAnnee() throws Exception;
	
	
	/**	
     * permet d'obtenir la liste des annï¿½es appartenant ï¿½ un dï¿½partement
     * @param d le dï¿½partement dont on veut les annï¿½es
     * @return une liste d'Annee         
     */	
	public abstract ArrayList<Annee> getListeAnnee(Departement d);
	
	
	/**	
     * permet d'obtenir la liste des ï¿½tudiants d'une ECUE
     * @param ecue l'ECUE dont on veut les ï¿½tudiants
     * @return une liste d'Etudiant       
     */	
	public abstract ArrayList<Etudiant> getListeEtudECUE(ECUE ecue);
	
	
	/**	
     * permet d'obtenir l'annï¿½e ï¿½ laquelle appartient un ï¿½tudiant
     * @param etud l'ï¿½tudiant dont on veut l'annee
     * @return un mnï¿½monique de l'annï¿½e         
     */	
	public abstract String getAnneeEtudiant(Etudiant etud);
	
	
	
	//MODIFICATION D'UN ETUDIANT : GESTION ETUDIANT

	
	/**	
     * permet de changer le nom d'un ï¿½tudiant
     * @param etud l'ï¿½tudiant dont on veut changer le nom
     * @param nom le nom que l'on veut affecter ï¿½ l'ï¿½tudiant       
     */	
	public void setNom(Etudiant etud, String nom) throws SQLException{
		etud.setNom(nom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}
	
	
	/**	
     * permet de changer le prenom d'un ï¿½tudiant
     * @param etud l'ï¿½tudiant dont on veut changer le prenom
     * @param prenom le prenom que l'on veut affecter ï¿½ l'ï¿½tudiant       
     */
	public void setPrenom(Etudiant etud, String prenom) throws SQLException{
		etud.setPrenom(prenom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}

	
	/**	
     * Obtenir la moyenne ï¿½ l'UE d'un ï¿½tudiant 
     * @param ue l'UE dont on veut la moyenne de l'ï¿½tudiant
     * @param etud l'ï¿½tudiant dont on veut obtenir la moyenne
     * @return la moyenne obtenue par l'ï¿½tudiant       
     */
	public double moyenneEtudiantUE(UE ue, Etudiant etud) {
		return ue.getMoyenne(etud);
	}
	
	
	/**	
     * permet de valider l'UE d'un ï¿½tudiant
     * @param etud l'ï¿½tudiant dont on valider l'UE
     * @param ue l'UE pour laquelle on veut valider l'UE      
     */
	public abstract void validationUE(Etudiant etud, UE ue) throws SQLException;

	
	
	/**	
     * changer la note obtenue ï¿½ l'ECUE par un ï¿½tudiant
     * @param ecue l'ECUE dont on veut changer la note de l'ï¿½tudiant
     * @param etud l'ï¿½tudiant dont on veut changer la note
     * @param numsess le numï¿½ro de session concernant la note
     * @param note la note obtenue par l'ï¿½tudiant      
     */
	public void changeNoteEtudiantECUE(ECUE ecue, Etudiant etud, int numsess, float note) throws SQLException {
		ecue.changeNoteEtudiantECUE(etud,numsess,note);
	}
	
	/**	
     * permet d'obtenir la note obtenue ï¿½ l'UE par un ï¿½tudiant
     * @param ecue l'ECUE pour laquelle on veut la note
     * @param etud l'ï¿½tudiant dont on veut la note
     * @param numsess le numï¿½ro de session concernant la note 
     * @return la note obtenue par l'ï¿½tudiant     
     */
	public abstract double noteEtudiantUE(ECUE ecue, Etudiant etud, int numsess) throws SQLException;
	
	
	
	
	/**	
     * permet de rï¿½cupï¿½rer la note obtenue par un ï¿½tudiant ï¿½ l'ECUE
     * @param ec l'ECUE pour laquelle on veut la note obtenue
     * @param et l'ï¿½tudiant dont on veut la note
     * @param session le numï¿½ro de session concernant la note
     * @return la note de l'ï¿½tudiant     
     */
	public abstract double getEtudNote(ECUE ec, Etudiant et, int session);
	
	
	
	
	
	// METHODES MAKE
	
	
	/**	
     * permet de crï¿½er un objet Annee
     * @param versionEtape la code caractï¿½risant l'annï¿½e ï¿½ crï¿½er
     * @param lib le libellï¿½ de l'annï¿½e que l'on veut crï¿½er
     * @return un objet Annee       
     */
	public abstract Annee makeAnnee(String versionEtape,String lib);
	
	
	/**	
     * permet de crï¿½er un objet UE
     * @param code le code caractï¿½risant l'UE ï¿½ crï¿½er
     * @param lib le libellï¿½ de l'UE que l'on veut crï¿½er 
     * @return un objet UE     
     */
	public abstract UE makeUE(String code, String lib);
	
	
	/**	
     * permet de crï¿½er un objet Semestre
     * @param sem le code caractï¿½risant le semestre ï¿½ crï¿½er
     * @param lib le libellï¿½ du semestre que l'on veut crï¿½er 
     * @return un objet Semestre     
     */
	public abstract Semestre makeSemestre(String sem, String lib);
	
	
	/**	
     * permet de crï¿½er un objet Etudiant
     * @return un objet Etudiant    
     */
	public abstract Etudiant makeEtudiant();
	
	
	/**	
     * permet de crï¿½er un objet Utilisateur
     * @param login le login de l'utilisateur ï¿½ crï¿½er
     * @param password mot de passe de l'utilisateur
     * @return un objet Utilisateur     
     */
	public abstract Utilisateur makeUtilisateur(String login, char[] password);
	
	
	/**	
     * permet de crï¿½er un objet Departement
     * @param mnemo le mnï¿½monique du dï¿½partement ï¿½ crï¿½ï¿½r
     * @return un objet Departement     
     */
	public abstract Departement makeDepartement(String mnemo);
	
	
	/**	
     * permet de crï¿½er un objet ECUE
     * @param ecue le libelle de l'ECUE ï¿½ crï¿½er
     * @return un objet ECUE     
     */
	public abstract ECUE makeECUE(String ecue);
	
	
	/**	
     * permet d'obtenir le nombre de points jury attriubés à un étudiant pour une UE
     * @param ue l'UE pour laquelle on veut les points jury
     * @param e l'Etudiant dont on veut les points jury
     * @return le nombre de points jury UE attribués    
     */
	public abstract float getPtsJuryUE(UE ue, Etudiant e) ;
	
	
	/**	
     * permet d'obtenir le nombre de points jury attriubés à un étudiant pour un semestre
     * @param se le semestre pour lequel on veut les points jury
     * @param e l'Etudiant dont on veut les points jury
     * @return le nombre de points jury semestre attribués    
     */
	public abstract float getPtsJurySem(Semestre se, Etudiant e);


	/**	
     * permet d'obtenir la moyenne d'un étudiant pour un semestre
     * @param sem le semestre pour lequel on veut la moyenne de l'étudiant
     * @param et l'Etudiant dont on veut la moyenne au semestre
     * @return la moyenne obtenue par l'étudiant au semestre    
     */
	public abstract double moyenneEtudiantSem(Semestre sem, Etudiant et);

	public abstract void changeNoteEcue(ECUE ec, Etudiant et, float note, int session);


	public abstract void ajoutPointsSem(Semestre sem, Etudiant etudiant, Float pts);


	
}
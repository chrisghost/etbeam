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
     * verifie si l'utilisateur est connecte       
     */	
	
	public abstract boolean isConnected();
	
	
	/**	
     * Permet d'obtenir des informations sur la connection a la base
     *            
     */	
	public abstract String getConnectionInfos();
	
	
	
	
	//TOUTES LES LISTES POSSIBLES

	/**	
     * permet d'obtenir la liste des departements
     * @return la liste des departements           
     */	
	public abstract ArrayList<Departement> getListeDepartement();
	
	
	/**	
     * permet d'obtenir la liste des ECUE contenues dans une UE donnee
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
     * permet d'obtenir la liste Etudiants d'une UE
     * @param ue l'UE dont on veut les etudiants
     * @return une liste d'Etudiant        
     */	
	public abstract ArrayList<Etudiant> getListeEtudbyUE(UE ue);
	
		
	/**	
     * permet d'obtenir la liste des semestre appartenant a une annee donnee
     * @param an l'annee dont on veut les semestres
     * @return une liste de Semestre         
     */	
	public abstract ArrayList<Semestre> getListeSemestre(Annee an);
	
	
	/**	
     * permet d'obtenir la liste de toutes les annees
     * @return une liste d'Annee         
     */	
	public abstract ArrayList<Annee> getListeAnnee() throws Exception;
	
	
	/**	
     * permet d'obtenir la liste des annees appartenant a un departement
     * @param d le departement dont on veut les annees
     * @return une liste d'Annee         
     */	
	public abstract ArrayList<Annee> getListeAnnee(Departement d);
	
	
	/**	
     * permet d'obtenir la liste des etudiants d'une ECUE
     * @param ecue l'ECUE dont on veut les etudiants
     * @return une liste d'Etudiant       
     */	
	public abstract ArrayList<Etudiant> getListeEtudECUE(ECUE ecue);
	
	
	/**	
     * permet d'obtenir l'annee a laquelle appartient un etudiant
     * @param etud l'etudiant dont on veut l'annee
     * @return un mnemonique de l'annee         
     */	
	public abstract String getAnneeEtudiant(Etudiant etud);
	
	
	
	//MODIFICATION D'UN ETUDIANT : GESTION ETUDIANT

	
	/**	
     * permet de changer le nom d'un etudiant
     * @param etud l'etudiant dont on veut changer le nom
     * @param nom le nom que l'on veut affecter a l'etudiant       
     */	
	public void setNom(Etudiant etud, String nom) throws SQLException{
		etud.setNom(nom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}
	
	
	/**	
     * permet de changer le prenom d'un etudiant
     * @param etud l'etudiant dont on veut changer le prenom
     * @param prenom le prenom que l'on veut affecter a l'etudiant       
     */
	public void setPrenom(Etudiant etud, String prenom) throws SQLException{
		etud.setPrenom(prenom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}

	
	/**	
     * Obtenir la moyenne a l'UE d'un etudiant 
     * @param ue l'UE dont on veut la moyenne de l'etudiant
     * @param etud l'etudiant dont on veut obtenir la moyenne
     * @return la moyenne obtenue par l'etudiant       
     */
	public double moyenneEtudiantUE(UE ue, Etudiant etud) {
		return ue.getMoyenne(etud);
	}
	
	
	/**	
     * permet de valider l'UE d'un etudiant
     * @param etud l'etudiant dont on valider l'UE
     * @param ue l'UE pour laquelle on veut valider l'UE      
     */
	public abstract void validationUE(Etudiant etud, UE ue) throws SQLException;

	
	
	/**	
     * changer la note obtenue a l'ECUE par un etudiant
     * @param ecue l'ECUE dont on veut changer la note de l'etudiant
     * @param etud l'etudiant dont on veut changer la note
     * @param numsess le numero de session concernant la note
     * @param note la note obtenue par l'etudiant      
     */
	public void changeNoteEtudiantECUE(ECUE ecue, Etudiant etud, int numsess, float note) throws SQLException {
		ecue.changeNoteEtudiantECUE(etud,numsess,note);
	}
	
	/**	
     * permet d'obtenir la note obtenue a l'UE par un etudiant
     * @param ecue l'ECUE pour laquelle on veut la note
     * @param etud l'etudiant dont on veut la note
     * @param numsess le numero de session concernant la note 
     * @return la note obtenue par l'etudiant     
     */
	public abstract double noteEtudiantUE(ECUE ecue, Etudiant etud, int numsess) throws SQLException;
	
	
	
	
	/**	
     * permet de recuperer la note obtenue par un etudiant a l'ECUE
     * @param ec l'ECUE pour laquelle on veut la note obtenue
     * @param et l'etudiant dont on veut la note
     * @param session le numero de session concernant la note
     * @return la note de l'etudiant     
     */
	public abstract double getEtudNote(ECUE ec, Etudiant et, int session);
	
	
	
	
	
	// METHODES MAKE
	
	
	/**	
     * permet de creer un objet Annee
     * @param versionEtape la code caracterisant l'annee a creer
     * @param lib le libelle de l'annee que l'on veut creer
     * @return un objet Annee       
     */
	public abstract Annee makeAnnee(String versionEtape,String lib);
	
	
	/**	
     * permet de creer un objet UE
     * @param code le code caracterisant l'UE a creer
     * @param lib le libellede l'UE que l'on veut creer 
     * @return un objet UE     
     */
	public abstract UE makeUE(String code, String lib);
	
	
	/**	
     * permet de creer un objet Semestre
     * @param sem le code caract�risant le semestre a creer
     * @param lib le libelle du semestre que l'on veut creer 
     * @return un objet Semestre     
     */
	public abstract Semestre makeSemestre(String sem, String lib);
	
	
	/**	
     * permet de creer un objet Etudiant
     * @return un objet Etudiant    
     */
	public abstract Etudiant makeEtudiant();
	
	
	/**	
     * permet de creer un objet Utilisateur
     * @param login le login de l'utilisateur a creer
     * @param password mot de passe de l'utilisateur
     * @return un objet Utilisateur     
     */
	public abstract Utilisateur makeUtilisateur(String login, char[] password);
	
	
	/**	
     * permet de creer un objet Departement
     * @param mnemo le mnemonique du departement a creer
     * @return un objet Departement     
     */
	public abstract Departement makeDepartement(String mnemo);
	
	
	/**	
     * permet de creer un objet ECUE
     * @param ecue le libelle de l'ECUE a creer
     * @return un objet ECUE     
     */
	public abstract ECUE makeECUE(String ecue);
	
	
	/**	
     * permet d'obtenir le nombre de points jury attriubes a un etudiant pour une UE
     * @param ue l'UE pour laquelle on veut les points jury
     * @param e l'Etudiant dont on veut les points jury
     * @return le nombre de points jury UE attribue   
     */
	public abstract float getPtsJuryUE(UE ue, Etudiant e) ;
	
	
	/**	
     * permet d'obtenir le nombre de points jury attriube a un etudiant pour un semestre
     * @param se le semestre pour lequel on veut les points jury
     * @param e l'Etudiant dont on veut les points jury
     * @return le nombre de points jury semestre attribues    
     */
	public abstract float getPtsJurySem(Semestre se, Etudiant e);


	/**	
     * permet d'obtenir la moyenne d'un etudiant pour un semestre
     * @param sem le semestre pour lequel on veut la moyenne de l'etudiant
     * @param et l'Etudiant dont on veut la moyenne au semestre
     * @return la moyenne obtenue par l'etudiant au semestre    
     */
	public abstract double moyenneEtudiantSem(Semestre sem, Etudiant et);

	
	/**	
     * permet de changer la note obtenue a une ECUE par un �tudiant
     * @param ec l'ECUE pour laquelle on veut changer la note
     * @param et l'etudiant a qui on vaut changer la note
     * @param note la note a affecter a l'etudiant
     * @param session le numero de session concernant la note
     */
	public abstract void changeNoteEcue(ECUE ec, Etudiant et, float note, int session);


	
	/**	
     * permet d'ajouter des points jury semestre a un etudiant
     * @param sem le semestre pour lequel on veut ajouter des points
     * @param etudiant l'etudiant a qui on veut ajouter des points
     * @param pts le nombre de points a ajouter
     */
	public abstract void ajoutPointsSem(Semestre sem, Etudiant etudiant, Float pts);

	

	/**	
     * permet d'ajouter des points jury UE a un etudiant
     * @param ue l'UE pour laquelle on veut ajouter des points
     * @param et l'etudiant a qui on veut ajouter des points
     * @param pts le nombre de points a ajouter
     */
	public abstract void ajoutPointsUE(UE ue, Etudiant et, Float pts);

	public abstract void saveEnseignant(Enseignant e, String nom, String prenom, String mail, String id);

	public abstract boolean saveUtilisateur(Utilisateur u,String login, String mdp, String id_ens, Integer droits);


	public boolean hasRights(String type, String field, Model m) {
		m.load();
		return (m.getResponsable().getId() == Facade.getInstance().getCurrentUser().getId() || Facade.getInstance().isAdmin());

	}
}
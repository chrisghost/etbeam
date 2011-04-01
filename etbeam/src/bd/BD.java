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
     * vérifie si l'utilisateur est connecté           
     */	
	public abstract boolean isConnected();
	
	
	/**	
     * Permet d'obtenir des informations sur la connection à la base
     *            
     */	
	public abstract String getConnectionInfos();
	
	
	
	
	//TOUTES LES LISTES POSSIBLES

	/**	
     * permet d'obtenir la liste des départements
     * @return la liste des départements           
     */	
	public abstract ArrayList<Departement> getListeDepartement();
	
	
	/**	
     * permet d'obtenir la liste des ECUE contenues dans une UE donnée
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
     * permet d'obtenir la liste étudiants étudiant une UE
     * @param ue l'UE dont on veut les étudiants
     * @return une liste d'Etudiant        
     */	
	public abstract ArrayList<Etudiant> getListeEtudbyUE(UE ue);
	
		
	/**	
     * permet d'obtenir la liste des semestre appartenant à une année donnée
     * @param an l'année dont on veut les semestres
     * @return une liste de Semestre         
     */	
	public abstract ArrayList<Semestre> getListeSemestre(Annee an);
	
	
	/**	
     * permet d'obtenir la liste de toutes les années
     * @return une liste d'Annee         
     */	
	public abstract ArrayList<Annee> getListeAnnee() throws Exception;
	
	
	/**	
     * permet d'obtenir la liste des années appartenant à un département
     * @param d le département dont on veut les années
     * @return une liste d'Annee         
     */	
	public abstract ArrayList<Annee> getListeAnnee(Departement d);
	
	
	/**	
     * permet d'obtenir la liste des étudiants d'une ECUE
     * @param ecue l'ECUE dont on veut les étudiants
     * @return une liste d'Etudiant       
     */	
	public abstract ArrayList<Etudiant> getListeEtudECUE(ECUE ecue);
	
	
	/**	
     * permet d'obtenir l'année à laquelle appartient un étudiant
     * @param etud l'étudiant dont on veut l'annee
     * @return un mnémonique de l'année         
     */	
	public abstract String getAnneeEtudiant(Etudiant etud);
	
	
	
	//MODIFICATION D'UN ETUDIANT : GESTION ETUDIANT

	
	/**	
     * permet de changer le nom d'un étudiant
     * @param etud l'étudiant dont on veut changer le nom
     * @param nom le nom que l'on veut affecter à l'étudiant       
     */	
	public void setNom(Etudiant etud, String nom) throws SQLException{
		etud.setNom(nom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}
	
	
	/**	
     * permet de changer le prenom d'un étudiant
     * @param etud l'étudiant dont on veut changer le prenom
     * @param prenom le prenom que l'on veut affecter à l'étudiant       
     */
	public void setPrenom(Etudiant etud, String prenom) throws SQLException{
		etud.setPrenom(prenom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}

	
	/**	
     * Obtenir la moyenne à l'UE d'un étudiant 
     * @param ue l'UE dont on veut la moyenne de l'étudiant
     * @param etud l'étudiant dont on veut obtenir la moyenne
     * @return la moyenne obtenue par l'étudiant       
     */
	public double moyenneEtudiantUE(UE ue, Etudiant etud) throws SQLException {
		return ue.getMoyenne(etud);
	}
	
	
	/**	
     * permet de valider l'UE d'un étudiant
     * @param etud l'étudiant dont on valider l'UE
     * @param ue l'UE pour laquelle on veut valider l'UE      
     */
	public abstract void validationUE(Etudiant etud, UE ue) throws SQLException;

	
	
	/**	
     * changer la note obtenue à l'ECUE par un étudiant
     * @param ecue l'ECUE dont on veut changer la note de l'étudiant
     * @param etud l'étudiant dont on veut changer la note
     * @param numsess le numéro de session concernant la note
     * @param note la note obtenue par l'étudiant      
     */
	public void changeNoteEtudiantECUE(ECUE ecue, Etudiant etud, int numsess, float note) throws SQLException {
		ecue.changeNoteEtudiantECUE(etud,numsess,note);
	}
	
	/**	
     * permet d'obtenir la note obtenue à l'UE par un étudiant
     * @param ecue l'ECUE pour laquelle on veut la note
     * @param etud l'étudiant dont on veut la note
     * @param numsess le numéro de session concernant la note 
     * @return la note obtenue par l'étudiant     
     */
	public abstract double noteEtudiantUE(ECUE ecue, Etudiant etud, int numsess) throws SQLException;
	
	
	
	
	/**	
     * permet de récupérer la note obtenue par un étudiant à l'ECUE
     * @param ec l'ECUE pour laquelle on veut la note obtenue
     * @param et l'étudiant dont on veut la note
     * @param session le numéro de session concernant la note
     * @return la note de l'étudiant     
     */
	public abstract double getEtudNote(ECUE ec, Etudiant et, int session);
	
	
	
	
	
	// METHODES MAKE
	
	
	/**	
     * permet de créer un objet Annee
     * @param versionEtape la code caractérisant l'année à créer
     * @param lib le libellé de l'année que l'on veut créer
     * @return un objet Annee       
     */
	public abstract Annee makeAnnee(String versionEtape,String lib);
	
	
	/**	
     * permet de créer un objet UE
     * @param code le code caractérisant l'UE à créer
     * @param lib le libellé de l'UE que l'on veut créer 
     * @return un objet UE     
     */
	public abstract UE makeUE(String code, String lib);
	
	
	/**	
     * permet de créer un objet Semestre
     * @param sem le code caractérisant le semestre à créer
     * @param lib le libellé du semestre que l'on veut créer 
     * @return un objet Semestre     
     */
	public abstract Semestre makeSemestre(String sem, String lib);
	
	
	/**	
     * permet de créer un objet Etudiant
     * @return un objet Etudiant    
     */
	public abstract Etudiant makeEtudiant();
	
	
	/**	
     * permet de créer un objet Utilisateur
     * @param login le login de l'utilisateur à créer
     * @param password mot de passe de l'utilisateur
     * @return un objet Utilisateur     
     */
	public abstract Utilisateur makeUtilisateur(String login, char[] password);
	
	
	/**	
     * permet de créer un objet Departement
     * @param mnemo le mnémonique du département à créér
     * @return un objet Departement     
     */
	public abstract Departement makeDepartement(String mnemo);
	
	
	/**	
     * permet de créer un objet ECUE
     * @param ecue le libelle de l'ECUE à créer
     * @return un objet ECUE     
     */
	public abstract ECUE makeECUE(String ecue);
	



	
}
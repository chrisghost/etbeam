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
     * v�rifie si l'utilisateur est connect�           
     */	
	public abstract boolean isConnected();
	
	
	/**	
     * Permet d'obtenir des informations sur la connection � la base
     *            
     */	
	public abstract String getConnectionInfos();
	
	
	
	
	//TOUTES LES LISTES POSSIBLES

	/**	
     * permet d'obtenir la liste des d�partements
     * @return la liste des d�partements           
     */	
	public abstract ArrayList<Departement> getListeDepartement();
	
	
	/**	
     * permet d'obtenir la liste des ECUE contenues dans une UE donn�e
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
     * permet d'obtenir la liste �tudiants �tudiant une UE
     * @param ue l'UE dont on veut les �tudiants
     * @return une liste d'Etudiant        
     */	
	public abstract ArrayList<Etudiant> getListeEtudbyUE(UE ue);
	
		
	/**	
     * permet d'obtenir la liste des semestre appartenant � une ann�e donn�e
     * @param an l'ann�e dont on veut les semestres
     * @return une liste de Semestre         
     */	
	public abstract ArrayList<Semestre> getListeSemestre(Annee an);
	
	
	/**	
     * permet d'obtenir la liste de toutes les ann�es
     * @return une liste d'Annee         
     */	
	public abstract ArrayList<Annee> getListeAnnee() throws Exception;
	
	
	/**	
     * permet d'obtenir la liste des ann�es appartenant � un d�partement
     * @param d le d�partement dont on veut les ann�es
     * @return une liste d'Annee         
     */	
	public abstract ArrayList<Annee> getListeAnnee(Departement d);
	
	
	/**	
     * permet d'obtenir la liste des �tudiants d'une ECUE
     * @param ecue l'ECUE dont on veut les �tudiants
     * @return une liste d'Etudiant       
     */	
	public abstract ArrayList<Etudiant> getListeEtudECUE(ECUE ecue);
	
	
	/**	
     * permet d'obtenir l'ann�e � laquelle appartient un �tudiant
     * @param etud l'�tudiant dont on veut l'annee
     * @return un mn�monique de l'ann�e         
     */	
	public abstract String getAnneeEtudiant(Etudiant etud);
	
	
	
	//MODIFICATION D'UN ETUDIANT : GESTION ETUDIANT

	
	/**	
     * permet de changer le nom d'un �tudiant
     * @param etud l'�tudiant dont on veut changer le nom
     * @param nom le nom que l'on veut affecter � l'�tudiant       
     */	
	public void setNom(Etudiant etud, String nom) throws SQLException{
		etud.setNom(nom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}
	
	
	/**	
     * permet de changer le prenom d'un �tudiant
     * @param etud l'�tudiant dont on veut changer le prenom
     * @param prenom le prenom que l'on veut affecter � l'�tudiant       
     */
	public void setPrenom(Etudiant etud, String prenom) throws SQLException{
		etud.setPrenom(prenom);
		EtudManager.getInstance().changeEtudiant(etud);
		etud.save();
	}

	
	/**	
     * Obtenir la moyenne � l'UE d'un �tudiant 
     * @param ue l'UE dont on veut la moyenne de l'�tudiant
     * @param etud l'�tudiant dont on veut obtenir la moyenne
     * @return la moyenne obtenue par l'�tudiant       
     */
	public double moyenneEtudiantUE(UE ue, Etudiant etud) {
		return ue.getMoyenne(etud);
	}
	
	
	/**	
     * permet de valider l'UE d'un �tudiant
     * @param etud l'�tudiant dont on valider l'UE
     * @param ue l'UE pour laquelle on veut valider l'UE      
     */
	public abstract void validationUE(Etudiant etud, UE ue) throws SQLException;

	
	
	/**	
     * changer la note obtenue � l'ECUE par un �tudiant
     * @param ecue l'ECUE dont on veut changer la note de l'�tudiant
     * @param etud l'�tudiant dont on veut changer la note
     * @param numsess le num�ro de session concernant la note
     * @param note la note obtenue par l'�tudiant      
     */
	public void changeNoteEtudiantECUE(ECUE ecue, Etudiant etud, int numsess, float note) throws SQLException {
		ecue.changeNoteEtudiantECUE(etud,numsess,note);
	}
	
	/**	
     * permet d'obtenir la note obtenue � l'UE par un �tudiant
     * @param ecue l'ECUE pour laquelle on veut la note
     * @param etud l'�tudiant dont on veut la note
     * @param numsess le num�ro de session concernant la note 
     * @return la note obtenue par l'�tudiant     
     */
	public abstract double noteEtudiantUE(ECUE ecue, Etudiant etud, int numsess) throws SQLException;
	
	
	
	
	/**	
     * permet de r�cup�rer la note obtenue par un �tudiant � l'ECUE
     * @param ec l'ECUE pour laquelle on veut la note obtenue
     * @param et l'�tudiant dont on veut la note
     * @param session le num�ro de session concernant la note
     * @return la note de l'�tudiant     
     */
	public abstract double getEtudNote(ECUE ec, Etudiant et, int session);
	
	
	
	
	
	// METHODES MAKE
	
	
	/**	
     * permet de cr�er un objet Annee
     * @param versionEtape la code caract�risant l'ann�e � cr�er
     * @param lib le libell� de l'ann�e que l'on veut cr�er
     * @return un objet Annee       
     */
	public abstract Annee makeAnnee(String versionEtape,String lib);
	
	
	/**	
     * permet de cr�er un objet UE
     * @param code le code caract�risant l'UE � cr�er
     * @param lib le libell� de l'UE que l'on veut cr�er 
     * @return un objet UE     
     */
	public abstract UE makeUE(String code, String lib);
	
	
	/**	
     * permet de cr�er un objet Semestre
     * @param sem le code caract�risant le semestre � cr�er
     * @param lib le libell� du semestre que l'on veut cr�er 
     * @return un objet Semestre     
     */
	public abstract Semestre makeSemestre(String sem, String lib);
	
	
	/**	
     * permet de cr�er un objet Etudiant
     * @return un objet Etudiant    
     */
	public abstract Etudiant makeEtudiant();
	
	
	/**	
     * permet de cr�er un objet Utilisateur
     * @param login le login de l'utilisateur � cr�er
     * @param password mot de passe de l'utilisateur
     * @return un objet Utilisateur     
     */
	public abstract Utilisateur makeUtilisateur(String login, char[] password);
	
	
	/**	
     * permet de cr�er un objet Departement
     * @param mnemo le mn�monique du d�partement � cr��r
     * @return un objet Departement     
     */
	public abstract Departement makeDepartement(String mnemo);
	
	
	/**	
     * permet de cr�er un objet ECUE
     * @param ecue le libelle de l'ECUE � cr�er
     * @return un objet ECUE     
     */
	public abstract ECUE makeECUE(String ecue);
	
	
	
	public abstract float getPtsJuryUE(UE ue, Etudiant e) ;
	
	public abstract float getPtsJurySem(Semestre se, Etudiant e);


	public abstract double moyenneEtudiantSem(Semestre sem, Etudiant et);


	



	
}
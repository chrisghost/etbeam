package bd;
import java.sql.SQLException;

//import sun.security.jca.GetInstance;

import models.Enseignant;
import models.EtudManager;
import models.Etudiant;
import models.Utilisateur;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Etudiant;

public class FacadeAdmin {
	
	
	/**	
     * la classe FacadeAdmin est un singleton
     */
	private static final FacadeAdmin INSTANCE = new FacadeAdmin();
	 
    private BD persistance = null;
    
    
    /***** Private constructor prevents instantiation from other classes *****/
    
    private FacadeAdmin() {
    }
 
    
    /**** getter and setter ****/
    
    
	
	/**	
     * r�cup�rer l'instance de la fa�ade
     * @return l'instance de la fa�ade
     */
    public static FacadeAdmin getInstance() {
        return INSTANCE;
    }
    
	
    
	/**	
     * permet de d�terminer la persistance � utiliser
     * @param bd le libell� de la persistance � utiliser 
     */
    public void setBD(String bd){
    	if(bd.equalsIgnoreCase("mysql")){
			this.persistance = new MySQL();
    	}
    }
    
    
	
	/**	
     * permet de r�cup�rer l'instance de la persistance
     * @return l'instance de la persistance
     */
    public BD getBD(){
    	
    	if(INSTANCE.persistance == null)
    		INSTANCE.persistance = new MySQL();
    	
    	return INSTANCE.persistance;
    
    }
    
  /*****  methodes 
 * @throws Throwable 
 * @throws SQLException ******/
    
    
    
	
	/**	
     * permet de chercher un �tudiant
     * @param nom le nom de l'�tudiant que l'on cherche
     * @return une liste d'objet Etudiant ayant le nom cherch�
     */
    public ArrayList<Etudiant> searchEtud(String nom){
    return EtudManager.getInstance().searchEtudiant(nom);
    }
    
    
	
	/**	
     * permet de supprimer un �tudiant
     * @param ine le num�ro INE de l'�tudiant � supprimer
     */
    public void deleteEtud(String ine) throws SQLException{
 	   EtudManager.getInstance().deleteEtud(ine);
     }

    
    
	
	/**	
     * permet de r�cup�rer un �tudiant
     * @param ine le num�ro INE de l'�tudiant � r�cup�rer
     * @return l'objet Etudiant 
     */
    public static Etudiant getEtudiant (String ine) throws SQLException{
    	return EtudManager.getInstance().getEtudiant(ine);    	
    }
    
    	
	/**	
     * permet de changer le nom d'un �tudiant
     * @param etud l'�tudiant dont on veut changer le nom
     * @param nom le nom que l'on veut affecter � l'�tudiant
     */
    public static void setNom(Etudiant etud, String nom) throws SQLException {
		getInstance().getBD().setNom(etud, nom);
	}
    
    
	/**	
     * permet de changer le pr�nom d'un �tudiant
     * @param etud l'�tudiant dont on veut changer le pr�nom
     * @param pr�nom le pr�nom que l'on veut affecter � l'�tudiant
     */
    public static void setPrenom(Etudiant etud, String prenom) throws SQLException{
    	getInstance().getBD().setPrenom(etud,prenom);
    }
    
   
    
	/**	
     * permet de cr�er un objet Etudiant
     * @return un objet Etudiant
     */
   public static Etudiant makeEtudiant(){
		return getInstance().getBD().makeEtudiant();
	}
    
   public static void saveEnseignant(Enseignant e, String nom, String prenom, String mail, String id){
	   getInstance().getBD().saveEnseignant(e, nom, prenom, mail, id);
   }
   
   public static boolean saveUtilisateur(Utilisateur u,String login, String mdp, String id_ens, Integer droits){
	   return getInstance().getBD().saveUtilisateur(u, login, mdp, id_ens, droits);
   }
  
}

    		
    
    


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
     * récupérer l'instance de la façade
     * @return l'instance de la façade
     */
    public static FacadeAdmin getInstance() {
        return INSTANCE;
    }
    
	
    
	/**	
     * permet de déterminer la persistance à utiliser
     * @param bd le libellé de la persistance à utiliser 
     */
    public void setBD(String bd){
    	if(bd.equalsIgnoreCase("mysql")){
			this.persistance = new MySQL();
    	}
    }
    
    
	
	/**	
     * permet de récupérer l'instance de la persistance
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
     * permet de chercher un étudiant
     * @param nom le nom de l'étudiant que l'on cherche
     * @return une liste d'objet Etudiant ayant le nom cherché
     */
    public ArrayList<Etudiant> searchEtud(String nom){
    return EtudManager.getInstance().searchEtudiant(nom);
    }
    
    
	
	/**	
     * permet de supprimer un étudiant
     * @param ine le numéro INE de l'étudiant à supprimer
     */
    public void deleteEtud(String ine) throws SQLException{
 	   EtudManager.getInstance().deleteEtud(ine);
     }

    
    
	
	/**	
     * permet de récupérer un étudiant
     * @param ine le numéro INE de l'étudiant à récupérer
     * @return l'objet Etudiant 
     */
    public static Etudiant getEtudiant (String ine) throws SQLException{
    	return EtudManager.getInstance().getEtudiant(ine);    	
    }
    
    	
	/**	
     * permet de changer le nom d'un étudiant
     * @param etud l'étudiant dont on veut changer le nom
     * @param nom le nom que l'on veut affecter à l'étudiant
     */
    public static void setNom(Etudiant etud, String nom) throws SQLException {
		getInstance().getBD().setNom(etud, nom);
	}
    
    
	/**	
     * permet de changer le prénom d'un étudiant
     * @param etud l'étudiant dont on veut changer le prénom
     * @param prénom le prénom que l'on veut affecter à l'étudiant
     */
    public static void setPrenom(Etudiant etud, String prenom) throws SQLException{
    	getInstance().getBD().setPrenom(etud,prenom);
    }
    
   
    
	/**	
     * permet de créer un objet Etudiant
     * @return un objet Etudiant
     */
   public static Etudiant makeEtudiant(){
		return getInstance().getBD().makeEtudiant();
	}
    
   public static void saveEnseignant(Enseignant e, String nom, String prenom, String mail, String id){
	   getInstance().getBD().saveEnseignant(e, nom, prenom, mail, id);
   }
   
   public static void saveUtilisateur(Utilisateur u,String login, String mdp, String id, String id_ens){
	   getInstance().getBD().saveUtilisateur(u, login, mdp, id, id_ens);
   }
  
}

    		
    
    


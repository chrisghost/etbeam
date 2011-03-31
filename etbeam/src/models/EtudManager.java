package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import bd.Facade;
import bd.FacadeAdmin;

public class EtudManager {
	 
/**	
     * La classe EtudManager est un Singleton       
     */	
    private static final EtudManager INSTANCE = new EtudManager();
 
 /**	
     * La liste des �tudiants contenus dans l'EtudManager
     *            
     */	
    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    
    /***** constructeur *****/
    // Private constructor prevents instantiation from other classes
    private EtudManager() {
    	
    }
 

    
/**	
     * r�cup�re l'INSTANCE de l'Etudmanager
     *            
     */	
    public static EtudManager getInstance() {
        return INSTANCE;
    }
    
    
    
    
/**	
     * Ajoute un �tudiant � l'EtudManager
     * 
     * @param e L'objet Etudiant que l'on veut ajouter 
     *            
     */	   
    public void addEtudiant(Etudiant e){
    	if (etudiants.isEmpty()){
    		etudiants.add(e);
    	}
    	else if (!etudiants.contains(e)){
    		etudiants.add(e);
    	}
    }
 
    
    
 /**	
???????????????????????????
 * @throws SQLException 
     *            
     */	
    public ArrayList<Etudiant> searchEtudiant(String nom) throws Throwable{
    	
    	Facade.getInstance();
		Etudiant e = FacadeAdmin.makeEtudiant();
    	
    	ArrayList<String> listEtud = e.getIdsByName(nom);
    	ArrayList<Etudiant> list = new ArrayList<Etudiant>();
    	
    	for(String ine : listEtud){
    		list.add(this.getEtudiant(ine));
    	}
    	
    	return list;
    }

    
    
  /**	
		 *R�cup�re un objet Etudiant de l'EtudManager
         *
         *@param ine le code INE de l'�tudiant qu'on veut r�cup�rer
         *@return l'objet Etudiant caract�ris� par le code INE
         */	
    public Etudiant getEtudiant(String ine) throws SQLException{
        Etudiant e = null;
        Iterator<Etudiant> i = etudiants.iterator();
        while ( i.hasNext()) {
        	Etudiant interm = (Etudiant)i.next();
        		
                if (interm.getNumINE().equals(ine)){
                        e=interm;
                }
                }
        if (e==null){
                e.load(ine);
                this.addEtudiant(e);
        }
        return e;
    }
  
    
 /**	
         *  Supprime un objet �tudiant de l'EtudManager
         *  
         *  @param le code INE caract�risant l'�tudiant que l'on veut supprimer
         *           
         */	

    public void deleteEtud(String ine) throws SQLException{
    	Etudiant e = null;
    	e = getEtudiant(ine);
    	etudiants.remove(e);
    	e.delete();
    }

    
    

 /**	
         * Permet de changer l'�tudiant? ?????????
         *            
         */	
	public void changeEtudiant(Etudiant etud) throws SQLException {
		String ine = etud.getNumINE();
		Etudiant e = getEtudiant(ine);
		etudiants.remove(e);
		etudiants.add(etud);
		
	}
	
	
/**	
     * Charge une liste d'objets Etudiant � partir d'une Liste de code INE
     * 
     * @param listINE liste contenant les codes INE caract�risant les �tudiants
     * @return Une liste charg�e contenant les objets Etudiant demand�s          
     */	
	public ArrayList<Etudiant> loadEtudByIne(ArrayList<String> listINE) throws SQLException {
		ArrayList<Etudiant> listEtud = new ArrayList<Etudiant>();
		for (Iterator<String> i = listINE.iterator(); i.hasNext();){
			listEtud.add(getEtudiant(i.next()));
		}
		return listEtud;
	}

	
}
 
package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


public abstract class Departement extends Model {
	protected String nomDept;
	protected String mnemo;
	protected String versionDiplome;
	protected Utilisateur ResponsableDept;
	protected ArrayList<Annee> Listeannee= new ArrayList<Annee>();
    
	protected void addVars(){
		this.addVar("mnemo");
		this.addVar("nomDept");
		this.addVar("versionDiplome");
	}
	
	
    /***** constructeur *****/
	
	//creation d'un departement avec toutes les info relatives au dpartement
	public Departement(String nomDept, String mnemo, String versionDiplome) {
		super();
		this.nomDept = nomDept;
		this.mnemo = mnemo;
		this.versionDiplome = versionDiplome;
	}

	

	public Departement() {
		super();
	}
	
	//creation d'un departement en notifiant que son nom
	public Departement(String mnemo) {
		super();
		this.mnemo = mnemo;
	}

	//creation d'un dpartement en y associant un responsable
	public Departement(String nomDept, String mnemo, String versionDiplome,
			Utilisateur responsableDept) {
		super();
		this.nomDept = nomDept;
		this.mnemo = mnemo;
		this.versionDiplome = versionDiplome;
		ResponsableDept = responsableDept;
	}
	
	//creation alternative
	public Departement(String nomDept, String mnemo, String versionDiplome,
			Utilisateur responsableDept, ArrayList<Annee> lesAnnees) {
		super();
		this.nomDept = nomDept;
		this.mnemo = mnemo;
		this.versionDiplome = versionDiplome;
		ResponsableDept = responsableDept;
		this.Listeannee = lesAnnees;
	}

	public Departement(String nomDept, String mnemo, String versionDiplome, ArrayList<Annee> lesAnnees) {
		super();
		this.nomDept = nomDept;
		this.mnemo = mnemo;
		this.versionDiplome = versionDiplome;
		this.Listeannee = lesAnnees;
	}
	
public ArrayList<String> EnsembleAnnees(){
	ArrayList<String> lesAns = new ArrayList<String>();
	String s;
	
	for (Iterator<Annee> indice = Listeannee.iterator(); indice.hasNext();){
		s= (String) indice.next().getMnemo();
		lesAns.add(s);
	}
	;
	return lesAns;
	}


	
/**
 * 
 * Récupère le nom du département
 * @return le nom du département 
 *            
 */
	public String getNomDept() {
		return nomDept;
	}
	
/**
	 * 
	 * change le nom du département
	 * @param nomDept le nom que l'on veut affecter au département 
	 *            
	 */
	public void setNomDept(String nomDept) {
		this.nomDept = nomDept;
	}
	
	
/**
	 * 
	 * Récupère le mnémonique du département
	 * @return le mnemonique du département 
	 *            
	 */	
	public String getMnemo() {
		return mnemo;
	}
	
/**
	 * 
	 * Change le mnémonique du département
	 * @param mnemo le mnémonique que l'on veut affecter au département 
	 *            
	 */
	public void setMnemo(String mnemo) {
		this.mnemo = mnemo;
	}
	
	
/**
	 * 
	 * Récupère le code VersionDiplome du département
	 * @return le code VersionDiplome du département
	 *            
	 */
	public String getVersionDiplome() {
		return versionDiplome;
	}
	

/**
	 * 
	 * Change le code VersionDiplome du département
	 * @param versionDiplome le code versionDiplome que l'on veut affecter au département 
	 *            
	 */
	public void setVersionDiplome(String versionDiplome) {
		this.versionDiplome = versionDiplome;
	}

	
/**
	 * 
	 * récupère la liste des années appartenant au département
	 * @return l'ArrayList contenant les objets Annee appartenant au département 
	 *            
	 */
	public ArrayList<Annee> getLesAnnees() {
		return this.Listeannee;
	}
	
	
/**
	 * 
	 * Affecte au département une liste d'années
	 * @param lesAnnees contient les objets Annee que l'on veut affecter au département 
	 *            
	 */
	public void setLesAnnees(ArrayList<Annee> lesAnnees) {
		this.Listeannee = lesAnnees;
	}
    


	
	
	
/**
	 * 
	 * Chargement des informations sur les années appartenant à un département
	 * @param mnemo le mnemonique du département dont on veut récupèrer les années 
	 *            
	 */	
	
	public abstract void loadAnnee(String mnemo)throws SQLException; 

	
/**
	 * 
	 * Chargement d'une liste contenant toutes les années appartenant au département         
	 */	
	public abstract void LoadListeAnnee()throws SQLException;


	public String getcodebylib(String lib) {

		String code = null;
		Annee ann;
		Iterator<Annee> i = this.getLesAnnees().iterator();
		while (i.hasNext()){
			ann=i.next();
			if(ann.getMnemo().equals(lib)){
				code = ann.getVersionEtape();
			}}
		return code;
	}
	
	/**
	 * Représentation de l'objet en String pour les ComboBox
	 */		
	public String toString(){
		return this.mnemo;
	}
	
 }








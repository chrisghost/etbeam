package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


public abstract class Departement extends Model {
	protected String nomDept;
	protected String mnemo;
	protected String versionDiplome;
	protected Utilisateur Responsable;
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
		Responsable = responsableDept;
	}
	
	//creation alternative
	public Departement(String nomDept, String mnemo, String versionDiplome,
			Utilisateur responsableDept, ArrayList<Annee> lesAnnees) {
		super();
		this.nomDept = nomDept;
		this.mnemo = mnemo;
		this.versionDiplome = versionDiplome;
		Responsable = responsableDept;
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
 * R�cupère le nom du d�partement
 * @return le nom du d�partement 
 *            
 */
	public String getNomDept() {
		return nomDept;
	}
	
/**
	 * 
	 * change le nom du d�partement
	 * @param nomDept le nom que l'on veut affecter au d�partement 
	 *            
	 */
	public void setNomDept(String nomDept) {
		this.nomDept = nomDept;
	}
	
	
/**
	 * 
	 * R�cupère le mn�monique du d�partement
	 * @return le mnemonique du d�partement 
	 *            
	 */	
	public String getMnemo() {
		return mnemo;
	}
	
/**
	 * 
	 * Change le mn�monique du d�partement
	 * @param mnemo le mn�monique que l'on veut affecter au d�partement 
	 *            
	 */
	public void setMnemo(String mnemo) {
		this.mnemo = mnemo;
	}
	
	
/**
	 * 
	 * R�cupère le code VersionDiplome du d�partement
	 * @return le code VersionDiplome du d�partement
	 *            
	 */
	public String getVersionDiplome() {
		return versionDiplome;
	}
	

/**
	 * 
	 * Change le code VersionDiplome du d�partement
	 * @param versionDiplome le code versionDiplome que l'on veut affecter au d�partement 
	 *            
	 */
	public void setVersionDiplome(String versionDiplome) {
		this.versionDiplome = versionDiplome;
	}

	
/**
	 * 
	 * r�cupère la liste des ann�es appartenant au d�partement
	 * @return l'ArrayList contenant les objets Annee appartenant au d�partement 
	 *            
	 */
	public ArrayList<Annee> getLesAnnees() {
		return this.Listeannee;
	}
	
	
/**
	 * 
	 * Affecte au d�partement une liste d'ann�es
	 * @param lesAnnees contient les objets Annee que l'on veut affecter au d�partement 
	 *            
	 */
	public void setLesAnnees(ArrayList<Annee> lesAnnees) {
		this.Listeannee = lesAnnees;
	}
    
	


	
	
	
public Utilisateur getResponsable() {
	return Responsable;
}


public void setResponsable(Utilisateur responsable) {
	Responsable = responsable;
}


/**
	 * 
	 * Chargement des informations sur les ann�es appartenant à un d�partement
	 * @param mnemo le mnemonique du d�partement dont on veut r�cupèrer les ann�es 
	 *            
	 */	
	
	public abstract void loadAnnee(String mnemo)throws SQLException; 

	
/**
	 * 
	 * Chargement d'une liste contenant toutes les ann�es appartenant au d�partement         
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
	 * Repr�sentation de l'objet en String pour les ComboBox
	 */		
	public String toString(){
		return this.mnemo;
	}
	
 }








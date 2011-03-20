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

	

	
	/***** getter and setter *****/
	public String getNomDept() {
		return nomDept;
	}
	public void setNomDept(String nomDept) {
		this.nomDept = nomDept;
	}
	public String getMnemo() {
		return mnemo;
	}
	public void setMnemo(String mnemo) {
		this.mnemo = mnemo;
	}
	public String getVersionDiplome() {
		return versionDiplome;
	}
	public void setVersionDiplome(String versionDiplome) {
		this.versionDiplome = versionDiplome;
	}
	
	public ArrayList<Annee> getLesAnnees() {
		return this.Listeannee;
	}
	
	public void setLesAnnees(ArrayList<Annee> lesAnnees) {
		this.Listeannee = lesAnnees;
	}
    
	/***** methodes *****/
	
	public abstract void loadAnnee(String mnemo)throws SQLException; //charger les infos sur les annees
	
	public abstract void LoadListeAnnee()throws SQLException; //charger une liste de toutes les annees du departement
	
 }








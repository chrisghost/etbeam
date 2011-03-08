package models;

import java.util.ArrayList;


public abstract class Departement  {
	protected String nomDept;
	protected String mnemo;
	protected String versionDiplome;
	protected Utilisateur ResponsableDept;
	protected ArrayList<Annee> lesAnnees;
    
    /***** constructeur *****/
	
	//creation d'un d�partement avec toutes les info relatives au d�partement
	public Departement(String nomDept, String mnemo, String versionDiplome) {
		super();
		this.nomDept = nomDept;
		this.mnemo = mnemo;
		this.versionDiplome = versionDiplome;
	}

	public Departement() {
	}
	
	//creation d'un d�partement en notifiant que sosn nom
	public Departement(String nomDept) {
		super();
		this.nomDept = nomDept;
	}

	//creation d'un d�partement en y associant un responsable
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
		this.lesAnnees = lesAnnees;
	}

	public Departement(String nomDept, String mnemo, String versionDiplome, ArrayList<Annee> lesAnnees) {
		super();
		this.nomDept = nomDept;
		this.mnemo = mnemo;
		this.versionDiplome = versionDiplome;
		this.lesAnnees = lesAnnees;
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
    
    

 }
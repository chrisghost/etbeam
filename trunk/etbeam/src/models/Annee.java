package models;

import java.util.ArrayList;


public  class Annee  {
    public String versionEtape;
    private Utilisateur ResponsableAn;
    private Departement dept;
    private ArrayList<Semestre> lesSem;

   /***** constructeurs *****/
    //creation d'une année sans responsable
	public Annee(String versionEtape) {
		super();
		this.versionEtape = versionEtape;
	}
	
	//creation d'une année associée à son responsable
	public Annee(String versionEtape, Utilisateur responsableAn) {
		super();
		this.versionEtape = versionEtape;
		ResponsableAn = responsableAn;
	}
	
	//creation d'une année alternative
	public Annee(String versionEtape, Utilisateur responsableAn,
			Departement dept) {
		super();
		this.versionEtape = versionEtape;
		ResponsableAn = responsableAn;
		this.dept = dept;
	}

	public Annee(String versionEtape, Utilisateur responsableAn,ArrayList<Semestre> lesSem) {
		super();
		this.versionEtape = versionEtape;
		ResponsableAn = responsableAn;
		this.lesSem = lesSem;
	}
	
	public Annee(String versionEtape, ArrayList<Semestre> lesSem) {
		super();
		this.versionEtape = versionEtape;
		this.lesSem = lesSem;
	}
	
	public Annee(String versionEtape,
			Departement dept) {
		super();
		this.versionEtape = versionEtape;
		this.dept = dept;
		
	}
	public Annee(String versionEtape, Utilisateur responsableAn,
			Departement dept, ArrayList<Semestre> lesSem) {
		super();
		this.versionEtape = versionEtape;
		ResponsableAn = responsableAn;
		this.dept = dept;
		this.lesSem = lesSem;
	}
	
	
	/***** getter and setter *****/

	public String getVersionEtape() {
		return versionEtape;
	}

	

	public void setVersionEtape(String versionEtape) {
		this.versionEtape = versionEtape;
	}

 }
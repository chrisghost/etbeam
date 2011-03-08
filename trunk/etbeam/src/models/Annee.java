package models;

import java.util.ArrayList;

import models.Utilisateur;

public abstract class Annee  {

    protected String versionEtape;
    protected Utilisateur ResponsableAn;

    protected Departement dept;

    protected ArrayList<Semestre> semestres;

   /***** constructeurs *****/
    //creation d'une ann�e sans responsable

    
	public Annee(String versionEtape) {
		this.versionEtape = versionEtape;
	}
	
	//creation d'une ann�e associ�e � son responsable
	public Annee(String versionEtape, Utilisateur responsableAn) {
		super();
		this.versionEtape = versionEtape;
		ResponsableAn = responsableAn;
	}
	
	//creation d'une ann�e alternative
	public Annee(String versionEtape, Utilisateur responsableAn,
			Departement dept) {
		super();
		this.versionEtape = versionEtape;
		ResponsableAn = responsableAn;
		this.dept = dept;
	}

	public Annee(String versionEtape, Utilisateur responsableAn,ArrayList<Semestre> semestres) {
		super();
		this.versionEtape = versionEtape;
		ResponsableAn = responsableAn;
		this.semestres = semestres;
	}
	
	public Annee(String versionEtape, ArrayList<Semestre> semestres) {
		super();
		this.versionEtape = versionEtape;
		this.semestres = semestres;
	}
	
	public Annee(String versionEtape,
			Departement dept) {
		super();
		this.versionEtape = versionEtape;
		this.dept = dept;
		
	}
	public Annee(String versionEtape, Utilisateur responsableAn,
			Departement dept, ArrayList<Semestre> semestres) {
		super();
		this.versionEtape = versionEtape;
		ResponsableAn = responsableAn;
		this.dept = dept;
		this.semestres = semestres;
	}
	
	
	public Annee() {
		// TODO Auto-generated constructor stub
	}

	/***** getter and setter *****/

	public String getVersionEtape() {
		return versionEtape;
	}

	

	public void setVersionEtape(String versionEtape) {
		this.versionEtape = versionEtape;
	}
	

	public void setResponsableAn(Utilisateur responsableAn) {
		ResponsableAn = responsableAn;
	}

	public Utilisateur getResponsableAn() {
		return ResponsableAn;
	}
	
 }
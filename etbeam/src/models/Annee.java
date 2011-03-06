package models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Bd;
import models.Utilisateur;

public class Annee  {

    public String versionEtape;
    private Utilisateur ResponsableAn;

    private Departement dept;

    private ArrayList<Semestre> semestres;

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
	
	
	/***** getter and setter *****/

	public String getVersionEtape() {
		return versionEtape;
	}

	

	public void setVersionEtape(String versionEtape) {
		this.versionEtape = versionEtape;
	}
	
	

	public void load(String versionetape) throws SQLException{
		Bd base = new Bd();
		
		ResultSet r = null;
		r = base.execute("SELECT * FROM annee WHERE version_etape="+versionetape);
		
		//recuperation des informations de l annee
		while(r.next()){
			this.ResponsableAn = new Utilisateur();
			this.ResponsableAn.load(Integer.parseInt(r.getString("id_responsable")));
		}
		
		r = base.execute("SELECT * FROM semestre WHERE version_etape="+versionetape);
		
		
		//Recuperation des semestres
		while(r.next()){
			Semestre s = new Semestre(
				r.getString("libelle_sem"),
				r.getString("code_sem"),
				Integer.parseInt(r.getString("nb_ue_fac")));
			
			s.load();
			this.semestres.add(s);
		}
		
		base.close();
	}

	public void setResponsableAn(Utilisateur responsableAn) {
		ResponsableAn = responsableAn;
	}

	public Utilisateur getResponsableAn() {
		return ResponsableAn;
	}
	
 }
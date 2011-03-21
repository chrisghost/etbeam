package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import models.Utilisateur;

public abstract class Annee extends Model {

    protected String versionEtape;
    protected Utilisateur ResponsableAn;
    protected String mnemo; 
   

	protected Departement dept;

    protected ArrayList<Semestre> semestres = new ArrayList<Semestre>();
    
    protected void addVars(){
    	this.addVar("versionEtape");
    	this.addVar("mnemo");
    }
    

   /***** constructeurs *****/
    //creation d'une ann�e sans responsable

    
	public Annee(String versionEtape) {
		super();
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
		super();
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
	
	 public String getMnemo() {
			return mnemo;
		}

		public void setMnemo(String mnemo) {
			this.mnemo = mnemo;
		}
		
		
		public ArrayList<Semestre> getSemestres() {
			return semestres;
		}


		public void setSemestres(ArrayList<Semestre> semestres) {
			this.semestres = semestres;
		}


		/***** METHODES *****/

		public abstract void loadSemestre(String versionE) throws SQLException;//charge une liste de semestre en fonction d'une annee
 
		public String getcodebylib(String lib) {

			String code = null;
			Semestre sem;
			Iterator<Semestre> i = this.getSemestres().iterator();
			while (i.hasNext()){
				sem=i.next();
				if(sem.getLibelleSem().equals(lib)){
					code = sem.getCodeSemestre();
				}}
			return code;
		}



		
}
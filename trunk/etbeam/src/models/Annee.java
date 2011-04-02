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



/**
     * 
     * @return le code version étape caractérisant l'Année 
     *            
     */
	public String getVersionEtape() {
		return versionEtape;
	}

	
	
/**
     * 
     * Change le code versionEtape de l'Année
     * @param versionEtape le nouveau code versionEtape que l'on veut affecter à l'Année
     *            
     */
	public void setVersionEtape(String versionEtape) {
		this.versionEtape = versionEtape;
	}
	

	
/**
     * 
     * Change le responsable de l'Année
     * @param responsableAn l'objet Utilisateur que l'on veut rendre responsable de l'Année
     *            
     */
	public void setResponsableAn(Utilisateur responsableAn) {
		ResponsableAn = responsableAn;
	}

	
/**
     * 
     * Récupère le responsable de l'Année
     * @return l'objet Utilisateur qui est responsable de l'Année
     *            
     */
	public Utilisateur getResponsableAn() {
		return ResponsableAn;
	}

	
/**
     * 
     * Récupère le mnémonique de l'Année
     * @return le mnémonique caractérisant l'Année
     *            
     */
	 public String getMnemo() {
			return mnemo;
		}

	 
/**
	     * 
	     * change le mnémonique de l'Année
	     * @param mnemo le mnémonique que l'on veut affecter à l'Année
	     *            
	     */
		public void setMnemo(String mnemo) {
			this.mnemo = mnemo;
		}
		

/**
	     * 
	     * Récupère la liste des semestres appartenant à l'Année
	     * @return un ArrayList contenant les Objets Semestre appartenant à l'Année 
	     *            
	     */
		public ArrayList<Semestre> getSemestres() {
			return semestres;
		}


/**
	     * 
	     * Affecte à l'Année une liste de Semestre qui lui appartient
	     * @param semestres un ArrayList d'objets Semestre qu'on veut affecter à l'Année 
	     *            
	     */
		public void setSemestres(ArrayList<Semestre> semestres) {
			this.semestres = semestres;
		}



/**
	     * 
	     * Charge une liste de semestre qui appartiennent à une Année
	     *            
	     */
		public abstract void loadSemestre();

		
		/**
		 * Représentation de l'objet en String pour les ComboBox
		 * @return String
		 */		
		public String toString(){
			return this.mnemo;
		}

		
}
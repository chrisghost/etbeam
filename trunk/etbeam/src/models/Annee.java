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
     * @return le code version �tape caract�risant l'Ann�e 
     *            
     */
	public String getVersionEtape() {
		return versionEtape;
	}

	
	
/**
     * 
     * Change le code versionEtape de l'Ann�e
     * @param versionEtape le nouveau code versionEtape que l'on veut affecter à l'Ann�e
     *            
     */
	public void setVersionEtape(String versionEtape) {
		this.versionEtape = versionEtape;
	}
	

	
/**
     * 
     * Change le responsable de l'Ann�e
     * @param responsableAn l'objet Utilisateur que l'on veut rendre responsable de l'Ann�e
     *            
     */
	public void setResponsableAn(Utilisateur responsableAn) {
		ResponsableAn = responsableAn;
	}

	
/**
     * 
     * R�cupère le responsable de l'Ann�e
     * @return l'objet Utilisateur qui est responsable de l'Ann�e
     *            
     */
	public Utilisateur getResponsableAn() {
		return ResponsableAn;
	}

	
/**
     * 
     * R�cupère le mn�monique de l'Ann�e
     * @return le mn�monique caract�risant l'Ann�e
     *            
     */
	 public String getMnemo() {
			return mnemo;
		}

	 
/**
	     * 
	     * change le mn�monique de l'Ann�e
	     * @param mnemo le mn�monique que l'on veut affecter à l'Ann�e
	     *            
	     */
		public void setMnemo(String mnemo) {
			this.mnemo = mnemo;
		}
		

/**
	     * 
	     * R�cupère la liste des semestres appartenant à l'Ann�e
	     * @return un ArrayList contenant les Objets Semestre appartenant à l'Ann�e 
	     *            
	     */
		public ArrayList<Semestre> getSemestres() {
			return semestres;
		}


/**
	     * 
	     * Affecte à l'Ann�e une liste de Semestre qui lui appartient
	     * @param semestres un ArrayList d'objets Semestre qu'on veut affecter à l'Ann�e 
	     *            
	     */
		public void setSemestres(ArrayList<Semestre> semestres) {
			this.semestres = semestres;
		}



/**
	     * 
	     * Charge une liste de semestre qui appartiennent à une Ann�e
	     *            
	     */
		public abstract void loadSemestre();

		
		/**
		 * Repr�sentation de l'objet en String pour les ComboBox
		 * @return String
		 */		
		public String toString(){
			return this.mnemo;
		}

		
}
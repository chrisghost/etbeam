package models;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ECUE extends Model {
	protected String libelleECUE;
	protected String codeECUE;
	protected float volumeHoraire;
	protected Utilisateur responsableECUE;
	protected UE uniteE;
	protected ArrayList<Etudiant> listeEtud= new ArrayList<Etudiant>();
	
	protected void addVars(){
		this.addVar("codeECUE");
		this.addVar("libelleECUE");
		this.addVar("volumeHoraire");
	}
	
	
	
	public ArrayList<Etudiant> getListeEtud() {
		return listeEtud;
	}


	public void setListeEtud(ArrayList<Etudiant> listeEtud) {
		this.listeEtud = listeEtud;
	}

	protected float coeff;
  
    
    public float getCoeff() {
		return coeff;
	}


	public void setCoeff(float coeff) {
		this.coeff = coeff;
	}


	/**** constructeurs *****/
	public ECUE(){
		super();
	}
	
	//constructeur ayant toutes les info concernant une ECUE
	public ECUE(String libelleECUE, String codeECUE, float volumHoraire){
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
		this.volumeHoraire = volumHoraire;
	}


	//constructeur d'une ECUE associ�e � son responsable
	public ECUE(String libelleECUE, String codeECUE, float volumHoraire,
			Utilisateur responsableECUE) {
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
		this.volumeHoraire = volumHoraire;
		this.responsableECUE = responsableECUE;
	}
	
	public abstract void load() throws SQLException;
	
	
	/***** getter and setter *****/

	public String getLibelleECUE() {
		return libelleECUE;
	}
	public void setLibelleECUE(String libelleECUE) {
		this.libelleECUE = libelleECUE;
	}
	public String getCodeECUE() {
		return codeECUE;
	}
	public void setCodeECUE(String codeECUE) {
		this.codeECUE = codeECUE;
	}
	public float getVolumeHoraire() {
		return volumeHoraire;
	}
	public void setVolumeHoraire(float volumHoraire) {
		this.volumeHoraire = volumHoraire;
	}

	public Utilisateur getResponsableECUE() {
		return responsableECUE;
	}

	public void setResponsableECUE(Utilisateur responsableECUE) {
		this.responsableECUE = responsableECUE;
	}

	
	//recup�re la liste des �tudiants
	public abstract void loadEtudiant();

	
	//modification coeff : gestion ECUE
	public abstract void saveCoeff() throws SQLException;


	// modification note : gestion ECUE
	public ArrayList<String> getEtudiantINE() {
			ArrayList<String> listINE = new ArrayList<String>();
			for (Iterator<Etudiant> i = this.listeEtud.iterator(); i.hasNext();){
				listINE.add((String)(i.next().getNumINE()));
			}
			return listINE;
		}
	public abstract void changeNoteEtudiantECUE(Etudiant etud, int numsess, float note) throws SQLException;
	

	// recup�re la note � l'ECUE de l'etudiant (numsess= numero de session) : gestion ECUE
	public abstract double getEtudiantNote(Etudiant etud, int numsess);



	
	public String toString(){
		return this.libelleECUE;
	}


    
 }

package models;


import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ECUE extends Model {
	protected String libelleECUE;
	protected String codeECUE;
	protected float volumeHoraire;
	protected Utilisateur responsableECUE;
	protected UE uniteE;
	protected ArrayList<Etudiant> listeEtud;
	
	protected void addVars(){
		this.addVar("libelleECUE");
		this.addVar("codeECUE");
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


    
 }

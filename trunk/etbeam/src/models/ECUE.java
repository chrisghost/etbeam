package models;


import java.util.ArrayList;

public abstract class ECUE  {
	protected String libelleECUE;
	protected String codeECUE;
	protected float volumHoraire;
	protected Utilisateur responsableECUE;
	protected UE uniteE;
	protected ArrayList<Etudiant> listeEtud;
  
    
    /**** constructeurs *****/
    
    
	public ECUE(String libelleECUE, String codeECUE) {
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
	}
	
	//constructeur ayant toutes les info concernant une ECUE
	public ECUE(String libelleECUE, String codeECUE, int volumHoraire) {
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
		this.volumHoraire = volumHoraire;
	}


	//constructeur d'une ECUE associ�e � son responsable
	public ECUE(String libelleECUE, String codeECUE, float volumHoraire,
			Utilisateur responsableECUE) {
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
		this.volumHoraire = volumHoraire;
		this.responsableECUE = responsableECUE;
	}
	
	public abstract void load();
	
	
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
	public float getVolumHoraire() {
		return volumHoraire;
	}
	public void setVolumHoraire(int volumHoraire) {
		this.volumHoraire = volumHoraire;
	}

    
 }
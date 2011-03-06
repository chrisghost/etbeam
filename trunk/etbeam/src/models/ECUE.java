package models;


import java.util.ArrayList;

public  class ECUE  {
    public String libelleECUE;
    public String codeECUE;
    public int volumHoraire;
    private Utilisateur responsableECUE;
    private UE uniteE;
    private ArrayList<Etudiant> listeEtud;
    
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


	//constructeur d'une ECUE associée à son responsable
	public ECUE(String libelleECUE, String codeECUE, int volumHoraire,
			Utilisateur responsableECUE) {
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
		this.volumHoraire = volumHoraire;
		this.responsableECUE = responsableECUE;
	}
	
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
	public int getVolumHoraire() {
		return volumHoraire;
	}
	public void setVolumHoraire(int volumHoraire) {
		this.volumHoraire = volumHoraire;
	}

    
 }
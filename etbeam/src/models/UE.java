package models;

import java.util.ArrayList;

public class UE {
	public String optionelle;
	public int nbECTS;
	public String libelleUE;
	public String codeUE;
	private Utilisateur responsableUE;
	private Semestre sem;
	private ArrayList<ECUE> lesECUE;
	
	public UE(String optionelle, int nbects, String libel, String code){
		
		this.optionelle = optionelle;
		this.nbECTS = nbects;
		this.libelleUE = libel;
		this.codeUE = code;
	}

	
	public String getOptionelle() {
		return optionelle;
	}


	public void setOptionelle(String optionelle) {
		this.optionelle = optionelle;
	}


	public int getNbECTS() {
		return nbECTS;
	}


	public void setNbECTS(int nbECTS) {
		this.nbECTS = nbECTS;
	}


	public String getLibelleUE() {
		return libelleUE;
	}


	public void setLibelleUE(String libelleUE) {
		this.libelleUE = libelleUE;
	}


	public String getCodeUE() {
		return codeUE;
	}


	public void setCodeUE(String codeUE) {
		this.codeUE = codeUE;
	}


	public float getmoyenne() {

		return 0;
	}

}

package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Bd;

public class UE {
	public boolean optionelle;
	public int nbECTS;
	public String libelleUE;
	public String codeUE;
	private Utilisateur responsableUE;
	private Semestre sem;
	private ArrayList<ECUE> lesECUE;
	
	/***** constructeurs *****/
	public UE(boolean optionelle, int nbects, String libel, String code){
		
		this.optionelle = optionelle;
		this.nbECTS = nbects;
		this.libelleUE = libel;
		this.codeUE = code;
	}

	//constructeur ssoci� � un responsable
	
	public UE(boolean optionelle, int nbECTS, String libelleUE, String codeUE,
			Utilisateur responsableUE) {
		super();
		this.optionelle = optionelle;
		this.nbECTS = nbECTS;
		this.libelleUE = libelleUE;
		this.codeUE = codeUE;
		this.responsableUE = responsableUE;
	}

	
	public void load() throws SQLException{
		Bd base = new Bd();
		
		ResultSet r = null;
		
		r = base.execute("SELECT * FROM ecue WHERE code_ue="+this.codeUE);
		
		
		//Recuperation des ecue
		while(r.next()){
			
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.load(r.getInt("id_responsable"));
			
			
			ECUE ecue = new ECUE(r.getString("libelle_ecue"),
					r.getString("code_matiere"),
					r.getFloat("vol_horaire"),
					utilisateur);
			
			ecue.load();
			this.lesECUE.add(ecue);
		}
		
		base.close();
	}
	
	/***** getter and setter *****/
	public boolean getOptionelle() {
		return optionelle;
	}



	public void setOptionelle(boolean optionelle) {
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

/***** methodes *****/
	public float getmoyenne() {
		return 0;
	}

}
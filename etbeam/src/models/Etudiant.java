package models;
import java.sql.SQLException;
import java.util.ArrayList;

import models.mysql.EtudiantMySQL;
public abstract class Etudiant extends Personne {

	protected int scoreTOEIC;
	protected float ptsJury;
	protected String numINE;
	protected String numEtud;
	protected ArrayList<ECUE> listeECUE;
	protected ArrayList<UE> listeUEfacultatives;
	
	/***** constructeurs *****/
	public Etudiant() {
		super();
	}
	
	
	public Etudiant(String numINE, String numEtud) {
		super();
		this.numINE = numINE;
		this.numEtud = numEtud;
	}
	
	
	public Etudiant(int scoreTOEIC, String numINE, String numEtud) {
		super();
		this.scoreTOEIC = scoreTOEIC;
		this.numINE = numINE;
		this.numEtud = numEtud;
	}

//constructeur alternatif
	
	public Etudiant(int scoreTOEIC, float ptsJury, String numINE,
			String numEtud, ArrayList<UE> listeUEfacultatives) {
		super();
		this.scoreTOEIC = scoreTOEIC;
		this.ptsJury = ptsJury;
		this.numINE = numINE;
		this.numEtud = numEtud;
		this.listeUEfacultatives = listeUEfacultatives;
	}


	public Etudiant(float ptsJury, String numINE, String numEtud) {
		super();
		this.ptsJury = ptsJury;
		this.numINE = numINE;
		this.numEtud = numEtud;
	}

/***** getter and setter *****/
	
	public int getScoreTOEIC() {
		return scoreTOEIC;
	}
	public void setScoreTOEIC(int scoreTOEIC) {
		this.scoreTOEIC = scoreTOEIC;
	}
	public float getPtsJury() {
		return ptsJury;
	}
	public void setPtsJury(float ptsJury) {
		this.ptsJury = ptsJury;
	}
	public String getNumINE() {
		return numINE;
	}
	public void setNumINE(String numINE) {
		this.numINE = numINE;
	}
	public String getNumEtud() {
		return numEtud;
	}
	public void setNumEtud(String numEtud) {
		this.numEtud = numEtud;
	}
	
	/***************************************************************************************/
	
	/**
	 * @throws SQLException 
	 *
	 */
	public abstract ArrayList<String> getIdsByName(String nom) throws SQLException;
	public abstract void load(String ine) throws SQLException;
	
	//supprimer un étudiant de la base
	public abstract void deleteFromBD() throws SQLException;

	//sauver informtions etudiant dans BD
	public abstract void saveInfoInBD() throws SQLException;
}

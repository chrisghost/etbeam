package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.MySQL;
import java.util.ArrayList;

public abstract class Semestre extends Model {
	protected String LibelleSem;
	protected String CodeSemestre;
	protected int NbUEfacultatives;
	protected Annee an;
	protected ArrayList<UE> lesUE = new ArrayList<UE>();

	
	protected void addVars(){
		this.addVar("CodeSemestre");
		this.addVar("LibelleSem");
		this.addVar("NbUEfacultatives");
	}
	
	/***** constructeurs *****/
	
	
	public Semestre() {
		super();
	}
	
	public Semestre(String libel, String code, int nbue){
		super();
		this.LibelleSem = libel;
		this.CodeSemestre = code;
		this.NbUEfacultatives = nbue;
		
	}

	
	/***** methodes *****/
	public abstract void load() throws SQLException;
	public abstract void loadUE(String id_sem) throws SQLException;//charge la liste des UE d'un semestre
	

	/***** getter and setter *****/
	public String getLibelleSem() {
		return LibelleSem;
	}
	public void setLibelleSem(String libelleSem) {
		this.LibelleSem = libelleSem;
	}
	public String getCodeSemestre() {
		return CodeSemestre;
	}
	public void setCodeSemestre(String codeSemestre) {
		CodeSemestre = codeSemestre;
	}
	public int getNbUEfacultatives() {
		return NbUEfacultatives;
	}
	public void setNbUEfacultatives(int nbUEfacultatives) {
		NbUEfacultatives = nbUEfacultatives;
	}

	public ArrayList<UE> getLesUE() {
		return lesUE;
	}
	
}
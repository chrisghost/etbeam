package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.MySQL;
import java.util.ArrayList;

public abstract class Semestre {
	protected String LibelleSem;
	protected String CodeSemestre;
	protected int NbUEfacultatives;
	protected Annee an;
	protected ArrayList<UE> lesUE;

	
	/***** constructeurs *****/
	
	
	public Semestre() {
		
	}
	
	public Semestre(String libel, String code, int nbue){
		
		this.LibelleSem = libel;
		this.CodeSemestre = code;
		this.NbUEfacultatives = nbue;
		
	}

	public abstract void load() throws SQLException;
	

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

}
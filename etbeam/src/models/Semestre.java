package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.MySQL;
import java.util.ArrayList;
import java.util.Iterator;

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
	public abstract void load();
	public abstract float getMoySem(Etudiant et);
	public abstract void loadUE(String id_sem) throws SQLException;//charge la liste des UE d'un semestre
	
	public String getcodebylib(String lib) {

		String code = null;
		UE ue;
		Iterator<UE> i = this.getLesUE().iterator();
		while (i.hasNext()){
			ue=i.next();
			if(ue.getLibelleUE().equals(lib)){
				code = ue.getCodeUE();
			}}
		return code;
	}
	

	
	

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

	public void setLesUE(ArrayList<UE> lesUE) {
		this.lesUE = lesUE;
	}




	public String toString(){
		return this.LibelleSem;
	}
	
}
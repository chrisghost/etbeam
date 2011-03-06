package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Bd;
import java.util.ArrayList;




public class Semestre {
	public String LibelleSem;
	public String CodeSemestre;
	public int NbUEfacultatives;
	private Annee an;
	private ArrayList<UE> lesUE;

	
	/***** constructeurs *****/
	

	public Semestre(String libel, String code, int nbue){
		
		this.LibelleSem = libel;
		this.CodeSemestre = code;
		this.NbUEfacultatives = nbue;
		
	}


	
	public void load() throws SQLException{
		Bd base = new Bd();
		
		ResultSet r = null;
		
		r = base.execute("SELECT * FROM ue WHERE code_sem="+this.CodeSemestre);
		
		
		//Recuperation des UE
		while(r.next()){
			
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.load(r.getInt("id_responsable"));
			
			UE ue = new UE(r.getBoolean("optionnel"),
					Integer.parseInt(r.getString("nb_ects")),
					r.getString("lib_ue"),
					r.getString("code_ue"),
					utilisateur);
			
			ue.load();
			this.lesUE.add(ue);
		}
		
		base.close();
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

}
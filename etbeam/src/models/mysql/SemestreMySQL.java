package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Facade;
import bd.MySQL;

import models.Semestre;

public class SemestreMySQL extends Semestre{

	
	/***** constructeurs *****/
	/*

	public SemestreMySQL(String libel, String code, int nbue){
		
		this.LibelleSem = libel;
		this.CodeSemestre = code;
		this.NbUEfacultatives = nbue;
		
	}

	*/
	
	public SemestreMySQL() {
	
	}

	public void load() throws SQLException{
		MySQL base = (MySQL) Facade.getBD();
		
		ResultSet r = null;
		
		r = base.execute("SELECT * FROM ue WHERE code_sem="+this.CodeSemestre);
		
		
		//Recuperation des UE
		while(r.next()){
			
			UtilisateurMySQL utilisateur = new UtilisateurMySQL();
			utilisateur.load(r.getInt("id_responsable"));
			
			UEMySQL ue = new UEMySQL(r.getBoolean("optionnel"),
									Integer.parseInt(r.getString("nb_ects")),
									r.getString("lib_ue"),
									r.getString("code_ue"),
									utilisateur);
			
			ue.load();
			this.lesUE.add(ue);
		}
		
		base.close();
	}

}
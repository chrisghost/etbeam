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
		
	}
*/
	
	
	public SemestreMySQL() {
	
	}

	
	/***** methodes *****/
	
	public void load() throws SQLException{
		MySQL base = (MySQL) Facade.getBD();
		
		ResultSet r = null;
		
		r = base.execute("SELECT * FROM ue WHERE code_semestre='"+this.CodeSemestre+"'");
		
		
		
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

	@Override
	public void loadUE(String id_sem) throws SQLException {
			MySQL base = (MySQL) Facade.getBD();
			ResultSet r = null;
			r = base.execute("SELECT * from ue WHERE code_semestre="+id_sem);
			while (r.next()){
				UEMySQL unite = new UEMySQL();
				unite.setCodeUE(r.getString("code_ue"));
				unite.setLibelleUE(r.getString("lib_ue"));
				unite.setNbECTS(r.getInt("nb_ects"));
				unite.setOptionelle(r.getBoolean("optionnel"));
				
				this.lesUE.add(unite);
			}

		}


}

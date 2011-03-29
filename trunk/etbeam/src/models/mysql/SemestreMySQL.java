package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Facade;
import bd.MySQL;

import models.Etudiant;
import models.Semestre;
import models.UE;

public class SemestreMySQL extends Semestre{

	
	/***** constructeurs *****/

/*
	public SemestreMySQL(String libel, String code, int nbue){
		
	}
*/
	
	
	public SemestreMySQL() {
		super();
	}

	
	/***** methodes *****/
	
	public void load(){
		MySQL base = (MySQL) Facade.getInstance().getBD();
		
		ResultSet r = null;
		
		try {
			r = base.execute("SELECT * FROM ue WHERE code_semestre='"+this.getCodeSemestre()+"'");
		
			
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public float getMoySem(Etudiant et){
		float moyue = 0;
		float ptsue = 0;
		float moysem = 0;
		float coef = 1;
		float totcoef = 0;
		ArrayList<UE> lUE = this.getLesUE();
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		
		
		for (UE ue : lUE){
			try {
				r = base.execute("SELECT coef FROM ue WHERE code_ue='"+ue.getCodeUE()+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				coef=r.getFloat("coef");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			moyue=(float) ue.getMoyenne(et);
			ptsue=ue.getPointsJuryUe(et);
			moysem= moysem + (moyue+ptsue)*coef;
			totcoef=totcoef+coef;
		}
		
		
		return moysem/totcoef;
	}

	
	
	public void loadUE(String id_sem) throws SQLException {
			MySQL base = (MySQL) Facade.getInstance().getBD();
			ResultSet r = null;
			r = base.execute("SELECT * from ue WHERE code_semestre='"+this.getCodeSemestre()+"'");
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

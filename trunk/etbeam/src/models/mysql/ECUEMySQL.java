package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.MySQL;
import models.ECUE;
import models.Utilisateur;

public class ECUEMySQL extends ECUE{

	public ECUEMySQL() {
		super();
	}
	
	public ECUEMySQL(String libelleECUE, String codeECUE,float volHoraire, UtilisateurMySQL utilisateur) {
		super(libelleECUE, codeECUE, volHoraire, utilisateur);
	}
	

	public void load() throws SQLException{
		MySQL base = new MySQL();
		
		ResultSet r = null;
		r = base.execute("SELECT * FROM ecue WHERE code_matiere="+this.codeECUE);
		
		//recuperation des informations de l annee
		while(r.next()){
			this.setLibelleECUE(r.getString("libelle_ecue"));
			this.setVolumHoraire(r.getFloat("vol_horaire"));
			this.setCodeECUE(r.getString("code_ue"));
			
			Utilisateur resp = new UtilisateurMySQL();
			resp.load(r.getInt("id_responsable"));
			
			this.setResponsableECUE(resp);

		}
		
		base.close();
	}
    
}
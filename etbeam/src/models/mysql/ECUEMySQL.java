package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Facade;
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
		MySQL base = (MySQL) Facade.getBD();
		
		ResultSet r1,r2 = null;
		r1 = base.execute("SELECT num_ine FROM note WHERE code_ecue="+this.codeECUE);
		
		
		while(r1.next()){
			/*
			 * Commenté pour les tests
			 * 
			r2 = base.execute("SELECT * FROM etudiant WHERE num_ine =" + r1.getString("num_ine"));
						
			EtudiantMySQL etudiant = new EtudiantMySQL();
			
			etudiant.setNumINE(r2.getString("num_ine"));
			
			*/
			
			
			
			//etudiant.setNom(nom);
			
			
			
			
			
			/*this.setLibelleECUE(r.getString("libelle_ecue"));
			this.setVolumHoraire(r.getFloat("vol_horaire"));
			this.setCodeECUE(r.getString("code_ue"));
			
			Utilisateur resp = new UtilisateurMySQL();
			resp.load(r.getInt("id_responsable"));
			
			this.setResponsableECUE(resp);
*/
		}
	}
    
}
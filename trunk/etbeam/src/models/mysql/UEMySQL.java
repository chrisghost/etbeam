package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.UE;

import bd.Facade;
import bd.MySQL;

public class UEMySQL extends UE{
	
	/***** constructeurs *****/
	public UEMySQL(){
		
	}
	
	public UEMySQL(boolean optionelle, int nbects, String libel, String code){
		
		this.optionelle = optionelle;
		this.nbECTS = nbects;
		this.libelleUE = libel;
		this.codeUE = code;
	}
	

	//constructeur ssoci� � un responsable
	
	public UEMySQL(boolean optionelle, int nbECTS, String libelleUE, String codeUE,
			UtilisateurMySQL responsableUE) {
		super();
		this.optionelle = optionelle;
		this.nbECTS = nbECTS;
		this.libelleUE = libelleUE;
		this.codeUE = codeUE;
		this.responsableUE = responsableUE;
	}
	
	
	public void load() throws SQLException{
		MySQL base = (MySQL) Facade.getBD();
		
		ResultSet r = null;
		
		r = base.execute("SELECT * FROM ecue WHERE code_ue="+this.codeUE);
		
		
		//Recuperation des ecue
		while(r.next()){
			
			UtilisateurMySQL utilisateur = new UtilisateurMySQL();
			utilisateur.load(r.getInt("id_responsable"));
			
			
			ECUEMySQL ecue = new ECUEMySQL(r.getString("libelle_ecue"),
					r.getString("code_matiere"),
					r.getFloat("vol_horaire"),
					utilisateur);
			
			ecue.load();
			this.lesECUE.add(ecue);
		}
		
		base.close();
	}

}

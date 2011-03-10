package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Facade;
import bd.MySQL;

import models.Utilisateur;

public class UtilisateurMySQL extends Utilisateur {

    /***** contructeurs *****/
	
    //constructeur par d�faut
	
    public UtilisateurMySQL() {
		super();
	}
    
	public void load(int id) throws SQLException{	
		
		MySQL base = (MySQL) Facade.getBD();
		
		ResultSet r = null;
		r = base.execute("SELECT * FROM utilisateur WHERE id="+id);
		
		while(r.next()){
			this.setLogin(r.getString("login"));
			this.setPassWord(r.getString("mdp"));
		//	this.setSexe(r.getString("sexe"));
		//	this.setMail(r.getString("mail"));
		//	this.setNom(r.getString("nom"));
		//	this.setPrenom(r.getString("prenom"));
		}
	}

 }
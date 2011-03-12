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
		r = base.execute("SELECT * FROM utilisateur WHERE id_utilisateur="+id);
		
		while(r.next()){
			this.setLogin(r.getString("login"));
			this.setPassWord(r.getString("mdp"));
		//	this.setSexe(r.getString("sexe"));
		//	this.setMail(r.getString("mail"));
		//	this.setNom(r.getString("nom"));
		//	this.setPrenom(r.getString("prenom"));
		}
	}

	@Override
	protected void addVars() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect(){
		MySQL base = (MySQL) Facade.getBD();
				
		ResultSet r = null;
		try {
			//System.out.println("SELECT COUNT(*) as nb FROM utilisateur WHERE login='"+this.getLogin()+"' AND mdp='"+this.getPassWord()+"'");
			r = base.execute("SELECT COUNT(*) as nb FROM utilisateur WHERE login='"+this.getLogin()+"' AND mdp='"+this.getPassWord()+"'");
			r.next();
			
			if(r.getInt("nb") > 0){
				this.setLogged(true);
			}
		} catch (NullPointerException e) {
			System.out.println("Error while connecting User "+this.getLogin());
			System.out.println("Exiting...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error while connecting User "+this.getLogin());
			e.printStackTrace();
		}
		

	}

 }
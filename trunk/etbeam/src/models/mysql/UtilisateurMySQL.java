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
		
		MySQL base = (MySQL) Facade.getInstance().getBD();
		
		ResultSet r = null;
		r = base.execute("SELECT * FROM utilisateur WHERE id_utilisateur="+id);
		
		while(r.next()){
			this.setLogin(r.getString("login"));
			this.setPassWord(r.getString("mdp"));
			this.setId(id);
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

		public void saveUtilisateur(String login, String mdp, String id, String id_ens){
			MySQL base = (MySQL) Facade.getInstance().getBD();
			
			try {
				base.executeUpdate("INSERT INTO utilisateur SET login='"+login+"' , mdp='"+mdp+"' id_utilisateur='"+id+"' AND id_enseigant='"+id_ens+"'" );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	@Override
	public void connect(){
		MySQL base = (MySQL) Facade.getInstance().getBD();
				
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
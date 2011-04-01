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
			this.setRights(r.getInt("droits"));
			System.out.println("droits : "+r.getInt("droits"));
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

		public void save(String login, String mdp, String id_ens, Integer droits){
			MySQL base = (MySQL) Facade.getInstance().getBD();
			
			try {

				if(this.getId() != 0)			//Existent user
					base.executeUpdate("UPDATE utilisateur SET login='"+login+"' mdp='"+mdp+"', id_enseignant'"+id_ens+"', droits='"+droits+"'" +
							"WHERE id_utilisateur='"+this.getId()+"'");
				else							//New user
					base.executeUpdate("INSERT INTO utilisateur VALUES('"+login+"' , '"+mdp+"', '','"+id_ens+"', '"+droits+"')");
				
				this.setId(-1);	//	id != 0 => existent user in DB
				
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
			r = base.execute("SELECT id_utilisateur, COUNT(*) as nb FROM utilisateur WHERE login='"+this.getLogin()+"' AND mdp='"+this.getPassWord()+"'");
			r.next();
			this.load(r.getInt("id_utilisateur"));
			
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

	@Override
	public boolean loginExists(String l) {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		
		ResultSet r = null;
		try {
			r = base.execute("SELECT COUNT(*) as nb FROM utilisateur WHERE login='"+l+"'");
			r.next();

			return (r.getInt("nb") > 0);
		} catch (SQLException e) {
			return false;
		}
	}

 }
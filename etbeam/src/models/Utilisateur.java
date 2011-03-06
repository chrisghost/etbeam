package models;

import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< .mine
import bd.Bd;
=======
import java.util.ArrayList;
>>>>>>> .r45

<<<<<<< .mine
=======

>>>>>>> .r45
public  class Utilisateur extends Personne  {
    public String login;
    public String passWord;
    private ArrayList<ECUE> myECUE ;
    private ArrayList<UE> myUE;
    private ArrayList<Departement> myDept;
    private ArrayList<Annee> myAnnee;
    
<<<<<<< .mine
    public Utilisateur(){
    	
    }
=======
    /***** contructeurs *****/
    //constructeur par défaut
    public Utilisateur() {
		super();
	}
>>>>>>> .r45
    
    //constructeur avec toute les info d'un utilisateur
    public Utilisateur(String  log, String pwd){
    	this.login = log;
    	this.passWord = pwd;
    }
    
   
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
    
	public void load(Integer id) throws SQLException{
		Bd base = new Bd();
		
		ResultSet r = null;
		r = base.execute("SELECT * FROM utilisateur WHERE id="+id);
		
		while(r.next()){
			this.setLogin(r.getString("login"));
			this.setPassWord(r.getString("mdp"));
			this.setSexe(r.getString("sexe"));
			this.setMail(r.getString("mail"));
			this.setNom(r.getString("nom"));
			this.setPrenom(r.getString("prenom"));
		}
	}

 }
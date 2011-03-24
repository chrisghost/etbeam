package models;

import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;

public abstract class Utilisateur extends Model {
	protected String login;
    protected String passWord;
    protected int id;
    
    protected Boolean logged = false;
    
    protected Enseignant mec;

    /***** contructeurs *****/
    //constructeur par d�faut
    public Utilisateur() {
		super();
	}

    
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
    
	public Boolean getLogged() {
		return logged;
	}


	public void setLogged(Boolean logged) {
		this.logged = logged;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Enseignant getMec() {
		return mec;
	}


	public void setMec(Enseignant mec) {
		this.mec = mec;
	}


	public abstract void load(int id) throws SQLException;
	public abstract void connect();

 }
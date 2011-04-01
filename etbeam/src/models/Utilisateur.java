package models;

import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;

public abstract class Utilisateur extends Model {
	protected String login;
    protected String passWord;
    protected int id;
    
    protected Boolean logged = false;
    
    protected Enseignant ens;

    /***** contructeurs *****/
    //constructeur par dï¿½faut
    public Utilisateur() {
		super();
	}

    
    //constructeur avec toute les info d'un utilisateur
    public Utilisateur(String  log, String pwd){
    	this.login = log;
    	this.passWord = pwd;
    }
    
   
    
    
    
    /**	
     * récupère le login de l'utilisateur
     * @return le login de l'utilisateur
     *            
     */	
	public String getLogin() {
		return login;
	}
	
	
	/**	
     * change le login d'un utilisateur
     * @param login le login que l'on veut affecter à l'utilisateur           
     */	
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	/**	
     * récupère le mot de passe de l'utilisateur
     * @return le mot de passe de l'utilisateur
     */	
	public String getPassWord() {
		return passWord;
	}
	
	
	/**	
     * modifie le mot de passe de l'utilisateur
     * @param passWord le mot de passe que l'on veut affecter à l'utilisateur           
     */	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	/**	
     * récupère l'état de connexion de l'utilisateur : si il est connecté ou non
     * @return l'état de connexion de l'utilisateur           
     */	    
	public Boolean getLogged() {
		return logged;
	}


	/**	
     * change l'état de connexion de l'utilisateur
     * @param logged un booleen définissant l'état de connexion
     *            
     */	
	public void setLogged(Boolean logged) {
		this.logged = logged;
	}


	/**	
     * récupère l'Id de l'utilisateur
     * @return le code Id de l'utilisateur           
     */	
	public int getId() {
		return id;
	}


	/**	
     * change le code Id de l'utilisateur
     * @param id le code Id que l'on veut affecter à l'utilisateur           
     */	
	public void setId(int id) {
		this.id = id;
	}


	/**	
     * ???
     *            
     */	
	public Enseignant getEnseignant() {
		return ens;
	}
	
	

	/**	
     * ???
     *            
     */	
	public void setEnseignant(Enseignant ens) {
		this.ens = ens;
	}


	/**	
     * charge les informations concernant un Utilisateur
     * @param l'id de l'Utilisateur dont on veut les informations
     *            
     */	
	public abstract void load(int id) throws SQLException;
	
	
	
	/**	
     * Connecte l'utilisateur à la base de données
     *            
     */	
	public abstract void connect();

 }
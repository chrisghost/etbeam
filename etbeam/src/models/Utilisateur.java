package models;


import java.util.ArrayList;


public  class Utilisateur extends Personne  {
    public String login;
    public String passWord;
    private ArrayList<ECUE> myECUE ;
    private ArrayList<UE> myUE;
    private ArrayList<Departement> myDept;
    private ArrayList<Annee> myAnnee;
    
    
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
    

 }
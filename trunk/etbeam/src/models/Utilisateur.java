package models;





public  class Utilisateur extends Personne  {
    public String login;
    public String passWord;
    
    
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
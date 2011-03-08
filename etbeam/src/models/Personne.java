package models;

public abstract class Personne  {
	protected String nom;
	protected String prenom;
	protected String sexe;
	protected String mail;
    
    /***** constructeurs *****/
    
	public Personne() {
		super();
	}


	public Personne(String nom, String prenom, String sexe, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.mail = mail;
	}
	
	
	public Personne(String nom, String prenom, String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
	}
	

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	/***** getter and setter *****/

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

 }
package models;

public abstract class Personne extends Model {
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

	
	
	//METHODES

	/**	
     * récupère le nom de la personne
     * 
     * @return le nom de la personne
     */	
	public String getNom() {
		return nom;
	}
	
	
	/**	
     * change le nom de la personne
     * 
     * @param nom le nom que l'on veut affecter à la personne
     */	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	/**	
     * récupère le prénom de la personne
     * 
     * @return le prenom de la personne
     */	
	public String getPrenom() {
		return prenom;
	}
	
	
	/**	
     * change le prenom de la personne
     * 
     * @param prenom le prenom que l'on veut affecter à la personne
     */	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	/**	
     * récupère le sexe de la personne
     * 
     * @return le sexe de la personne
     */	
	public String getSexe() {
		return sexe;
	}
	
	
	/**	
     * change le sexe de la personne
     * 
     * @param sexe le sexe que l'on veut affecter à la personne
     */	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
	/**	
     * récupère le mail de la personne
     * 
     * @return le mail de la personne
     */	
	public String getMail() {
		return mail;
	}
	
	
	/**	
     * change le mail de la personne
     * 
     * @param mail le nouveau mail que l'on veut affecter à la personne
     */	
	public void setMail(String mail) {
		this.mail = mail;
	}


	/**	
     * récupère une concaténation du nom et du prénom de la personne
     * 
     * @return un String contenant le nom de la personne associé à son prénom
     */	
	public String toString(){
		return this.nom+" "+this.prenom;
	}
	
 }
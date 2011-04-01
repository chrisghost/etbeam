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
	
	
	public Personne(String nom, String prenom, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}
	

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	
	
	//METHODES

	/**	
     * r�cup�re le nom de la personne
     * 
     * @return le nom de la personne
     */	
	public String getNom() {
		return nom;
	}
	
	
	/**	
     * change le nom de la personne
     * 
     * @param nom le nom que l'on veut affecter � la personne
     */	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	/**	
     * r�cup�re le pr�nom de la personne
     * 
     * @return le prenom de la personne
     */	
	public String getPrenom() {
		return prenom;
	}
	
	
	/**	
     * change le prenom de la personne
     * 
     * @param prenom le prenom que l'on veut affecter � la personne
     */	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	/**	
     * r�cup�re le sexe de la personne
     * 
     * @return le sexe de la personne
     */	
	public String getSexe() {
		return sexe;
	}
	
	
	/**	
     * change le sexe de la personne
     * 
     * @param sexe le sexe que l'on veut affecter � la personne
     */	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
	/**	
     * r�cup�re le mail de la personne
     * 
     * @return le mail de la personne
     */	
	public String getMail() {
		return mail;
	}
	
	
	/**	
     * change le mail de la personne
     * 
     * @param mail le nouveau mail que l'on veut affecter � la personne
     */	
	public void setMail(String mail) {
		this.mail = mail;
	}


	/**	
     * r�cup�re une concat�nation du nom et du pr�nom de la personne
     * 
     * @return un String contenant le nom de la personne associ� � son pr�nom
     */	
	public String toString(){
		return this.nom+" "+this.prenom;
	}
	
 }
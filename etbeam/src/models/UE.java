package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public abstract class UE extends Model {
	protected boolean optionelle;
	protected int nbECTS;
	protected String libelleUE;
	protected String codeUE;
	protected String codeSemestre;
	protected Utilisateur responsable;
	protected Semestre sem;
	protected ArrayList<ECUE> lesECUE = new ArrayList<ECUE>();
	protected ArrayList<Etudiant> listeEtudUE = new ArrayList<Etudiant>(); //liste des �tudiants appartenant � l'UE 
	
	protected void addVars(){
		this.addVar("codeUE");
		this.addVar("optionelle");
		this.addVar("nbECTS");
		this.addVar("libelleUE");
		
	}
	
	
	/***** constructeurs *****/
	
	public UE(){
		super();
	}
	
	public UE(boolean optionelle, int nbects, String libel, String code){
		super();
		this.optionelle = optionelle;
		this.nbECTS = nbects;
		this.libelleUE = libel;
		this.codeUE = code;
	}

	//constructeur associ� � un responsable
	
	public UE(boolean optionelle, int nbECTS, String libelleUE, String codeUE,
			Utilisateur responsableUE) {
		super();
		this.optionelle = optionelle;
		this.nbECTS = nbECTS;
		this.libelleUE = libelleUE;
		this.codeUE = codeUE;
		this.responsable = responsableUE;
	}

	
	
	
	/***** methodes ****/
	
	
	
	/**	
     * r�cup�re et charge les informations de l'UE
     *            
     */	
	public abstract void load();

	
	
	/**	
     * r�cup�re et charge la liste des ECUE appartenant � l'UE
     *  @param id_UE le code de l'UE dont on veut les ECUE          
     */	
	public abstract void loadECUE(String id_UE) throws SQLException;
	
	
	
	/**	
     * charge et r�cup�re la liste des �tudiants appartenant � l'UE
     *            
     */	
	public abstract void loadEtudiant() throws SQLException, Exception; 
	
	
	
	/**	
     * Permet d'obtenir la moyenne obtenue � l'UE par un �tudiant
     * @param e l'objet Etudiant dont on veut la moyenne           
     */	
	public abstract double getMoyenne(Etudiant e); 
	
	
	
	
	/**	
     * Permet d'obtenir le nombre de points jury attribu�s � l'Etudiant pour l'UE
     * @param e l'objet Etudiant dont on veut obtenir les points jury UE
     *            
     */	
	public abstract float getPointsJuryUe(Etudiant e);
	
	
	
	
	
	
	
	/***** getter and setter *****/

	
	/**	
     * permet de savoir si l'UE est optionnelle ou pas
     * @return un booleen indiquant si l'UE est optionnelle.           
     */	
	public boolean getOptionelle() {
		return optionelle;
	}


	/**	
     * change le statut optionnel de l'UE
     * @param optionnelle le booleen indiquant si l'UE est optionnelle ou pas           
     */	
	public void setOptionelle(boolean optionelle) {
		this.optionelle = optionelle;
	}


	
	/**	
     * r�cup�re le nombre d'ECTS que l'UE conf�re
     * @return le nombre d'ECTS           
     */	
	public int getNbECTS() {
		return nbECTS;
	}


	
	/**	
     * change le nombre d'ECTS que l'UE conf�re
     * @param nbECTS le nombre d'ECTS que l'on veut affecter � l'UE           
     */	
	public void setNbECTS(int nbECTS) {
		this.nbECTS = nbECTS;
	}


	
	/**	
     * r�cup�re le libell� de l'UE
     * @return le libell� de l'UE           
     */	
	public String getLibelleUE() {
		return libelleUE;
	}


	
	/**	
     * change le libell� de l'UE
     * @param libelleUE le libell� que l'on veut affecter � l'UE
     *            
     */	
	public void setLibelleUE(String libelleUE) {
		this.libelleUE = libelleUE;
	}


	
	/**	
     * r�cup�re le code de l'UE
     * @return le codeUE de l'UE
     */	
	public String getCodeUE() {
		return codeUE;
	}


	
	/**	
     * change le code de l'UE
     * @param codeUE le code que l'on veut affecter � l'UE
     *            
     */	
	public void setCodeUE(String codeUE) {
		this.codeUE = codeUE;
	}


	
	/**	
     * r�cup�re la liste des ECUE appartenant � l'UE
     * @return l'ArrayList contenant les ECUE appartenant � l'UE           
     */	
	public ArrayList<ECUE> getLesECUE() {
		return lesECUE;
	}
	
	
	/**	
     * r�cup�re la liste des �tudiants appartenant � l'UE
     * @return l'ArrayList contenant les �tudiants de l'UE          
     */	
	public ArrayList<Etudiant> getLesEtudiants(){
		return listeEtudUE;
	}


	/**	
     * retourne le libell� de l'UE
     * @return le libelle de l'UE           
     */	
	public String toString(){
		return this.libelleUE;
	}
	


	
	
	
	public String getCodeSemestre() {
		return codeSemestre;
	}


	public void setCodeSemestre(String codeSemestre) {
		this.codeSemestre = codeSemestre;
	}


	public Utilisateur getResponsable() {
		return responsable;
	}


	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}


	/**	
     * Valide l'UE pour un �tudiant
     * @param etud l'objet �tudiant dont on veut valider l'UE           
     */	
	public abstract void validation(Etudiant etud) throws SQLException;


	public abstract void ajoutPointsUE(Etudiant et, Float pts);
	

}

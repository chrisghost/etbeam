package models;
import java.sql.SQLException;
import java.util.ArrayList;

import models.mysql.EtudiantMySQL;
public abstract class Etudiant extends Personne {

	protected int scoreTOEIC;
	protected float ptsJury;
	protected String numINE;
	protected String numEtud;
	protected String Provenance;
	protected String comJury;
	protected ArrayList<ECUE> listeECUE;
	protected ArrayList<UE> listeUEfacultatives;
	
	
	
	public Etudiant() {
		super();
	}
	
	
	public Etudiant(String numINE, String numEtud) {
		super();
		this.numINE = numINE;
		this.numEtud = numEtud;
	}
	
	
	public Etudiant(int scoreTOEIC, String numINE, String numEtud, String Provenance, String comJury) {
		super();
		this.scoreTOEIC = scoreTOEIC;
		this.numINE = numINE;
		this.numEtud = numEtud;
		this.Provenance = Provenance;
		this.comJury = comJury;
	}

//constructeur alternatif
	
	public Etudiant(int scoreTOEIC, float ptsJury, String numINE,
			String numEtud, ArrayList<UE> listeUEfacultatives) {
		super();
		this.scoreTOEIC = scoreTOEIC;
		this.ptsJury = ptsJury;
		this.numINE = numINE;
		this.numEtud = numEtud;
		this.listeUEfacultatives = listeUEfacultatives;
	}


	public Etudiant(float ptsJury, String numINE, String numEtud) {
		super();
		this.ptsJury = ptsJury;
		this.numINE = numINE;
		this.numEtud = numEtud;
	}

	
	
	
	/**
	 * r�cup�re le score TOEIC de l'Etudiant
	 * @return le score TOEIC        
	 */
	public int getScoreTOEIC() {
		return scoreTOEIC;
	}
	
	
	/**
	 * change le score Toeic de l'etudiant
	 * @param scoreTOEIC le score Toeic que l'on veut affecter � l'�tudiant      
	 */
	public void setScoreTOEIC(int scoreTOEIC) {
		this.scoreTOEIC = scoreTOEIC;
	}
	
	
	/**
	 * r�cup�re le nombre de points jury ann� donn� � l'�tudiant
	 * @return le nombre de points jury         
	 */
	public float getPtsJury() {
		return ptsJury;
	}
	
	
	
	/**
	 * change le nombre de points jury donn� � l'�tudiant
	 * @param ptsJury le nombre de points jury que l'on veut affecter � l'�tudiant           
	 */
	public void setPtsJury(float ptsJury) {
		this.ptsJury = ptsJury;
	}
	
	
	/**
	 * r�cup�re le num�ro INE de l'�tudiant
	 * @return le num�ro INE          
	 */
	public String getNumINE() {
		return numINE;
	}
	
	
	/**
	 * r�cup�re la provenance de l'�tudiant
	 * @return la provenance de l'�tudiant          
	 */
	public String getProvenance() {
		return Provenance;
	}
	
	/**
	 * change la provenance d'un �tudiant
	 * @param Provenance la provenance � affecter � l'�tudiant          
	 */
	public void setProvenance(String Provenance) {
		this.Provenance = Provenance;
	}
	
	
	/**
	 * r�cup�re le commentaire emis par le jury � l'�gard de l'�tudiant
	 * @return le commentaire du jury          
	 */
	public String getcomJury() {
		return comJury;
	}
	
	
	
	/**
	 * change le commentaire emis par le jury � l'�gard de l'�tudiant
	 * @param comJury le nouveau commentaire � affecter � l'�tudiant          
	 */
	public void setcomJury(String comJury) {
		this.comJury = comJury;
	}
	
	
	/**
	 * change le num�ro INE de l'�tudiant
	 * @param numINE le num�ro INE � affecter � l'�tudiant          
	 */
	public void setNumINE(String numINE) {
		this.numINE = numINE;
	}
	
	
	/**
	 * r�cup�re le num�ro d'�tudiant
	 * @return le num�ro etudiant          
	 */
	public String getNumEtud() {
		return numEtud;
	}
	
	
	/**
	 * change le num�ro Etudiant de l'�tudiant
	 * @param numEtud le num�ro d'�tudiant que l'on veut affecter          
	 */
	public void setNumEtud(String numEtud) {
		this.numEtud = numEtud;
	}
	
	
	
	
	/**
	 * @throws SQLException 
	 *
	 */

	
	
/** * r�cup�re dans la base le num�ro INE d'un ou plusieurs �tudiants
    * 
    * @param nom Le nom de ou des �tudiants dont on veut le code INE
    * @return la liste des code INE correspondant au nom entr� en param�tre    
    */
	public abstract ArrayList<String> getIdsByName(String nom);
	
	
	/**	
     * Charge les informations d'un �tudiant
     * 
     * @param ine Le code INE de l'�tudiant dont on veut charger les informations
     */	
	public abstract void load(String ine);

	
	
	
	/**	
     * R�cup�re l'ann�e � laquelle l'�tudiant appartient
     * 
     * @return le mnemonique de l'annee dont l'�tudiant appartient
     */	
	public abstract String getAnnee();
	
	
	/**	
     * supprime un �tudiant
     */	
	public abstract void delete();

	
	/**	
	 * sauvegarde les informations d'un �tudiant
     */	
	public abstract void save();
	
}

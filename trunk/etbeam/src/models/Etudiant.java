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
	 * récupère le score TOEIC de l'Etudiant
	 * @return le score TOEIC        
	 */
	public int getScoreTOEIC() {
		return scoreTOEIC;
	}
	
	
	/**
	 * change le score Toeic de l'etudiant
	 * @param scoreTOEIC le score Toeic que l'on veut affecter à l'étudiant      
	 */
	public void setScoreTOEIC(int scoreTOEIC) {
		this.scoreTOEIC = scoreTOEIC;
	}
	
	
	/**
	 * récupère le nombre de points jury anné donné à l'étudiant
	 * @return le nombre de points jury         
	 */
	public float getPtsJury() {
		return ptsJury;
	}
	
	
	
	/**
	 * change le nombre de points jury donné à l'étudiant
	 * @param ptsJury le nombre de points jury que l'on veut affecter à l'étudiant           
	 */
	public void setPtsJury(float ptsJury) {
		this.ptsJury = ptsJury;
	}
	
	
	/**
	 * récupère le numéro INE de l'étudiant
	 * @return le numéro INE          
	 */
	public String getNumINE() {
		return numINE;
	}
	
	
	/**
	 * récupère la provenance de l'étudiant
	 * @return la provenance de l'étudiant          
	 */
	public String getProvenance() {
		return Provenance;
	}
	
	/**
	 * change la provenance d'un étudiant
	 * @param Provenance la provenance à affecter à l'étudiant          
	 */
	public void setProvenance(String Provenance) {
		this.Provenance = Provenance;
	}
	
	
	/**
	 * récupère le commentaire emis par le jury à l'égard de l'étudiant
	 * @return le commentaire du jury          
	 */
	public String getcomJury() {
		return comJury;
	}
	
	
	
	/**
	 * change le commentaire emis par le jury à l'égard de l'étudiant
	 * @param comJury le nouveau commentaire à affecter à l'étudiant          
	 */
	public void setcomJury(String comJury) {
		this.comJury = comJury;
	}
	
	
	/**
	 * change le numéro INE de l'étudiant
	 * @param numINE le numéro INE à affecter à l'étudiant          
	 */
	public void setNumINE(String numINE) {
		this.numINE = numINE;
	}
	
	
	/**
	 * récupère le numéro d'étudiant
	 * @return le numéro etudiant          
	 */
	public String getNumEtud() {
		return numEtud;
	}
	
	
	/**
	 * change le numéro Etudiant de l'étudiant
	 * @param numEtud le numéro d'étudiant que l'on veut affecter          
	 */
	public void setNumEtud(String numEtud) {
		this.numEtud = numEtud;
	}
	
	
	
	
	/**
	 * @throws SQLException 
	 *
	 */
	
	
/** * récupère dans la base le numéro INE d'un ou plusieurs étudiants
    * 
    * @param nom Le nom de ou des étudiants dont on veut le code INE
    * @return la liste des code INE correspondant au nom entré en paramètre    
    */
	public abstract ArrayList<String> getIdsByName(String nom) throws SQLException;
	
	
	/**	
     * Charge les informations d'un étudiant
     * 
     * @param ine Le code INE de l'étudiant dont on veut charger les informations
     */	
	public abstract void load(String ine) throws SQLException;
	
	
	
	/**	
     * Récupère l'année à laquelle l'étudiant appartient
     * 
     * @return le mnemonique de l'annee dont l'étudiant appartient
     */	
	public abstract String getAnnee();
	
	
	/**	
     * supprime un étudiant
     */	
	public abstract void delete();

	
	/**	
	 * sauvegarde les informations d'un étudiant
     */	
	public abstract void save();
	
}

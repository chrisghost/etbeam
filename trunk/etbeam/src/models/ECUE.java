package models;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ECUE extends Model {
	protected String libelleECUE;
	protected String codeECUE;
	protected float volumeHoraire;
	protected Utilisateur responsableECUE;
	protected UE uniteE;
	protected ArrayList<Etudiant> listeEtud= new ArrayList<Etudiant>();
	protected float coeff;


	public ECUE(){
		super();
	}
	
	//constructeur ayant toutes les info concernant une ECUE
	public ECUE(String libelleECUE, String codeECUE, float volumHoraire){
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
		this.volumeHoraire = volumHoraire;
	}


	//constructeur d'une ECUE associ�e � son responsable
	public ECUE(String libelleECUE, String codeECUE, float volumHoraire,
			Utilisateur responsableECUE) {
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
		this.volumeHoraire = volumHoraire;
		this.responsableECUE = responsableECUE;
	}
	
	public abstract void load() throws SQLException;
	
	
	
	/**
	 * r�cup�re le libell� de l'ECUE
	 * @return  le libell� de l'ECUE          
	 */
	public String getLibelleECUE() {
		return libelleECUE;
	}
	
	
	/**
	 * change le libell� de l'ECUE
	 * @param libelleECUE le nouveau libell� que l'on veut affecter          
	 */	
	public void setLibelleECUE(String libelleECUE) {
		this.libelleECUE = libelleECUE;
	}
	
	
	/**
	 * r�cup�re le code de l'ECUE
	 * @return  le code de l'ECUE          
	 */
	public String getCodeECUE() {
		return codeECUE;
	}
	
	/**
	 * change le code de l'ECUE
	 * @param codeECUE le nouveau code que l'on veut affecter     
	 */
	public void setCodeECUE(String codeECUE) {
		this.codeECUE = codeECUE;
	}
	
	
	/**
	 * r�cup�re le volume horaire de l'ECUE
	 * @return  le volume horaire de l'ECUE          
	 */
	public float getVolumeHoraire() {
		return volumeHoraire;
	}
	
	
	/**
	 * change le volume horaire de l'ECUE
	 * @param volumHoraire le volume horaire de l'ECUE          
	 */
	public void setVolumeHoraire(float volumHoraire) {
		this.volumeHoraire = volumHoraire;
	}

	
	/**
	 * r�cup�re le responsable de l'ECUE
	 * @return  l'objet Utilisateur responsable de l'ECUE        
	 */
	public Utilisateur getResponsableECUE() {
		return responsableECUE;
	}

	
	/**
	 * change le responsable de l'ECUE
	 * @param responsableECUE  l'objet Utilisateur responsable de l'ECUE        
	 */	
	public void setResponsableECUE(Utilisateur responsableECUE) {
		this.responsableECUE = responsableECUE;
	}

	
	/**
	 * charge la liste des �tudiants de l'ECUE       
	 */
	public abstract void loadEtudiant();

	
	/**
	 * modifie le coefficient de l'ECUE    
	 */
	public abstract void saveCoeff() throws SQLException;


	/**
	 * r�cup�re la liste des num�roINE des �tudiants de l'ECUE
	 * @return  Un ArrayList contenant la liste des num�ro INE        
	 */
	public ArrayList<String> getEtudiantINE() {
			ArrayList<String> listINE = new ArrayList<String>();
			for (Iterator<Etudiant> i = this.listeEtud.iterator(); i.hasNext();){
				listINE.add((String)(i.next().getNumINE()));
			}
			return listINE;
		}
	
	
	/**
	 * Change la note obtenue � l'ECUE par un �tudiant
	 * @param etud l'objet Etudiant dont on veut changer la note
	 * @param numsess le num�ro de session correspondant � la note
	 * @param note la note obtenue par l'�tudiant      
	 */
	public abstract void changeNoteEtudiantECUE(Etudiant etud, int numsess, float note);
	

	
	/**
	 * r�cup�re la note obtenue par un �tudiant � l'ECUE
	 * @param etud l'objet Etudiant dont on veut la note
	 * @param numsess le num�ro de session dont on veut la note          
	 */
	public abstract double getEtudiantNote(Etudiant etud, int numsess);


	
	
	
	
	protected void addVars(){
		this.addVar("codeECUE");
		this.addVar("libelleECUE");
		this.addVar("volumeHoraire");
	}
	
	
	/**
	 * r�cup�re la liste des Etudiants de l'ECUE       
	 */
	public ArrayList<Etudiant> getListeEtud() {
		return listeEtud;
	}

	/**
	 * r�cup�re la note obtenue par un �tudiant � l'ECUE
	 * @param etud l'objet Etudiant dont on veut la note
	 * @param numsess le num�ro de session dont on veut la note          
	 */
	public void setListeEtud(ArrayList<Etudiant> listeEtud) {
		this.listeEtud = listeEtud;
	}


  
	
	/**
	 * r�cup�re le coefficient de l'ECUE
	 * @return le coefficient de l'ECUE          
	 */
    public float getCoeff() {
		return coeff;
	}

    
	/**
	 * change le coefficient de l'ECUE
	 * @param coeff le coefficient de l'ECUE     
	 */
	public void setCoeff(float coeff) {
		this.coeff = coeff;
	}

	
	public String toString(){
		return this.libelleECUE;
	}

    
 }

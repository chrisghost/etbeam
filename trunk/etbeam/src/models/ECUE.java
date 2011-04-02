package models;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ECUE extends Model {
	protected String libelleECUE;
	protected String codeECUE;
	protected String codeUE;
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


	//constructeur d'une ECUE associée é son responsable
	public ECUE(String libelleECUE, String codeECUE, float volumHoraire,
			Utilisateur responsableECUE) {
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
		this.volumeHoraire = volumHoraire;
		this.responsableECUE = responsableECUE;
	}
	
	public abstract void load();
	
	
	
	/**
	 * récupÃ¨re le libellé de l'ECUE
	 * @return  le libellé de l'ECUE          
	 */
	public String getLibelleECUE() {
		return libelleECUE;
	}
	
	
	/**
	 * change le libellé de l'ECUE
	 * @param libelleECUE le nouveau libellé que l'on veut affecter          
	 */	
	public void setLibelleECUE(String libelleECUE) {
		this.libelleECUE = libelleECUE;
	}
	
	
	/**
	 * récupÃ¨re le code de l'ECUE
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
	 * récupÃ¨re le volume horaire de l'ECUE
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
	 * récupÃ¨re le responsable de l'ECUE
	 * @return  l'objet Utilisateur responsable de l'ECUE        
	 */
	public Utilisateur getResponsable() {
		return responsableECUE;
	}

	
	/**
	 * change le responsable de l'ECUE
	 * @param responsableECUE  l'objet Utilisateur responsable de l'ECUE        
	 */	
	public void setResponsable(Utilisateur responsableECUE) {
		this.responsableECUE = responsableECUE;
	}

	
	/**
	 * charge la liste des étudiants de l'ECUE       
	 */
	public abstract void loadEtudiant();

	
	/**
	 * modifie le coefficient de l'ECUE    
	 */
	public abstract void saveCoeff() throws SQLException;


	/**
	 * récupÃ¨re la liste des numéroINE des étudiants de l'ECUE
	 * @return  Un ArrayList contenant la liste des numéro INE        
	 */
	public ArrayList<String> getEtudiantINE() {
			ArrayList<String> listINE = new ArrayList<String>();
			for (Iterator<Etudiant> i = this.listeEtud.iterator(); i.hasNext();){
				listINE.add((String)(i.next().getNumINE()));
			}
			return listINE;
		}
	
	
	/**
	 * Change la note obtenue Ã  l'ECUE par un étudiant
	 * @param etud l'objet Etudiant dont on veut changer la note
	 * @param numsess le numéro de session correspondant Ã  la note
	 * @param note la note obtenue par l'étudiant      
	 */
	public abstract void changeNoteEtudiantECUE(Etudiant etud, int numsess, float note);
	

	
	/**
	 * récupÃ¨re la note obtenue par un étudiant Ã  l'ECUE
	 * @param etud l'objet Etudiant dont on veut la note
	 * @param numsess le numéro de session dont on veut la note          
	 */
	public abstract double getEtudiantNote(Etudiant etud, int numsess);


	
	
	
	
	protected void addVars(){
		this.addVar("codeECUE");
		this.addVar("libelleECUE");
		this.addVar("volumeHoraire");
	}
	
	
	/**
	 * récupÃ¨re la liste des Etudiants de l'ECUE       
	 */
	public ArrayList<Etudiant> getListeEtud() {
		return listeEtud;
	}

	/**
	 * récupÃ¨re la note obtenue par un étudiant Ã  l'ECUE
	 * @param etud l'objet Etudiant dont on veut la note
	 * @param numsess le numéro de session dont on veut la note          
	 */
	public void setListeEtud(ArrayList<Etudiant> listeEtud) {
		this.listeEtud = listeEtud;
	}


  
	
	/**
	 * récupÃ¨re le coefficient de l'ECUE
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

	
	public String getCodeUE() {
		return codeUE;
	}

	public void setCodeUE(String codeUE) {
		this.codeUE = codeUE;
	}

	public String toString(){
		return this.libelleECUE;
	}

    
 }

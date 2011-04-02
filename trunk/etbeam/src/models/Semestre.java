package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.MySQL;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Semestre extends Model {
	protected String LibelleSem;
	protected String CodeSemestre;
	protected int NbUEfacultatives;
	protected Annee an;
	protected ArrayList<UE> lesUE = new ArrayList<UE>();
	
	protected Utilisateur responsable;

	
	protected void addVars(){
		this.addVar("CodeSemestre");
		this.addVar("LibelleSem");
		this.addVar("NbUEfacultatives");
	}
	
	/***** constructeurs *****/
	
	
	public Semestre() {
		super();
	}
	
	public Semestre(String libel, String code, int nbue){
		super();
		this.LibelleSem = libel;
		this.CodeSemestre = code;
		this.NbUEfacultatives = nbue;
		
	}

	
	
	
	/***** methodes *****/
	
	
	
	public Utilisateur getResponsable() {
		return responsable;
	}

	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}

	/**	
     * charge les donn�es des UE appartenant au Semestre
     *            
     */	
	public abstract void load();
	
	
	/**	
     * r�cup�re la moyenne obtenue au semestre par un �tudiant
     * @param et l'objet Etudiant dont on veut avoir la moyenne
     */	
	public abstract float getMoySem(Etudiant et);

	
	
	
	/**	
     * charge la liste des UE du semestre
     * @param id_sem le code du semestre dont on veut la liste des UE           
     */	
	public abstract void loadUE(String id_sem);
	
	
	
	
	/**	
     * r�cup�re le code d'une UE appartenant au semestre
     * @param lib le libell� de l'UE dont on veut le code
     * @return le code de l'UE
     */	
	public String getcodebylib(String lib) {

		String code = null;
		UE ue;
		Iterator<UE> i = this.getLesUE().iterator();
		while (i.hasNext()){
			ue=i.next();
			if(ue.getLibelleUE().equals(lib)){
				code = ue.getCodeUE();
			}}
		return code;
	}
	

	
	

	/***** getter and setter *****/
	
	

	
	/**	
     * r�cup�re le libelle du semestre
     * @return le libell� du semestre
     */	
	public String getLibelleSem() {
		return LibelleSem;
	}
	
	
	
	/**	
     * change le libelle du semestre
     * @param libelleSem le libell� que l'on veut affecter au semestre
     *            
     */	
	public void setLibelleSem(String libelleSem) {
		this.LibelleSem = libelleSem;
	}
	
	
	/**	
     * r�cup�re le code du semestre
     * @return le code du semestre
     */	
	public String getCodeSemestre() {
		return CodeSemestre;
	}
	
	
	/**	
     * change le code du semestre
     * @param codeSemestre le code que l'on veut affecter au semestre
     */	
	public void setCodeSemestre(String codeSemestre) {
		CodeSemestre = codeSemestre;
	}
	
	
	/**	
     * r�cup�re le nombre d'UE facultatives du semestre
     * @return le nombre d'UE facultatives           
     */	
	public int getNbUEfacultatives() {
		return NbUEfacultatives;
	}
	
	
	/**	
     * modifie le nombre d'UE facultatives du semestre
     * @param nbUEfacultatives le nombre d'UE que l'on veut affecter au semestre           
     */	
	public void setNbUEfacultatives(int nbUEfacultatives) {
		NbUEfacultatives = nbUEfacultatives;
	}

	
	/**	
     * r�cup�re la liste des UE appartenant au semestre
     * @return un ArrayList contenant des objets UE           
     */	
	public ArrayList<UE> getLesUE() {
		return lesUE;
	}

	
	/**	
     * Modifie la liste des UE appartenant au semestre
     * @param lesUE la liste d'UE que l'on veut affecter au semestre           
     */	
	public void setLesUE(ArrayList<UE> lesUE) {
		this.lesUE = lesUE;
	}



	/**	
     * retourne le libelle du semestre
     *            
     */	
	public String toString(){
		return this.LibelleSem;
	}

	public abstract float getPointsJurySem(Etudiant et) ;

	public abstract void ajoutPointsSem(Etudiant etudiant, Float pts);
	
}
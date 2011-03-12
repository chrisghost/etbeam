package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public abstract class UE extends Model {
	protected boolean optionelle;
	protected int nbECTS;
	protected String libelleUE;
	protected String codeUE;
	protected Utilisateur responsableUE;
	protected Semestre sem;
	protected ArrayList<ECUE> lesECUE = new ArrayList<ECUE>();
	
	protected void addVars(){
		this.addVar("optionelle");
		this.addVar("nbECTS");
		this.addVar("libelleUE");
		this.addVar("codeUE");
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

	//constructeur ssoci� � un responsable
	
	public UE(boolean optionelle, int nbECTS, String libelleUE, String codeUE,
			Utilisateur responsableUE) {
		super();
		this.optionelle = optionelle;
		this.nbECTS = nbECTS;
		this.libelleUE = libelleUE;
		this.codeUE = codeUE;
		this.responsableUE = responsableUE;
	}

	/***** methodes ****/
	
	public abstract void load() throws SQLException;
	public abstract void loadECUE(String id_UE) throws SQLException;//charge les ECUE d'un semestre
	
	
	
	/***** getter and setter *****/
	public boolean getOptionelle() {
		return optionelle;
	}



	public void setOptionelle(boolean optionelle) {
		this.optionelle = optionelle;
	}


	public int getNbECTS() {
		return nbECTS;
	}


	public void setNbECTS(int nbECTS) {
		this.nbECTS = nbECTS;
	}


	public String getLibelleUE() {
		return libelleUE;
	}


	public void setLibelleUE(String libelleUE) {
		this.libelleUE = libelleUE;
	}


	public String getCodeUE() {
		return codeUE;
	}


	public void setCodeUE(String codeUE) {
		this.codeUE = codeUE;
	}


	public ArrayList<ECUE> getLesECUE() {
		return lesECUE;
	}

/***** methodes *****/
	
/*	public float getmoyenne(Etudiant etud) {
		float moyenne = 0;
		Note note = new Note() {
		};
		for (Iterator<ECUE> iter = lesECUE.iterator(); iter.hasNext(); ) {
			ECUE matiere = (ECUE) iter.next();
			ArrayList<Etudiant> lesEtud = matiere.getListeEtud();
			for (Iterator<Etudiant> indice = lesEtud.iterator(); indice.hasNext();){
				if (indice.equals(etud)){
					moyenne = matiere.getCoeff()*note.getNote(etud)+ moyenne;
				}
			}
		}

		return moyenne;
	}*/

}

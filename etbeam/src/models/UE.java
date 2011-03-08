package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import bd.MySQL;

public abstract class UE {
	protected boolean optionelle;
	protected int nbECTS;
	protected String libelleUE;
	protected String codeUE;
	protected Utilisateur responsableUE;
	protected Semestre sem;
	protected ArrayList<ECUE> lesECUE;
	
	/***** constructeurs *****/
	
	public UE(){
		
	}
	
	public UE(boolean optionelle, int nbects, String libel, String code){
		this.optionelle = optionelle;
		this.nbECTS = nbects;
		this.libelleUE = libel;
		this.codeUE = code;
	}

	//constructeur ssoci� � un responsable
	
	public UE(boolean optionelle, int nbECTS, String libelleUE, String codeUE,
			Utilisateur responsableUE) {
		this.optionelle = optionelle;
		this.nbECTS = nbECTS;
		this.libelleUE = libelleUE;
		this.codeUE = codeUE;
		this.responsableUE = responsableUE;
	}

	
	public abstract void load() throws SQLException;
	
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

/***** methodes *****/
	public float getmoyenne(Etudiant etud) {
		float moyenne = 0;
		for (Iterator<ECUE> iter = lesECUE.iterator(); iter.hasNext(); ) {
			ECUE matiere = (ECUE) iter.next();
			ArrayList<Etudiant> lesEtud = matiere.getListeEtud();
			for (Iterator<Etudiant> indice = lesEtud.iterator(); iter.hasNext();){
				if (indice.equals(etud)){
					moyenne = matiere.getCoeff()*
				}
				}
			
		}
			
		//TODO
		return 0;
	}

}

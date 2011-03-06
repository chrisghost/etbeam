package models;
public class Etudiant extends Personne {

	public int scoreTOEIC;
	public float ptsJury;
	public String numINE;
	public String numEtud;
	
	
	public Etudiant(String numINE, String numEtud) {
		super();
		this.numINE = numINE;
		this.numEtud = numEtud;
	}
	
	
	public Etudiant(int scoreTOEIC, String numINE, String numEtud) {
		super();
		this.scoreTOEIC = scoreTOEIC;
		this.numINE = numINE;
		this.numEtud = numEtud;
	}


	public Etudiant(float ptsJury, String numINE, String numEtud) {
		super();
		this.ptsJury = ptsJury;
		this.numINE = numINE;
		this.numEtud = numEtud;
	}


	public int getScoreTOEIC() {
		return scoreTOEIC;
	}
	public void setScoreTOEIC(int scoreTOEIC) {
		this.scoreTOEIC = scoreTOEIC;
	}
	public float getPtsJury() {
		return ptsJury;
	}
	public void setPtsJury(float ptsJury) {
		this.ptsJury = ptsJury;
	}
	public String getNumINE() {
		return numINE;
	}
	public void setNumINE(String numINE) {
		this.numINE = numINE;
	}
	public String getNumEtud() {
		return numEtud;
	}
	public void setNumEtud(String numEtud) {
		this.numEtud = numEtud;
	}
}

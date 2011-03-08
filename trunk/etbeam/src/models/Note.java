package models;

public abstract class Note {
	protected int note1;
	protected int note2;
	protected ECUE matiere;
	protected Etudiant etud;
	
	/***** constructeur *****/
	public Note(){
		
	}
	
	public Note(int note1, int note2) {
		super();
		this.note1 = note1;
		this.note2 = note2;
	}

	
	/***** getter and setter *****/
	
	public int getNote1() {
		return note1;
	}

	public void setNote1(int note1) {
		this.note1 = note1;
	}

	public int getNote2() {
		return note2;
	}

	public void setNote2(int note2) {
		this.note2 = note2;
	}

	public ECUE getMatiere() {
		return matiere;
	}

	public void setMatiere(ECUE matiere) {
		this.matiere = matiere;
	}

	public Etudiant getEtud() {
		return etud;
	}

	public void setEtud(Etudiant etud) {
		this.etud = etud;
	}
	

}

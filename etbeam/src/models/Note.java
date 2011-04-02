package models;

public abstract class Note extends Model {
	protected float note1; // note de la session 1
	protected Float note2= null; //note de la session 2
	protected ECUE matiere;
	protected Etudiant etud;
	
	/***** constructeur *****/
	
	public Note(){
		super();
	}
	
	public Note(float note1, float note2) {
		super();
		this.note1 = note1;
		this.note2 = note2;
	}

	
	
	public Note(float note1, Float note2, ECUE matiere, Etudiant etud) {
		super();
		this.note1 = note1;
		this.note2 = note2;
		this.matiere = matiere;
		this.etud = etud;
	}

	
//Getter and Setter	
	
	/**	
     * RécupÃ¨re la note de la session 1
     * 
     * @return la note de la session 1
     */	
	public float getNote1() {
		return note1;
	}

	
	/**	
     * Modifie la note de la session 1
     * 
     * @param note1 la note de la session 1
     */	
	public void setNote1(float note1) {
		this.note1 = note1;
	}

	
	/**	
     * RécupÃ¨re la note de la session 2
     * 
     * @return la note de la session 2
     */	
	public float getNote2() {
		return note2;
	}

	
	/**	
     * Change la note de la session 2
     * 
     * @param note2 la note de la session 2
     */	
	public void setNote2(float note2) {
		this.note2 = note2;
	}

	
	/**	
     * récupÃ¨re la matiÃ¨re concernée par l'objet Note
     * 
     * @return l'objet ECUE
     */	
	public ECUE getMatiere() {
		return matiere;
	}

	
	/**	
     * change l'ECUE concernée par l'objet Note
     * 
     * @param matiere l'objet ECUE que l'on veut affecter Ã  la note
     */	
	public void setMatiere(ECUE matiere) {
		this.matiere = matiere;
	}

	
	/**	
     * récupÃ¨re l'étudiant concerné par la Note
     * 
     * @return l'objet étudiant concerné par la Note
     */	
	public Etudiant getEtud() {
		return etud;
	}

	
	/**	
     * change l'étudiant concerné par la note
     * 
     * @param etud l'objet Etudiant que l'on veut affecter Ã  la note
     */	
	public void setEtud(Etudiant etud) {
		this.etud = etud;
	}
	
	
	/**	
     * RécupÃ¨re la note d'un étudiant
     * 
     * @return la note de la premiere session, si la note de la session 2 est nulle, sinon la note de la premiere session
     */	
	public float getNote(Etudiant etudiant){
		if(this.etud==etudiant){
			if (note2==null)
			{
				return note1;
			}
			else return note2;
		}
		return 0;
	}

}

package models.mysql;

import models.Note;

public class NoteMySQL extends Note {
	public int note1;
	public int note2;
	private ECUEMySQL matiere;
	private EtudiantMySQL etud;
	
	/***** constructeur *****/
	public NoteMySQL(int note1, int note2) {
		super();
		this.note1 = note1;
		this.note2 = note2;
	}

}

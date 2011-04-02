package models.mysql;

import models.Note;

public class NoteMySQL extends Note {
	
	/***** constructeur *****/
	public NoteMySQL(int note1, int note2) {
		super(note1,note2);
	
	}

	@Override
	protected void addVars() {
		
	}

}

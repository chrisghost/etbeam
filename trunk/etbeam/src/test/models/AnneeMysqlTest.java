package test.models;

import java.sql.SQLException;

import models.mysql.AnneeMySQL;
import models.mysql.UtilisateurMySQL;
import junit.framework.TestCase;

public class AnneeMysqlTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLoad() {
		/*
		 * 
		 * Jeu de test:
		 * Enseignant : St	Paul	M	st.paul@vatican.va	ID: 12
		 * 
		 * Annee : IG4; ID resp: 12; VersionEtape : PUI235
		 * 
		 */
		
		AnneeMySQL a = new AnneeMySQL();
		try {
			a.load("pui235");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		UtilisateurMySQL u = new UtilisateurMySQL();
		try {
			u.load(12);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		assertEquals(a.getResponsableAn().getId(), u.getId());
		assertEquals(a.getResponsableAn().getLogin(), u.getLogin());
		assertEquals(a.getResponsableAn().getPassWord(), u.getPassWord());
		
		
	}

}

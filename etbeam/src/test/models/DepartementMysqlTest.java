package test.models;

import java.sql.SQLException;

import junit.framework.TestCase;

import models.mysql.AnneeMySQL;
import models.mysql.DepartementMySQL;
import models.mysql.UtilisateurMySQL;


public class DepartementMysqlTest extends TestCase {
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
		
		DepartementMySQL a = new DepartementMySQL();
		a.setMnemo("IG");
		
		a.load();

		
		
		UtilisateurMySQL u = new UtilisateurMySQL();
		try {
			u.load(100);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		assertEquals(a.getResponsable().getId(), u.getId());
		assertEquals(a.getResponsable().getLogin(), u.getLogin());
		assertEquals(a.getResponsable().getPassWord(), u.getPassWord());
		assertEquals(a.getMnemo(), "IG");
		
		
	}

}

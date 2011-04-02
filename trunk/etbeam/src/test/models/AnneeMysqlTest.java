package test.models;

import java.sql.SQLException;

import models.Semestre;
import models.mysql.AnneeMySQL;
import models.mysql.SemestreMySQL;
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

		
		AnneeMySQL a = new AnneeMySQL();
		try {
			a.load("pui235");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		a.loadSemestre();
		
		
		UtilisateurMySQL u = new UtilisateurMySQL();
		try {
			u.load(12);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		assertEquals(a.getResponsableAn().getId(), u.getId());
		assertEquals(a.getResponsableAn().getLogin(), u.getLogin());
		assertEquals(a.getResponsableAn().getPassWord(), u.getPassWord());
		
		for(Semestre s : a.getSemestres())
			assertEquals(s.getVersionEtape(), a.getVersionEtape());
		
		
	}

}

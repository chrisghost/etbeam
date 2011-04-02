package test.models;

import java.sql.SQLException;

import models.mysql.AnneeMySQL;
import models.mysql.UEMySQL;
import models.mysql.UtilisateurMySQL;
import junit.framework.TestCase;

public class UEMysqlTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLoad() {
		
		UEMySQL a = new UEMySQL();
		a.setCodeUE("PIA87");
		

		a.load();

		
		
		UtilisateurMySQL u = new UtilisateurMySQL();
		try {
			u.load(2000);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		assertEquals(a.getResponsable().getId(), u.getId());
		assertEquals(a.getResponsable().getLogin(), u.getLogin());
		assertEquals(a.getResponsable().getPassWord(), u.getPassWord());
		assertEquals(a.getLibelleUE(), "Stage");
		
		
	}

}

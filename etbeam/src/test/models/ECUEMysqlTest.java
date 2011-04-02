package test.models;

import java.sql.SQLException;

import models.mysql.AnneeMySQL;
import models.mysql.ECUEMySQL;
import models.mysql.UEMySQL;
import models.mysql.UtilisateurMySQL;
import junit.framework.TestCase;

public class ECUEMysqlTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLoad() {

		
		ECUEMySQL a = new ECUEMySQL();
		a.setCodeECUE("PIGUEOp12");
		

		a.load();

		
		
		UtilisateurMySQL u = new UtilisateurMySQL();
		try {
			u.load(941);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		assertEquals(a.getResponsable().getId(), u.getId());
		assertEquals(a.getResponsable().getLogin(), u.getLogin());
		assertEquals(a.getResponsable().getPassWord(), u.getPassWord());		
		
	}

}

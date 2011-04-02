package test.models;

import java.sql.SQLException;

import models.ECUE;
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
		
		UEMySQL ue = new UEMySQL();
		ue.setCodeUE("PIA87");
		

		ue.load();

		
		
		UtilisateurMySQL u = new UtilisateurMySQL();
		try {
			u.load(2000);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		assertEquals(ue.getResponsable().getId(), u.getId());
		assertEquals(ue.getResponsable().getLogin(), u.getLogin());
		assertEquals(ue.getResponsable().getPassWord(), u.getPassWord());
		
		
		for(ECUE ecue : ue.getLesECUE())
			assertEquals(ecue.getCodeUE(), ue.getCodeUE());
		
		
	}

}

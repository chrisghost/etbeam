package test.models;

import models.mysql.UtilisateurMySQL;
import junit.framework.TestCase;

public class UtilisateurMysqlTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testConnect() {
		UtilisateurMySQL u = new UtilisateurMySQL();
		
		u.setLogin("a");
		u.setPassWord("b");
		u.connect();
		
		assertEquals((Boolean) true, (Boolean) u.getLogged());
	}
}

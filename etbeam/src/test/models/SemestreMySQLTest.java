package test.models;


import java.sql.SQLException;

import junit.framework.TestCase;

import models.mysql.DepartementMySQL;
import models.mysql.SemestreMySQL;
import models.mysql.UtilisateurMySQL;

import org.junit.After;
import org.junit.Before;

public class SemestreMySQLTest extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	public void testLoad(){
		SemestreMySQL a = new SemestreMySQL();
		a.setCodeSemestre("PIG5");
		
		a.load();

		
		
		UtilisateurMySQL u = new UtilisateurMySQL();
		try {
			u.load(510);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		assertEquals(a.getResponsable().getId(), u.getId());
		assertEquals(a.getResponsable().getLogin(), u.getLogin());
		assertEquals(a.getResponsable().getPassWord(), u.getPassWord());
		assertEquals(a.getCodeSemestre(), "PIG5");
	}
}

package test.models;

import java.sql.SQLException;

import junit.framework.TestCase;

import models.Annee;
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
		
		DepartementMySQL dept = new DepartementMySQL();
		dept.setMnemo("IG");
		
		dept.load();
		dept.LoadListeAnnee();

		
		
		UtilisateurMySQL u = new UtilisateurMySQL();
		try {
			u.load(100);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
				
		assertEquals(dept.getResponsable().getId(), u.getId());
		assertEquals(dept.getResponsable().getLogin(), u.getLogin());
		assertEquals(dept.getResponsable().getPassWord(), u.getPassWord());
		
		for(Annee an : dept.getLesAnnees()){
			assertEquals(an.getMnemo().substring(0, dept.getMnemo().length()), dept.getMnemo());
		}
		
		
	}

}

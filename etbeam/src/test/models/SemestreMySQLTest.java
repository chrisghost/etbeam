package test.models;


import java.sql.SQLException;

import junit.framework.TestCase;

import models.UE;
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
		SemestreMySQL sem = new SemestreMySQL();
		sem.setCodeSemestre("PIA5");
		
		sem.load();
//		sem.loadUE();
		
		UtilisateurMySQL u = new UtilisateurMySQL();
		try {
			u.load(510);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		assertEquals(sem.getResponsable().getId(), u.getId());
		assertEquals(sem.getResponsable().getLogin(), u.getLogin());
		assertEquals(sem.getResponsable().getPassWord(), u.getPassWord());
		
		for(UE ue : sem.getLesUE()){
			System.out.println(ue.getCodeSemestre()+" = "+sem.getCodeSemestre());
			assertEquals(ue.getCodeSemestre(), sem.getCodeSemestre());
			
		}
		
	}
}

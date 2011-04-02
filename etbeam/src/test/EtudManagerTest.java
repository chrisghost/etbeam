package test;

import java.sql.SQLException;
import java.util.ArrayList;

import models.EtudManager;
import models.Etudiant;
import models.mysql.EtudiantMySQL;
import junit.framework.TestCase;

public class EtudManagerTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testEtudManager(){
		
		
		/*
+---------+-----------+--------+-------------------+------+--------------+-------------+------------------+------------------+-------------+------------+-------+
| num_ine | nom       | prenom | mail              | sexe | num_etudiant | score_toeic | point_jury_annee | commentaire_jury | nationalite | provenance | annee |
+---------+-----------+--------+-------------------+------+--------------+-------------+------------------+------------------+-------------+------------+-------+
| 12345   | Zanuttini | Hugo   | hugo@hugo.com     | M    | 543          |         900 |                  |                  | francaise   | PEIP       | 4     |
| 4567    | Counil    | Cecile | cecile@cecile.com | F    | 454          |         900 |                  |                  | francaise   | PEIP       | 4     |
| 6789    | Maillol   | Adrien | adri@adri.com     | M    | 977          |         900 |                  |                  | francaise   | IUT        | 4     |
| 6665    | Mattiaci  | Kevin  | kev@kev.com       | M    | 222          |         900 | 45               |                  | francaise   | IUT        | 4     |
+---------+-----------+--------+-------------------+------+--------------+-------------+------------------+------------------+-------------+------------+-------+

		 * 
		 * 
		 * 
		 */
		
		ArrayList<Etudiant> adrien = EtudManager.getInstance().searchEtudiant("Maillol");
		
		int tailleInit = adrien.size();
		Etudiant e = adrien.get(0);
		assertEquals(e , EtudManager.getInstance().getEtudiant(e.getNumINE()));
		
		e.setNom("TestName");
		e.save();
		EtudManager.getInstance().changeEtudiant(e);
		
		assertEquals(EtudManager.getInstance().searchEtudiant("Maillol").size(), tailleInit-1);
		
		e.setNom("Maillol");
		e.save();
		
		assertEquals(EtudManager.getInstance().searchEtudiant("Maillol").size(), tailleInit);
		
		EtudManager.getInstance().deleteEtud(e.getNumINE());
		
		assertEquals(EtudManager.getInstance().searchEtudiant("Maillol").size(), tailleInit-1);
		
		EtudManager.getInstance().addEtudiant(e);
		
		e.insert();

		assertEquals(EtudManager.getInstance().searchEtudiant("Maillol").size(), tailleInit);
	}

}

package test;

import java.sql.SQLException;
import java.util.ArrayList;

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
		
		try {
			ArrayList<Etudiant> adrien = models.EtudManager.getInstance().searchEtudiant("Maillol");
			
			
			for(Etudiant e : adrien){
				System.out.println(e.getNumINE());
				assertEquals(e , models.EtudManager.getInstance().getEtudiant(e.getNumINE()));
			}
	
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

}

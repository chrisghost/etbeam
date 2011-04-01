package models.mysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Facade;
import bd.MySQL;

import models.Departement;
import models.EtudManager;
import models.Etudiant;
import models.Semestre;
public class EtudiantMySQL extends Etudiant {

	
	public EtudiantMySQL() {
		super();
	}

	
	protected void addVars() {
		
		
	}

/**	
     * récupère dans la base le numéro INE d'un ou plusieurs étudiants
     * 
     * @param nom Le nom de ou des étudiants dont on veut le code INE
     * @return la liste des code INE correspondant au nom entré en paramètre           
 * @throws SQLException 
     */		
	public ArrayList<String> getIdsByName(String nom) throws SQLException{
	
		ArrayList<String> lINE = new ArrayList<String>();
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r;
		
		r = base.execute("SELECT * FROM etudiant WHERE nom LIKE '%"+nom+"%'");
		while (r.next()){
			lINE.add(r.getString("num_ine"));
		}
		return lINE;
	}


/**	
     * Charge les informations d'un étudiant à partir de la base de données
     * 
     * @param ine Le code INE de l'étudiant dont on veut charger les informations
     */	
	public void load(String ine) throws SQLException {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		
		r = base.execute("SELECT nom, prenom, num_ine FROM etudiant WHERE num_ine ='"+ine+"'");
		while(r.next()){
		this.setNom(r.getString("nom"));
		this.setPrenom(r.getString("prenom"));
		this.setNumINE(r.getString("num_ine"));
		}
	}
	
	
	
		

/**	
     * supprime l'étudiant de la base de données
     */		
	public void delete(){
			MySQL base = (MySQL) Facade.getInstance().getBD();
			ResultSet r = null;
		try {
			base.executeUpdate("DELETE FROM etudiant WHERE num_ine = '"+this.getNumINE()+"'");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	
/**	
     * sauvegarde dans la base de données les informations de l'étudiant
     *
     */	
	public void save() {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		try {
			r = base.execute("UPDATE etudiant set nom='"+this.getNom()+"', prenom ='"+this.getPrenom()+"' WHERE num_ine='"+this.getNumINE()+"'");
			r.rowUpdated();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	
	
/**	
     * Récupère le mnémonique de l'Annee à laquelle l'étudiant appartient
     *
     */	
public String getAnnee() {
	MySQL base = (MySQL) Facade.getInstance().getBD();
	String mnemo="";
	ResultSet r = null;

		try {
			r = base.execute("SELECT Distinct a.mnemo FROM etudiant e,ecue ec, note n, ue u, semestre s, annee a WHERE e.num_ine= n.num_ine AND " +
					"n.code_ecue = ec.code_matiere AND ec.code_ue = u.code_ue AND u.code_semestre = s.code_sem AND s.version_etape = a.version_etape " +
					"AND e.num_ine='"+this.getNumINE()+"'");
			while(r.next()){
				mnemo = r.getString("mnemo");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


	
	return mnemo;
}
	


}

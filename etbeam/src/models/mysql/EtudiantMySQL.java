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
	 * r�cup�re dans la base le num�ro INE d'un ou plusieurs �tudiants
	 * 
	 * @param nom
	 *            Le nom de ou des �tudiants dont on veut le code INE
	 * @return la liste des code INE correspondant au nom entr� en param�tre
	 * @throws SQLException
	 */
	public ArrayList<String> getIdsByName(String nom) {

		ArrayList<String> lINE = new ArrayList<String>();
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r;

		try {
			r = base.execute("SELECT * FROM etudiant WHERE nom LIKE '%" + nom
					+ "%'");

			while (r.next()) {
				lINE.add(r.getString("num_ine"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lINE;
	}

	/**
	 * Charge les informations d'un �tudiant � partir de la base de donn�es
	 * 
	 * @param ine
	 *            Le code INE de l'�tudiant dont on veut charger les
	 *            informations
	 */
	public void load(String ine) {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;

		try {
			r = base.execute("SELECT * FROM etudiant WHERE num_ine ='"
					+ ine + "'");

			while (r.next()) {
				this.setNom(r.getString("nom"));
				this.setPrenom(r.getString("prenom"));
				this.setNumINE(r.getString("num_ine"));
				this.setMail(r.getString("mail"));
				this.setSexe(r.getString("sexe"));
				this.setNumEtud(r.getString("num_etudiant"));
				this.setScoreTOEIC(r.getInt("score_toeic"));
				this.setPtsJury(r.getFloat("point_jury_annee"));
				this.setcomJury(r.getString("commentaire_jury"));
				this.setProvenance(r.getString("provenance"));
				
				
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * supprime l'�tudiant de la base de donn�es
	 */
	public void delete() {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		try {
			base.executeUpdate("DELETE FROM etudiant WHERE num_ine = '"
					+ this.getNumINE() + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * sauvegarde dans la base de donn�es les informations de l'�tudiant
	 * 
	 */
	public void save() {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		try {
			base.executeUpdate("UPDATE etudiant set nom='" + this.getNom()
					+ "', prenom ='" + this.getPrenom() +
					"', mail = '"+this.getMail()+"'" +
					", score_toeic = "+this.getScoreTOEIC() +
					", provenance='"+this.getProvenance()+"' WHERE num_ine='"
					+ this.getNumINE() + "'");
		} catch (SQLException e) {
			e.printStackTrace();		
		}
	}
	
	public void insert() {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		try {
			base.executeUpdate("INSERT INTO etudiant VALUES('" +
					this.getNumINE()+"'"+
					",'"+this.getNom()+"'"+
					",'"+this.getPrenom()+"'"+
					",'"+this.getMail()+"'"+
					",'"+this.getSexe()+"'"+
					",'"+this.getNumEtud()+"'"+
					",'"+this.getScoreTOEIC()+"'"+
					",'"+this.getPtsJury()+"'"+
					",'"+this.getcomJury()+"'"+
					",'"+this.getProvenance()+"'"+
					",'null')");
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
	}

	/**
	 * R�cup�re le mn�monique de l'Annee � laquelle l'�tudiant appartient
	 * 
	 */
	public String getAnnee() {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		String mnemo = "";
		ResultSet r = null;

		try {
			r = base.execute("SELECT Distinct a.mnemo FROM etudiant e,ecue ec, note n, ue u, semestre s, annee a WHERE e.num_ine= n.num_ine AND "
					+ "n.code_ecue = ec.code_matiere AND ec.code_ue = u.code_ue AND u.code_semestre = s.code_sem AND s.version_etape = a.version_etape "
					+ "AND e.num_ine='" + this.getNumINE() + "'");
			while (r.next()) {
				mnemo = r.getString("mnemo");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mnemo;
	}

}

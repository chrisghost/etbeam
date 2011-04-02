package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Facade;
import bd.MySQL;
import models.ECUE;
import models.EtudManager;
import models.Etudiant;
import models.Utilisateur;

public class ECUEMySQL extends ECUE {

	public ECUEMySQL() {
		super();
	}

	public ECUEMySQL(String libelleECUE, String codeECUE, float volHoraire,
			UtilisateurMySQL utilisateur) {
		super(libelleECUE, codeECUE, volHoraire, utilisateur);

	}

	/**
	 * Charge à partir de la base les informations concernant l'ECUE
	 * 
	 */
	public void load(){
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r;

		try {
			r = base.execute("SELECT * FROM ecue WHERE ecue.code_matiere='"+this.codeECUE+"'");
			//AND ecue.id_responsable=utilisateur.id_utilisateur" +
			//		"AND utilisateur.id_enseignant=enseignant.id_enseignant");
			while (r.next()) {
				this.setLibelleECUE(r.getString("ecue.libelle_ecue"));
				this.setVolumeHoraire(r.getFloat("ecue.vol_horaire"));
				UtilisateurMySQL u = new UtilisateurMySQL();
				u.load(r.getInt("ecue.id_responsable"));
				this.setResponsable(u);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	/**
	 * ???????????????
	 * 
	 * 
	 * 
	 */
	public void saveCoeff() throws SQLException {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r;
		r = base.execute("UPDATE ecue SET coeffcient = '" + this.getCoeff()
				+ "' WHERE code_matiere ='" + this.getCodeECUE() + "'");
		r.updateRow();
	}

	/**
	 * Change la note de l'étudiant dans la base de données.
	 * 
	 * @param etud
	 *            L'objet Etudiant dont on veut modifier la note
	 * @param numsess
	 *            Le numéro de session concernant la note (session 1 ou 2)
	 * @param note
	 *            La note obtenue
	 * 
	 */
	public void changeNoteEtudiantECUE(Etudiant etud, int numsess, float note) {
		MySQL base = (MySQL) Facade.getInstance().getBD();

		try {
			base.executeUpdate("UPDATE note SET session" + numsess + "=" + note
					+ " WHERE code_ecue='" + this.codeECUE
					+ "' AND num_ine = '" + etud.getNumINE() + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// recup�re la note � l'ECUE de l'etudiant (numsess= numero de session) :
	// gestion ECUE

	/**
	 * Récupère à partir de la base la note obtenue par un étudiant à l'ECUE
	 * 
	 * @param etud
	 *            L'objet Etudiant dont on veut obtenir la note
	 * @param numsess
	 *            Le numéro de session concernant la note (session 1 ou 2)
	 * 
	 * @return la note obtenue par l'étudiant
	 */
	public double getEtudiantNote(Etudiant etud, int numsess) {

		MySQL base = (MySQL) Facade.getInstance().getBD();
		double note = -1; // initialisation � -1 au cas ou la note n'est pas
							// disponible

		ResultSet r = null;

		try {
			r = base.execute("SELECT session" + numsess
					+ " FROM note n WHERE n.code_ecue ='" + this.codeECUE
					+ "' AND n.num_ine = '" + etud.getNumINE() + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (r.next()) {

				try {
					note = r.getDouble("session" + numsess);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return note;
	}

	/**
	 * Récupère les étudiants qui étudient l'ECUE La liste des étudiants va être
	 * chargée dans l'ArrayList de l'ECUE
	 * 
	 */
	public void loadEtudiant() {

		Etudiant etud;
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;

		listeEtud.clear(); // On efface le contenu afin de ne pas avoir de
							// boublons

		try {
			r = base.execute("SELECT e.num_ine,e.nom,e.prenom FROM note n, etudiant e WHERE code_ecue='"
					+ this.codeECUE
					+ "' AND e.num_ine = n.num_ine ORDER BY e.nom,e.prenom");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// la requ�te permet de r�cup�rer les ine class� par ordre du nom et du
		// pr�nom

		try {
			while (r.next()) {
				etud = new EtudiantMySQL();
				etud.setNumINE(r.getString("num_ine"));// on r�cup�re l'�tudiant
														// � partir de
														// l'EtudManager
				etud.setNom(r.getString("nom"));
				etud.setPrenom(r.getString("prenom"));
				listeEtud.add(etud);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Etudiant i : this.getListeEtud()) {
			System.out.println(i.getNom() + "\n");

			System.out.println(listeEtud.size());
		}
	}

}

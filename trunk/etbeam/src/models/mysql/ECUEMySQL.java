package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Facade;
import bd.MySQL;
import models.ECUE;
import models.EtudManager;
import models.Etudiant;
import models.Utilisateur;

public class ECUEMySQL extends ECUE{

	public ECUEMySQL() {
		super();
	}
	
	public ECUEMySQL(String libelleECUE, String codeECUE,float volHoraire, UtilisateurMySQL utilisateur) {
		super(libelleECUE, codeECUE, volHoraire, utilisateur);
		
	}
	

	public void load() throws SQLException{
		MySQL base = (MySQL) Facade.getBD();
		ResultSet r;
		
		r = base.execute("SELECT * FROM ecue WHERE code_matiere='"+this.codeECUE+"'");
		while(r.next()){
			this.setLibelleECUE(r.getString("libelle_ecue"));
			this.setVolumeHoraire(r.getFloat("vol_horaire"));
			
		}
	}
	
	
		//modification coeff : gestion ECUE
		public void saveCoeff() throws SQLException {
			MySQL base = (MySQL) Facade.getBD();
			ResultSet r;
			r = base.execute("UPDATE ecue SET coeffcient = '"+this.getCoeff()+"' WHERE code_matiere ='"+this.getCodeECUE()+"'");
			r.updateRow();
		}
		
		
		public void changeNoteEtudiantECUE(Etudiant etud, int numsess, float note) throws SQLException {
			MySQL base = (MySQL) Facade.getBD();
			ResultSet r = null;
			r= base.execute("UPDATE note SET session"+numsess+"="+note+" WHERE code_ecue='"+this.codeECUE+"' AND num_ine = '"+etud.getNumINE()+"'");
			r.updateRow();
			//on save dans l'objet NOTE?? ou on ne se sert pas de cette clasee?
		}
		
		

		// recupère la note à l'ECUE de l'etudiant (numsess= numero de session) : gestion ECUE
		public double getEtudiantNote(Etudiant etud, int numsess) throws SQLException {
			MySQL base = (MySQL) Facade.getBD();
			double note = -1; //initialisation à -1 au cas ou la note n'est pas disponible
			
			ResultSet r = null;
			r = base.execute("SELECT session"+numsess+" FROM note n WHERE n.code_ecue ='"+this.codeECUE+"' AND n.num_ine = '"+etud.getNumINE()+"'");
			
			while(r.next()){
			
				note = r.getDouble("session"+numsess);
						
			}
			
			return note;
		}
		
		
		
public void loadEtudiant() throws SQLException {
			
			Etudiant etud;
			MySQL base = (MySQL) Facade.getBD();
			ResultSet r = null;
			r = base.execute("SELECT n.num_ine,e.nom,e.prenom FROM note n, etudiant e WHERE code_ecue="+this.codeECUE+" AND n.num_ine = e.num_ine ORDER BY e.nom, e.prenom ASC");
			//la requête permet de récupérer les ine classé par ordre du nom et du prénom
			while (r.next()){
					etud=EtudManager.getInstance().getEtudiant(r.getString("num_ine"));// on récupère l'étudiant à partir de l'EtudManager
					this.listeEtud.add(etud);
		}
			
		}


		
//		ResultSet r1,r2 = null;
//		r1 = base.execute("SELECT num_ine FROM note WHERE code_ecue="+this.codeECUE);
		
		
//		while(r1.next()){
			/*
			 * CommentÃ© pour les tests
			 * 
			r2 = base.execute("SELECT * FROM etudiant WHERE num_ine =" + r1.getString("num_ine"));
						
			EtudiantMySQL etudiant = new EtudiantMySQL();
			
			etudiant.setNumINE(r2.getString("num_ine"));
			
			*/
			
			
			
			//etudiant.setNom(nom);
			
			
			
			
			
			/*this.setLibelleECUE(r.getString("libelle_ecue"));
			this.setVolumHoraire(r.getFloat("vol_horaire"));
			this.setCodeECUE(r.getString("code_ue"));
			
			Utilisateur resp = new UtilisateurMySQL();
			resp.load(r.getInt("id_responsable"));
			
			this.setResponsableECUE(resp);
*/
//		}
}


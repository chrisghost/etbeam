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
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r;
		
		r = base.execute("SELECT * FROM ecue WHERE code_matiere='"+this.codeECUE+"'");
		while(r.next()){
			this.setLibelleECUE(r.getString("libelle_ecue"));
			this.setVolumeHoraire(r.getFloat("vol_horaire"));
			
		}
	}
	
	
		//modification coeff : gestion ECUE
		public void saveCoeff() throws SQLException {
			MySQL base = (MySQL) Facade.getInstance().getBD();
			ResultSet r;
			r = base.execute("UPDATE ecue SET coeffcient = '"+this.getCoeff()+"' WHERE code_matiere ='"+this.getCodeECUE()+"'");
			r.updateRow();
		}
		
		
		public void changeNoteEtudiantECUE(Etudiant etud, int numsess, float note) throws SQLException {
			MySQL base = (MySQL) Facade.getInstance().getBD();
			ResultSet r = null;
			r= base.execute("UPDATE note SET session"+numsess+"="+note+" WHERE code_ecue='"+this.codeECUE+"' AND num_ine = '"+etud.getNumINE()+"'");
			r.updateRow();
			//on save dans l'objet NOTE?? ou on ne se sert pas de cette clasee?
		}
		
		

		// recup�re la note � l'ECUE de l'etudiant (numsess= numero de session) : gestion ECUE
		public double getEtudiantNote(Etudiant etud, int numsess){
			MySQL base = (MySQL) Facade.getInstance().getBD();
			double note = -1; //initialisation � -1 au cas ou la note n'est pas disponible
			
			ResultSet r = null;
			try {
				r = base.execute("SELECT session"+numsess+" FROM note n WHERE n.code_ecue ='"+this.codeECUE+"' AND n.num_ine = '"+etud.getNumINE()+"'");

				while(r.next()){
					note = r.getDouble("session"+numsess);							
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			return note;
		}
		
		
		
public void loadEtudiant() throws SQLException {
			
			Etudiant etud = new EtudiantMySQL();
			MySQL base = (MySQL) Facade.getInstance().getBD();
			ResultSet r = null;
			r = base.execute("SELECT e.num_ine,nom,prenom FROM note n, etudiant e WHERE code_ecue="+this.codeECUE+" AND e.num_ine = n.num_ine");
			//la requ�te permet de r�cup�rer les ine class� par ordre du nom et du pr�nom
			while (r.next()){
					etud.setNumINE(r.getString("num_ine"));// on r�cup�re l'�tudiant � partir de l'EtudManager
					etud.setNom(r.getString("nom"));
					etud.setPrenom(r.getString("prenom"));
					this.listeEtud.add(etud);
					
		}
			for (Etudiant i : this.getListeEtud()){
			System.out.println(i.getNom()+"\n");
			}
		}


		//EtudManager.getInstance().getEtudiant(
//		ResultSet r1,r2 = null;
//		r1 = base.execute("SELECT num_ine FROM note WHERE code_ecue="+this.codeECUE);
		
		
//		while(r1.next()){
			/*
			 * Commenté pour les tests
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


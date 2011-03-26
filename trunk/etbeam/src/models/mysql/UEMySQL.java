package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.EtudManager;
import models.ECUE;
import models.Etudiant;
import models.Semestre;
import models.UE;
import models.Utilisateur;

import bd.Facade;
import bd.MySQL;

public class UEMySQL extends UE{
	
	/***** constructeurs *****/
	public UEMySQL(){
		super();
	}
	
	public UEMySQL(boolean optionelle, int nbects, String libel, String code){
		super();
		this.optionelle = optionelle;
		this.nbECTS = nbects;
		this.libelleUE = libel;
		this.codeUE = code;
	}
	

	//constructeur associée un responsable
	
	public UEMySQL(boolean optionelle, int nbECTS, String libelleUE, String codeUE,
			UtilisateurMySQL responsableUE) {
		super();
		this.optionelle = optionelle;
		this.nbECTS = nbECTS;
		this.libelleUE = libelleUE;
		this.codeUE = codeUE;
		this.responsableUE = responsableUE;
	}
	
	
	
	
	/***** methodes *****/
	
	public void load() throws SQLException{
		MySQL base = (MySQL) Facade.getInstance().getBD();
		
		ResultSet r = null;

		r = base.execute("SELECT * FROM ue WHERE code_ue='"+this.codeUE+"'");
		r.next();
		
		this.setLibelleUE(r.getString("lib_ue"));
		this.setNbECTS(r.getInt("nb_ects"));
		
		
		r = base.execute("SELECT * FROM ecue WHERE code_ue='"+this.codeUE+"'");
		
		
		//Recuperation des ecue
		while(r.next()){
			
			
			UtilisateurMySQL utilisateur = new UtilisateurMySQL();
			utilisateur.load(r.getInt("id_responsable"));
			
			
			ECUEMySQL ecue = new ECUEMySQL(r.getString("libelle_ecue"),
					r.getString("code_matiere"),
					r.getFloat("vol_horaire"),
					utilisateur);
			
			//ecue.load();
			this.lesECUE.add(ecue);
		}
	}
	
	
	public void recuperateStudent() throws SQLException{
	
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		r = base.execute("SELECT nom,prenom FROM choisir_ue c, etudiant e " +
						 "WHERE code_ue="+this.codeUE+" AND c.num_ine=e.num_ine");
		while(r.next()){
			EtudiantMySQL etudiant = new EtudiantMySQL();
			etudiant.setNom(r.getString("nom"));
			etudiant.setPrenom(r.getString("prenom"));
		
		}
	
	}


	public void loadECUE(String id_UE) throws SQLException {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		r = base.execute("SELECT * FROM ecue WHERE code_ue="+id_UE);
		while (r.next()){
			ECUEMySQL matiere = new ECUEMySQL();
			matiere.setCodeECUE(r.getString("code_matiere"));
			matiere.setLibelleECUE(r.getString("libelle_ecue"));
			//matiere.setResponsableECUE("id_responsable"));
			matiere.setVolumeHoraire(r.getFloat("vol_horaire"));
		
			this.lesECUE.add(matiere);
		}

	}
	
	
	
	public void loadEtudiant() throws SQLException { //r�cup�re la liste des �tudiants de l'UE
		
		
		Etudiant etud;
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		r = base.execute("SELECT c.num_ine,e.nom,e.prenom FROM choisir_ue c, etudiant e WHERE code_ue="+this.codeUE+" AND c.num_ine = e.num_ine ORDER BY e.nom, e.prenom ASC");
		//la requ�te permet de r�cup�rer les ine class� par ordre du nom et du pr�nom
		while (r.next()){
				etud=EtudManager.getInstance().getEtudiant(r.getString("num_ine"));// on r�cup�re l'�tudiant � partir de l'EtudManager
				this.listeEtudUE.add(etud);
	}
		
}
	


	// calcule en renvoie la moyenne d'un etudiant a l'UE : gestion UE
	public double getMoyenne(Etudiant e) throws SQLException {
		double moy=-1;  //on initialise la moyenne � -1 afin que l'�tudiant n'ai pas 0
		double tot=0;
		double coeff=0;
		
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		r = base.execute("SELECT session1,session2,coeff FROM ecue ec, note n WHERE ec.code_ue ="+this.codeUE+" AND ec.code_matiere = n.code_ecue AND n.num_ine ="+e.getNumINE());
		
		while(r.next()){
		
		tot=tot+(r.getFloat("session1")*r.getFloat("coeff")); //on multiplie la note avec le coeff
		coeff=coeff+r.getFloat("coeff");
		
		}
		
		
		if (coeff ==0){
		moy = tot/1;
		}
		else { moy = tot/coeff;}
		
		moy =Math.round(moy*100.0) / 100.0; //pour arrondir � deux chiffres apr�s la virgule
		
		return moy;
	}
	

	//validation UE : gestion UE
	public void validation(Etudiant etud) throws SQLException {
		//double moy;
		//moy=this.getMoyenne(etud);
		//if (moy >= 10){
		//	valide=true;
		//}
		MySQL base = (MySQL)Facade.getInstance().getBD();
		ResultSet r = null;
		r = base.execute("INSERT INTO apdj SET code_ue ='"+ this.getCodeUE()+"', num_ine='"+ etud.getNumINE()+"'");
		r.updateRow();
	}
	
}

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
	

	//constructeur associÃ©e un responsable
	
	public UEMySQL(boolean optionelle, int nbECTS, String libelleUE, String codeUE,
			UtilisateurMySQL responsableUE) {
		super();
		this.optionelle = optionelle;
		this.nbECTS = nbECTS;
		this.libelleUE = libelleUE;
		this.codeUE = codeUE;
		this.responsableUE = responsableUE;
	}
	
	
	
	
	
	
	
/**	
     *????????????????????????????????????????
     *            
     */	
	public void load() throws SQLException{
		MySQL base = (MySQL) Facade.getInstance().getBD();
		
		ResultSet r = null;

		r = base.execute("SELECT * FROM ue WHERE code_ue='"+this.getCodeUE()+"'");
		r.next();
		
		this.setLibelleUE(r.getString("lib_ue"));
		this.setNbECTS(r.getInt("nb_ects"));
		
		
		r = base.execute("SELECT * FROM ecue WHERE code_ue='"+this.getCodeUE()+"'");
		
	
		//Recuperation des ecue
		while(r.next()){
			
			
			UtilisateurMySQL utilisateur = new UtilisateurMySQL();
			//utilisateur.load(r.getInt("id_responsable"));
			
			
			ECUEMySQL ecue = new ECUEMySQL(r.getString("libelle_ecue"),
					r.getString("code_matiere"),
					r.getFloat("vol_horaire"),
					utilisateur);
			
			ecue.loadEtudiant();
			this.lesECUE.add(ecue);
		}
	}
	
	
/**	
     *??????????????????????????????????????????
     *            
     */		
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

	
/**	
     *récupère dans un ArrayList la liste des Objets ECUE appartenant à l'UE
     * 
     *@param id_UE le code caractérisant l'UE dont on veut la liste des ECUE            
     */		
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
			matiere.loadEtudiant();
		
			this.lesECUE.add(matiere);
		}

	}
	
	
	/**	
     *Récupère dans un ArrayList la liste des étudiants appartenant à l'UE
     *            
     */			
	public void loadEtudiant() throws SQLException { 
		
		
		Etudiant etud;
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		r = base.execute("SELECT c.num_ine,e.nom,e.prenom FROM choisir_ue c, etudiant e WHERE code_ue="+this.codeUE+" AND c.num_ine = e.num_ine ORDER BY e.nom, e.prenom ASC");
		//la requï¿½te permet de rï¿½cupï¿½rer les ine classï¿½ par ordre du nom et du prï¿½nom
		while (r.next()){
				etud=EtudManager.getInstance().getEtudiant(r.getString("num_ine"));// on rï¿½cupï¿½re l'ï¿½tudiant ï¿½ partir de l'EtudManager
				this.listeEtudUE.add(etud);
	}
		
}
	

/**	
     *Calcule la moyenne obtenue par un étudiant à l'UE
     *
     *@param e l'objet Etudiant dont on veut calculer la moyenne
     *@return la moyenne obtenue par l'étudiant à l'UE
     *            
     */		
	public double getMoyenne(Etudiant e){
		double moy=-1;  //on initialise la moyenne ï¿½ -1 afin que l'ï¿½tudiant n'ai pas 0
		double tot=0;
		double coeff=0;
		
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		try {
			r = base.execute("SELECT session1,session2,coeff FROM ecue ec, note n WHERE ec.code_ue ="+this.codeUE+" AND ec.code_matiere = n.code_ecue AND n.num_ine ="+e.getNumINE());

			while(r.next()){
			
			tot=tot+(r.getFloat("session1")*r.getFloat("coeff")); //on multiplie la note avec le coeff
			coeff=coeff+r.getFloat("coeff");
			
			}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if (coeff ==0){
		moy = tot/1;
		}
		else { moy = tot/coeff;}
		
		moy =Math.round(moy*100.0) / 100.0; //pour arrondir ï¿½ deux chiffres aprï¿½s la virgule
		
		return moy;
	}

	

/**	
     *Récupère la liste des points jury obtenus par un étudiant à l'UE
     *
     *@param e l'objet Etudiant dont on veut récupérer les points jury
     *@return les points jury obtenus à l'UE par l'étudiant.          
     */		
	public float getPointsJuryUe(Etudiant e){
		float pts = 0;
		MySQL base = (MySQL)Facade.getInstance().getBD();
		ResultSet r = null;
		
		try {
			r= base.execute("SELECT pts FROM points_jury_ue WHERE num_ine='"+e.getNumINE()+"' AND code_ue='"+this.getCodeUE()+"'");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			pts = r.getFloat("pts");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return pts;
	}
	
	
	

	public void validation(Etudiant etud) throws SQLException {

		MySQL base = (MySQL)Facade.getInstance().getBD();
		ResultSet r = null;
		r = base.execute("INSERT INTO apdj SET code_ue ='"+ this.getCodeUE()+"', num_ine='"+ etud.getNumINE()+"'");
		r.updateRow();
	}
	
}

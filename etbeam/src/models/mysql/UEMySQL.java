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
		this.responsable = responsableUE;
	}
	
	
	
	
	
	
	
/**	
     *
     *            
     */	
	public void load() {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		
		ResultSet r = null;

		try {
			r = base.execute("SELECT * FROM ue WHERE code_ue='"+this.getCodeUE()+"'");
		
			r.next();
			
			this.setLibelleUE(r.getString("lib_ue"));
			this.setNbECTS(r.getInt("nb_ects"));
			UtilisateurMySQL utilisateur = new UtilisateurMySQL();
			utilisateur.load(r.getInt("id_responsable"));
			this.setResponsable(utilisateur);
			
			
			r = base.execute("SELECT * FROM ecue WHERE code_ue='"+this.getCodeUE()+"'");

			while(r.next()){
				
				
				UtilisateurMySQL user = new UtilisateurMySQL();
				
				
				ECUEMySQL ecue = new ECUEMySQL(r.getString("libelle_ecue"),
						r.getString("code_matiere"),
						r.getFloat("vol_horaire"),
						utilisateur);
				
				ecue.setCodeUE(this.getCodeUE());
				
				ecue.loadEtudiant();
				this.lesECUE.add(ecue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
/**	
     *
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
     *r�cup�re dans un ArrayList la liste des Objets ECUE appartenant � l'UE
     * 
     *@param id_UE le code caract�risant l'UE dont on veut la liste des ECUE            
     */		
	public void loadECUE(String id_UE) throws SQLException {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		r = base.execute("SELECT * FROM ecue WHERE code_ue='"+id_UE+"'");
		while (r.next()){
			ECUEMySQL matiere = new ECUEMySQL();
			matiere.setCodeECUE(r.getString("code_matiere"));
			matiere.setLibelleECUE(r.getString("libelle_ecue"));

			matiere.setVolumeHoraire(r.getFloat("vol_horaire"));
			matiere.loadEtudiant();
		
			this.lesECUE.add(matiere);
		}

	}
	
	
	/**	
     *R�cup�re dans un ArrayList la liste des �tudiants appartenant � l'UE
     *            
     */			
	public void loadEtudiant() throws SQLException { 
		
		
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
	

/**	
     *Calcule la moyenne obtenue par un �tudiant � l'UE
     *
     *@param e l'objet Etudiant dont on veut calculer la moyenne
     *@return la moyenne obtenue par l'�tudiant � l'UE
     *            
     */		
	public double getMoyenne(Etudiant e){
		double moy=-1;  //on initialise la moyenne � -1 afin que l'�tudiant n'ai pas 0
		double tot=0;
		double coeff=0;
		
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		try {
			r = base.execute("SELECT session1,session2,coeff FROM ecue ec, note n WHERE ec.code_ue ='"+this.codeUE+"' AND ec.code_matiere = n.code_ecue AND n.num_ine ='"+e.getNumINE()+"'");

			while(r.next()){
			
				if(r.getFloat("session2") > 0.0)
					tot=tot+(r.getFloat("session2")*r.getFloat("coeff")); //on multiplie la note avec le coeff
				else
					tot=tot+(r.getFloat("session1")*r.getFloat("coeff")); //on multiplie la note avec le coeff
				
			coeff=coeff+r.getFloat("coeff");
			
			}
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		if (coeff ==0){
		moy = tot/1;
		}
		else { moy = tot/coeff;}
		
		moy =Math.round(moy*100.0) / 100.0; //pour arrondir � deux chiffres apr�s la virgule
		
		return moy;
	}

	

/**	
     *R�cup�re la liste des points jury obtenus par un �tudiant � l'UE
     *
     *@param e l'objet Etudiant dont on veut r�cup�rer les points jury
     *@return les points jury obtenus � l'UE par l'�tudiant.          
     */		
	public float getPointsJuryUe(Etudiant e){
		float pts = 0;
		MySQL base = (MySQL)Facade.getInstance().getBD();
		ResultSet r = null;
		
		try {
			r= base.execute("SELECT pts FROM points_jury_ue WHERE num_ine='"+e.getNumINE()+"' AND code_ue='"+this.getCodeUE()+"'");
			while (r.next()){
			pts = r.getFloat("pts");
			}
		} catch (SQLException e1) {
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

	@Override
	public void ajoutPointsUE(Etudiant et, Float pts) {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		try {
			r= base.execute("SELECT * FROM points_jury_ue WHERE num_ine='"+et.getNumINE()+"' AND code_ue='"+this.getCodeUE()+"'");
			
			while(r.next()){
			base.executeUpdate("DELETE FROM points_jury_ue WHERE num_ine='"+et.getNumINE()+"' AND code_ue='"+this.getCodeUE()+"'");
			}
			base.executeUpdate("INSERT INTO points_jury_ue VALUES ('"+this.getCodeUE()+"', '"+et.getNumINE()+"',  "+pts+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
	


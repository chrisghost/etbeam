package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Facade;
import bd.MySQL;

import models.Etudiant;
import models.Semestre;
import models.UE;
import models.Utilisateur;

public class SemestreMySQL extends Semestre{

	
	/***** constructeurs *****/

	public SemestreMySQL() {
		super();
	}

	
/**	
     * charge et ajoute dans un ArrayList les donn�es des UE appartenant au Semestre
     *            
     */	
	public void load(){
		MySQL base = (MySQL) Facade.getInstance().getBD();
		
		ResultSet r = null;
		
		try {
			r = base.execute("SELECT * FROM semestre WHERE code_sem='"+this.getCodeSemestre()+"'");
			r.next();
			
			this.setLibelleSem(r.getString("libelle_sem"));
			this.setNbUEfacultatives(r.getInt("nb_ue_fac"));
			
			this.setVersionEtape(r.getString("version_etape"));
			
			UtilisateurMySQL u = new UtilisateurMySQL();
			u.load(r.getInt("id_responsable"));
			this.setResponsable(u);
			
			r = base.execute("SELECT * FROM ue WHERE code_semestre='"+this.getCodeSemestre()+"'");
		
			
			//Recuperation des UE
			while(r.next()){
				UtilisateurMySQL utilisateur = new UtilisateurMySQL();
				utilisateur.load(r.getInt("id_responsable"));
				
				UEMySQL ue = new UEMySQL(r.getBoolean("optionnel"),
										Integer.parseInt(r.getString("nb_ects")),
										r.getString("lib_ue"),
										r.getString("code_ue"),
										utilisateur);
				
				ue.setCodeSemestre(this.getCodeSemestre());
				
				ue.load();
				this.lesUE.add(ue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
/**	
     * r�cup�re la moyenne obtenue au semestre par un �tudiant
     * 
     * @param et l'objet Etudiant dont on veut calculer la moyenne
     * @return La moyenne obtenue au semestre par l'Etudiant         
     */		
	public float getMoySem(Etudiant et){
		float moyue = 0;
		float ptsue = 0;
		float moysem = 0;
		float coef = 1;
		float totcoef = 0;
		ArrayList<UE> lUE = this.getLesUE();
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		
		
		for (UE ue : lUE){
			try {
				r = base.execute("SELECT coef FROM ue WHERE code_ue='"+ue.getCodeUE()+"'");
				while (r.next()){
				coef=r.getFloat("coef");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			moyue=(float) ue.getMoyenne(et);
			ptsue=ue.getPointsJuryUe(et);
			moysem= moysem + (moyue+ptsue)*coef;
			totcoef=totcoef+coef;
		}
		
		
		return moysem/totcoef;
	}

	
/**	
?????????????????????????        
     */		
	public void loadUE() {
			MySQL base = (MySQL) Facade.getInstance().getBD();
			ResultSet r = null;
			try {
				r = base.execute("SELECT * from ue WHERE code_semestre='"+this.getCodeSemestre()+"'");
			
			while (r.next()){
				UEMySQL unite = new UEMySQL();
				unite.setCodeUE(r.getString("code_ue"));
				unite.setLibelleUE(r.getString("lib_ue"));
				unite.setNbECTS(r.getInt("nb_ects"));
				unite.setOptionelle(r.getBoolean("optionnel"));
				unite.setCodeSemestre(r.getString("code_semestre"));
				
				this.lesUE.add(unite);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


@Override
public float getPointsJurySem(Etudiant et) {
		float pts = 0;
		MySQL base = (MySQL)Facade.getInstance().getBD();
		ResultSet r = null;
		
		try {
			r= base.execute("SELECT pts FROM points_jury_sem WHERE id_ine='"+et.getNumINE()+"' AND semestre='"+this.getCodeSemestre()+"'");
			while (r.next()){
			pts = r.getFloat("pts");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return pts;
	}


@Override/**	
 * 
 * 
 * ???            
 */		
public void ajoutPointsSem(Etudiant etudiant, Float pts) {

	MySQL base = (MySQL) Facade.getInstance().getBD();
	ResultSet r = null;
	try {
		r= base.execute("SELECT * FROM points_jury_sem WHERE id_ine='"+etudiant.getNumINE()+"' AND semestre='"+this.getCodeSemestre()+"'");
		
		while(r.next()){
		base.executeUpdate("DELETE FROM points_jury_sem WHERE id_ine='"+etudiant.getNumINE()+"' AND semestre='"+this.getCodeSemestre()+"'");
		}
		base.executeUpdate("INSERT INTO points_jury_sem VALUES ("+pts+", '"+this.getCodeSemestre()+"',  '"+etudiant.getNumINE()+"')");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	



}

package models.mysql;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.MySQL;
import models.Annee;
import models.Utilisateur;

public class AnneeMySQL extends Annee{

	public AnneeMySQL() {
		super();
	}
	
	public AnneeMySQL(String v_etape) {
		super(v_etape);
	}
	
   /***** constructeurs *****/
	

	/***** methodes ******/

	public void load(String versionetape) throws SQLException{
		MySQL base = new MySQL();
		
		ResultSet r = null;
		r = base.execute("SELECT * FROM annee WHERE version_etape="+versionetape);
		
		//recuperation des informations de l annee
		while(r.next()){
			this.ResponsableAn = new UtilisateurMySQL();
			this.ResponsableAn.load(Integer.parseInt(r.getString("id_responsable")));
		}
		
		r = base.execute("SELECT * FROM semestre WHERE version_etape="+versionetape);
		
		
		//Recuperation des semestres
		while(r.next()){
			SemestreMySQL s = new SemestreMySQL(
				r.getString("libelle_sem"),
				r.getString("code_sem"),
				Integer.parseInt(r.getString("nb_ue_fac")));
			
			s.load();
			this.semestres.add(s);
		}
		
		base.close();
	}
	
	
	/***** getter and setter *****/

	public void setResponsableAn(Utilisateur responsableAn) {
		ResponsableAn = responsableAn;
	}

	public Utilisateur getResponsableAn() {
		return ResponsableAn;
	}
	
 }
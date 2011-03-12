package models.mysql;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Facade;
import bd.MySQL;
import models.Annee;
import models.Departement;
import models.Semestre;
import models.Utilisateur;

public class AnneeMySQL extends Annee{

	public AnneeMySQL() {
		super();
	}
	
	public AnneeMySQL(String v_etape) {
		super(v_etape);
	}

	/***** methodes ******/
	
	

	
	
	

	public void load(String versionetape) throws SQLException{
		MySQL base = (MySQL) Facade.getBD();
		
		ResultSet r = null;
		r = base.execute("SELECT * FROM annee WHERE version_etape='"+versionetape+"'");
		
		//recuperation des informations de l annee
		while(r.next()){
			this.setVersionEtape(r.getString("version_etape"));
			this.setMnemo(r.getString("mnemo"));
			this.ResponsableAn = new UtilisateurMySQL();
			this.ResponsableAn.load(Integer.parseInt(r.getString("id_responsable")));
		}
		
		//r = base.execute("SELECT * FROM semestre WHERE version_etape='"+versionetape+"'");
		
		
		//Recuperation des semestres

		}
		
	public void loadSemestre(String versionE) throws SQLException{
		MySQL base = (MySQL) Facade.getBD();
		ResultSet r = null;
		
		this.semestres = new ArrayList<Semestre>();
		
		r = base.execute("SELECT * from semestre where version_etape='"+versionE+"'");
		while (r.next()){
			SemestreMySQL sem = new SemestreMySQL();
			sem.setCodeSemestre(r.getString("code_sem"));
			sem.setLibelleSem(r.getString("libelle_sem"));
			sem.setNbUEfacultatives(r.getInt("nb_ue_fac"));
			
			this.semestres.add(sem);
		}
	}
	
 }
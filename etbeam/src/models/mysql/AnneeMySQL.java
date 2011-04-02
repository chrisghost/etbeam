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
	
/**
     * Charge les informations concernant l'ann�e à partir de la base.
     * 
     * @param versionetape 
     *            Le code caract�risant l'ann�e à charger
     *            
     */
	public void load(String versionetape) throws SQLException{
		MySQL base = (MySQL) Facade.getInstance().getBD();
		
		ResultSet r = null;
		r = base.execute("SELECT * FROM annee WHERE version_etape='"+versionetape+"'");
		
		//recuperation des informations de l annee
		while(r.next()){
			this.setVersionEtape(r.getString("version_etape"));
			this.setMnemo(r.getString("mnemo"));
			this.ResponsableAn = new UtilisateurMySQL();
			this.ResponsableAn.load(Integer.parseInt(r.getString("id_responsable")));
		}


		}
		
/**    
    * * Charge la liste des semestres appartenant à l'ann�e dans un ArrayList.
    *            
    */
	public void loadSemestre(){
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		
		this.semestres = new ArrayList<Semestre>();
		
		try {
			r = base.execute("SELECT * from semestre where version_etape='"+this.getVersionEtape()+"'");

			while (r.next()){
				SemestreMySQL sem = new SemestreMySQL();
				sem.setCodeSemestre(r.getString("code_sem"));
				sem.setLibelleSem(r.getString("libelle_sem"));
				sem.setNbUEfacultatives(r.getInt("nb_ue_fac"));
				sem.setVersionEtape(r.getString("version_etape"));
				
				this.semestres.add(sem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
 }
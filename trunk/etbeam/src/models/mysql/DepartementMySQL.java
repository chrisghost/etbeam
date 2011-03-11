package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.MySQL;

import models.Annee;
import models.Departement;


public class DepartementMySQL extends Departement{
	
	
	public DepartementMySQL() {
		super();
	}
	
	public DepartementMySQL(String mnemo) {
		super(mnemo);
	}
	
	public void loadAnnee(String mnemo) throws SQLException{
		MySQL base = new MySQL();
		ArrayList<Annee> EnsAn = new ArrayList<Annee>();
		ResultSet r = null;
		r = base.execute("SELECT * FROM annee WHERE mnemo="+mnemo);
		
		//Recuperation des annee
		while(r.next()){
			Annee an = new AnneeMySQL(r.getString("version_Etape"));
			EnsAn.add(an);
		}
		this.Listeannee= (ArrayList<Annee>) EnsAn;
	}
	
	
    public void LoadListeAnnee(Departement dept) throws SQLException{
		MySQL base = new MySQL();
		ArrayList<Annee> Listeannee = new ArrayList<Annee>();
		ResultSet r = null;
		r = base.execute("SELECT * FROM annee WHERE mnemo="+ dept.getMnemo());
		
		//Recuperation des annees
		while(r.next()){
			Annee an = new AnneeMySQL(r.getString("version_Etape"));
			Listeannee.add(an);
		}
	
    }
	

	public ArrayList<String> EnsembleAnnees(){
		
	return super.EnsembleAnnees();
	}
	
	
}
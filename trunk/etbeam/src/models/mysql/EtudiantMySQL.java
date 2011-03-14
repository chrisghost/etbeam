package models.mysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Facade;
import bd.MySQL;

import models.Etudiant;
import models.Semestre;
public class EtudiantMySQL extends Etudiant {

	
	public EtudiantMySQL() {
		super();
	}

	
	protected void addVars() {
		
		
	}

	
	public ArrayList<String> getIdsByName(String nom) throws SQLException {
	
		ArrayList<String> lINE = new ArrayList<String>();
		MySQL base = (MySQL) Facade.getBD();
		ResultSet r;
		
		r = base.execute("SELECT * FROM etudiant WHERE nom LIKE '%"+nom+"%'");
		while (r.next()){
			this.setNom(r.getString("nom"));
			this.setPrenom(r.getString("prenom"));
			this.setNumINE(r.getString("num_ine"));
			lINE.add(this.getNumINE());
		}
		return lINE;
	}



	public void load(String ine) throws SQLException {
		MySQL base = (MySQL) Facade.getBD();
		ResultSet r = null;
		
		r = base.execute("SELECT * FROM etudiant WHERE num_ine = '"+ine+"'");
		
		this.setNom(r.getString("nom"));
		this.setPrenom(r.getString("prenom"));
		this.setNumINE(r.getString("num_ine"));
		
	}
}

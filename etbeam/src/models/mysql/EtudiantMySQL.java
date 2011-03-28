package models.mysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Facade;
import bd.MySQL;

import models.EtudManager;
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
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r;
		
		r = base.execute("SELECT * FROM etudiant WHERE nom LIKE '%"+nom+"%'");
		while (r.next()){
//			this.setNom(r.getString("nom"));
//			this.setPrenom(r.getString("prenom"));
//			this.setNumINE(r.getString("num_ine"));
			lINE.add(r.getString("num_ine"));
		}
		return lINE;
	}



	public void load(String ine) throws SQLException {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		
		r = base.execute("SELECT nom, prenom, num_ine FROM etudiant WHERE num_ine ='"+ine+"'");
		while(r.next()){
		this.setNom(r.getString("nom"));
		this.setPrenom(r.getString("prenom"));
		this.setNumINE(r.getString("num_ine"));
		}
	}
		
	//supprimer un etudiant de la base MySQL
		
	public void deleteFromBD() throws SQLException{
			MySQL base = (MySQL) Facade.getInstance().getBD();
			ResultSet r = null;
		r = base.execute("SELECT * FROM etudiant WHERE num_ine = '"+this.getNumINE()+"'");
		r.deleteRow();
	}


	//sauver informtions etudiant dans base MySQL
	public void saveInfoInBD() throws SQLException {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		r = base.execute("UPDATE etudiant set nom='"+this.getNom()+"', prenom ='"+this.getPrenom()+"' WHERE num_ine='"+this.getNumINE()+"'");
		r.rowUpdated();
	}
}

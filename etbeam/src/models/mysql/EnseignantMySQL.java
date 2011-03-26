package models.mysql;
import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Facade;
import bd.MySQL;
import models.Enseignant;

public class EnseignantMySQL extends Enseignant {
	
	public EnseignantMySQL(){
		super();
	}
	
public void loadEnseignant(int id) throws SQLException{	
		
		MySQL base = (MySQL) Facade.getInstance().getBD();
		
		ResultSet r = null;
		r = base.execute("SELECT * FROM enseignant WHERE id="+id);
		
		while(r.next()){
		
			this.setSexe(r.getString("sexe"));
			this.setMail(r.getString("mail"));
			this.setNom(r.getString("nom"));
			this.setPrenom(r.getString("prenom"));
		}
	}

@Override
protected void addVars() {
	// TODO Auto-generated method stub
	
}



}

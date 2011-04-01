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
	

/**	
     * R�cup�re � partir de la base les informations concernant l'Enseignant
     * 
     * @param id Le code caract�risant un enseignant
     *            
     */	
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

public void saveEnseignant(String nom, String prenom, String mail, String id){
	MySQL base = (MySQL) Facade.getInstance().getBD();
		
	try {
		base.executeUpdate("INSERT INTO enseignant SET nom='"+nom+"', prenom='"+prenom+"' , id_enseignant='"+id+"' AND mail='"+mail );
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Override
protected void addVars() {
	// TODO Auto-generated method stub
	
}



}

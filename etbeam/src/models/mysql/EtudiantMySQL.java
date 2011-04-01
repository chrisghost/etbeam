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

/**	
     * r�cup�re dans la base le num�ro INE d'un ou plusieurs �tudiants
     * 
     * @param nom Le nom de ou des �tudiants dont on veut le code INE
     * @return la liste des code INE correspondant au nom entr� en param�tre           
 * @throws SQLException 
     */		
	public ArrayList<String> getIdsByName(String nom) throws SQLException{
	
		ArrayList<String> lINE = new ArrayList<String>();
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r;
		
		r = base.execute("SELECT * FROM etudiant WHERE nom LIKE '%"+nom+"%'");
		while (r.next()){
			lINE.add(r.getString("num_ine"));
		}
		return lINE;
	}


/**	
     * Charge les informations d'un �tudiant � partir de la base de donn�es
     * 
     * @param ine Le code INE de l'�tudiant dont on veut charger les informations
     */	
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
	
	
	
		

/**	
     * supprime l'�tudiant de la base de donn�es
     */		
	public void delete(){
			MySQL base = (MySQL) Facade.getInstance().getBD();
			ResultSet r = null;
		try {
			r = base.execute("DELETE FROM etudiant WHERE num_ine = '"+this.getNumINE()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	
/**	
     * sauvegarde dans la base de donn�es les informations de l'�tudiant
     *
     */	
	public void save() {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		try {
			r = base.execute("UPDATE etudiant set nom='"+this.getNom()+"', prenom ='"+this.getPrenom()+"' WHERE num_ine='"+this.getNumINE()+"'");
			r.rowUpdated();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

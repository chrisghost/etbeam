package models.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Facade;
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
	
/**	
    * Charge dans l'ArrayList du département les années qu'il contient.
    * 
    * @param mnemo 
    *            Le mnémonique caractérisant le département
    *            
    */
	public void loadAnnee(String mnemo) throws SQLException{
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ArrayList<Annee> EnsAn = new ArrayList<Annee>();
		ResultSet r = null;
		r = base.execute("SELECT * FROM annee WHERE mnemo="+mnemo);
		
		//Recuperation des annees
		while(r.next()){
			Annee an = new AnneeMySQL(r.getString("version_Etape"));
			EnsAn.add(an);
		}
		this.Listeannee= (ArrayList<Annee>) EnsAn;
	}
	

	
/**	
	   * Charge dans l'ArrayList du département des années qu'il contient.
	   * 
	   * @param mnemo 
	   *            Le mnémonique caractérisant le département
	   *            
	   */
    public void LoadListeAnnee(){
    	MySQL base = (MySQL) Facade.getInstance().getBD();

		ResultSet r = null;
		try {
			r = base.execute("SELECT * FROM annee where mnemo LIKE '"+this.getMnemo()+"%'");

		
			//Recuperation des departements
			while(r.next()){
				Annee a = new AnneeMySQL();
				
				a.setVersionEtape(r.getString("version_etape"));
				a.setMnemo(r.getString("mnemo"));
				
				this.Listeannee.add(a);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	

    
    
 /**	
     * Permet de renvoyer l'ensemble des années contenue dansl'ArrayList du département.
     * 
     *            
     */
	public ArrayList<String> EnsembleAnnees(){
		
	return super.EnsembleAnnees();
	}

	
	
/**	
     * Charge Ã  partir de la base les informations du département
     * 
     *            
     */	
	public void load() {
		MySQL base = (MySQL) Facade.getInstance().getBD();
		ResultSet r = null;
		try {
			r = base.execute("SELECT * FROM departement WHERE mnemo='"+ this.getMnemo()+"'");
			while(r.next()){
				this.setNomDept(r.getString("nom_departement"));
				this.setVersionDiplome(r.getString("version_diplome"));
				UtilisateurMySQL u =new UtilisateurMySQL();
				u.load(r.getInt("id_responsable"));
				this.setResponsable(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
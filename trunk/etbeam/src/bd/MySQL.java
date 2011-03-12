package bd;

import java.sql.*;

import java.util.ArrayList;

import models.Departement;
import models.ECUE;
import models.Etudiant;
import models.Annee;
import models.Semestre;
import models.UE;
import models.mysql.AnneeMySQL;
import models.mysql.DepartementMySQL;
import models.mysql.SemestreMySQL;
import models.mysql.UEMySQL;

public class MySQL extends BD {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
		
	public void connect() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/etbeam",
							Login.getLogin(), Login.getPassword());

		} catch (Exception e) {
			throw e;
		}
	}
	
	public ResultSet execute(String query) throws SQLException{		
		statement = connect.createStatement();
		
		// Result set get the result of the SQL query
		
		Facade.getInstance().printDebug("SQL QUERY = "+query);
		resultSet = statement.executeQuery(query);
		
		return this.resultSet;
	}

	// You need to close the resultSet
	public void close() {
		/*
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}*/
	}



	@Override
	/*public ArrayList<Etudiant> loadEtudByECUE(String ecue) throws Exception {
		ArrayList<Etudiant> ret = new ArrayList<Etudiant>();
		
		this.connect();
		
		ECUEMySQL ec = new ECUEMySQL();
		
		ec.setCodeECUE(ecue);
		ec.load();

		
		this.close();
		
		return ret;
	}*/

	

	public ArrayList<ECUE> getListeECUE(UE ue) throws Exception {
		if(ue.getLesECUE().size() <= 0)
			ue.loadECUE(ue.getCodeUE());
		return ue.getLesECUE();
	}

	@Override
	public ArrayList<UE> getListeUE(Semestre sem) throws Exception {
		if(sem.getLesUE().size() <= 0)
			sem.loadUE(sem.getCodeSemestre());
		return sem.getLesUE();
	}

	public ArrayList<Departement> getListeDepartement() throws Exception {
		ArrayList<Departement> ret = new ArrayList<Departement>();

		this.connect();
		ResultSet r = null;
		r = this.execute("SELECT * FROM departement");
		
		//Recuperation des departements
		while(r.next()){
			Departement dep = new DepartementMySQL(r.getString("mnemo"));
			
			dep.setNomDept(r.getString("nom_departement"));
			dep.setVersionDiplome(r.getString("version_diplome"));
			
			ret.add(dep);
		}
		this.close();
		return ret;
	}

	public ArrayList<Annee> getListeAnnee() throws Exception {
		ArrayList<Annee> ret = new ArrayList<Annee>();
		this.connect();
		ResultSet r = null;
		r = this.execute("SELECT * FROM annee");
		
		//Recuperation des departements
		while(r.next()){
			Annee a = new AnneeMySQL();
			
			a.setVersionEtape(r.getString("version_etape"));
			//a.set(r.getString("id_responsable"));
			a.setMnemo(r.getString("mnemo"));
			
			ret.add(a);
		}
		this.close();
		return ret;
	}
	
	/*@Override
	public ArrayList<Etudiant> getListeEtudiantbyUE(UE ue) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public ArrayList<Semestre> getListeSemestre(Annee an) throws Exception {		
		an.loadSemestre(an.getVersionEtape());
		return an.getSemestres();
	}

	public Annee makeAnnee(String versionEtape) throws SQLException {
		AnneeMySQL a = new AnneeMySQL();
		a.load(versionEtape);
		return a;
	}

	@Override
	public UE makeUE(String code) {
		UEMySQL ue = new UEMySQL();
		ue.setCodeUE(code);
		try {
			ue.load();
		} catch (SQLException e) {
			System.out.println("Error while generating new UE from MySQL");
			e.printStackTrace();
		}
		return ue;
	}

	@Override
	public Semestre makeSemestre(String sem) {
		SemestreMySQL s = new SemestreMySQL();
		s.setCodeSemestre(sem);
		try {
			s.load();
		} catch (SQLException e) {
			System.out.println("Error while generating new Semestre from MySQL");
			e.printStackTrace();
		}
		return s;
	}




	/*public ArrayList<Etudiant> loadEtudByAnnee(String an) throws Exception {
		ArrayList<Etudiant> ret = new ArrayList<Etudiant>();
		
		this.connect();
		
		AnneeMySQL annee = new AnneeMySQL();
		annee.load(an);
		
		this.close();
		
		return ret;
	}*/
	
	/*@Override
	public ArrayList<Etudiant> loadEtudByUE(String ue) {
		// TODO Auto-generated method stub
		return null;
	}*/

}

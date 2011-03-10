package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.ECUE;
import models.Etudiant;
import models.Annee;
import models.Semestre;
import models.UE;
import models.mysql.AnneeMySQL;
import models.mysql.ECUEMySQL;
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
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://r33099.ovh.net/etbeam?"+
							"user="+bd.Login.getLogin()+"&password="+bd.Login.getPassword());

		} catch (Exception e) {
			throw e;
		}
	}
	
	public ResultSet execute(String query) throws SQLException{
		ResultSet res = null;
		
		statement = connect.createStatement();
		
		// Result set get the result of the SQL query
		resultSet = statement.executeQuery(query);
		
		return res;
	}

	// You need to close the resultSet
	public void close() {
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

		}
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
		ArrayList<ECUE> ret = new ArrayList<ECUE>();
		this.connect();
		((UEMySQL) ue).loadECUE(ue.getCodeUE());
		this.close();
		return ret;
	}

	@Override
	public ArrayList<UE> getListeUE(Semestre sem) throws Exception {
		ArrayList<UE> ret = new ArrayList<UE>();
		this.connect();
		sem.loadUE(sem.getCodeSemestre());
		this.close();
		return ret;
	}

	@Override
	public ArrayList<Etudiant> getListeEtudiantbyUE(UE ue) {
		// TODO Auto-generated method stub
		return null;
	}


    public ArrayList<Semestre> getListeSemestre(Semestre sem) throws Exception{
    	ArrayList<Semestre> ret = new ArrayList<Semestre>();
		this.connect();
		((SemestreMySQL) sem).loadSemestre(sem.getCodeSemestre());
		this.close();
		return ret;

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

}}

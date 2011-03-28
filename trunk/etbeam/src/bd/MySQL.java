package bd;

import java.sql.*;

import java.util.ArrayList;

import models.Departement;
import models.ECUE;
import models.Etudiant;
import models.Annee;
import models.Semestre;
import models.UE;
import models.Utilisateur;
import models.mysql.AnneeMySQL;
import models.mysql.DepartementMySQL;
import models.mysql.ECUEMySQL;
import models.mysql.EtudiantMySQL;
import models.mysql.SemestreMySQL;
import models.mysql.UEMySQL;
import models.mysql.UtilisateurMySQL;

public class MySQL extends BD {
	
	private Connection connect = null;
	private Statement statement = null;
	//private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
//	private String host = "127.0.0.1";
	
	private String host = "r33099.ovh.net";
	private String database = "etbeam";
		
	public MySQL() {
		super();
		try {
			this.connect();
		} catch (Exception e) {
			System.out.println("Problem while connecting to MySQL database "+this.host+"/"+this.database);
			e.printStackTrace();
		}
	}

	
	/************* methodes *************/
	
	// execution commandes SQL
	public ResultSet execute(String query) throws SQLException{	
		
		statement = connect.createStatement();
		
		// Result set get the result of the SQL query
		
		Facade.getInstance().printDebug("SQL QUERY = "+query);
		resultSet = statement.executeQuery(query);
		
		return this.resultSet;
	}
	
	// execution commandes SQL de type UPDATE
	public int executeUpdate(String query) throws SQLException{	
		
		statement = connect.createStatement();
		
		// Result set get the result of the SQL query
		
		Facade.getInstance().printDebug("SQL QUERY = "+query);
		return statement.executeUpdate(query);
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

	
	// connection
	public boolean isConnected() {
		return this.connect != null;
	}
	public String getConnectionInfos(){
		return Login.getLogin()+":"+Login.getPassword()+"@"+this.host+"/"+this.database;
	}
	
	public void connect() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// Setup the connection with the DB
			
			connect = DriverManager
					.getConnection("jdbc:mysql://"+this.host+"/"+this.database,
							Login.getLogin(), Login.getPassword());

		} catch (Exception e) {
			throw e;
		}
	}

	//toutes les listes possibles

	public ArrayList<ECUE> getListeECUE(UE ue) {
		if(ue.getLesECUE().size() <= 0){
			try {
				ue.loadECUE(ue.getCodeUE());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ue.getLesECUE();
	}

	
	public ArrayList<UE> getListeUE(Semestre sem) {
		
		if(sem.getLesUE().size() <= 0){
			try {
				sem.loadUE(sem.getCodeSemestre());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return sem.getLesUE();
	}

	public ArrayList<Departement> getListeDepartement(){
		ArrayList<Departement> ret = new ArrayList<Departement>();

		ResultSet r = null;
		try {
			r = this.execute("SELECT * FROM departement");

			//Recuperation des annees
			//Recuperation des departements
		
			while(r.next()){
				Departement dep = new DepartementMySQL(r.getString("mnemo"));
				
				dep.setNomDept(r.getString("nom_departement"));
				dep.setVersionDiplome(r.getString("version_diplome"));
				
				ret.add(dep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	public ArrayList<Annee> getListeAnnee() throws Exception {
		ArrayList<Annee> ret = new ArrayList<Annee>();

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
		return ret;
	}
	
	public ArrayList<Semestre> getListeSemestre(Annee an) {		
		try {
			an.loadSemestre(an.getVersionEtape());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return an.getSemestres();
	}

	public ArrayList<Etudiant> getListeEtudECUE(ECUE ecue){
		ecue.loadEtudiant();

		
		return ecue.getListeEtud();
	}

	
	
	public ArrayList<Annee> getListeAnnee(Departement d){
		try {
			d.LoadListeAnnee();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return d.getLesAnnees();
	}

	
	
	public ArrayList<Etudiant> getListeEtudbyUE(UE ue){
         if(ue.getLesEtudiants().size() <= 0){
			try {
				ue.loadEtudiant();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
         }
         
		return ue.getLesEtudiants();
	}
	
	//fonctions make
	public Annee makeAnnee(String versionEtape, String lib){

		AnneeMySQL a = new AnneeMySQL();
		a.setVersionEtape(versionEtape);
	 	a.setMnemo(lib);
		try {
			a.load(versionEtape);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	
	public UE makeUE(String code, String lib) {
		UEMySQL ue = new UEMySQL();
		ue.setCodeUE(code);
		ue.setLibelleUE(lib);
		try {
			ue.load();
		} catch (SQLException e) {
			System.out.println("Error while generating new UE from MySQL");
			e.printStackTrace();
		}
		return ue;
	}

	
	public Semestre makeSemestre(String sem, String lib) {
		SemestreMySQL s = new SemestreMySQL();
		s.setLibelleSem(lib);
		s.setCodeSemestre(sem);
		s.load();
		return s;
	}

	
	public Utilisateur makeUtilisateur(String login, char[] password) {
		UtilisateurMySQL u = new UtilisateurMySQL();
		
		u.setLogin(login);
		u.setPassWord(new String(password));
		
		return u;
	}

	
	public Departement makeDepartement(String mnemo) {
		DepartementMySQL d = new DepartementMySQL(mnemo);
		d.load();
		
		return d;
	}

	
	public ECUE makeECUE(String ecue) {
		ECUEMySQL e = new ECUEMySQL();
		e.setCodeECUE(ecue);
		try {
			e.load();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return e;
	}
	
	
	public Etudiant makeEtudiant() {
		return new EtudiantMySQL();
	}
	
	
	// modification/cration note : gestion ECUE
	
	public double noteEtudiantUE(ECUE ecue, Etudiant etud,int numsess) throws SQLException {

		return ecue.getEtudiantNote(etud,numsess);
	}
	
    //validation UE : gestion UE
	public void validationUE(Etudiant etud, UE ue) throws SQLException {
		ue.validation(etud);	
	}




}

package bd;

import java.sql.*;

import java.util.ArrayList;

import models.Departement;
import models.ECUE;
import models.Enseignant;
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
	private ResultSet resultSet = null;
	
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

	
	//METHODES
	
	
	/**	
     * retourne le resultSet de la requ�te
     * @param query la requ�te � effectuer
     * @return le resultSet
     */
	public ResultSet execute(String query) throws SQLException{	
		
		statement = connect.createStatement();
		
		// Result set get the result of the SQL query
		
		Facade.getInstance().printDebug("SQL QUERY = "+query);
		resultSet = statement.executeQuery(query);
		
		return this.resultSet;
	}
	
	
	
	
	/**	
     * execute une requ�te de type UPDATE
     * @param query la requ�te � ex�cuter
     * @return l'entier retourn� par la requ�te
     */
	public int executeUpdate(String query) throws SQLException{	
		
		statement = connect.createStatement();
		
		// Result set get the result of the SQL query
		
		Facade.getInstance().printDebug("SQL QUERY = "+query);
		return statement.executeUpdate(query);
	}

	
	
	/**	
     * fermeture du resultSet
     */
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

	
	
	/**	
     * v�rifie l'�tat de la connection 
     * @return l'�tat de la connection
     */
	public boolean isConnected() {
		return this.connect != null;
	}
	
	
	
	/**	
     * permet d'obtenir les informations sur la connection
     * @return les informations sur la connection
     */
	public String getConnectionInfos(){
		return Login.getLogin()+":"+Login.getPassword()+"@"+this.host+"/"+this.database;
	}
	
	
	
	/**	
     * Connection avec la base de donn�es
     */
	public void connect() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// Setup the connection with the DB
			
			connect = DriverManager
					.getConnection("jdbc:mysql://"+this.host+"/"+this.database,
							Login.getLogin(), Login.getPassword());
			
			this.execute("set sql_mode = ''; -- empty string means 'traditional MySQL-mode'");

		} catch (Exception e) {
			throw e;
		}
	}

	
	
	
	//RECUPERATION DES LISTES
	
	

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
		
		{
				sem.load();
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
	
	
	

	public String getAnneeEtudiant(Etudiant etud){
		
		return etud.getAnnee();
		
	}
	
	
	
	//METHODES MAKE
	
	

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
			ue.load();
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
	
	
	
	public double noteEtudiantUE(ECUE ecue, Etudiant etud,int numsess) throws SQLException {

		return ecue.getEtudiantNote(etud,numsess);
	}
	
		

	public void validationUE(Etudiant etud, UE ue) throws SQLException {
		ue.validation(etud);	
	}



	public double getEtudNote(ECUE ec, Etudiant et, int session) {
		return ec.getEtudiantNote(et, session);
	}



	public float getPtsJuryUE(UE ue, Etudiant e) {
	return ue.getPointsJuryUe(e);
	}


	public float getPtsJurySem(Semestre se, Etudiant e) {
		return se.getPointsJurySem(e);
		}



	public double moyenneEtudiantSem(Semestre sem, Etudiant et) {
		return sem.getMoySem(et);
	}



	public void changeNoteEcue(ECUE ec, Etudiant et, float note, int session) {
		ec.changeNoteEtudiantECUE(et, session,note);
	}



	public void ajoutPointsSem(Semestre sem, Etudiant etudiant, Float pts) {
		sem.ajoutPointsSem(etudiant, pts);	
	}


	public void ajoutPointsUE(UE ue, Etudiant et, Float pts) {
		ue.ajoutPointsUE(et, pts);
		
	}
	
	public void saveEnseignant(Enseignant e, String nom, String prenom, String mail, String id){
		e.saveEnseignant(nom, prenom, mail, id);

	}

	public boolean saveUtilisateur(Utilisateur u, String login, String mdp, String id_ens, Integer droits){
		UtilisateurMySQL tmp = new UtilisateurMySQL();
		
		if(!tmp.loginExists(login)){
			u.save(login, mdp, id_ens, droits);
			return true;
		}
		else
			return false;
	}

}

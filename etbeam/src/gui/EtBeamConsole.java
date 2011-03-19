package gui;
import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import models.Annee;
import models.Departement;
import models.ECUE;
import models.EtudManager;
import models.Etudiant;
import models.Model;
import models.Semestre;
import models.UE;
import models.Utilisateur;
import models.mysql.EtudiantMySQL;

import bd.Facade;
import bd.MySQL;

public class EtBeamConsole implements EtBeamIF {
	
	private Console console = System.console();
	private Boolean alive = true;
	
	private String prompter = "$> ";
	private int minColWidth = 5;
	
	private int leftPadding = 20;
	
	
	//Currently selected ressources
	private Utilisateur user = null;
	private Departement dept = null;
	private Annee annee = null;
	private Semestre sem = null;
	private UE ue = null;
	private ECUE ecue = null;
	
	
	
	public void main() {
		
		
		
		//POUR LE TEST DU REMPLISSAGE deETUDMANAGER (a virer apres avoir fait la bonne fonction de load);
		try {
			loadetudman();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//FIN
		
		
		this.print("*********** Welcome in &Beam ***********\n");
		this.print("*    Using default console interface   *\n");
		this.print("* &Beam is developped for educationnal *\n");
		this.print("*   purposes at Polytech'Montpellier   *\n");
		this.print("*--------------------------------------*\n");
		this.print("****************************************\n");
		this.print("*---------   Developped By :   --------*\n");
		this.print("*        <<<   The Coon   >>>          *\n");
		this.print("*        <<<   Youg'Ho    >>>          *\n");
		this.print("*        <<<   Mat Yaki   >>>          *\n");
		this.print("*        <<<    T-Bag     >>>          *\n");
		this.print("****************************************\n");
		this.print("*        Basic usage :                 *\n");
		this.print("* etbeam -gui           Loads the GUI  *\n");
		this.print("* etbeam                Loads the CLI  *\n");
		this.print("*                                      *\n");
		this.print("* Type `help' in console to get a full *\n");
		this.print("*      list of available commands      *\n");
		this.print("****************************************\n");

		this.login();
		
		
		while(alive){
			String command = console.readLine(this.getPrompter());
			
			if(command.equalsIgnoreCase("help")){
				this.print("Available commands:\n");
				this.print("help						- Display this message\n");
				this.print("quit						- Exit &Beam\n");
				this.print("getlistdepartement			- Display Departments list\n");
				this.print("getlistsemestre				- Display Semesters list\n");
				this.print("getlistue					- Display UE list\n");
				this.print("getlistecue					- Display ECUE list\n");
				this.print("getlistetudbyUE			    - Display Etudiant list by UE\n");
				
				this.print("*** ALIASES ***\n");
				this.print("gl dept						- getlistdepartement\n");
				this.print("gl sem						- getlistsemestre\n");
				this.print("gl ue						- getlistue\n");
				this.print("gl ecue						- getlistecue\n");
				this.print("gl etue						- getlistetudbyUE\n");
			}
			else if(command.equalsIgnoreCase("quit")){
				alive = false;
			}
			else if(command.length() > 3 && command.substring(0, 2).equalsIgnoreCase("cd")){
				if(command.substring(3).equalsIgnoreCase("..")){
					if(this.annee == null)
						this.dept = null;
					else if(this.sem == null)
						this.annee = null;
					else if(this.ue == null)
						this.sem = null;
					else if(this.ecue == null)
						this.ue = null;
					else
						this.ecue = null;
					
				}else if(command.substring(3).equalsIgnoreCase("/")){
						this.reinitCurentValues();
				}else{
					if(this.dept == null)
						this.dept = Facade.makeDepartement(command.substring(3));
					else if(this.annee == null)
						this.annee = Facade.makeAnnee(command.substring(3));
					else if(this.sem == null)
						this.sem = Facade.makeSemestre(command.substring(3));
					else if(this.ue == null)
						this.ue = Facade.makeUE(command.substring(3));
					else if(this.ecue == null)
						this.ecue = Facade.makeECUE(command.substring(3));
				}
			}
			else if(command.equalsIgnoreCase("ls")){
				try {
					if(this.dept == null)
						this.displayList(Facade.getListeDepartement());
						
					else if(this.annee == null)
						this.displayList(Facade.getListeAnnee(this.dept));
					
					else if(this.sem == null)
						this.displayList(Facade.getListeSemestre(this.annee));
					
					else if(this.ue == null)
						this.displayList(Facade.getListeUE(this.sem));
					
					else if(this.ecue == null)
						this.displayList(Facade.getListeECUE(this.ue));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else if(command.equalsIgnoreCase("getlistdepartement") ||
					command.equalsIgnoreCase("gl dept"))
			{
				try {
					this.displayList(Facade.getListeDepartement());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equalsIgnoreCase("getlistsemestre") ||
					command.equalsIgnoreCase("gl sem"))
			{
				try {
					Departement d = this.getCurrentDepartement();
					Annee a = this.getCurrentAnnee();
					
					this.displayList(Facade.getListeSemestre(a));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equalsIgnoreCase("getlistue") ||
					command.equalsIgnoreCase("gl ue"))
			{
				try {
					Departement d = this.getCurrentDepartement();
					Annee a = this.getCurrentAnnee();
					Semestre s = this.getCurrentSemestre();
					
					this.displayList(Facade.getListeUE(this.sem));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equalsIgnoreCase("getlistecue") ||
					command.equalsIgnoreCase("gl ecue"))
			{
				try {
					Departement d = this.getCurrentDepartement();
					Annee a = this.getCurrentAnnee();
					Semestre s = this.getCurrentSemestre();
					UE ue = this.getCurrentUE();
					
					this.displayList(Facade.getListeECUE(this.ue));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(command.equalsIgnoreCase("getlistetudbyUE") ||
					command.equalsIgnoreCase("gl etue"))
			{
				try {
					Departement d = this.getCurrentDepartement();
					Annee a = this.getCurrentAnnee();
					Semestre s = this.getCurrentSemestre();
					UE ue = this.getCurrentUE();
					
					
					  
					
					ArrayList<Etudiant> e=(Facade.getListeEtudbyUE(ue)); //Récupération de la liste des étudiants de l'UE
					
					//AFFICHAGE DES ETUDIANTS
					
					for (Iterator<Etudiant> i = e.iterator(); i.hasNext();) {
			        	Etudiant interm = (Etudiant)i.next();
			        	
			        	console.printf("\n"+interm.getNumINE() +" "+interm.getNom()+" "+interm.getPrenom()+" Moyenne UE :"+Facade.moyenneEtudiantUE(ue,interm)+"\n\n");
			    }

					

			       
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void reinitCurentValues() {
			this.dept = null;
			this.annee = null;
			this.sem = null;
			this.ue = null;		
	}

	private Departement getCurrentDepartement() {
		if(this.dept == null){
			try {
				this.displayList(Facade.getListeDepartement());
				this.dept = Facade.makeDepartement(this.askFor("Mnemo du Departement : "));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.dept;
	}

	private Annee getCurrentAnnee() {
		console.printf("\n COUCOU\n");
		if(this.annee == null){
			try {
				this.displayList(Facade.getListeAnnee(this.dept));
				this.annee = Facade.makeAnnee(this.askFor("Code de l'annee : "));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.annee;
	}
	
	private Semestre getCurrentSemestre() {
		if(this.sem == null){
			try {
				this.displayList(Facade.getListeSemestre(this.annee));
				this.sem = Facade.makeSemestre(this.askFor("Code du semestre : "));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.sem;
	}
	private UE getCurrentUE() {
		if(this.ue == null){
			try {
				this.displayList(Facade.getListeUE(this.sem));
				this.ue = Facade.makeUE(this.askFor("Code de l'UE: "));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.ue;
	}
	
	private ECUE getCurrentECUE() {
		if(this.ecue == null){
			try {
				this.displayList(Facade.getListeECUE(this.ue));
				this.ecue = Facade.makeECUE(this.askFor("Code de l'ECUE : "));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.ecue;
	}
	
	private String getPrompter() {
		String p = "";
		
		if(this.user!=null)
			p = p+this.user.getLogin()+"@";
		
		if(this.dept!=null)
			p = p+this.dept.getMnemo();

		if(this.annee!=null)
			p = p+"."+this.annee.getMnemo();
		
		if(this.sem!=null)
			p = p+"."+this.sem.getCodeSemestre();
		
		if(this.ue!=null)
			p = p+"."+this.ue.getLibelleUE();
		
		if(this.ecue!=null)
			p = p+"."+this.ecue.getLibelleECUE();
		
		p=p+" "+this.prompter;
		return p;
	}

	private void login() {
		String login = console.readLine("Login: ");
		char[] password = console.readPassword("Pass: ");
		
		Utilisateur u = Facade.makeUtilisateur(login, password);

		u.connect();

		this.alive = u.getLogged();
		
		if(this.alive){	//Utilisateure connectÃ©
			console.printf("Succesfully connected as "+u.getLogin()+"\n");
		}else{
			console.printf("Bad login/password match for user "+u.getLogin()+"\n");
		}
	}

	private String askFor(String question) {
		console.printf(question);
		return console.readLine();
	}

	
	
	public void displayList(ArrayList<? extends Model> list){
		ArrayList<Integer> cols = new ArrayList<Integer>();
		int colsMargin = 2;
		
		if(list.size() > 0){
			for(int i = 0; i < list.get(0).getVars().size(); i++){
				cols.add(this.minColWidth);
			}
		}
		
		//1er parcours pour le calul des tailles
		for(Model o : list){

			for(int i = 0; i < list.get(0).getVars().size(); i++){
				ModelVariable mv = o.getVars().get(i);
				
				if(mv.getTitle().length()+colsMargin > cols.get(i))
					cols.set(i, mv.getTitle().length()+colsMargin);
				
				if(mv.getContent().length()+colsMargin > cols.get(i))
					cols.set(i, mv.getContent().length()+colsMargin);

			}

		
		}
		
		int width = 1;//1ere collonne a gauche
		for(Integer i : cols)
			width += i+1;//+1 pr la colonne a droite
		
		//dessin 1ere ligne
		printLine(cols);
		
		//titres
		for(int i = 0; i < list.get(0).getVars().size(); i++){
			console.printf("|");
			int leadingspaces = (int) Math.round((cols.get(i)-list.get(0).getVars().get(i).getTitle().length())/2);
			for(int x = 0;x<leadingspaces;x++)
				console.printf(" ");
			
			console.printf(list.get(0).getVars().get(i).getTitle());
			
			int trailingspaces = (cols.get(i)-list.get(0).getVars().get(i).getTitle().length()-leadingspaces);
			for(int x = 0;x<trailingspaces;x++)
				console.printf(" ");
			
		}
		console.printf("|\n");
		printLine(cols);
		
		for(Model o : list){

			for(int i = 0; i< o.getVars().size(); i++){
				ModelVariable mv = o.getVars().get(i);
				
				console.printf("|");
				int leadingspaces = (int) Math.ceil((cols.get(i)-mv.getContent().length())/2);
				for(int x = 0;x<leadingspaces;x++)
					console.printf(" ");
				
				console.printf(mv.getContent());
				
				int trailingspaces = (cols.get(i)-mv.getContent().length()-leadingspaces);
				for(int x = 0;x<trailingspaces;x++)
					console.printf(" ");
				
			}
			console.printf("|\n");
			printLine(cols);
		}

	}
	
	public void dumpList(ArrayList<? extends Model> list){
		for(Model o : list){

			for(ModelVariable mv : o.getVars()){
				
				console.printf(mv.getContent());
				console.printf(" | ");
				
			}
			console.printf("\n");
		}
		
	}
	
	private void printLine(ArrayList<Integer> l){
		console.printf("+");
		for(Integer i : l){
			for(int j=0;j<i;j++){
				console.printf("-");
			}
			console.printf("+");
		}
		console.printf("\n");
		
	}


	
	
	
	private void print(String str){
		for(int i=0;i<this.leftPadding;i++)
			console.printf(" ");
		console.printf(str);
	}
	
	
	public void loadetudman() throws SQLException{	
		//TEST POUR REMPLIR LE ETUDMANAGER
		//!!!penser a enlever les imports necessaires apres!!!
		MySQL base = (MySQL) Facade.getBD();
		ResultSet r,t = null;
		
			r = base.execute("SELECT num_ine FROM etudiant");
		
			
		
			while (r.next()){
				
				Etudiant etud = new EtudiantMySQL();
				
				t = base.execute("SELECT * FROM etudiant WHERE num_ine ="+r.getString("num_ine"));
				
				while (t.next()){
				etud.setNom(t.getString("nom"));
				etud.setPrenom(t.getString("prenom"));
				etud.setNumINE(t.getString("num_ine"));
				}

				EtudManager.getInstance().addEtudiant(etud);	
}
		
	}		// FIN DU TEST
	
	
}

package gui;
import java.io.Console;
import java.util.ArrayList;

import models.Annee;
import models.Departement;
import models.Model;

import bd.Facade;

public class EtBeamConsole implements EtBeamIF {
	
	private Console console = System.console();
	private Boolean alive = true;
	private String prompter = "$> ";
	
	public void main() {
		console.printf("*********** Welcome in &Beam ***********\n");
		console.printf("*    Using default console interface   *\n");
		console.printf("* &Beam is developped for educationnal *\n");
		console.printf("*   purposes at Polytech'Montpellier   *\n");
		console.printf("*--------------------------------------*\n");
		console.printf("****************************************\n");
		console.printf("*---------   Developped By :   --------*\n");
		console.printf("*        <<<   The Coon   >>>          *\n");
		console.printf("*        <<<   Youg'Ho    >>>          *\n");
		console.printf("*        <<<   Mat Yaki   >>>          *\n");
		console.printf("*        <<<    T-Bag     >>>          *\n");
		console.printf("****************************************\n");
		console.printf("*        Basic usage :                 *\n");
		console.printf("* etbeam -gui           Loads the GUI  *\n");
		console.printf("* etbeam                Loads the CLI  *\n");
		console.printf("*                                      *\n");
		console.printf("* Type `help' in console to get a full *\n");
		console.printf("*      list of available commands      *\n");
		console.printf("****************************************\n");

		
		while(alive){
			String command = console.readLine(prompter);
			
			if(command.equalsIgnoreCase("help")){
				console.printf("Available commands:\n");
				console.printf("help						- Display this message\n");
				console.printf("quit						- Exit &Beam\n");
				console.printf("getlistdepartement			- Display Departments list\n");
				console.printf("getlistsemestre				- Display Semesters list\n");
				console.printf("getlistue					- Display UE list\n");
				console.printf("getlistecue					- Display ECUE list\n");

				
				console.printf("*** ALIASES ***\n");
				console.printf("gl dept						- getlistdepartement\n");
				console.printf("gl sem						- getlistsemestre\n");
				console.printf("gl ue						- getlistue\n");
				console.printf("gl ecue						- getlistecue\n");
			}
			else if(command.equalsIgnoreCase("quit")){
				alive = false;
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
					this.displayList(Facade.getListeAnnee());
					this.displayList(Facade.getListeSemestre(Facade.makeAnnee(this.askFor("Code de l'annee : "))));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equalsIgnoreCase("getlistue") ||
					command.equalsIgnoreCase("gl ue"))
			{
				try {
					this.displayList(Facade.getListeAnnee());
					this.displayList(Facade.getListeSemestre(Facade.makeAnnee(this.askFor("Code de l'annee : "))));
					this.displayList(Facade.getListeUE(Facade.makeSemestre(this.askFor("Code du Semestre : "))));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(command.equalsIgnoreCase("getlistecue") ||
					command.equalsIgnoreCase("gl ecue"))
			{
				try {
					this.displayList(Facade.getListeAnnee());
					this.displayList(Facade.getListeSemestre(Facade.makeAnnee(this.askFor("Code de l'annee : "))));
					this.displayList(Facade.getListeUE(Facade.makeSemestre(this.askFor("Code du Semestre : "))));
					this.displayList(Facade.getListeECUE(Facade.makeUE(this.askFor("Code de l'UE: "))));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private String askFor(String question) {
		console.printf(question);
		return console.readLine();
	}

	public void displayList(ArrayList<? extends Model> list){
		
		for(Model o : list){
			for(ModelVariable mv : o.getVars()){
				console.printf("	");
				console.printf(mv.getContent());
				//console.printf("\n");
			}
			
//			console.printf(o.toString());
			console.printf("\n");
		}
		
	}

}

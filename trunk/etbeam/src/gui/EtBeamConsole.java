package gui;
import java.io.Console;
import java.util.ArrayList;
import java.util.Map;

import models.Annee;
import models.Departement;
import models.Model;

import bd.Facade;

public class EtBeamConsole implements EtBeamIF {
	
	private Console console = System.console();
	private Boolean alive = true;
	
	private String prompter = "$> ";
	private int minColWidth = 5;
	
	private int leftPadding = 20;
	
	public void main() {
		
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

		
		while(alive){
			String command = console.readLine(prompter);
			
			if(command.equalsIgnoreCase("help")){
				this.print("Available commands:\n");
				this.print("help						- Display this message\n");
				this.print("quit						- Exit &Beam\n");
				this.print("getlistdepartement			- Display Departments list\n");
				this.print("getlistsemestre				- Display Semesters list\n");
				this.print("getlistue					- Display UE list\n");
				this.print("getlistecue					- Display ECUE list\n");

				
				this.print("*** ALIASES ***\n");
				this.print("gl dept						- getlistdepartement\n");
				this.print("gl sem						- getlistsemestre\n");
				this.print("gl ue						- getlistue\n");
				this.print("gl ecue						- getlistecue\n");
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
	
	
	
	
}

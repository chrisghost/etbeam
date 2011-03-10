package gui;
import java.io.Console;
import java.util.ArrayList;

import models.Departement;

import bd.Facade;

public class EtBeamConsole implements EtBeamIF {
	
	private Console console = System.console();
	private Boolean alive = true;
	private String prompter = "$> ";
	
	public void main() {
		console.printf("*** Welcome in &Beam ***\n");
		console.printf("> Using console interface\n");
		
		while(alive){
			String command = console.readLine(prompter);
			
			if(command.equalsIgnoreCase("help")){
				console.printf("Available commands:\n");
				console.printf("help						- Display this message\n");
				console.printf("quit						- Exit &Beam\n");
				console.printf("getlistdepartement			- Display Departments list\n");
			}
			else if(command.equalsIgnoreCase("quit")){
				alive = false;
			}else if(command.equalsIgnoreCase("getlistdepartement")){
				try {
					ArrayList<Departement> list = Facade.getListeDepartement();
					for (Departement dep : list) {
						console.printf(dep.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		}
	}

}

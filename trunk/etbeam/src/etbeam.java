import gui.EtBeamConsole;
import gui.EtBeamGui;
import gui.EtBeamIF;

/*
 * Fichier principal du logiciel
 */

public class etbeam {
	private static EtBeamIF IF = null;
	
	public static void main(String[] args) {
		System.out.println(args);
		
		if(args.length > 1){
			if(args[1].equalsIgnoreCase("-gui")){
				IF = new EtBeamGui();
			}
		}
		
		if(IF == null)
			IF = new EtBeamConsole();
		
		IF.main();
	}
}
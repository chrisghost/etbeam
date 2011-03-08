import gui.EtBeamConsole;
import gui.EtBeamGui;
import gui.EtBeamIF;

/*
 * Fichier principal du logiciel
 */

public class etbeam {
	private static EtBeamIF IF = null;
	
	public static void main(String[] args) {
		if(args.length > 0){
			if(args[0].equalsIgnoreCase("-gui")){
				IF = new EtBeamGui();
			}
		}
		
		if(IF == null)
			IF = new EtBeamConsole();
		
		IF.main();
	}
}
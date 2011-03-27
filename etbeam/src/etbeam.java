import java.awt.EventQueue;

import bd.Facade;
import gui.EtBeamConsole;
import gui.ConsultationMoy;
import gui.EtBeamGui;
import gui.EtBeamIF;
//import gui.EtBeamGUI;
/*
 * Fichier principal du logiciel
 */
import gui.Login;

public class etbeam {
	private static EtBeamIF IF = null;
	
	public static void main(String[] args) {


				Facade.getInstance().setBD("mysql");
				
				if(!Facade.getInstance().getBD().isConnected()){
					System.out.println("+==============================================================================+");
					System.out.println("|                                                                              |");
					System.out.println("|                    Database connection is broken !!                          |");
					System.out.println("|               You shoulf fix this before going further                       |");
					System.out.println("|                                                                              |");
					System.out.println("+==============================================================================+");
					
					System.out.println("       Connection Informations : "+Facade.getInstance().getBD().getConnectionInfos());
					System.out.println();
					System.out.println();
				}
				
				if(args.length > 0){
					
					if(args[0].equalsIgnoreCase("-gui")){
						
							try {
								EventQueue.invokeLater(new Runnable() {
									
									
									public void run() {
										try {
											new EtBeamGui();

										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
								
		
								
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						
					}
				}
				
				if(IF == null)
					IF = new EtBeamConsole();
				
				IF.main();
			}
	
}
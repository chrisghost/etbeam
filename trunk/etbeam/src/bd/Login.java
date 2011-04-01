package bd;

public class Login {

	static private String login = "etbeam";
	static private String password = "polytech";


	
	
	/**	
     * permet de r�cup�rer le login de l'utilisateur
     * @return le login de l'utilisateur
     */
	static public String getLogin(){
		return login;
	}
	
	/**	
     * permet de r�cup�rer le password de l'utilisateur
     * @return le password de l'utilisateur
     */
	static public String getPassword(){
		return password;
	}
}

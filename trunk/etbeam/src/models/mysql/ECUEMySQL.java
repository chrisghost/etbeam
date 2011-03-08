package models.mysql;

import java.util.ArrayList;

import models.ECUE;

public class ECUEMySQL extends ECUE{

	
	public ECUEMySQL(String libelleECUE, String codeECUE,float volHoraire, UtilisateurMySQL utilisateur) {
		super(libelleECUE, codeECUE, volHoraire, utilisateur);
	}
	

	public void load(){
		
	}
    
}
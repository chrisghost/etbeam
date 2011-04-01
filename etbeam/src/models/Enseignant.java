package models;

import java.util.ArrayList;

public abstract class Enseignant extends Personne {
	


/***** constructeurs *****/
	
	protected ArrayList<ECUE> myECUE ;
    protected ArrayList<UE> myUE;
    protected ArrayList<Departement> myDept;
    protected ArrayList<Annee> myAnnee;
    
    public Enseignant(String nom, String prenom, String mail) {
    	super(nom, prenom, mail);

    }


    public Enseignant() {
    	super();

    }
    
    public abstract void saveEnseignant(String nom, String prenom, String mail, String id);


}

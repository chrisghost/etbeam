package models;
import models.Utilisateur;
import models.Departement;



public  class Annee  {
    public String versionEtape;
    private Utilisateur ResponsableAn;
    private Departement dept;

    
	public Annee(String versionEtape) {
		super();
		this.versionEtape = versionEtape;
	}

	public String getVersionEtape() {
		return versionEtape;
	}

	public void setVersionEtape(String versionEtape) {
		this.versionEtape = versionEtape;
	}

 }
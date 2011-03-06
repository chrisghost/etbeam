package models;
import models.Utilisateur;




public  class Annee  {
    public String versionEtape;
    private Utilisateur ResponsableAn;

    
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
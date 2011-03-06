package models;

import java.util.ArrayList;


public  class Annee  {
    public String versionEtape;
    private Utilisateur ResponsableAn;
    private Departement dept;
    private ArrayList<Semestre> lesSem;

    
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
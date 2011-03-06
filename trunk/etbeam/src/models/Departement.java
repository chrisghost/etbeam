package models;

import models.Utilisateur;



public  class Departement  {
    public String nomDept;
    public String mnemo;
    public String versionDiplome;
    private Utilisateur ResponsableDept;	
	
	
	public Departement(String nomDept, String mnemo, String versionDiplome) {
		super();
		this.nomDept = nomDept;
		this.mnemo = mnemo;
		this.versionDiplome = versionDiplome;
	}


	public Departement(String nomDept) {
		super();
		this.nomDept = nomDept;
	}

	public String getNomDept() {
		return nomDept;
	}
	public void setNomDept(String nomDept) {
		this.nomDept = nomDept;
	}
	public String getMnemo() {
		return mnemo;
	}
	public void setMnemo(String mnemo) {
		this.mnemo = mnemo;
	}
	public String getVersionDiplome() {
		return versionDiplome;
	}
	public void setVersionDiplome(String versionDiplome) {
		this.versionDiplome = versionDiplome;
	}
    
    

 }
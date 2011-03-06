package models;





public  class ECUE  {
    public String libelleECUE;
    public String codeECUE;
    public int volumHoraire;
    
    
	public ECUE(String libelleECUE, String codeECUE) {
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
	}
	
	
	public ECUE(String libelleECUE, String codeECUE, int volumHoraire) {
		super();
		this.libelleECUE = libelleECUE;
		this.codeECUE = codeECUE;
		this.volumHoraire = volumHoraire;
	}


	public String getLibelleECUE() {
		return libelleECUE;
	}
	public void setLibelleECUE(String libelleECUE) {
		this.libelleECUE = libelleECUE;
	}
	public String getCodeECUE() {
		return codeECUE;
	}
	public void setCodeECUE(String codeECUE) {
		this.codeECUE = codeECUE;
	}
	public int getVolumHoraire() {
		return volumHoraire;
	}
	public void setVolumHoraire(int volumHoraire) {
		this.volumHoraire = volumHoraire;
	}

    
 }
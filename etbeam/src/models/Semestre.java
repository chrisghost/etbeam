package models;





public class Semestre {
	public String libelleSem;
	public String CodeSemestre;
	public int NbUEfacultatives;
	
	
	public String getLibelleSem() {
		return libelleSem;
	}
	public void setLibelleSem(String libelleSem) {
		this.libelleSem = libelleSem;
	}
	public String getCodeSemestre() {
		return CodeSemestre;
	}
	public void setCodeSemestre(String codeSemestre) {
		CodeSemestre = codeSemestre;
	}
	public int getNbUEfacultatives() {
		return NbUEfacultatives;
	}
	public void setNbUEfacultatives(int nbUEfacultatives) {
		NbUEfacultatives = nbUEfacultatives;
	}

}
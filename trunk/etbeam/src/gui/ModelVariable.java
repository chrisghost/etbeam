package gui;
import models.Model;

public class ModelVariable {
	private String title;
	private String content;
	private Model m;
	
	public ModelVariable(Model m, String t, String c){
		this.title = t;
		this.content = c;
		this.m = m;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Model getM() {
		return m;
	}

	public void setM(Model m) {
		this.m = m;
	}
	
	
}
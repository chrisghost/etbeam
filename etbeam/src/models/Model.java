package models;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


import gui.ModelVariable;

public abstract class Model{
	private ArrayList<ModelVariable> vars = new ArrayList<ModelVariable>();
	
	public Model(){
		this.addVars();
	}
	
	protected abstract void addVars();

	protected void addVar(String title){
		vars.add(new ModelVariable(this, title, ""));
	}
	
	public ArrayList<ModelVariable> getVars(){
		Method method;
		
		for(ModelVariable v : this.vars){
			try {
				String methodName = Character.toUpperCase(v.getTitle().charAt(0)) + v.getTitle().substring(1);
				method = v.getM().getClass().getMethod("get"+methodName);
				v.setContent(((Object) method.invoke(v.getM())).toString());
				
			} catch (SecurityException e) {
				System.out.println("================== Reflection problem ==================");
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				System.out.println("================== Reflection problem ==================");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println("================== Reflection problem ==================");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.out.println("================== Reflection problem ==================");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.out.println("================== Reflection problem ==================");
				e.printStackTrace();
			}
		}
		
		return this.vars;
	}
	
	

}
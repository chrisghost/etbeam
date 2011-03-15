package bd;

public class FacadeAdmin {
	private static final FacadeAdmin INSTANCE = new FacadeAdmin();
	 
    private BD persistance = null;
    
    
    /***** Private constructor prevents instantiation from other classes *****/
    
    private FacadeAdmin() {
    }
 
    
    /**** getter and setter ****/
    
    public static FacadeAdmin getInstance() {
        return INSTANCE;
    }
    
    public void setBD(String bd){
    	if(bd.equalsIgnoreCase("mysql")){
			this.persistance = new MySQL();
    	}
    }
    
    public static BD getBD(){
    	
    	if(INSTANCE.persistance == null)
    		INSTANCE.persistance = new MySQL();
    	
    	return INSTANCE.persistance;
    
    }

}

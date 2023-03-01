package farmer.createFarmer;

public interface CreateFarmerControllerCallBack {
	String encryptPassword(String password);
	boolean addFarmer(String name,String mobile,String password);
	
	
}

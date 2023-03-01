package farmer.farmersAccess;

public interface FarmerAccessControllerCallBack {
	boolean getIDandPassword(String id,String password);
	String encryptPassword(String password);
	boolean getProductName(String productName);
	boolean updateAvailableProductControl(String prodname,double quantity,double price);
	boolean addNewProductControl(String prodname,double quantity,double price);
	
	
}

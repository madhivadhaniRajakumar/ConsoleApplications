package farmer.farmersAccess;

public interface FarmerAccessModelCallBack {
	boolean getFarmer(String fid,String password);
	boolean checkProdName(String prodname);
	boolean updateProduct(String prodname,double quantity,double price);
	boolean addNewProduct(String prodname,double quantity,double price);
	
}

package farmer.farmersAccess;

public interface FarmerAccessViewCallBack {
	void mainMenu();
	void addProducts();
	boolean updateAvailableProductView(String productName,double quantity,double price);
	boolean addNewProductView(String productName,double quantity,double price);
}

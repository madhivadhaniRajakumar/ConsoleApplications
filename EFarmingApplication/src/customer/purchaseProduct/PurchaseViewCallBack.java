package customer.purchaseProduct;

public interface PurchaseViewCallBack {
	void customerLogin() ;
	void purchaseMenu(String userID) ;
	void viewOrderDetails(String userID);
}

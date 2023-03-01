package customer.purchaseProduct;

import java.sql.ResultSet;

public interface PurchaseModelCallBack {
	boolean checkUserModel(String userID,String password);
	ResultSet getProductMenuModel();
	boolean addProducttoCartModel(String uId,String prodId,String prodname,double quantity,double amount,double initialquantity);
	 ResultSet viewOrderDetails(String userId);
}

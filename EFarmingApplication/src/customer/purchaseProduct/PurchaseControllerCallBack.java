package customer.purchaseProduct;

import java.sql.ResultSet;

public interface PurchaseControllerCallBack {
	boolean checkUser(String userID,String password) ;
	ResultSet getProductMenu();
	boolean addProducttoCart(String uID,String prodID,String prodName,double quantity,double price,double initialQuantity);
	ResultSet orderDetailsControl(String userId);
}

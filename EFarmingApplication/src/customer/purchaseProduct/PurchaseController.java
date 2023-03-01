package customer.purchaseProduct;

import java.sql.ResultSet;

public class PurchaseController implements PurchaseControllerCallBack{

	PurchaseModelCallBack modelback;
	PurchaseViewCallBack viewback;
	public PurchaseController(PurchaseViewCallBack purchaseView) {
		// TODO Auto-generated constructor stub
		viewback= purchaseView;
		modelback = new PurchaseModel(this);
	}

	public boolean checkUser(String userID,String password) {
		if(modelback.checkUserModel(userID, password)) {
			return true;
		}
		return false;
	}
	
	public ResultSet getProductMenu() {
		ResultSet set = modelback.getProductMenuModel();
		return set;
	}
	public boolean addProducttoCart(String uID,String prodID,String prodName,double quantity,double price,double initialquantity) {
		if(modelback.addProducttoCartModel(uID, prodID, prodName, quantity, price,initialquantity)) {
			return true;
		}
		return false;
	}
	public ResultSet orderDetailsControl(String userId) {
		ResultSet set =modelback.viewOrderDetails(userId);
		return set;
	}
}

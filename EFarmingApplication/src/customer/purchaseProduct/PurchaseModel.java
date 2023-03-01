package customer.purchaseProduct;

import java.sql.ResultSet;

import repository.EFarmingDB;

public class PurchaseModel implements PurchaseModelCallBack {

	PurchaseControllerCallBack controllerCallBack;
	public PurchaseModel(PurchaseControllerCallBack purchaseController) {
		// TODO Auto-generated constructor stub
		controllerCallBack = purchaseController;
	}

	public boolean checkUserModel(String userID,String password) {
		if(EFarmingDB.getInstance().getUserLoginDetails(userID, password)) {
			return true;
		}
		return false;
	}
	public  ResultSet getProductMenuModel() {
		ResultSet set = EFarmingDB.getInstance().getProducts();
		return set;
	}
	public boolean addProducttoCartModel(String uId,String prodId,String prodname,double quantity,double amount,double initialquantity) {
		if(EFarmingDB.getInstance().addProductDB(uId, prodId, prodname, quantity, amount,initialquantity)) {
			return true;
		}
		return false;
	}
	
	public ResultSet viewOrderDetails(String userId) {
		ResultSet set = EFarmingDB.getInstance().viewOrder(userId);
		return set;
	}
}

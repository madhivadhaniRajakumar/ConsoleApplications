package farmer.farmersAccess;

import repository.EFarmingDB;

public class FarmerAccessModel implements FarmerAccessModelCallBack {
	
	FarmerAccessControllerCallBack  accessControllerCallBack;
	public FarmerAccessModel(FarmerAccessControllerCallBack farmerAccessController) {
		// TODO Auto-generated constructor stub
		accessControllerCallBack =farmerAccessController;
	}

	public boolean getFarmer(String fid,String password) {
		if(EFarmingDB.getInstance().getFarmerCredential(fid, password)) {
			return true;
		}
		return false;
	}
	
	public boolean checkProdName(String prodname) {
		if(EFarmingDB.getInstance().getProductNameDB(prodname)) {
			return true;
		}
		return false;
	}
	public boolean updateProduct(String prodname,double quantity,double price) {
		if(EFarmingDB.getInstance().updateProductDB(prodname, quantity, price)) {
			return true;
		}
		return false;
	}
	public boolean addNewProduct(String prodname,double quantity,double price) {
		if(EFarmingDB.getInstance().addNewProductDB(prodname, quantity, price)) {
			return true;
		}
		return false;
	}
}

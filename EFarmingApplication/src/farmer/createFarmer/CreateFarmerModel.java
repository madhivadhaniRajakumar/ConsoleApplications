package farmer.createFarmer;

import repository.EFarmingDB;

public class CreateFarmerModel implements CreateFarmerModelCallBack {

	
	CreateFarmerControllerCallBack controller;
	public CreateFarmerModel(CreateFarmerController createFarmerController) {
		controller = createFarmerController;
	}
	public boolean createFarmer(String farmerID, String farmername,String mobile,String password) {
		if(EFarmingDB.getInstance().addFarmer(farmerID, farmername, mobile, password)) {
			return true;
		}
		return false;
	}
	public int getIDfromDB() {
		System.out.println("model");
		int count = EFarmingDB.getInstance().getIdCount();
		return count;
	}
}

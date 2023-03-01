package farmer.createFarmer;

public interface CreateFarmerModelCallBack {
	boolean createFarmer(String farmerID, String farmername,String mobile,String password);
	int getIDfromDB();
}

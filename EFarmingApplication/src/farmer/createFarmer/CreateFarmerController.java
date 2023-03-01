package farmer.createFarmer;

public class CreateFarmerController implements CreateFarmerControllerCallBack {

	private CreateFarmerModelCallBack modelback;
	private CreateFarmerViewCallBack viewback;
	static private int farmerID = 130;
	
	public CreateFarmerController(CreateFarmerViewCallBack createFarmerView) {
		viewback = createFarmerView;
		modelback = new CreateFarmerModel(this);
	}
	
	
	public String encryptPassword(String password) {
		 char[] ch = password.toCharArray();
		 String pass= "";
		 for(int i=0;i<ch.length;i++) {
			char a= (char) (ch[i]+1);
			 pass += a;
		 }
		return pass;
	}

	
	public boolean addFarmer(String name,String mobile,String password) {
		farmerID = farmerID+1;
		int tempId = farmerID;
		String farmerID = "FARM"+tempId;
		return modelback.createFarmer(farmerID,name, mobile, password);
				
	}

}

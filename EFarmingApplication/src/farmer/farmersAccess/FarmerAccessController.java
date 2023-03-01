package farmer.farmersAccess;

public class FarmerAccessController implements FarmerAccessControllerCallBack {

	FarmerAccessModelCallBack modelback;
	FarmerAccessViewCallBack viewback;
	public FarmerAccessController(FarmerAccessViewCallBack farmerAccessView) {
		// TODO Auto-generated constructor stub
		viewback = farmerAccessView;
		modelback = new FarmerAccessModel(this);
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
	
	
	public boolean getIDandPassword(String id,String password) {
		if(modelback.getFarmer(id, password)) {
			return true;
		}
		return false;
	}
	
	public boolean getProductName(String productName) {
		if(modelback.checkProdName(productName)){
			return true;
		}
		return false;
	}
	public boolean updateAvailableProductControl(String prodname,double quantity,double price) {
		if(modelback.updateProduct(prodname, quantity, price)) {
			return true;
		}
		return false;
	}
	public boolean addNewProductControl(String prodname,double quantity,double price) {
		if(modelback.addNewProduct(prodname, quantity, price)) {
			return true;
		}
		return false;
	}
	
}

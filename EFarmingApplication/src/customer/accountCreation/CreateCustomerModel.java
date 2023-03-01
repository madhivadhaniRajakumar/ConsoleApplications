package customer.accountCreation;

import repository.EFarmingDB;

public class CreateCustomerModel implements CreateCustomerModelCallBack {

	CreateCustomerControlCallBack controlCallBack;
	public CreateCustomerModel(CreateCustomerControlCallBack createCustomerController) {
		// TODO Auto-generated constructor stub
		controlCallBack = createCustomerController;
	}

	public boolean custAccountCreateModel(String custId,String name,String add,String mobile,String password) {
		if(EFarmingDB.getInstance().addNewCustomer(custId, name, add, mobile, password)) {
			return true;
		}
		return false;
	}
}

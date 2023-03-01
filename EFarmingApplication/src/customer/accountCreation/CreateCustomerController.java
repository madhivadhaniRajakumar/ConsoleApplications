package customer.accountCreation;

public class CreateCustomerController implements CreateCustomerControlCallBack {

	CreateCustomerViewCallBack viewback;
	CreateCustomerModelCallBack modelback;
	
	public CreateCustomerController(CreateCustomerViewCallBack createCustomerView) {
		// TODO Auto-generated constructor stub
		viewback = createCustomerView;
		modelback = new CreateCustomerModel(this);
	}

	public boolean createAccountControl(String custId,String name,String address,String mobile,String password) {
		if(modelback.custAccountCreateModel(custId, name, address, mobile, password)) {
			return true;
		}
		return false;
	}
}

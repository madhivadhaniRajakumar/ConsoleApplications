package customer.login;

import Repositary.BankingApplicationDB;
import customer.dto.Customer;

public class LoginModel implements LoginModelCallBack {
	LoginControllerCallBack controllerCallBack;
	public LoginModel(LoginController loginController) {
		controllerCallBack = loginController;
	}

	public Customer checkCustIDDB(String name,String password) {
		Customer c = BankingApplicationDB.getInstance().checkCustIDDB(name, password);
		return c;
	}
}

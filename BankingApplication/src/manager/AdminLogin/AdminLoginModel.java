package manager.AdminLogin;

import Repositary.BankingApplicationDB;

public class AdminLoginModel implements AdminLoginModelCallBack  {
	
	AdminLoginControllerCallBack controlback;
	
	public AdminLoginModel(AdminLoginControllerCallBack adminLoginController) {
		// TODO Auto-generated constructor stub
		controlback = adminLoginController;
	}

	public boolean checkCredentialDB(String name,String password) {
		
		return BankingApplicationDB.getInstance().checkValidUser(name, password);
	}
}

package customer.login;

import java.text.ParseException;

import customer.dto.Customer;

public class LoginController implements LoginControllerCallBack{

	LoginViewCallBack viewback;
	LoginModelCallBack modelback;
	public LoginController(LoginViewCallBack loginView) {
		viewback = loginView;
		modelback = new LoginModel(this);
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
	public void getCustomerObject(String custID,String password) throws ParseException {
		System.out.println("Control");
		Customer c =modelback.checkCustIDDB(custID, password);
		viewback.success(c);
	}
}

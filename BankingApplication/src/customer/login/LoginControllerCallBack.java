package customer.login;

import java.text.ParseException;

import customer.dto.Customer;

public interface LoginControllerCallBack {
	String encryptPassword(String password);
	void getCustomerObject(String custID,String password) throws ParseException;
}

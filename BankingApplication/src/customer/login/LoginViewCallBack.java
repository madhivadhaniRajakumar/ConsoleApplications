package customer.login;

import java.io.IOException;
import java.text.ParseException;

import customer.dto.Customer;

public interface LoginViewCallBack {
	void displayLogin() throws IOException, ParseException;
	void success(Customer c) throws ParseException;
	void fail() throws IOException, ParseException;
	void login() throws IOException, ParseException;
}

package customer.login;

import customer.dto.Customer;

public interface LoginModelCallBack {
	Customer checkCustIDDB(String name,String password);
}

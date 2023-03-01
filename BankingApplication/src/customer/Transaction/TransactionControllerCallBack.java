package customer.Transaction;

import customer.dto.Customer;

public interface TransactionControllerCallBack {
	Customer getCustObject(String custID);
	void  transferAmount(Customer c , Customer c1,double amount);
	void transferAmount(Customer c, double amount);
	void withdrawAmount(Customer c, double amount);
	void transferDiff(Customer c, double amount,String ifsc,String accNo);
}

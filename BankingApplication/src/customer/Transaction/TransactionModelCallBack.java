package customer.Transaction;

import customer.dto.Customer;

public interface TransactionModelCallBack {
	Customer getCustomerDetailsFromDB(String custID);
	void tranferAmountModel(Customer c1,Customer c2,double amount,long transId);
	void transferAmountModel(Customer c,double amount,long transId);
	void withdrawFromDB(Customer c,double amount,long transId);
	void transferDiffDBModel(Customer c,double amount,long transId,String ifsc,String accNo);
}

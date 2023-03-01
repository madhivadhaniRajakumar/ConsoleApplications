package customer.Transaction;

import customer.createAccount.CreateAccountController;
import customer.dto.Customer;

public class TransactionController implements TransactionControllerCallBack {
	TransactionViewCallBack viewback;
	TransactionModelCallBack modelback;
	public TransactionController(TransactionViewCallBack transactionView) {
		// TODO Auto-generated constructor stub
		viewback = transactionView;
		modelback = new TransactionModel(this);
	}

	public Customer getCustObject(String custID) {
		Customer c = modelback.getCustomerDetailsFromDB(custID);
		return c;
	}
	public void transferAmount(Customer c, double amount) {
		long transId = CreateAccountController.getTransID();
		modelback.transferAmountModel(c, amount, transId);
		return;
		
	}
	public void  transferAmount(Customer c , Customer c1,double amount) {
		long transID = CreateAccountController.getTransID();
		modelback.tranferAmountModel(c1, c, amount,transID);
		return;
	}
	public void withdrawAmount(Customer c, double amount) {
		long trasID = CreateAccountController.getTransID();
		modelback.withdrawFromDB(c, amount, trasID);
		return;
	}
	public void transferDiff(Customer c, double amount,String ifsc,String accNo) {
		long trasID = CreateAccountController.getTransID();
		modelback.transferDiffDBModel(c, amount, trasID, ifsc, accNo);
		return;
	}
}

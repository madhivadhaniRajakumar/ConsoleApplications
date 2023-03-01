package customer.Transaction;



import Repositary.BankingApplicationDB;
import customer.dto.Customer;

public class TransactionModel implements TransactionModelCallBack{
	TransactionControllerCallBack controllerback;
	public TransactionModel(TransactionControllerCallBack transactionController) {
		// TODO Auto-generated constructor stub
		controllerback = transactionController;
	}

	public Customer getCustomerDetailsFromDB(String custID) {
		Customer c = BankingApplicationDB.getInstance().getCustObjectDB(custID);
		return c;
	}
	
	public void tranferAmountModel(Customer c1,Customer c2,double amount,long transId) {
		BankingApplicationDB.getInstance().transferAmount(c1, c2, amount,transId) ;	
		return ;
	}
	public void transferAmountModel(Customer c,double amount,long transId) {
		BankingApplicationDB.getInstance().transferAmount(c, amount, transId);
		return;
	}
	public void withdrawFromDB(Customer c,double amount,long transId) {
		BankingApplicationDB.getInstance().withDrawDB(c, amount, transId);
		return;
	}
	public void transferDiffDBModel(Customer c,double amount,long transId,String ifsc,String accNo) {
		BankingApplicationDB.getInstance().transferDiffDB(c, amount, transId, ifsc, accNo);
		return;
	}
}

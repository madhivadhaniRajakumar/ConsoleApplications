package customer.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import customer.dto.Customer;
import customer.login.LoginView;

public class TransactionView implements TransactionViewCallBack{
	private InputStreamReader i = new InputStreamReader(System.in);
	private BufferedReader br = new BufferedReader(i);
	static LoginView lv = new LoginView();
	TransactionController controller ;
	static TransactionView tv = new TransactionView();
	public TransactionView() {
		// TODO Auto-generated constructor stub
		controller = new TransactionController(this);
	}
	
	public void withdrawfromAccount(Customer c) throws NumberFormatException, IOException, ParseException {
		System.out.println("Enter Amount to withDraw");
		double amount = Double.parseDouble(br.readLine());
		if(c.getBalance()>=amount) {
			controller.withdrawAmount(c, amount);
			System.out.println("Amount WithDrawn Successfully");
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}
	
	public void depositToAccount(Customer c) throws NumberFormatException, IOException, ParseException {
		System.out.println("Enter Amount to Deposit");
		double amount = Double.parseDouble(br.readLine());
		controller.transferAmount(c, amount);
		System.out.println("Amount Deposited Successfully");
		
	}
	
	public void transferWithinBank(Customer c) throws IOException, ParseException {
		System.out.println("Enter the customer ID of the payee");
		String custIDPayee = br.readLine();
		Customer cpayee = controller.getCustObject(custIDPayee);
		if(cpayee==null) {
			System.out.println("Enter Valid CustomerID");
			tv.transferWithinBank(c);
		}
		System.out.println("Enter the amount to transfer customer "+cpayee.getFname());
		double amount = Double.parseDouble(br.readLine());
		if(c.getBalance()<amount) {
			System.out.println("Insufficient Balance");
		}
		else {
			controller.transferAmount(c,cpayee, amount);

			System.out.println("Amount successfully transfered ");
		}
		
	}
	public void transferDifferntBank(Customer c) throws NumberFormatException, IOException, ParseException {
		System.out.println("Enter Amount to transfer");
		double amount = Double.parseDouble(br.readLine());
		System.out.println("Enter IFSC code of the payee");
		String ifsc = br.readLine();
		System.out.println("Enter Account number");
		String accNo = br.readLine();
		if(c.getBalance()<amount) {
			System.out.println("Insufficient Balance");
		}
		else {
		controller.transferDiff(c, amount, ifsc, accNo);
		System.out.println("Amount Successfully Transfered");
		}
	}
	
}

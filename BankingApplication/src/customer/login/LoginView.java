package customer.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import customer.Transaction.TransactionView;
import customer.dto.Customer;
import mainPage.mainPageView;

public class LoginView implements LoginViewCallBack{

	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	LoginController controller;
	static LoginView lv = new LoginView();
	static TransactionView tv = new TransactionView();
	public void login() throws IOException, ParseException {
		
		lv.displayLogin();
	}
	public LoginView() {
		controller = new LoginController(this);
		
	}
	public void displayLogin() throws IOException, ParseException {
		System.out.println("Enter Customer ID");
		String custID = br.readLine();
		System.out.println("Enter thr Password");
		String password =controller.encryptPassword(br.readLine());
		controller.getCustomerObject(custID, password);
		
	}
	public void success(Customer c) throws ParseException {
		System.out.println("Welcome "+ c.getFname()+" "+c.getLname());	
		lv.displayLoginMenu(c);
	}
	public void displayLoginMenu(Customer c) throws ParseException {
		System.out.println("Press 1 for View Profile");
		System.out.println("Press 2 for Transfer money within same bank");
		System.out.println("Press 3 to Tranfer money to different bank");
		System.out.println("Press 4 to Withdraw money");
		System.out.println("Press 5 to Deposit money ");
		System.out.println("Press 6 to View Statement");
		System.out.println("Press 7 to Apply Loan");
		System.out.println("Press 8 to Log-out");
		try {
			int choice = Integer.parseInt(br.readLine());
			lv.choiceOperation(choice, c);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void choiceOperation(int choice, Customer c) throws IOException, ParseException {
		if(choice==1) {
			System.out.println("******PROFILE*********");
			System.out.println("custID :"+c.getCustID());
			System.out.println("Name  :"+ c.getFname() +" "+ c.getLname());
			System.out.println("IFSC  :"+c.getIfsc());
			System.out.println("Branch Name  :"+c.getBranchName().toUpperCase());
			System.out.println("Available Balance :"+c.getBalance());
			System.out.println();
			System.out.println("**************************************");
			lv.displayLoginMenu(c);
			
		}
		if(choice==2) {
			
			tv.transferWithinBank(c);
			lv.displayLoginMenu(c);
		}
		if(choice==3) {
			tv.transferDifferntBank(c);
			lv.displayLoginMenu(c);
		}
		if(choice==4) {
			tv.withdrawfromAccount(c);
			lv.displayLoginMenu(c);
		}
		if(choice==5) {
			tv.depositToAccount(c);
			lv.displayLoginMenu(c);
		}
		if(choice==6) {
			List<String> ls = new ArrayList<>();
			ls = c.getPassbook();
			for(int i=0;i<ls.size();i++) {
				System.out.println(ls.get(i));
			}
			System.out.println("*******"+c.getBalance()+"*****");
			lv.displayLoginMenu(c);
		}
		if(choice==7) {
			System.out.println("Yet to Develop");
			lv.displayLoginMenu(c);
		}
		if(choice==8) {
			mainPageView mp = new mainPageView();
			mp.mainDisplay();
		}
	}
	
	public void fail() throws IOException, ParseException {
		System.out.println("Login Failed");
		lv.displayLogin();
	}
}

package Repositary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import customer.dto.Customer;
import customer.dto.Transaction;
import manager.dto.Branch;

public class BankingApplicationDB {

	private static BankingApplicationDB  bankingApplicationDB;
	private  static List<Branch> branch = new ArrayList<>();
	private static List<Customer> customer = new ArrayList<>();
	private  List<Transaction> transaction  = new ArrayList<>();
	
	public static BankingApplicationDB getInstance() {
		if(bankingApplicationDB==null) {
			branch.add(new Branch("rspuram","CRBRS234","Ramesh",434));
			branch.add(new Branch("nehrunagar","CRBNE235","Manoj",134));
			branch.add(new Branch("gandhipuram","CRBGA236","Pramila",594));
			branch.add(new Branch("kknagar","CRBKK237","Dinesh",294));
			customer.add(new Customer("RS234", "Madhivadhani", "Rajakumar", "3272 LIG II", "rspuram",7654312334L, "CRBRS234", LocalDate.parse("1995-07-02"), 27, "9566557550", "madhi@gmail.com", 1000000L, 10000, (new Transaction(LocalDate.parse("2023-01-02"), "Opening Account Balance ",10000.0,5000L)).toString(), "benjo"));
			customer.add(new Customer("RS222", "Sangavi", "R", "3272 LIG II", "rspuram",7654334L, "CRBRS234", LocalDate.parse("2000-01-13"), 23, "76394343043", "sangavi@gmail.com", 1000000L, 10000, (new Transaction(LocalDate.parse("2020-05-01"), "Opening Account Balance ",10000.0,6000L)).toString(), "benjo"));

			bankingApplicationDB = new BankingApplicationDB();
		}
		return bankingApplicationDB;	
	}
	
	public boolean checkValidUser(String name,String password) {
		if(name.equals("admin")&& password.equals("benjo")) {
			return true;
		}
		return false;
	}
	public boolean addBranchDetails(String branchName,String ifsc,String managername,int noOfCustomers) {
		if(branch.add(new Branch( branchName,ifsc,managername,noOfCustomers))) {
			return true;
		}
		return false;
	}
	public String getIFSCNo(String branchName) {
		Branch b;
		for(int i=0;i<branch.size();i++) {
			b= branch.get(i);
			if(b.getBranchName().equals(branchName.toLowerCase())) {
				return b.getIfsc();
			}
		}
		return "";
	}
	public List<Branch> getBranchID(){
		return branch;
	}
	public boolean createAccount(String fname,String lname,String address,String branchName,String ifsc,long adNo,LocalDate dob,int age,long salary,String mobile, String email,String pass,double balance,long ID,String custID) {
		Transaction t = new Transaction(LocalDate.now(), "Opening Account Balance",balance ,ID );
		if(customer.add(new Customer(custID, fname, lname, address, branchName, adNo, ifsc, dob, age, mobile, email, salary, balance, t.toString(), pass))){

			return true;
		}
		
		return false;
	}
	
	public Customer getCustObjectDB(String custId) {
		Customer c ;
		for(int i=0;i<customer.size();i++) {
			c=customer.get(i);
			if(c.getCustID().equals(custId) ) {
				return c;
			}
		}
		return null;
	}
	
	public Customer checkCustIDDB(String name,String password) {
		Customer c ;
		for(int i=0;i<customer.size();i++) {
			c=customer.get(i);
			if(c.getCustID().equals(name) && c.getPassword().equals(password)) {
				return c;
			}
		}
		return null;
	}
	
	
	public void transferAmount(Customer c1,Customer c2,double amount,long transId) {
		double c1Amount = c1.getBalance() -amount;
		double c2Amount = c2.getBalance() +amount;
		c1.setBalance(c1Amount);
		c2.setBalance(c2Amount);
		Transaction t1 = new Transaction(LocalDate.now(), "Amount transfer to "+c2.getCustID(), amount, transId);
		Transaction t2 = new Transaction(LocalDate.now(), "Amount Received from "+c1.getCustID(), amount, transId);
		c1.setPassbook(t2.toString());
		c2.setPassbook(t1.toString());
		return;
	}
	public void transferAmount(Customer c,double amount,long transId) {
		double cAmount = c.getBalance()+ amount;
		c.setBalance(cAmount);
		Transaction t = new Transaction(LocalDate.now(),"Amount Deposited", cAmount, transId);
		c.setPassbook(t.toString());
		return;
	}
	public void withDrawDB(Customer c,double amount,long transId) {
		double cAmount = c.getBalance()-amount;
		c.setBalance(cAmount);
		Transaction t = new Transaction(LocalDate.now(),"Amount WithDrawn", cAmount, transId);
		c.setPassbook(t.toString());
		return;
	}
	public void transferDiffDB(Customer c,double amount,long transId,String ifsc,String accno) {
		double cAmount = c.getBalance()- amount;
		c.setBalance(cAmount);
		System.out.println(c.getBalance());
		Transaction t = new Transaction(LocalDate.now(),"Amount Transfered to IFSC: "+ifsc+" Account: "+accno, amount, transId);
		c.setPassbook(t.toString());
		return;
	}
}

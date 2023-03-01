package customer.createAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import customer.login.LoginView;
import manager.dto.Branch;



public class CreateAccountView implements CreateAccountViewCallBack {
	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	static CreateAccountView av= new CreateAccountView();
	CreateAccountController controller;
	Exception e;
	public CreateAccountView() {
		// TODO Auto-generated constructor stub
		controller = new CreateAccountController(this);
	}
//	public static void main(String[] args) throws IOException, ParseException {
//		av = new CreateAccountView();
//		av.initialsetUp();
//	}
	
	public void initialsetUp() throws IOException, ParseException   {
		System.out.println("Welcome to CRB pvt limt.");
		System.out.println("Enter customer First Name");
		String fname = null;
		try {
			fname = br.readLine();
		} catch (IOException e) {
			System.out.println("Enter valid name");
			av.initialsetUp();
		}
		System.out.println("Enter customer Last Name");
		String lname = null;
		try {
			lname = br.readLine();
		} catch (IOException e) {
			System.out.println("Enter Valid name");
			av.initialsetUp();
		}
		System.out.println("Enter Address");
		String address = null;
		try {
			address = br.readLine();
		} catch (IOException e) {
			System.out.println("Enter Valid Address");
			av.initialsetUp();
		}
		List<Branch> ls = new ArrayList<>();
		List<String> b = new ArrayList<>();
		ls = controller.get_branchDetails();
		for(int i=0;i<ls.size();i++) {
			b.add(ls.get(i).getBranchName());
			System.out.println(ls.get(i).getBranchName());
		}
		controller.get_branchDetails();
		System.out.println("Select customer's nearby branch");
		String branch=null;
		try {
			branch = br.readLine();
		   if(!b.contains(branch))
			   throw e;
		
		} catch (Exception e) {
			System.out.println("Enter valid branch");
			av.initialsetUp();
		}
		String ifsc= controller.getIFSCCode(branch);
		System.out.println("Enter customer AadharNumber");
		long adarno = 0;
		try {
			adarno = Long.parseLong(br.readLine());
			String a = String.valueOf(adarno);
			if(!a.matches("^[0-9]{12}$")) {
				throw e;
			}
		} catch (Exception e) {
			System.out.println("Enter valid AdarNumber");
			av.initialsetUp();
		} 
		System.out.print("Enter your DOB in YYYY-MM-DD format: ");
		LocalDate dob = null;
		try {
			dob = LocalDate.parse(br.readLine());
			if(Period.between(dob, LocalDate.now()).getYears()<=0) {
				throw e;
			}
		} catch (Exception e) {
			System.out.println("Enter valid date");
			av.initialsetUp();
		}
		//Calculates Age based on the given DOB
		int age = Period.between(dob, LocalDate.now()).getYears();
		if(age<18) {
		//av.minorAccountSetUp(fname, lname, branch, adarno, dob);
		}
		else {
			System.out.println("Anual Income of the customer");
			long salary = 0;
			try {
				salary = Long.parseLong(br.readLine());
			} catch (Exception e) {
				System.out.println("Enter Valid salary");
			} 
			System.out.println("Enter Mobile Number");
			String mobile="";
			try {
				mobile = br.readLine();
				if(!mobile.matches("^[0-9]{10}$")) {
					throw e;
				}
			} catch (Exception e) {
				System.out.println("Enter valid mobile");
				av.initialsetUp();
			}
			System.out.println("Enter email Address");
			String email="";
			try {
				email=br.readLine();
				if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
					throw e;
			}
			catch (Exception e) {
				System.out.println("Enter valid email");
				av.initialsetUp();
			}		
			System.out.println("Enter Password");
			String password = controller.encryptPassword(br.readLine());
			System.out.println("Enter opening Balance");
			double balance = Double.parseDouble(br.readLine());
			controller.setUpAccountControl(fname, lname, address, branch, ifsc, adarno, dob, age, salary, mobile, email, password, balance);
		
		}
		
		
	}
	public void minorAccountSetUp(String fname,String lname,String branch,long adarno,LocalDate dob) throws IOException {
		System.out.println("*****Minor Account Creation*******");
		System.out.println("Enter Parent's Details");
		
		System.out.println("Enter Parent/Guardian Name");
		String gName = br.readLine();
		System.out.println("Enter Parent/Guardian AadharNumber");
		long gaNumber = Long.parseLong(br.readLine());
		System.out.println("Enter Parent/Guardian MobileNumber");
		long mobile = Long.parseLong(br.readLine());
		System.out.println("Enter email Address");
		String email=br.readLine();
		System.out.println("Enter Password");
		String password = br.readLine();
		
		
	}
	public void accountSuccess(String message) throws IOException, ParseException {
		System.out.println("Your Account successfully created");
		System.out.println(message);
		System.out.println("Thank you");
		
		LoginView lv = new LoginView();
		lv.displayLogin();
	}
	public void fail() {
		System.out.println("Account creation Failed");
	}
}

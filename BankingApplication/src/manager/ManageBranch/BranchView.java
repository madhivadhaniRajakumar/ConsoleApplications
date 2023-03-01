package manager.ManageBranch;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import mainPage.mainPageView;

public class BranchView implements BranchViewCallBack{
	Scanner sc = new Scanner(System.in);
	BranchController control;
	BranchView bv = new BranchView();
	public BranchView() {
		// TODO Auto-generated constructor stub
		control = new BranchController(this);
	}
	public void option() throws Exception {
		
		System.out.println("********Welcome Admin***********");
		System.out.println("Press 1 to view Branch Details");
		System.out.println("Press 2 to add Branch Details");
		System.out.println("Press 3 to Go Back");
		int option = sc.nextInt();
		if(option==1) {
			bv.displayBranch();
			bv.option();
		}
		if(option==2) {
			bv.addBranch();
		}
		if(option==3) {+
			mainPageView mv = new mainPageView();
			mv.mainDisplay();
		}
	}
	public void displayBranch() {
		System.out.println("Yet to develop");
	}
	public void addBranch() throws Exception {
		System.out.println("Enter Branch Details");
		String branchName = sc.nextLine();
		System.out.println("Enter the pinCode");
		int pincode = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Current Branch Manager name");
		String managerName = sc.nextLine();
		System.out.println("Enter number of current customers");
		int noOfCustomer = sc.nextInt();
		sc.nextLine();
		control.generateIFSCCode(branchName, pincode,managerName,noOfCustomer);
	}
	
	public void success(String ifsc ) throws Exception {
		System.out.println("New Branch Added IFSC Code : "+ifsc);
		bv.option();
		
	}
	public void fail() throws Exception {
		System.out.println("Unable to create new Branch");
		bv.option();
	}
}

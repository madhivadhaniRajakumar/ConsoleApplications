package customer.createAccount;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Repositary.BankingApplicationDB;
import manager.dto.Branch;

public class CreateAccountModel implements CreateAccountModelCallBack {
	CreateAccountControllerCallBack controllerback;

	public CreateAccountModel(CreateAccountControllerCallBack createAccountController) {
		// TODO Auto-generated constructor stub
		controllerback = createAccountController;
	}

	public String getIFSC(String branchName) {
		String ifsc = BankingApplicationDB.getInstance().getIFSCNo(branchName);
		return ifsc;
	}
	public List<Branch> getBranchDetails(){
		List<Branch> br = new ArrayList<>();
		br= BankingApplicationDB.getInstance().getBranchID();
		return br;
	}
	public void setUpAccountDB(String fname,String lname,String address,String branchName,String ifsc,long adNo,LocalDate dob,int age,long salary,String mobile, String email,String pass,double balance,long tansId,String custID ) throws IOException, ParseException {
		if(BankingApplicationDB.getInstance().createAccount(fname, lname, address, branchName, ifsc, adNo, dob, age, salary, mobile, email, pass, balance, tansId, custID)) {
			controllerback.accountCreated(ifsc, custID);
		}
		else {
			controllerback.failController();
		}
	}
}

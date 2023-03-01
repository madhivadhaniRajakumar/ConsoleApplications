package customer.createAccount;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import manager.dto.Branch;

public interface CreateAccountModelCallBack {
	public List<Branch> getBranchDetails();
	public String getIFSC(String branchName);
	void setUpAccountDB(String fname,String lname,String address,String branchName,String ifsc,long adNo,LocalDate dob,int age,long salary,String mobile, String email,String pass,double balance,long tansId,String custID ) throws IOException, ParseException;
}

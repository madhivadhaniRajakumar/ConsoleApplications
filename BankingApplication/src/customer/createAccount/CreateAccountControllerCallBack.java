package customer.createAccount;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import manager.dto.Branch;

public interface CreateAccountControllerCallBack {
	public List<Branch> get_branchDetails();
	public String generateCustomerID(long adno,String branch);
	String getIFSCCode(String branch);
	String encryptPassword(String password);
	void setUpAccountControl(String fname,String lname,String address,
			String branchName,String ifsc,long adNo,LocalDate dob,
			int age,long salary,String mobile, String email,String pass,double balance ) throws IOException, ParseException;
	void accountCreated(String ifsc , String custID) throws IOException, ParseException;
	
	void failController();
	
}

package customer.createAccount;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import manager.dto.Branch;

public class CreateAccountController implements CreateAccountControllerCallBack {
	CreateAccountModelCallBack modelback;
	CreateAccountViewCallBack viewback;
	private static long transId =1000000;
	public CreateAccountController(CreateAccountViewCallBack createAccountView) {
		// TODO Auto-generated constructor stub
		viewback = createAccountView;
		modelback = new CreateAccountModel(this);
	}
    public String getIFSCCode(String branch) {
    	String ifsc=modelback.getIFSC(branch);
    	return ifsc;
    }
	public String generateCustomerID(long adno,String ifsc) {
		String custID ="";
		custID+= (char)ifsc.charAt(3);
		custID+= (char)ifsc.charAt(4);
		custID+= adno%1000;
		System.out.println(custID);
		return custID;
	}
	public String encryptPassword(String password) {
		 char[] ch = password.toCharArray();
		 String pass= "";
		 for(int i=0;i<ch.length;i++) {
			char a= (char) (ch[i]+1);
			 pass += a;
		 }
		return pass;
	}
	public List<Branch> get_branchDetails() {
		List<Branch> br = new ArrayList<>();
		br = modelback.getBranchDetails();
		return br;
	}
	public static long getTransID() {
		transId = transId+1;
		return transId;
	}
	
	public void setUpAccountControl(String fname,String lname,String address,String branchName,String ifsc,long adNo,LocalDate dob,int age,long salary,String mobile, String email,String pass,double balance ) throws IOException, ParseException {
		transId =CreateAccountController.getTransID();
		String custID = generateCustomerID(adNo, ifsc);
		modelback.setUpAccountDB(fname, lname, address, branchName, ifsc, adNo, dob, age, salary, mobile, email, pass, balance, transId, custID);
	}
	public void accountCreated(String ifsc , String custID) throws IOException, ParseException {
		String message="";
		
			message += "IFSC Number :"+ ifsc +"  Customer ID : "+ custID ;
		
		viewback.accountSuccess(message);
	}
	public void failController() {
		viewback.fail();
	}
	
}

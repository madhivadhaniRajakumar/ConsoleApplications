package manager.ManageBranch;

import java.io.IOException;
import java.text.ParseException;

public class BranchController implements BranchControllerCallBack {
	BranchViewCallBack viewback;
	BranchModelCallBack modelback;
	public BranchController(BranchViewCallBack branchView) {
		// TODO Auto-generated constructor stub
		viewback = branchView;
		modelback= new BranchModel(this);
	}

	public void generateIFSCCode(String branchName,int pincode,String managerName,int noOfCustomers) throws Exception {
		String ifsc = "CRB";
		int val=0,i=0;
		while(val<2) {
			char ch = branchName.toUpperCase().charAt(i);
			if(ch>='A'&&ch<='Z') {
				ifsc += ch;
				val++;
			}
			i++;
		}
		
		ifsc += pincode%1000;	
		if(modelback.addBranch(branchName, ifsc, pincode,managerName,noOfCustomers)) {
			viewback.success(ifsc);
		}
		else {
			viewback.fail();
		}
	}

}

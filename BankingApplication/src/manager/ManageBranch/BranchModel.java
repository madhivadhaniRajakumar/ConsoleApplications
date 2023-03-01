package manager.ManageBranch;

import Repositary.BankingApplicationDB;

public class BranchModel implements BranchModelCallBack{
	BranchControllerCallBack controlback;
	public BranchModel(BranchControllerCallBack branchController) {
		// TODO Auto-generated constructor stub
		controlback = branchController;
	}

	@Override
	public boolean addBranch(String branchName, String ifsc, int pincode,String managerName,int noOfCustomers) {
		if(BankingApplicationDB.getInstance().addBranchDetails(branchName, ifsc,managerName,noOfCustomers)) {
			return true;
		}
		return false;
	}

}

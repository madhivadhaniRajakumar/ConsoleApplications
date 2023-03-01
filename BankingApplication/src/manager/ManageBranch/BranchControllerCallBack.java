package manager.ManageBranch;

import java.io.IOException;
import java.text.ParseException;

public interface BranchControllerCallBack {
	void generateIFSCCode(String branchName,int pincode,String managerName,int noOfCustomers) throws IOException, ParseException, Exception;
}

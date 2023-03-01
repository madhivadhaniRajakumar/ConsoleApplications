package manager.ManageBranch;

import java.io.IOException;
import java.text.ParseException;

public interface BranchViewCallBack {
	 void addBranch() throws Exception;
	 void success(String ifsc ) throws IOException, ParseException, Exception;
	 void fail() throws Exception;
	 void displayBranch();
}

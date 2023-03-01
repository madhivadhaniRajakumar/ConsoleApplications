package manager.dto;

public class Branch {

	private String branchName;
	private String ifsc;
	private String branchManager;
	private int numberOfCurrentCustomer;
	
	
	public Branch(String branchName, String ifsc, String branchManager, int numberOfCurrentCustomer) {
		super();
		this.branchName = branchName;
		this.ifsc = ifsc;
		this.branchManager = branchManager;
		this.numberOfCurrentCustomer = numberOfCurrentCustomer;
	}

	public int getNumberOfCurrentCustomer() {
		return numberOfCurrentCustomer;
	}

	public void setNumberOfCurrentCustomer(int numberOfCurrentCustomer) {
		this.numberOfCurrentCustomer = numberOfCurrentCustomer;
	}

	public String getBranchManager() {
		return branchManager;
	}

	public void setBranchManager(String branchManager) {
		this.branchManager = branchManager;
	}

	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	@Override
	public String toString() {
		return "Branch [branchName=" + branchName + ", ifsc=" + ifsc + ", branchManager=" + branchManager
				+ ", numberOfCurrentCustomer=" + numberOfCurrentCustomer + "]";
	}

	
	
	
	
}

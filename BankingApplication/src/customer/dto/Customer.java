 package customer.dto;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Customer {
	private String custID;
	private String fname;
	private String lname;
	private String address;
	private String branchName;
	private long aadharNo;
	private String ifsc;
	private LocalDate dob;
	private int age;
	private String mobile;
	private String email;
	private long salary;
	private double balance;
	private List<String> passbook = new LinkedList<>();
	private String password;
	public Customer(String custID, String fname, String lname, String address, String branchName, long aadharNo,
			String ifsc, LocalDate dob, int age, String mobile, String email, long salary, double balance,
			String t, String password) {
		super();
		this.custID = custID;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.branchName = branchName;
		this.aadharNo = aadharNo;
		this.ifsc = ifsc;
		this.dob = dob;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.salary = salary;
		this.balance = balance;
		this.passbook.add(t);
		this.password = password;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<String> getPassbook() {
		return passbook;
	}
	public void setPassbook(String t) {
		this.passbook.add(t);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", branchName=" + branchName + ", aadharNo=" + aadharNo + ", ifsc=" + ifsc + ", dob=" + dob + ", age="
				+ age + ", mobile=" + mobile + ", email=" + email + ", salary=" + salary + ", balance=" + balance
				+ ", passbook= \n" + passbook + "\n, password=" + password + "]";
	}
	
	
}

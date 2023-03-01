package manager.AdminLogin;

import java.util.Scanner;

import manager.ManageBranch.BranchView;

public class AdminLoginView implements AdminLoginViewCallBack{
	Scanner sc = new Scanner(System.in);
	AdminLoginController adminLoginController;
	
	public AdminLoginView() {
		// TODO Auto-generated constructor stub
		adminLoginController = new AdminLoginController(this);
	}
	
//	public static void main(String[] args) {
//		AdminLoginView av = new AdminLoginView();
//		av.displayLogin();
//	}
	public void displayLogin() {
		System.out.println("Enter the Admin User Name");
		String name = sc.next();
		System.out.println("Enter thr Password");
		String password = sc.next();
		//Password Encryption
		adminLoginController.encodeCredentials(name, password);
	}
	public void success() {
		BranchView bv = new BranchView();
		try {
			bv.option();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void fail() {
		System.out.println("Login Failed");
	}

}

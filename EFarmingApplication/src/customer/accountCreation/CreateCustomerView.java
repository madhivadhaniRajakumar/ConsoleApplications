package customer.accountCreation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import farmer.createFarmer.CreateFarmerView;
import farmer.farmersAccess.FarmerAccessView;

public class CreateCustomerView implements CreateCustomerViewCallBack {
	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	Exception e;
	static CreateCustomerView cv = new CreateCustomerView();
	CreateCustomerController controller;
	public CreateCustomerView() {
		controller = new CreateCustomerController(this);
	}
	public static void main(String[] args) {
		cv.menu();
	}
	public void menu() {
		System.out.println("1.Farmer");
		System.out.println("2.Customer");
		try {
			int choice = Integer.parseInt(br.readLine());
			if(choice==1) {
				FarmerAccessView av = new FarmerAccessView();
				av.mainMenu();
			}
			if(choice==2) {
			
				cv.cMenu();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	public void cMenu() {
		System.out.println("1.Create Account");
		System.out.println("2.Login");
		try {
			int ch = Integer.parseInt(br.readLine());
			if(ch==1) {
				cv.customerDisplayMenu();
			}
			if(ch==2) {
				cv.loginMenu();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}
	public void customerDisplayMenu() {
		System.out.println("*******Create Customer Account*******");
		try {
			System.out.println("Enter Customer Name");
			String name = br.readLine();
			System.out.println("Enter Customer Address");
			String address = br.readLine();
			System.out.println("Enter Customer Phone number");
			String mobile = br.readLine();
			System.out.println("Enter Customer ID");
			String custID = br.readLine();
			System.out.println("Enter Password");
			String password = br.readLine();
			if(controller.createAccountControl(custID, name, address, mobile, password))
			{
				cv.loginMenu();
			}
			else {
				System.out.println("Cannot add Customer");
				cv.customerDisplayMenu();
			}
		}
		catch(Exception e) {
			
		}
	}
	public void loginMenu() {
		System.out.println("Login");
	}
}

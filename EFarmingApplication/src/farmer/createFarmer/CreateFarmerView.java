package farmer.createFarmer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import customer.purchaseProduct.PurchaseView;
import farmer.farmersAccess.FarmerAccessView;

public class CreateFarmerView implements CreateFarmerViewCallBack{

	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	CreateFarmerController controller;
	static CreateFarmerView fv = new CreateFarmerView();
	public CreateFarmerView() {
		controller = new CreateFarmerController(this);
	}
	public  void travel() {
		
		fv.displayMenu();
	}
	
	public void displayMenu() {
		System.out.println("****FARMER'S APPLICATION FORM****");
		System.out.println("ENTER FARMER'S NAME");
		String farmername = null;
		try {
			 farmername = br.readLine();
		} catch (IOException e) {
			System.out.println("Enter valid name");
		}
		System.out.println("Enter mobile number");
		String mobile =null;
		try {
			mobile=br.readLine();
		}
		catch(Exception e) {
			System.out.println("Enter valid mobile number");
		}
		System.out.println("Enter password");
		String password=null;
		try {
			password = controller.encryptPassword(br.readLine());
		}
		catch(Exception e) {
			System.out.println("Enter valid password");
		}
		boolean isAdded=controller.addFarmer(farmername, mobile, password);
		if(isAdded) {
			System.out.println("Added Successfully");
		}
		else {
			System.out.println("Failed to add");
		}
	}
}

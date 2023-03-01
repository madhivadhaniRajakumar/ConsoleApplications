package farmer.farmersAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import farmer.createFarmer.CreateFarmerView;

public class FarmerAccessView implements FarmerAccessViewCallBack {

	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	static FarmerAccessView av = new FarmerAccessView();
	FarmerAccessController accessController;
	Exception e;

	public FarmerAccessView() {
		accessController = new FarmerAccessController(this);
	}

	
	public void mainMenu() {
		System.out.println("******WELCOME TO FARMER'S PORTAL*******");
		System.out.println("Press 1 to sign up ");
		System.out.println("Press 2 to login-in");
		int option = 0;
		try {
			option = Integer.parseInt(br.readLine());
			if (option != 1 && option != 2) {
				throw e;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (option == 1) {
			CreateFarmerView cv = new CreateFarmerView();
			cv.travel();
			av.mainMenu();
		}
		if (option == 2) {
			try {
				System.out.println("Enter Farmer ID");
				String fid = br.readLine();
				System.out.println("Enter password");
				String password = accessController.encryptPassword(br.readLine());
				if (accessController.getIDandPassword(fid, password)) {
					av.addProducts();
				} else {
					System.out.println("Invalid User");
					av.mainMenu();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addProducts() {
		System.out.println("********ADD PRODUCTS*******");

		try {
			System.out.println("Enter Product Name");
			String productName = br.readLine().toUpperCase();
			System.out.println("Enter the Quantity available");
			double quantity = Double.parseDouble(br.readLine());
			System.out.println("Enter the Product Price");
			double price = Double.parseDouble(br.readLine());
			if (accessController.getProductName(productName)) {
				if (av.updateAvailableProductView(productName, quantity, price)) {
					System.out.println("Updated successfully");
					System.out.println("Do you want to add more products Y/N");
					char choice = br.readLine().toLowerCase().charAt(0);
					if (choice == 'y') {
						av.addProducts();
					} else {
						av.mainMenu();
					}
				} 
			} else {
				if (av.addNewProductView(productName, quantity, price)) {
					System.out.println("Do you want to add more products Y/N");
					char choice = br.readLine().toLowerCase().charAt(0);
					if (choice == 'y') {
						av.addProducts();
					} else {
						av.mainMenu();
					}
				} else {
					System.out.println("Addition failed");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean updateAvailableProductView(String productName, double quantity, double price) {
		if (accessController.updateAvailableProductControl(productName, quantity, price)) {
			return true;
		}
		return false;
	}

	public boolean addNewProductView(String productName, double quantity, double price) {
		if (accessController.addNewProductControl(productName, quantity, price)) {
			return true;
		}
		return false;
	}
}

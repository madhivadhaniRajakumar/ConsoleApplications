package customer.purchaseProduct;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseView implements PurchaseViewCallBack {
	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	Exception e;
	static PurchaseView pv = new PurchaseView();
	PurchaseController controller;
	
	public PurchaseView() {
		// TODO Auto-generated constructor stub
		controller = new PurchaseController(this);
	}
	
	public void customerLogin() {
		try {
			System.out.println("Enter UserID");
			String userID = br.readLine();
			System.out.println("Enter password");
			String password = br.readLine();
			if(controller.checkUser(userID, password)) {
				pv.purchaseMenu(userID);
			}
			else {
				System.out.println("Login Failed");
				pv.customerLogin();
			}
		}
		catch(Exception e) {
			
		}
	}
	public void purchaseMenu(String userID) {
		System.out.println("Product Menu");
		ResultSet set = controller.getProductMenu();
		
		try {
				System.out.printf("%-15s%-15s%-20s%-15s%n","ProductID","ProductName","Available Quantity","ProductPrice");
				System.out.println("*******************************************************************");
				while(set.next()) {
					System.out.printf("%-15s%-15s%-20s%-15s%n",set.getString("prodId"),set.getString("prodName"),set.getDouble("quantity"),set.getDouble("price"));
			}
			pv.purchaseProduct(userID);
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void purchaseProduct(String userID) {
		try {
			ResultSet set = controller.getProductMenu();
			System.out.println("Enter ProductID");
			String prodID = br.readLine();
			System.out.println("Enter Quantity");
			double quantity = Double.parseDouble(br.readLine());
			String prodName=null;
			double price =0;
			double initialquantity=0;
			boolean canProceed = false;
			while(set.next()) {
				if(set.getString("prodId").equals(prodID)) {
					
					initialquantity=set.getDouble("quantity");
					System.out.println(initialquantity);
					if(initialquantity<quantity) {
						System.out.println("Quantity not available currently");
					}
					else {
						prodName = set.getString("prodName");
						price = set.getDouble("price");
						canProceed=true;
					}
					break;
				}
			}
			if(canProceed) {
				double amount = price*quantity;
				if(controller.addProducttoCart(userID, prodID, prodName, quantity, amount,initialquantity)) {
					System.out.println("Do you want to continue adding");
					char c = br.readLine().toLowerCase().charAt(0);
					if(c=='y') {
						pv.purchaseProduct(userID);
					}
					else {
						pv.viewOrderDetails(userID);
					}
				}
				else {
					System.out.println("Failed to add Products");
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	public void viewOrderDetails(String userId) {
		ResultSet set1 = controller.orderDetailsControl(userId);
		
		System.out.printf("%-15s%-15s%-20s%-15s%n","ProductID","ProductName","Quantity","Amount");
		try {
			while(set1.next()) {
				System.out.printf("%-15s%-15s%-20s%-15s%n",set1.getString("prodId"),set1.getString("prodName"),set1.getDouble("quantity"),set1.getDouble("amount"));
			}
			System.out.println("Thank you");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

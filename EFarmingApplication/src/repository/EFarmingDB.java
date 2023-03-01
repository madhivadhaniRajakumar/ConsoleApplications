package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;



public class EFarmingDB {
	public static EFarmingDB efarming;
	private  Connection connection;
	private EFarmingDB() {
		connection = new ConnectionManagerImpl().getConnection();
	}
	public static EFarmingDB getInstance() {
		if(efarming==null) {
			efarming = new EFarmingDB();
		}
		return efarming;
	}
	public boolean addFarmer(String farmerID,String farmername,String mobile,String password) {
		boolean isFarmerAdded = false;
		String query = "insert into farmer values(?,?,?,?)";
		 PreparedStatement statement ;
		 try {
			statement = connection.prepareStatement(query);
			statement.setString(1,farmerID);
			statement.setString(2, farmername);
			statement.setString(3, mobile);
			statement.setString(4, password);
			int val = statement.executeUpdate();
			if(val>0) {
				isFarmerAdded = true;
			}
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		return isFarmerAdded;
	}
	public boolean getFarmerCredential(String fid,String password) {
		boolean isFarmerAvailable=false;
		String query = "select * from farmer where farmerId= ? and password = ?";
		PreparedStatement statement ;
		 try {
			statement = connection.prepareStatement(query);
			statement.setString(1,fid);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				isFarmerAvailable=true;
			}
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		return isFarmerAvailable;
	}
	
	public boolean getProductNameDB(String prodname) {
		boolean isProdAvailable = false;
		String query = "select * from product where prodName=?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, prodname);
			ResultSet set = statement.executeQuery();
			if(set.next()) {
				isProdAvailable = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isProdAvailable;
	}
	public int getIdCount() {
		int count=0;
		String query = "SELECT COUNT(farmerId) FROM farmer";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			count =statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public boolean updateProductDB(String prodname,double quantity,double price) {
		boolean isProductUpdated = false;
		String query = "update product set quantity=? , price =? where prodName=?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setDouble(1, quantity);
			statement.setDouble(2, price);
			statement.setString(3, prodname);
			int val = statement.executeUpdate();
			if(val>0) {
				isProductUpdated=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isProductUpdated;
	
	}

	public boolean addNewProductDB(String prodname,double quantity,double price) {
		boolean isProductAdded = false;
		String query = "insert into product values(?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, prodname.toLowerCase());
			statement.setString(2, prodname);
			statement.setDouble(3, quantity);
			statement.setDouble(4, price);
			int val = statement.executeUpdate();
			if(val>0) {
				
				isProductAdded = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isProductAdded;
	}
	
	public boolean addNewCustomer(String custID, String custName,String address,String mobile,String password) {
		boolean isCustomerAdded=false;
		String query = "insert into customer values(?,?,?,?,?)";
		 PreparedStatement statement ;
		 try {
			statement = connection.prepareStatement(query);
			statement.setString(1,custID);
			statement.setString(2, custName);
			statement.setString(3, address);
			statement.setString(4, mobile);
			statement.setString(5, password);
			int val = statement.executeUpdate();
			if(val>0) {
				isCustomerAdded = true;
			}
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		return isCustomerAdded;
	}
	public boolean getUserLoginDetails(String uId,String password) {
		boolean isUserAvailable = false;
		String query = "select * from customer where custId= ? and password = ?";
		PreparedStatement statement ;
		 try {
			statement = connection.prepareStatement(query);
			statement.setString(1,uId);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				isUserAvailable=true;
			}
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		return isUserAvailable;
		
	}
	public ResultSet getProducts() {
		ResultSet set = null;
		String query = "select * from product";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			set = statement.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
	public boolean addProductDB(String uID,String prodID,String prodName,double quantity,double amount,double initialquantity) {
		boolean isProductAdded = false;
		String query = "insert into orders values(?,?,?,?,?,?)";
		 PreparedStatement statement ,statement1;
		 try {
			statement = connection.prepareStatement(query);
			statement.setDate(1,Date.valueOf(LocalDate.now()));
			statement.setString(2,uID);
			statement.setString(3, prodID);
			statement.setString(4, prodName);
			statement.setDouble(5, quantity);
			statement.setDouble(6, amount);
			
			int val = statement.executeUpdate();
		
			if(val>0) {
				
				String query1 = "update product set quantity=? where prodId=?";
				statement1 = connection.prepareStatement(query1);
				double q = initialquantity-quantity;
				statement1.setDouble(1,q);
				statement1.setString(2, prodID);
				val =statement1.executeUpdate();
				
				if(val>0) {
					isProductAdded = true;
				}
			}
		 }
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		return isProductAdded;
	}
	public ResultSet viewOrder(String userID) {
		ResultSet set = null;
		String query = "select prodId,prodName,quantity,amount from orders where userId= ? ";
		PreparedStatement statement ;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, userID);
			System.out.println("execute");
			set = statement.executeQuery();
			System.out.println("execute");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
}

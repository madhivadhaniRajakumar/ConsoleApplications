package customer.Transaction;

import java.io.IOException;
import java.text.ParseException;

import customer.dto.Customer;

public interface TransactionViewCallBack {
	
	void transferWithinBank(Customer c) throws IOException, ParseException;
	void withdrawfromAccount(Customer c) throws NumberFormatException, IOException, ParseException ;
	void depositToAccount(Customer c) throws NumberFormatException, IOException, ParseException;
	void transferDifferntBank(Customer c) throws NumberFormatException, IOException, ParseException;
}

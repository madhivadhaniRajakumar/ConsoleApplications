package customer.createAccount;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public interface CreateAccountViewCallBack {
	void initialsetUp()throws IOException, ParseException;
	public void minorAccountSetUp(String fname,String lname,String branch,long adarno,LocalDate dob) throws IOException;
	void fail();
	void accountSuccess(String message) throws IOException, ParseException;
}

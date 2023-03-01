package mainPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import customer.createAccount.CreateAccountView;
import customer.login.LoginView;
import manager.AdminLogin.AdminLoginView;

public class mainPageView {
	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	
	public static void main(String[] args) throws IOException, ParseException {
		mainPageView mv = new mainPageView();
		mv.mainDisplay();
	}
	public void mainDisplay() throws IOException, ParseException {
		System.out.println("**********WELCOME TO CRB Pvt Lmt**************");
		System.out.println("Press 1 for Official Use");
		System.out.println("Press 2 for Customer Use");
		int option = Integer.parseInt(br.readLine());
		
		if(option==1) {
	
			AdminLoginView av = new AdminLoginView();
			av.displayLogin();
			
		}
		if(option==2) {
			System.out.println("********Customer Portal**********");
			System.out.println("Press 1 to Create Account");
			System.out.println("Press 2 to Sign in");
			System.out.println("Press 3 to Exit");
			int choice = Integer.parseInt(br.readLine());
			if(choice==1) {
				CreateAccountView cv = new CreateAccountView();
				cv.initialsetUp();
			}
			if(choice==2) {
				LoginView lv = new LoginView();
				lv.displayLogin();
			}
			if(choice==3) {
				mainPageView mv = new mainPageView();
				mv.mainDisplay();
			}
		}
	}
}

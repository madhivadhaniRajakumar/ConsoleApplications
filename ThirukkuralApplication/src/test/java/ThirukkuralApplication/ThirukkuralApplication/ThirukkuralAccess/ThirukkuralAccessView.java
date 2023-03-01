package ThirukkuralApplication.ThirukkuralApplication.ThirukkuralAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.json.simple.parser.ParseException;

import ThirukkuralApplication.ThirukkuralApplication.dto.EnglishThirukkural;
import ThirukkuralApplication.ThirukkuralApplication.dto.TamilThirukkural;

public class ThirukkuralAccessView implements ThirukkuralViewCallBack {

	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	Exception e;
	static ThirukkuralAccessView av = new ThirukkuralAccessView();
	ThirukkuralAccessController accessController;
	public ThirukkuralAccessView() {
		// TODO Auto-generated constructor stub
		accessController = new ThirukkuralAccessController(this);
	}
	public static void main(String[] args) throws IOException, ParseException {
		av.displayOption();
	}
	public void displayOption() throws IOException, ParseException {
		System.out.println("***Welcome to Thirukkural Directory***");
		System.out.println("திருக்குறளை தமிழில் பார்க்க 1ஐ அழுத்தவும்");
		System.out.println("Press 2 to view Thirukkural in English");
		int option=0;
		try {
			 option = Integer.parseInt(br.readLine());
			if(option!=1 && option!=2) {
				throw e;
			}
		} catch (Exception e) {
			System.out.println("Enter Valid Option");
			av.displayOption();
		}

		if(option==1) 
			av.viewThirukkuralinTamil();
		if(option==2) 
			av.viewThirukkuralinEnglish();
	}
	
	public void viewThirukkuralinTamil() throws IOException, ParseException {
		System.out.println("******திருக்குறள் செயலிக்கு வரவேற்கிறோம்*********");
		System.out.println("இன்றைய குறளைப் பார்க்க 1ஐ அழுத்தவும்");
		System.out.println("குறளைத் தேட 2ஐ அழுத்தவும்");
		System.out.println("குறிப்பிட்ட அதிகாரத்திலிருந்து அனைத்து திருக்குறளையும் காட்ட 3ஐ அழுத்தவும்");
		System.out.println("முந்தைய நிலைக்கு செல்ல 4 ஐ அழுத்தவும்");
		int option =0;
		try {
			option=Integer.parseInt(br.readLine());
			if(option!=1 && option!=2 && option!=3) {
				throw e;
			}
		} catch (Exception e) {
			System.out.println("சரியான விருப்பத்தை உள்ளிடவும்");
			av.viewThirukkuralinTamil();
		} 
		if(option==1) {
			av.dailyTamilKural();
			av.viewThirukkuralinTamil();
		}
		if(option==2) {
			System.out.println("திருக்குறள் எண்ணை உள்ளிடவும்");
			int number=0;
			try {
			 number = Integer.parseInt(br.readLine());
			if(number<=0 || number>1330) {
				throw e;
			}
			}
			catch(Exception e) {
				System.out.println("சரியான எண்ணை உள்ளிடவும்");
				av.viewThirukkuralinTamil();
			}
			TamilThirukkural tt = accessController.getThirukuralbyNumber(number);
			System.out.println(tt.toString());
			System.out.println("__________________________________________________");
			System.out.println();
			av.viewThirukkuralinTamil();
		}
		if(option==3) {
			System.out.println("திருக்குறள் அதிகார எண்ணை உள்ளிடவும்");
			int aNumber =0;
			try {
				aNumber = Integer.parseInt(br.readLine());
				if(aNumber<=0 || aNumber>133) {
					throw e;
				}
				List<TamilThirukkural> ls = accessController.convertAndGetAthigaram(aNumber);
				for(int i=0;i<ls.size();i++) {
					TamilThirukkural tt = ls.get(i);
					System.out.println(tt.toString());
					System.out.println();
					System.out.println("**************************************************");
				}
				System.out.println();
				av.viewThirukkuralinTamil();
			}
			catch(Exception e) {
				System.out.println("சரியான எண்ணை உள்ளிடவும்");
				av.viewThirukkuralinTamil();
			}
			
		}
		if(option==4) {
			av.displayOption();
		}
		
	}
	public void dailyTamilKural() throws IOException, ParseException {
		System.out.println("இன்றைய திருக்குறள்");
		int number = accessController.generateRandomnumber();
		TamilThirukkural tt= accessController.getThirukuralbyNumber(number+1);
		System.out.println(tt.toString());
		System.out.println("____________________________________________________________");
		System.out.println();
		
	}
	
	public void dailyEnglishKural() throws IOException, ParseException {
		System.out.println("Today's Thirukkural");
		int number = accessController.generateRandomnumber();
		EnglishThirukkural et= accessController.getThirukkuralbyNumberEnglish(number+1);
		System.out.println(et.toString());
		System.out.println("____________________________________________________________");
		System.out.println();
		
	}
	public void viewThirukkuralinEnglish() throws IOException, ParseException {
		System.out.println("*********Welcome to Thirukkural Application**************");
		System.out.println("Press 1 to view Today's Thirukkural");
		System.out.println("Press 2 to search Thirukkural");
		System.out.println("Press 3 to display all Thirukkural in specific chapters");
		System.out.println("Press 4 to go to previous menu");
		int option =0;
		try {
			option=Integer.parseInt(br.readLine());
			if(option!=1 && option!=2 && option!=3) {
				throw e;
			}
		} catch (Exception e) {
			System.out.println("Please Enter Valid option");
			av.viewThirukkuralinTamil();
		} 
		if(option==1) {
			av.dailyEnglishKural();
			av.viewThirukkuralinEnglish();
		}
		if(option==2) {
			System.out.println("Enter the Thirukkural Number");
			int number=0;
			try {
				number=Integer.parseInt(br.readLine());
				if(number<=0 || number>1330)
					throw e;
			}
			catch(Exception e) {
				System.out.println("Please Enter valid number");
				av.viewThirukkuralinEnglish();
			}
			EnglishThirukkural et = accessController.getThirukkuralbyNumberEnglish(number);
			System.out.println(et.toString());
			System.out.println("____________________________________________________________");
			System.out.println();
			av.viewThirukkuralinEnglish();
			
		}
		if(option==3) {
			System.out.println("Please Enter Thirukkural's Chapter Number");
			int aNumber =0;
			try {
				aNumber = Integer.parseInt(br.readLine());
				if(aNumber<=0 || aNumber>133) {
					throw e;
				}
				List<EnglishThirukkural> ls = accessController.convertAndGetAthigaramEnglish(aNumber);
				for(int i=0;i<ls.size();i++) {
					EnglishThirukkural et = ls.get(i);
					System.out.println(et.toString());
					System.out.println();
					System.out.println("**************************************************");
				}
				System.out.println();
				av.viewThirukkuralinEnglish();;
			}
			catch(Exception e) {
				System.out.println("Please Enter Valid Chapter Number");
				av.viewThirukkuralinEnglish();;
			}
		}
		if(option==4) {
			av.displayOption();
		}
	}
	
}

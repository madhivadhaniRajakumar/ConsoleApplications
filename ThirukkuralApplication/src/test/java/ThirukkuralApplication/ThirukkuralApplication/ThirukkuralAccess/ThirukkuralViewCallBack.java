package ThirukkuralApplication.ThirukkuralApplication.ThirukkuralAccess;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface ThirukkuralViewCallBack {
	void displayOption() throws IOException, ParseException;
	void viewThirukkuralinTamil() throws IOException, ParseException;
	void dailyTamilKural() throws IOException, ParseException;
	 void viewThirukkuralinEnglish() throws IOException, ParseException;
}

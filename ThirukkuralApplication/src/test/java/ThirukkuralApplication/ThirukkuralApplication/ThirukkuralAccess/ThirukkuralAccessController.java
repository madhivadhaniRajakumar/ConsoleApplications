package ThirukkuralApplication.ThirukkuralApplication.ThirukkuralAccess;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.json.simple.parser.ParseException;

import ThirukkuralApplication.ThirukkuralApplication.dto.EnglishThirukkural;
import ThirukkuralApplication.ThirukkuralApplication.dto.TamilThirukkural;

public class ThirukkuralAccessController implements ThirukkuralControllerCallBack {

	ThirukkuralViewCallBack thirukkuralViewCallBack;
	ThirukkuralModelCallBack thirukkuralModelCallBack;
	public ThirukkuralAccessController(ThirukkuralViewCallBack thirukkuralAccessView) {
		// TODO Auto-generated constructor stub
		thirukkuralViewCallBack = thirukkuralAccessView;
		thirukkuralModelCallBack = new ThirukkuralAccessModel(this);
	}
	public int generateRandomnumber() {
		Random randomNum = new Random();
		 int number = randomNum.nextInt(9);
		 return number;
	}
	public TamilThirukkural getThirukuralbyNumber(int number) throws IOException, ParseException  {
		TamilThirukkural tt= thirukkuralModelCallBack.getTThirukkuralNumber(number);
		return tt;
	}
	public EnglishThirukkural getThirukkuralbyNumberEnglish(int number) throws IOException, ParseException {
		EnglishThirukkural et = thirukkuralModelCallBack.getThirukkuralEnglish(number);
		return et;
	}
	public List<TamilThirukkural> convertAndGetAthigaram(int enteredNumber) throws IOException, ParseException{
		int number = (enteredNumber*10)-9;
		List<TamilThirukkural> ls = thirukkuralModelCallBack.getAthigaramtamil(number);
		return ls;
	}
	public List<EnglishThirukkural> convertAndGetAthigaramEnglish(int eNumber) throws IOException, ParseException{
		int number = (eNumber*10)-9;
		List<EnglishThirukkural> ls = thirukkuralModelCallBack.getAthigaramEnglish(number);
		return ls;
	}
}

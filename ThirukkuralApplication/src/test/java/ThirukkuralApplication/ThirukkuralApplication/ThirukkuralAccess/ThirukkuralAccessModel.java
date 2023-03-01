package ThirukkuralApplication.ThirukkuralApplication.ThirukkuralAccess;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import ThirukkuralApplication.ThirukkuralApplication.dto.EnglishThirukkural;
import ThirukkuralApplication.ThirukkuralApplication.dto.TamilThirukkural;
import ThirukkuralApplication.ThirukkuralApplication.respositary.ThirukkuralDB;

public class ThirukkuralAccessModel implements ThirukkuralModelCallBack {
	
	ThirukkuralControllerCallBack controllerCallBack;
	public ThirukkuralAccessModel(ThirukkuralControllerCallBack thirukkuralAccessController) {
		// TODO Auto-generated constructor stub
		controllerCallBack = thirukkuralAccessController;
	}

	public TamilThirukkural getTThirukkuralNumber(int number) throws IOException, ParseException {
		TamilThirukkural tt;
		tt=ThirukkuralDB.getInstance().getThirukkuralTamil(number);
		return tt;
	}
	
	public EnglishThirukkural getThirukkuralEnglish(int number) throws IOException, ParseException {
		EnglishThirukkural et = ThirukkuralDB.getInstance().getThirukkuralEnglish(number);
		return et;
		
	}
	public List<TamilThirukkural>  getAthigaramtamil(int number) throws IOException, ParseException {
		List<TamilThirukkural> ls = ThirukkuralDB.getInstance().getKuralinAthikaramTamil(number);
		return ls;
		
	}
	public List<EnglishThirukkural> getAthigaramEnglish(int number) throws IOException, ParseException{
		List<EnglishThirukkural> ls = ThirukkuralDB.getInstance().getKuralAthikaramEnglish(number);
		return ls;
		
	}
}

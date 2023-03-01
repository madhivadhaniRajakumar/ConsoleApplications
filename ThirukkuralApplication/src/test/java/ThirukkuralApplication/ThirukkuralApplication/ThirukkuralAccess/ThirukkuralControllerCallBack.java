package ThirukkuralApplication.ThirukkuralApplication.ThirukkuralAccess;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import ThirukkuralApplication.ThirukkuralApplication.dto.EnglishThirukkural;
import ThirukkuralApplication.ThirukkuralApplication.dto.TamilThirukkural;

public interface ThirukkuralControllerCallBack {
	public int generateRandomnumber();
	TamilThirukkural getThirukuralbyNumber(int number) throws IOException, ParseException;
	EnglishThirukkural getThirukkuralbyNumberEnglish(int number) throws IOException, ParseException;
	List<TamilThirukkural> convertAndGetAthigaram(int enteredNumber) throws IOException, ParseException;
	List<EnglishThirukkural> convertAndGetAthigaramEnglish(int eNumber) throws IOException, ParseException;
}

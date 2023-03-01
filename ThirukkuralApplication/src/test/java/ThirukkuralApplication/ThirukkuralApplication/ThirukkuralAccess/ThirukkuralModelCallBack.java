package ThirukkuralApplication.ThirukkuralApplication.ThirukkuralAccess;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import ThirukkuralApplication.ThirukkuralApplication.dto.EnglishThirukkural;
import ThirukkuralApplication.ThirukkuralApplication.dto.TamilThirukkural;

public interface ThirukkuralModelCallBack {
	TamilThirukkural getTThirukkuralNumber(int number) throws IOException, ParseException;
	EnglishThirukkural getThirukkuralEnglish(int number) throws IOException, ParseException;
	List<TamilThirukkural>  getAthigaramtamil(int number) throws IOException, ParseException;
	List<EnglishThirukkural> getAthigaramEnglish(int number) throws IOException, ParseException;

}

package ThirukkuralApplication.ThirukkuralApplication.respositary;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ThirukkuralApplication.ThirukkuralApplication.dto.EnglishThirukkural;
import ThirukkuralApplication.ThirukkuralApplication.dto.TamilThirukkural;

public class ThirukkuralDB {

	private static ThirukkuralDB db ;
	private static JSONArray kuralDb;
	private List<TamilThirukkural> tamilkural = new ArrayList<TamilThirukkural>();
	private List<EnglishThirukkural> englishkural = new ArrayList<EnglishThirukkural>();
	public static ThirukkuralDB getInstance() throws IOException, ParseException {
		if(db==null) {
			db = new ThirukkuralDB();
			JSONParser jsonparser = new JSONParser();
			FileReader reader = new FileReader(".\\jsonFiles\\allthirukural.json");
			Object obj=jsonparser.parse(reader);
			JSONObject value = (JSONObject)obj;
			kuralDb = (JSONArray) value.get("kural");
		}
		return db;
	}
	public TamilThirukkural getThirukkuralTamil(int number) {
		JSONObject k = (JSONObject)kuralDb.get(number-1);
		String line1 = (String)k.get("Line1");
		String line2 = (String)k.get("Line2");
		String translation = (String)k.get("mv");
		TamilThirukkural tt = new TamilThirukkural(line1, line2, translation, number);
		return tt;
	}
	public EnglishThirukkural getThirukkuralEnglish(int number) {
		JSONObject k = (JSONObject)kuralDb.get(number-1);
		String line1 = (String)k.get("transliteration1");
		String line2 = (String)k.get("transliteration2");
		String couplet = (String)k.get("couplet");
		String explanation = (String)k.get("explanation");
		EnglishThirukkural et = new EnglishThirukkural(number, line1, line2, couplet, explanation);
		return et;
	}
	public List<TamilThirukkural> getKuralinAthikaramTamil(int number){
		tamilkural.clear();
		for(int i=1;i<=10;i++) {
			JSONObject k = (JSONObject)kuralDb.get(number-1);
			String line1 = (String)k.get("Line1");
			String line2 = (String)k.get("Line2");
			String translation = (String)k.get("mv");
			tamilkural.add(new TamilThirukkural(line1, line2, translation, number));
			number++;
		}
		return tamilkural;
	}
	public List<EnglishThirukkural> getKuralAthikaramEnglish(int number){
		englishkural.clear();
		for(int i=1;i<=10;i++) {
			JSONObject k = (JSONObject)kuralDb.get(number-1);
			String line1 = (String)k.get("transliteration1");
			String line2 = (String)k.get("transliteration2");
			String couplet = (String)k.get("couplet");
			String explanation = (String)k.get("explanation");
			englishkural.add(new EnglishThirukkural(number, line1, line2, couplet, explanation));
			number++;
		}
		return englishkural;
	}
	
	
}

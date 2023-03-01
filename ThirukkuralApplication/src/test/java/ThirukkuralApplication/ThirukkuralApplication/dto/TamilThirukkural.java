package ThirukkuralApplication.ThirukkuralApplication.dto;

public class TamilThirukkural {

	private String line1;
	private String line2;
	private String translation;
	private int number;
	public TamilThirukkural(String line1, String line2, String translation, int number) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.translation = translation;
		this.number = number;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "திருக்குறள் எண் :"+ number +"\n\t" + line1 + "\n\t" + line2 + "\nதிருக்குறள் விளக்கம் :\n\t" + translation;
	}
	
	
}

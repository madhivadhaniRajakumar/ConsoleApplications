package ThirukkuralApplication.ThirukkuralApplication.dto;

public class EnglishThirukkural {
	private int number;
	private String line1;
	private String line2;
	private String couplet;
	private String explanation;
	public EnglishThirukkural(int number, String line1, String line2, String couplet, String explanation) {
		super();
		this.number = number;
		this.line1 = line1;
		this.line2 = line2;
		this.couplet = couplet;
		this.explanation = explanation;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
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
	public String getCouplet() {
		return couplet;
	}
	public void setCouplet(String couplet) {
		this.couplet = couplet;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	@Override
	public String toString() {
		return "Number : " + number + "\n\t" + line1 + "\n\t" + line2 + "\ncouplet : \n" + couplet
				+ "\nExplanation : \n" + explanation;
	}
	
}

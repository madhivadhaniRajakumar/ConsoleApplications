package customer.dto;

import java.time.LocalDate;

public class Transaction {
	private LocalDate date;
	private String message;
	private double amount;
	private long transactionId;
	public Transaction(LocalDate date, String message, double amount, long transactionId) {
		super();
		this.date = date;
		this.message = message;
		this.amount = amount;
		this.transactionId = transactionId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "" +transactionId+"\t\t"+ date + "\t\t" + message + "\t\t" + amount ;
	}
	
	
	
	
	
}

package banks;

import java.util.Random;

public class Bank {

	private String bankName, ownerName, accountNumber;
	private double balance, bankLimit;
	private static final String[] bankNames = { 
			"Deutsche Bank", 
			"Sparkasse", 
			"CommerzBank", 
			"UniCredit", 
			"ING-DIBA", 
			"Postbank" 
			};
	
	public Bank(String bankName, String ownerName, double balance) {
		this.bankName = bankName;
		this.ownerName = ownerName;
		this.accountNumber = generateAccountNumber();
		this.balance = balance;
		this.bankLimit = getBankLimit();
	}
	
	public static String getBankName(int index) {
		if(index >= bankNames.length || index <= 0) return null;
		else return bankNames[index - 1]; // we are getting index 1 - *
	}
	
	public String getBankName() {
		return this.bankName;
	}
	
	private String generateAccountNumber() {
		String accountNumber = "";
		Random random = new Random();
		int rangeUntil = 10;
		int randomNumber;
		
		switch(this.bankName) {
			case "Deutsche Bank" -> accountNumber = "DB13-";
			case "Sparkasse" -> accountNumber = "SK24-";
			case "CommerzBank" -> accountNumber = "CB55-";
			case "UniCredit" -> accountNumber = "UC67-";
			case "ING-DIBA" -> accountNumber = "ING98-";
			case "Postbank" -> accountNumber = "PB10-";
		}
		
		for(int block = 0; block < 5; block++) {
			
			for(int counterWithinBlock = 0; counterWithinBlock < 4; counterWithinBlock++) {
				randomNumber = random.nextInt(rangeUntil);
				accountNumber += randomNumber;
			}
			
			if(block != 4) {
				accountNumber += "-";
			}
		}
		
		return accountNumber;
	}
	
	public static void displayBanks() {
		// we showing options to the user from 1 to *
		// but within the array it has start from 0 to *
		for(int index = 1; index < bankNames.length; index++) {
			System.out.println(index + ".) " + bankNames[index-1]);
		}
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("Deposit succesful! New balance: " + this.balance);
	}
	
	public void liftOff(double amount) {
		if((this.balance + this.bankLimit) >= amount) {
			this.balance -= amount;
			System.out.println("Lift off succesful! New balance: " + this.balance);
		}
		else {
			System.out.println("Insufficient funds.");
		}
	}
	
	public double getBankLimit() {
		return switch(this.bankName) {
			case "Deutsche Bank" -> 500d;
			case "Sparkasse" -> 250d;
			case "CommerzBank" -> 400d;
			case "UniCredit" -> 350d;
			case "ING-DIBA" -> 100d;
			case "Postbank" -> 200d;
			default -> 500d;
		};
	}
	
	public static double getBankLimit(String bankName) {
		return switch(bankName) {
			case "Deutsche Bank" -> 500d;
			case "Sparkasse" -> 250d;
			case "CommerzBank" -> 400d;
			case "UniCredit" -> 350d;
			case "ING-DIBA" -> 100d;
			case "Postbank" -> 200d;
			default -> 500d;
		};
	}
	
}

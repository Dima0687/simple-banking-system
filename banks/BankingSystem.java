package banks;

import java.util.Map;
import java.util.HashMap;

public class BankingSystem {
	
	private static final Map<String, Bank> bankAccounts = new HashMap<>();

	public static void createAccount(String bankName, String ownerName, double balance, double limit) {
		Bank bankAccount = new Bank(bankName, ownerName, balance);
		String accountNumber = bankAccount.getAccountNumber();
		
		if(bankAccounts.containsKey(accountNumber)) {
			System.out.println("Account already exists!");
		}
		else {
			bankAccounts.put(accountNumber, bankAccount);
			System.out.println("\nAccount created successfully!");
			System.out.println("Welcome " + bankAccount.getOwnerName() + " your choosen bank is: " + bankAccount.getBankName());
			System.out.printf("Your given bank limit is: %.2f € high!\n" ,bankAccount.getBankLimit());
			System.out.println("Your Account number is: \n" + accountNumber);
		}
	}
	
	public static void doTransaction(String accountNumber, int typeOfTransaction, double amount) {
	
		if(bankAccounts.containsKey(accountNumber)) {
			Bank bankAccount = bankAccounts.get(accountNumber);
			
			// deposit
			if(typeOfTransaction == 1) {
				bankAccount.deposit(amount);
			}
			// lift off
			else if(typeOfTransaction == 2) {
				bankAccount.liftOff(amount);
			}
			else {
				System.out.println("Invalid transaction type.");
			}
		}
		else {
			System.out.println("Account not found!");
		}
	}
	
	public static void checkBalance(String accountNumber) {
		if(bankAccounts.containsKey(accountNumber)) {
			Bank bankAccount = bankAccounts.get(accountNumber);
			
			System.out.println("Name of the bank: " + bankAccount.getBankName());
			System.out.println("Account number: " + bankAccount.getAccountNumber());
			System.out.println("Account owner: " + bankAccount.getOwnerName());
			System.out.println("Account limit: " + bankAccount.getBankLimit());
			System.out.println("Account balance: " + bankAccount.getBalance());
		}
		else {
			System.out.println("Account not found!");
		}
	}
}

package main;

import java.util.Scanner;

import banks.Bank;
import banks.BankingSystem;

public class Application{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		displayProgramOnConsole(scan);
	}
	
	private static void displayProgramOnConsole(Scanner scan) {
		int choice;
		String accountNumber = "";
		
		while(true) {
			System.out.println("\nWelcome to the Banking System 3000");
			System.out.println("1. Create Account");
			System.out.println("2. Check Balance");
			System.out.println("3. Do Transaction");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scan.nextInt();
			
			switch(choice) {
				case 1 -> {
					String bankName;
					int bankChoice;
					String firstName = "";
					String lastName = "";
					String ownerName = "";
					double initialBalance;
					
					do {
						System.out.println("\nChoose a Bank: ");
						Bank.displayBanks();
						bankChoice = scan.nextInt();
						bankName = Bank.getBankName(bankChoice);
					} while(bankName == null);
		
					do {

						System.out.print("Enter your first name: ");
						firstName = scan.next(); // nextLine doesn't worked for me! I tried to get fullname here at once
					} while(firstName.equals(""));
					
					do {
						
						System.out.print("Enter your last name: ");
						lastName = scan.next();
					} while(lastName.equals(""));
					
					ownerName = firstName + " " + lastName;
					
					do {
						System.out.print("Enter your initial balance: ");
						initialBalance = scan.nextDouble();
					} while (initialBalance < 0);
					
					BankingSystem.createAccount(bankName, ownerName, initialBalance);
				}
				
				case 2 -> {
					System.out.print("Enter your Account number: ");
					accountNumber = scan.next(); // I tried to do with nextLine here too, and it also doesn't worked for me
					BankingSystem.checkBalance(accountNumber);
				}
				
				case 3 -> {
					System.out.print("Enter your Account number: ");
					accountNumber = scan.next(); // same problem with nextLine here
					System.out.println("\n1.) Deposit");
					System.out.println("2.) Lift off");
					int transactionChoice = scan.nextInt();
					System.out.print("Enter amount: ");
					double amount = scan.nextDouble();
					BankingSystem.doTransaction(accountNumber, transactionChoice, amount);
				}
				
				case 4 -> {
					System.out.println("Exiting ...");					
					scan.close();
					System.exit(0);
				}
				
				default -> System.out.println("Invalid choice. Please choose a valid option.");
			}
		}
	}
	
}
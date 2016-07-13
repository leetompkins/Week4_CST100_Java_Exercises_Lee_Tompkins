/* Summary: An ATM machine that has 10 accounts. Prompts user for account ID
 * if account id is not valid, request different id, once ID accepted, display menu with
 * various options (withdraw deposit, view balance, exit menu
 * File: ATM_Machine.java
 * Author: Lee Tompkins 
 * Date: Jul 12 2016
 * Week 4 Exercise 10.7
 */
import java.util.Scanner;
 
public class ATM_Machine {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Create new Account objects with initial ID / Balance
		Account account0 = new Account(0, 100);
		Account account1 = new Account(1, 100);
		Account account2 = new Account(2, 100);
		Account account3 = new Account(3, 100);
		Account account4 = new Account(4, 100);
		Account account5 = new Account(5, 100);
		Account account6 = new Account(6, 100);
		Account account7 = new Account(7, 100);
		Account account8 = new Account(8, 100);
		Account account9 = new Account(9, 100);
		// Create new Array for accounts
		Account[] accArray = new Account[10];
		accArray[0] = account0;
		accArray[1] = account1;
		accArray[2] = account2;
		accArray[3] = account3;
		accArray[4] = account4;
		accArray[5] = account5;
		accArray[6] = account6;
		accArray[7] = account7;
		accArray[8] = account8;
		accArray[9] = account9;
		byte x = 0; // variable to keep do while loop looping
		boolean xx = true; // boolean for while loop in menu
		do {
			xx = true; // reset menu boolean
			System.out.print("Enter in an account ID number");
			int accID = input.nextInt();
			if (accID < 0 || accID > 9) { // Check if ID valid
				System.out.println("Invalid Account ID number");
			} else {
				while (xx) {
				System.out.println("Enter 1 to view current balance");
				System.out.println("Enter 2 to make a withdraw");
				System.out.println("Enter 3 to make a deposit");
				System.out.println("Enter 4 to exit");
				System.out.print("");
				int menuOption = input.nextInt();
				
				// Switch to menu option selected
				switch (menuOption) {
				case 1: {
					System.out.println("The balance is " + accArray[accID].getBalance()); // display balance
					break;
				}
				case 2: { 
					System.out.print("Enter in an ammount to withdraw");
					double withdrawAmount = input.nextDouble();
					accArray[accID].withdraw(withdrawAmount); // Withdraw said amount
					break;
				}
				case 3: {
					System.out.print("Enter an ammount to Deposit");
					double depositAmount = input.nextDouble();
					accArray[accID].deposit(depositAmount); // Deposit said amount
					break;
				}
				case 4: {
					xx = false; // Exit menu, return to request ID
				}
				}
			}
			}
		} while (x == 0); 
	}	
}



/* Account class 
 * Date Jun 3 2016
 * Author Lee Tompkins
 * File Account.java
 */
 class Account {
	
	
	// Declare variables 
	
	
	private java.util.Date date = new java.util.Date();
	private int id;
	private double balance;
	private double annualInterestRate;
	private long dateCreated = date.getTime();
	
	// Variable getters 
	
	int getID() {
		return id;
	}
	double getBalance() {
		return balance;
	}
	double getAnnualInterestRate() {
		return annualInterestRate;
	}
	long getDateCreated() {
		return dateCreated;
	}
	// Variable setters 
	public void setID(int newID) {
		id = newID;
	}
	public void setBalance(double newBalance) {
		balance = newBalance;
	}
	public void setAnnualInterestRate(double newAnnualInterestRate) {
		annualInterestRate = newAnnualInterestRate;
	}
	double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}
	double getMonthlyInterest() {
		// Get monthly interest from annual interest
		return annualInterestRate / 12 / 100 * balance;
	}
	public void withdraw(double withdrawAmount) {
		// withdraw from balance
		 balance = balance - withdrawAmount;
	}
	public void deposit(double depositAmount) {
		// add to balance
		balance = balance + depositAmount;
	}
	public void setDateCreated() {
		//set date account was created 
		dateCreated = date.getTime();
	}
	Account() { // constructor default
		
	}
	
	Account(int id, double balance){ // specified constructor
		setID(id);
		setBalance(balance);
	}
}

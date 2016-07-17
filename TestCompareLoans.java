/* Program: Compare Loans
 * Week 4 Exercise 5.21 
 * Summary: Financial Application to compare monthly payments for an input loan amount
 * over an input amount of years.
 * Author: Lee Tompkins
 * Date Jul 13 2016
 * File: TestCompareLoans.java
 */


import java.util.Scanner;
public class TestCompareLoans {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // create scanner
		System.out.println("Compare loans of various rates between 5-8% for given years");
		System.out.print("Enter in a loan amount     ");
			double loanAmount = input.nextDouble(); // user input loan amount
		System.out.print("Enter in number of years     ");
			int years = input.nextInt(); // user input time 
		double[] arrayRate = new double[25]; // new array for rates, 25 size
		double rate = 5; // initial rate
		// fill array with rates 5 - 8 at 1/8 interval
		for (int i = 0; i < 25; i++) { 
			arrayRate[i] = rate;
			rate += .125;
		} // Display all the monthly rates and total payments for given loan amount and given time with rates 5-8
		System.out.println("Interest Rate    Monthly Payment       Total Payment");
		for (int j = 0; j < 25; j++) {
			System.out.println(arrayRate[j] + "%" + "            " + (loanAmount * (arrayRate[j]) / 1200) / (1 - 1 / Math.pow(1 + (arrayRate[j]) / 1200, years * 12)) + "    " + (years * 12 * (loanAmount * (arrayRate[j]) / 1200) / (1 - 1 / Math.pow(1 + (arrayRate[j]) / 1200, years * 12))));
		}
				
	}

}




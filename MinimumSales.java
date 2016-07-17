/* Program: Minimum sales to reach Salary
 * Week 4 Exercise 5.39
 * Summary: A program that calculates the minimum sales needed to make 30k a year
 * with a base salary of 5k
 * Author: Lee Tompkins 
 * Date: Jul 13 2016 
 * File: MinimumSales.java
 */
public class MinimumSales {
 
	public static void main(String[] args) {
		// Declare variables 
		double minSalary = 30000;
		int initialSalary = 5000;
		//int salesToMinSalary;
		if(minSalary == 0) {
			System.out.println("No sales are needed");
		} else if (minSalary <= 5400 && minSalary >= 5000.01) { // if salary < 5400
			System.out.println("Sales needed to reach minimum salary are $" + 
		    (minSalary) / .08);
		} else if (minSalary <= 5900 && minSalary >= 5400.01) { // if salary < 5900
			System.out.println("Sales needed to reach minimum salary are $" + 
				    ((minSalary - initialSalary) - 400) / .10 + 5000);
		} else if (minSalary >= 5900.01) { // if salary is > 5900
			System.out.println("Sales needed to reach minimum salary are $" + 
				    ((minSalary - initialSalary) - 900) / .12 + 10000);
		}

	}

}



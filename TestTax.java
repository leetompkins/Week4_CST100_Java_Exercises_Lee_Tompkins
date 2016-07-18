/* Program: Financial Taxes 
 * Summary: Week4 Exercise 10.8
 * 		Using tax brackets from the years 2009 and 2001, this application will 
 * 		return the amount of tax paid based on, the year, filing status, and taxable income
 * 		Per request of the exercise, this program will display the taxes on an interval of 1000 for an income of
 * 		50k - 60k for all statuses, for 2001 and 2009 tax years.
 * Author: Lee Tompkins 
 * Date: Jul 16 2016
 * File: TestTax.java
 */
public class TestTax {

	public static void main(String[] args) {
		// Declare Variables
		// 2009 tax brackets
		int[][] brackets2009 = {{8350, 33950, 82250, 171550, 372950},	//Single Filer
				   {1670, 67900, 137050, 20885, 372950},	//Married Jointly or widow(er)
				   {8350, 33950, 68525, 104425, 186475},	//Married Separately
				   {11950, 45500, 117450, 190200, 372950}	// Head of Household
				   };
		// 2001 tax brackets
		int[][] brackets2001 = {{27050, 65550, 136750, 297350},	//Single Filer
					{45200, 109250, 166500, 297350},	//Married Jointly or widow(er)
					{22600, 54625, 83250, 148675},	//Married Separately
					{36250, 93650, 151651, 297350}	// Head of Household
					};
		double[] rates2009 = {.10, .15, .25, .28, .33, .35}; // tax rates for 2009 
		double[] rates2001 = {.15, .275, .305, .355, .391}; // tax rates for 2001
			Tax tax_0_2009_50 = new Tax(0, brackets2009, rates2009, 50000); // create new tax object for 2009 taxes with base taxable income of 50k
			Tax tax_0_2001_50 = new Tax(0, brackets2001, rates2001, 50000); // create new tax object for 2001 taxes with base taxable income of 50k
			for (int j = 0; j <= 3; j ++){ // iterate through taxable income 50k-60k and through filing statuses 0-3
				tax_0_2009_50.setFilingStatus(j);
					for (int i = 0; i <= 10; i++){
					System.out.println("The tax paid on an income of " + tax_0_2009_50.getTaxableIncome() + " for filing status " + tax_0_2009_50.getFilingStatus() + " in the year 2009 is $" + tax_0_2009_50.getTax());
					tax_0_2009_50.setTaxableIncome(tax_0_2009_50.getTaxableIncome() + 1000); //add 1000 to taxable income
				}
			}
			for (int j = 0; j <= 3; j ++){ // iterate through taxable income 50k-60k and through filing statuses 0-3
				tax_0_2001_50.setFilingStatus(j);
					for (int i = 0; i <= 10; i++){
					System.out.println("The tax paid on an income of " + tax_0_2001_50.getTaxableIncome() + " for filing status " + tax_0_2001_50.getFilingStatus() + " in the year 2001 is $" + tax_0_2001_50.getTax());
					tax_0_2001_50.setTaxableIncome(tax_0_2001_50.getTaxableIncome() + 1000); //add 1000 to taxable income
				}
			}		
	}
}



class Tax {
	// Data fields for tax class 
	private double[] rates;
	private int[][] bracket;
	private int filingStatus;
	private double taxableIncome;
	// Generic Tax no parameter constructor
	public Tax() {
		
	}
	// Tax constructor with specific parameters 
	public Tax(int filingStatus, int[][] bracket, double[] rates, double taxableIncome) {
		this.filingStatus = filingStatus;
		this.rates = rates;
		this.bracket = bracket;
		this.taxableIncome = taxableIncome;
	}
	public void setRate(double[] rates) {
		// set the rate array
		this.rates = rates;
	}
	public void setBracket(int[][] bracket){
		// set the bracket array
		this.bracket = bracket;
	}
	public void setTaxableIncome(double taxableIncome){
		// set the taxable income
		this.taxableIncome = taxableIncome;
	}
	public void setFilingStatus(int filingStatus) {
		// set the filing status
		this.filingStatus = filingStatus;
	}
	public double[] getRates(){
		// get rates array
		return rates;
	}
	public int[][] getBracket() {
		// get bracket array
		return bracket;
	}
	public double getTaxableIncome(){
		// get taxable income
		return taxableIncome;
	}
	public int getFilingStatus(){
		// get filing status
		return filingStatus;
	}
	public double getTax() {
		int numberOfRates = rates.length;
		double tax = 0;
		switch (numberOfRates) { // Switch for the two tax years and respective number of rates for that year
		// Return Tax for appropriate tax brackets, filing status, taxable income, and number of different tax rates
		case 5: {
			if(taxableIncome <= bracket[filingStatus][0]) {
				return tax = taxableIncome * rates[0];
			} else if 
				(taxableIncome > bracket[filingStatus][0] && taxableIncome < bracket[filingStatus][1]) {
				return tax =  bracket[0][0] * rates[0] + ((taxableIncome - bracket[0][0]) * rates[1]);
			} else if 
				(taxableIncome > bracket[filingStatus][1] && taxableIncome < bracket[filingStatus][2]) {
				return  tax = bracket[filingStatus][0] * rates[0] + ((bracket[filingStatus][1] - bracket[filingStatus][0]) * rates[1]) + 
						((taxableIncome - bracket[0][1]) * rates[2]);
			} else if 
				(taxableIncome > bracket[filingStatus][2] && taxableIncome < bracket[filingStatus][3]) {
				return tax =  bracket[filingStatus][0] * rates[0] + ((bracket[filingStatus][1] - bracket[filingStatus][0]) * rates[1]) + 
						((bracket[filingStatus][2] - bracket[filingStatus][1]) * rates[2] + 
								((taxableIncome - bracket[filingStatus][2]) * rates[3]));
			} else {
				return tax =  bracket[filingStatus][0] * rates[0] + ((bracket[filingStatus][1] - bracket[filingStatus][0]) * rates[1]) + 
						((bracket[filingStatus][2] - bracket[filingStatus][1]) * rates[2] + 
								((bracket[filingStatus][3] - bracket[filingStatus][2]) * rates[3])) + 
									((taxableIncome - bracket[filingStatus][3]) * rates[4]);
				}
			}
		// Return Tax for appropriate tax brackets, filing status, taxable income, and number of different tax rates 
		case 6: {
			if(taxableIncome <= bracket[filingStatus][0]) {
				return tax =  taxableIncome * rates[0];
			} else if 
				(taxableIncome > bracket[filingStatus][0] && taxableIncome < bracket[filingStatus][1]) {
				return tax =  bracket[0][0] * rates[0] + ((taxableIncome - bracket[0][0]) * rates[1]);
			} else if 
				(taxableIncome > bracket[filingStatus][1] && taxableIncome < bracket[filingStatus][2]) {
				return tax =  bracket[filingStatus][0] * rates[0] + ((bracket[filingStatus][1] - bracket[filingStatus][0]) * rates[1]) + 
						((taxableIncome - bracket[0][1]) * rates[2]);
			} else if 
				(taxableIncome > bracket[filingStatus][2] && taxableIncome < bracket[filingStatus][3]) {
				return tax =  bracket[filingStatus][0] * rates[0] + ((bracket[filingStatus][1] - bracket[filingStatus][0]) * rates[1]) + 
						((bracket[filingStatus][2] - bracket[filingStatus][1]) * rates[2] + 
								((taxableIncome - bracket[filingStatus][2]) * rates[3]));
			} else if 
				(taxableIncome > bracket[filingStatus][3] && taxableIncome < bracket[filingStatus][4]) {
				return tax =  bracket[filingStatus][0] * rates[0] + ((bracket[filingStatus][1] - bracket[filingStatus][0]) * rates[1]) + 
						((bracket[filingStatus][2] - bracket[filingStatus][1]) * rates[2] + 
								((bracket[filingStatus][3] - bracket[filingStatus][2]) * rates[3])) + 
									((taxableIncome - bracket[filingStatus][3]) * rates[4]);
			} else {
				return tax =  bracket[filingStatus][0] * rates[0] + ((bracket[filingStatus][1] - bracket[filingStatus][0]) * rates[1]) + 
						((bracket[filingStatus][2] - bracket[filingStatus][1]) * rates[2] + 
								((bracket[filingStatus][3] - bracket[filingStatus][2]) * rates[3])) + 
									((bracket[filingStatus][4] - bracket[filingStatus][3]) * rates[4]) + 
									((taxableIncome - bracket[filingStatus][5]) * rates[5]);
				}
			}
		}
		return tax; // returns the tax calculated 
	}
}
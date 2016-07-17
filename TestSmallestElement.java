/* Program : Find Smallest Element 
 * Week 4 Exercise 7.9
 * Summary: A program that asks user to input 10 numbers, inputs numbers into an array, 
 * then finds the smallest element in the array 
 * Author: Lee Tompkins 
 * Date: Jul 13 2016 
 * File TestSmallestElement.java
 */

import java.util.Scanner;
import java.util.Arrays; // for use in sorting Array 
public class TestSmallestElement { // Tests the SmallestElement class funcionality 

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] array = new double[10];
		System.out.print("Enter in 10 numbers seperated by a space to return the smallest number.     ");
		// Put user input into an array
		array[0] = input.nextDouble();
		array[1] = input.nextDouble();
		array[2] = input.nextDouble();
		array[3] = input.nextDouble();
		array[4] = input.nextDouble();
		array[5] = input.nextDouble();
		array[6] = input.nextDouble();
		array[7] = input.nextDouble();
		array[8] = input.nextDouble();
		array[9] = input.nextDouble();
		// Construct SmallestElement obj with "array" parameter
		SmallestElement se = new SmallestElement(array); 
		System.out.println(" The smallest element is " + se.min(array)); // invoke min method from SmallestElement class
	}

}


class SmallestElement {
	// Data field 
	private double[] array;
	public static double min (double[] array) { // method to return smallest element in array
		Arrays.sort(array);
		return array[0];
	}
	public SmallestElement(double[] array){ // constructor with specified args
		this.array = array;
	}
}
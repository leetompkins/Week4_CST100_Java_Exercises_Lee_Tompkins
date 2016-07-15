/* Week4 Exercise 7.35 
 * Summary: A game program for hangman, selects random words from array, prompts user
 * to enter one letter at a time, each letter in word unguessed is displayed as *. 
 * When guess is correct, * turns into and displays letter, tells user how many misses 
 * and asks to play another game
 * Author: Lee Tompkins 
 * File: Hangman.java
 * Date: Jul 14 2016
 * 
 */
import java.util.Scanner;
public class Hangman {

	public static void main(String[] args) {
		boolean x = false; // boolean for do while loop
		int guessCounter = 0; // initialize counter
		String[] array = new String[5]; // new string array with size: 5
		// Declare and set words, add to array
		String a = "pascal";
		String b = "america";
		String c = "java";
		String d = "computer";
		String e = "motherboard";
		array[0] = a;
		array[1] = b;
		array[2] = c;
		array[3] = d;
		array[4] = e;
		int randomWordNum = (int)(Math.random() * 5); // random int for choosing word from array at int
		char[] guessLetters = new char[array[randomWordNum].length()];
		
		do { // do while, with switch for return of methods
			switch (guessLetter(array[randomWordNum], guessLetters)) {
				case 0: {
					guessCounter++; // adds to missed guesses counter 
					break;
				}
				case 1: {
					break;
				}
				case 2: {
					System.out.println("  ");
					System.out.println("With " + guessCounter + " missed guesses, you guessed the word " + array[randomWordNum]); // return guesses missed and word
					System.out.print("To play again enter 1 else enter 0 "); // request play again
					Scanner input = new Scanner(System.in); // new scanner
					int continuePlay = input.nextInt(); // input for request play
					if (continuePlay == 1) { // choose play again or exit
						//reset variables and choose random word for next game
						randomWordNum = (int)(Math.random() * 5);
						guessLetters = new char[array[randomWordNum].length()];
						break;
					} else {
						x = true; // exit if user chooses 0
					}
				}
			}	
		} while (!x);
		
		
	}
	
	public static int guessLetter(String word, char[] guessLetters) {
		
		System.out.print("Guess a letter for the word ");
		if (!printWord(word, guessLetters)) {
            return 2;
		}
		Scanner input = new Scanner(System.in);
        int empty = findEmptyPosition(guessLetters);
        char userInput = input.nextLine().charAt(0);
        if (word.contains(String.valueOf(userInput))) {
            guessLetters[empty] = userInput;
            return 1;
        }
        else {
            System.out.println(userInput + " is not in the word");
            return 0;
            }
    }

    // Hide word with ******** characters
    public static boolean printWord(String word, char[] enteredLetters) {
        boolean ast = false;
        for (int i = 0; i < word.length(); i++) { // go through all characters
            char letter = word.charAt(i);
            // check for already entered values
            if (inGuessLetters(letter, enteredLetters))
                System.out.print(letter);
            else {
                System.out.print('*');
                ast = true;
            }
        }
        return ast;
    }

    // Check if letter is in array
    public static boolean inGuessLetters(char letter, char[] guessLetters) {
        return new String(guessLetters).contains(String.valueOf(letter));
    }

    // Find first empty spot
    public static int findEmptyPosition(char[] guessLetters) {
        int i = 0;
        while (guessLetters[i] != '\u0000') i++;
        return i;
    }
    
}

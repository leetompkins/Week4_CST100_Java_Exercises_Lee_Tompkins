/* Program: A Test Class for the TicTacToe class
 * Week4 Exercise 9.9 
 */

import java.util.Scanner;
public class TestTicTacToe {

	public static void main(String[] args) {
		TicTacToe t3 = new TicTacToe(); // Construct TicTacToe object
		t3.printBoard(); // display the board
		Scanner input = new Scanner(System.in);
		for (int counter = 0; counter <= 9; counter++) {
			System.out.print("Player " + t3.getSymbol() + " enter in a row and column (1 2 or 0 2 ect...) to place an " + t3.getSymbol() + "    ");
			t3.userSpotSelection(input.nextInt(), input.nextInt()); // User input, immediately input into userSpotSelection method from TicTacToe class
			if (counter == 9 && !t3.checkWin()) { // if 9 plays have been made and there is no winner, declare draw 
				System.out.println("The game is a draw"); // if draw and not winner, display draw
				counter = 10; // exit loop
			}
			if (t3.checkWin()) {
				counter = 10; // exit loop
				t3.switchPlayer(); // Switch to back to last player 
				System.out.println("Winner is player " + t3.getSymbol()); // display winner
			}
		}
	}		
}
		
		



/* Week4 Exercise 8.9
 * Summary: A game of TicTacToe, Displays a 3x3 board, two player, players enter
 * in a position for x or o, if three in a row, that player wins, or else draw if 
 * no three in a row.
 * Author: Lee Tompkins 
 * File: TicTacToe;
 * Date Jul 13 2016
 */


class TicTacToe {
	// Data Fields
	public static char[][] boardSpots;
	private char playerSymbol;
	
	public char getSymbol() { // Symbol getter
		return playerSymbol;
	}
	
	public void setSpot(int row, int column) { // setter for user symbol placement 
		boardSpots[row][column] = playerSymbol;
	}
	
	public void createBoard(){ // creates board with empty slots 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boardSpots[i][j] = ' ';
			}
		}
	}
	
	public void printBoard () { // prints out the game board
			System.out.println("_____________");
			for (int i = 0; i < 3; i++) {
				System.out.print("| ");
				for (int j = 0; j < 3; j++) {
					System.out.print(boardSpots[i][j] + " | ");
				}
				System.out.println("                 ");
				System.out.println("_____________");
			}
		} 
	public void switchPlayer() { // switches between X and O after play "moves"
		if(playerSymbol == 'X') {
			playerSymbol = 'O';
		} else {
			playerSymbol = 'X';
		}
	}
	// Checks for matching chars and if initial value of ' '
	public boolean checkForMatches(char x, char y, char z) {
		return (x == y && y == z && x != ' ');
	}
	// Checks for row matches
	public boolean ifRowThreeMatches() {
		boolean match = false;
			if(checkForMatches(boardSpots[0][0], boardSpots[0][1], boardSpots[0][2]) || checkForMatches(boardSpots[1][0], boardSpots[1][1], boardSpots[1][2]) || checkForMatches(boardSpots[2][0], boardSpots[2][1], boardSpots[2][2])) {
				match = true;
			} else {
				match = false;
			}
		return match;
	}
	// checks for column matches
	public boolean ifColumnThreeMatches() {
		boolean match = false;
			if (checkForMatches(boardSpots[0][0], boardSpots[1][0], boardSpots[2][0]) || checkForMatches(boardSpots[0][1], boardSpots[1][1], boardSpots[2][1]) || checkForMatches(boardSpots[0][2], boardSpots[1][2], boardSpots[2][2])) {
				match = true;
			} else {
				match = false;
			}
		return match;
	}
	//checks for diagonal matches
	public boolean ifDiagonalThreeMatches() {
		boolean match = false;
		if (checkForMatches(boardSpots[0][0], boardSpots[1][1], boardSpots[2][2]) || (checkForMatches(boardSpots[0][2], boardSpots[1][1], boardSpots[2][0]))){
			match = true;
		} else {
			match = false;
		}
		 return match;
	}
	// checks if any of three matches are true, if so, there is a winner, returns true 
	public boolean checkWin() {
		boolean match = false;
		if (ifDiagonalThreeMatches() || ifColumnThreeMatches() || ifRowThreeMatches()) {
			match = true;
		} else {
			match = false;
		}
		return match;
	}
	//Adds character to user spot selection, switches character, prints new board
	public void userSpotSelection( int row, int column) {
		if (row >= 0 && row < 3 && column >= 0 && column < 3) {
			if (boardSpots[row][column] == ' ') {
				setSpot(row, column);
				printBoard();
				switchPlayer();
			}	
		}
	}
	// No args constructor for TicTacToe object
	public TicTacToe () {
		boardSpots = new char[3][3];
		createBoard();
		playerSymbol = 'X';
	}
}






package com.assignment2;

import java.util.Scanner;

public class GuessingGame {

	public GuessingGame() {}

	public static void main(String[] args) {
		GuessingGame G1 = new GuessingGame();
		G1.startGame();
	}

	/**
	 * When the player starts the game,a random number will be generated. 
	 * This random number will be the number that the player will try to guess.
	 */

	private static void startGame() {
		
		int theRandomNumber = (int) (Math.random() * 100 + 1);
		Scanner scanner = new Scanner(System.in);
		collectInput(scanner, theRandomNumber);
		scanner.close();
		
	}

	/**
	 * The player only gets 5 chances to guess the number .
	 * An invalid input should not affect the number of guesses the player has left.
	 */
	private static void collectInput(Scanner scanner, int number) {

		for (int j = 0; j < 5; j++) {
			System.out.print("Please pick a number between 1 and 100 : ");
			int guess = scanner.nextInt();
			System.out.println();
			if (guess == number) {
				System.out.println("YOU WIN!");
				break;
			} else if (guess < 1 || guess > 100) {
				System.out.println("Your guess is not between 1 and 100, please try again");
				j--;
			} else if (guess < number) {
				System.out.println("Please pick a higher number");
			} else if (guess > number && j < 4) {
				System.out.println("Please pick a lower number");
			}
		}

		System.out.println("You lose, the number to guess was " + number);

	}

}

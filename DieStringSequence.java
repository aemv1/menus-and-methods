/**
 * 
 */
package amvMenusAndMethods;
import java.util.Scanner;

/**
 * @author Amaryllis
 *
 */
public class DieStringSequence {
	private static Scanner keyboard = new Scanner(System.in);
	/**
	 * The method prompts the user to enter a 6 character string sequence containing
	 * numbers from 1 to 6. If the user enters 7, 8, 9, or 0, the boolean properInput
	 * will set to false and the user will be prompted to enter a new sequence. Once 
	 * the user enters valid input, the program calls the dieRoll method with the 
	 * dieSequence input as the parameter.
	 * @param args
	 */
	public static void dieSequences(String[] args) {
		boolean properInput;
		String dieSequence = "";
		
		do {
    		properInput = true;
        	System.out.println("Please enter a sequence of 6 die face values.");
        	dieSequence = keyboard.next().trim();
        	if (dieSequence.contains("7")) {
        		System.out.println("7 is not a proper die face value");
        		properInput = false;
        	}
        	if (dieSequence.contains("8")) {
        		System.out.println("8 is not a proper die face value");
        		properInput = false;
        	}
        	if (dieSequence.contains("9")) {
        		System.out.println("9 is not a proper die face value");
        		properInput = false;
        	}
        	if (dieSequence.contains("0")) {
        		System.out.println("0 is not a proper die face value");
        		properInput = false;
        	}
    	} while (properInput == false);
    	dieRoll(dieSequence);
	}
	/**
	 * The method takes the input from the user. The method generates a random sequence of numbers from 1 to 6
	 * using the Math.random method and concatenates the number to the randomSequence string. The rolls variable
	 * keeps track of how many times the method had to generate a new random integer in order to find a sequence 
	 * that matched the user's input.
	 * @param dieSequence
	 */
	private static void dieRoll(String dieSequence) {
		int rolls = 0;
		String randomSequence = "";
		do {
			int number = (int) (Math.random() * 7);
			randomSequence += number;
			rolls += 1;
		} while (!randomSequence.contains(dieSequence));
		System.out.printf("It took %d rolls of the die to roll the sequence %s. \n \n", rolls, dieSequence);
	}
	
}

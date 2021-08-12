/**
 * 
 */
package amvMenusAndMethods;
import java.util.Scanner;
/**
 * @author Amaryllis
 *
 */
public class ControlsAndCounting {
	private static Scanner keyboard = new Scanner(System.in);
	/**
	 * This program displays a menu giving the user the option to (A) count to a maximum value,
	 * (B) count a certain amount of times, (C) compare die roll strings, or (Q) quit. The program validates the user's input and
	 * if the input is invalid, it asks the user to input "A", "B", or "Q" again.
	 * If the user enters A or B, the program asks the user for a starting number, an interval, and
	 * a maximum number. The interval cannot be greater to or equal to 0 in either option.
	 * In option A, the maximum number cannot be lesser than or equal to the starting number plus 
	 * the interval. If it is, an error message will show and ask for a new number.
	 * In option B, the maximum number of times must be greater than 1. If it is not, an error message 
	 * will show and ask for a new number.
	 * Option A will call the countToMax method. Option A will then present a menu that asks the user 
	 * if they would like to run it again. Any incorrect answers will prompt the user to enter valid data.
	 * Option B will call the countCertainTimes method. Option B will then present a menu that asks the user 
	 * if they would like to run it again. Any incorrect answers will prompt the user to enter valid data.
	 * Option C will call the dieSequence method from the DieStringSequence class. Option C will ask the user
	 * if they would like to run it again. Any incorrect answers will prompt the user to enter valid data.
	 * Option Q prints out "Goodbye!" and ends the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
        String choiceA = "A) Count to a maximum value";
        String choiceB = "B) Count a maximum number of times and convert numbers";
        String choiceC = "C) Sequence of Die Rolls";
        String quit = "Q) Quit";
        String menuInput;
        String yesNo;
        String choiceY = "Y) Yes";
        String choiceN = "N) No";
        int startingNum = 0;
        int maxNum = 0;
        int interval = 0;
        
        do{
	        System.out.println("Please enter A, B, C, or Q:" + "\n" + choiceA + "\n" + choiceB + "\n" + choiceC + "\n" + quit);
	        do {
	            menuInput = keyboard.next().toLowerCase().trim();
	            if (!menuInput.equals("a") && !menuInput.equals("b") && !menuInput.equals("c") && !menuInput.equals("q"))
	            {
	                System.out.println("Please enter A, B, C, or Q");
	            }
	        } while (!menuInput.equals("a") && !menuInput.equals("b") && !menuInput.equals("c") && !menuInput.equals("q"));
	        if (menuInput.equals("a"))
	        {
	        	
		        do {
		            System.out.println("Enter a starting number:");
		            startingNum = keyboard.nextInt();
		            do {
		            	System.out.println("Enter an interval: ");
		            	interval = keyboard.nextInt();
		            	if (interval <= 0)
		            	{
		            		System.out.println("Interval cannot be less than or equal to 0");
		            	}
		            }while (interval <= 0);
		            do {
			            System.out.println("Enter a maximum number as a stopping point: ");
			            maxNum = keyboard.nextInt();
			            if (maxNum < startingNum + interval)
			    		{
			    			System.out.println("The ending number needs to be at least one counting interval larger than the starting number!");
			    		}
		            } while(maxNum < startingNum + interval);
		            countToMax(startingNum, interval, maxNum);
			        System.out.println("Would you like to repeat this counting program?");
			        System.out.println(choiceY);
			        System.out.println(choiceN);
			        do {
			            yesNo = keyboard.next().toLowerCase().trim();
			            if (!yesNo.equals("y") && !yesNo.equals("n"))
			            {
			                System.out.println("Please enter Y or N");
			            }
		            } while (!yesNo.equals("y") && !yesNo.equals("n"));
	        	} while(yesNo.equals("y"));
	        }
	        else if (menuInput.equals("b"))
	        {
	            
	            do {
		            System.out.println("Enter a starting number:");
		            startingNum = keyboard.nextInt();
		            do {
		            	System.out.println("Enter an interval: ");
		            	interval = keyboard.nextInt();
		            	if (interval <= 0)
		            	{
		            		System.out.println("The interval cannot be less than or equal to 0.");
		            	}
		            } while (interval <= 0);
		            do {
			            System.out.println("Enter a maximum number of times to count: ");
			            maxNum = keyboard.nextInt();
			            if (maxNum < 1)
			            {
			            	System.out.println("The ending number needs to be at least one counting interval larger than the starting number!");
			            }
		            } while (maxNum < 1);
		            countCertainTimes(startingNum, interval, maxNum);
		            RomanNumeral.numeralConversion(args);
		            System.out.println("Would you like to repeat this counting program?");
			        System.out.println(choiceY);
			        System.out.println(choiceN);
		            do {
			            yesNo = keyboard.next().toLowerCase().trim();
			            if (!yesNo.equals("y") && !yesNo.equals("n"))
			            {
			                System.out.println("Please enter Y or N");
			            }
		            } while (!yesNo.equals("y") && !yesNo.equals("n"));
	        	} while(yesNo.equals("y"));
	        }
	        else if (menuInput.equals("c")) 
	        {
	        	do {
		        	
		        	DieStringSequence.dieSequences(args);
		        	System.out.println("Would you like to repeat this counting program?");
			        System.out.println(choiceY);
			        System.out.println(choiceN);
		            do {
			            yesNo = keyboard.next().toLowerCase().trim();
			            if (!yesNo.equals("y") && !yesNo.equals("n"))
			            {
			                System.out.println("Please enter Y or N");
			            }
		            } while (!yesNo.equals("y") && !yesNo.equals("n"));
	        	} while(yesNo.equals("y"));
	        }
	        else
	        {
	            System.out.println("You have chosen: \n" + quit + "\n \nGoodbye!");
	        }
     	} while(!menuInput.equals("q"));

	}
	/**
	 * @description
	 * This method prints out the series of numbers according to the starting integer,
	 * interval number, and the specified maximum number.
	 * 
	 * @algorithm
	 * Start
	 * declare maxCount
	 * print startInt
	 * maxCount is assigned to sum of startInt and countInterval
	 * print maxCount
	 * repeat while loop until maxCount is no longer less than or equal to maxInt - countInterval
	 * 		maxCount is assigned to maxCount + countInterval
	 * 		print maxCount
	 * Stop
	 * @param startInt
	 * @param countInterval
	 * @param maxInt
	 */
	public static void countToMax(int startInt, int countInterval, int maxInt)
	{
		int maxCount;
		System.out.println(startInt);
		maxCount = startInt + countInterval;
		System.out.println(maxCount);
		while (maxCount <= maxInt - countInterval)
		{
			maxCount += countInterval;
			System.out.println(maxCount);
		}
	}
	/**
	 * @description
	 * This method prints out the series of numbers according to the starting integer, 
	 * interval number, and number of times the loop should go through.
	 * 
	 * @algorithm
	 * Start
	 * declare integer max count
	 * print startInt
	 * maxCount is assigned to the sum of startInt and countInterval
	 * print maxInt
	 * for loop
	 * 	int i is assigned to 1 and continues adding i until i < maxInt
	 * 		maxCount is assigned to maxCount + countInterval
	 * 		print maxCount
	 * stop
	 * @param startInt
	 * @param countInterval
	 * @param maxInt
	 */
	public static void countCertainTimes(int startInt, int countInterval, int maxInt)
	{
		int maxCount;
		System.out.println(startInt);
		maxCount = startInt + countInterval;
		System.out.println(maxCount);
		for (int i = 1; i < maxInt; i++)
		{
			maxCount += countInterval;
			System.out.println(maxCount);
		}
	}
}
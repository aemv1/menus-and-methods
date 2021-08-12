/**
 * 
 */
package amvMenusAndMethods;
import java.util.Scanner;
/**
 * @author Amaryllis
 *
 */
public class RomanNumeral {
	private static Scanner keyboard = new Scanner(System.in);
	/**
	 * The main method uses two methods to complete conversions from Roman Numerals to Arabic Numerals
	 * Arabic Numerals to Roman Numerals. It first asks the user which type of numeral they would like
	 * to input and then asks for the input. If the user enters a Roman Numeral, the program uses the
	 * romanToArabic method. If the user enters an Arabic integer, the program uses the arabicToRoman
	 * method. The numbers must be between 0 and 4000 exclusive or it will ask for a new input. After
	 * converting the number, the program asks the user if they would like to run it again.
	 * @param args
	 */
	public static void numeralConversion(String[] args) {
		String loopAnswer;
		do {
		char numberType;
		int integer = 0;
		String romanNumeral;
		boolean numberCheck = true;
		System.out.println("Is your number a Roman Numeral or an Integer? Type 'R' for Roman Numeral. 'I' for Integer.");
		do {
			numberType = keyboard.next().charAt(0);
			if ((numberType != 'R' && numberType != 'r') && (numberType !='I' && numberType != 'i'))
			{
				System.out.println("You did not enter a proper input. Enter 'R' for Roman Numeral or 'I' for Integer.");
			}
		}while((numberType != 'R' && numberType != 'r') && (numberType !='I' && numberType != 'i'));
		if(numberType == 'R' || numberType == 'r')
		{
			System.out.println("Type in your Roman Numeral that is greater than 0 and less 4000");
			do {
				romanNumeral = keyboard.next().toUpperCase();
				numberCheck = romanToArabic(romanNumeral);
				if (numberCheck == false)
				{
					System.out.println("Enter another Roman Numeral that is greater than 0 and less 4000:");
				}
			}while (numberCheck == false);
		}
		else
		{
			do {
				System.out.println("Type in an integer that is greater than 0 and less than 4000");
				integer = keyboard.nextInt();
			} while(!(integer > 0 && integer < 4000));
			romanNumeral = arabicToRoman(integer);
			System.out.println("Integer is " + romanNumeral + " in Roman Numerals");
		}
		/*
		 * Asks user whether they want to run the program again. If the user enters
		 * anything other than "yes" or "no" (ignoring letter casing), the program 
		 * asks the user the question again until an appropriate response is entered.
		 */
		do {
			System.out.println("Do you want to run the program again? Enter \"yes\" or \"no\"");
			loopAnswer = keyboard.next().toLowerCase();
			if (!loopAnswer.equals("yes") && !loopAnswer.equals("no"))
			{
				System.out.println("Incorrect input. Must be \"yes\" or \"no\".");
			}
		} while (!loopAnswer.equals("yes") && !loopAnswer.equals("no"));
	} while (loopAnswer.equals("yes"));
	System.out.println("Goodbye!");
		
	}
	
	/**
	 * This method takes the user's Roman Numeral input and decides whether it is valid or not.
	 * If the number is valid, the Roman Numeral is converted to an Arabic integer. The program
	 * gets the length of the inputed string and adds or subtracts the appropriate number to the
	 * Roman Numeral's value. It will then print the integer value after exiting the loop. If the
	 * Roman Numeral is invalid, it will print out a message to the user.
	 * @param romanNumber
	 */
	public static boolean romanToArabic(String romanNumber)
	{
		int value1 = 0;
		boolean valid = true;
		for (int i= romanNumber.length(); i > 0 && valid == true; i--)
		{
			if (romanNumber.charAt(i-1) == 'I')
			{
				if (value1 < 3)
				{
					value1 += 1;
				}
				else if (value1 == 5 || value1 == 10)
				{
					value1 -= 1;
				}
				else
				{
					valid = false;
				}
			}
			else if (romanNumber.charAt(i-1) == 'V')
			{
				if (value1 <= 3)
				{
					value1 += 5;
				}
				else
				{
					valid = false;
				}
			}
			else if (romanNumber.charAt(i-1) == 'X')
			{
				if (value1 <= 29)
				{
					value1 += 10;
				}
				else if (value1 >= 50 && value1 <= 59)
				{
					value1 -= 10;
				}
				else if (value1 >= 100 && value1 <= 109)
				{
					value1 -= 10;
				}
				else
				{
					valid = false;
				}
			}
			else if (romanNumber.charAt(i-1) == 'L')
			{
				if (value1 <= 39)
				{
					value1 += 50;
				}
				else
				{
					valid = false;
				}
			}
			else if (romanNumber.charAt(i-1) == 'C')
			{
				if (value1 <= 299)
				{
					value1 += 100;
				}
				else if (value1 >= 500 && value1 <= 599)
				{
					value1 -= 100;
				}
				else if (value1 >= 1000 && value1 <= 1099)
				{
					value1 -= 100;
				}
				else
				{
					valid = false;
				}
			}
			else if(romanNumber.charAt(i-1) == 'D')
			{
				if (value1 <= 399)
				{
					value1 += 500;
				}
				else
				{
					valid = false;
				}
			}
			else if(romanNumber.charAt(i-1) == 'M')
			{
				if (value1 <= 2999)
				{
					value1 += 1000;
				}
				else
				{
					valid = false;
				}
			}
			
		}
		if (valid == true) 
		{
			System.out.println("the integer value of the roman numeral is "+ value1);
		}
		else {
			System.out.println("Roman Numeral is not valid.");
		}
		return valid;
	}
	/**
	 * This method takes the inputted Arabic integer and decides if the number is 
	 * bigger than or equal to 1000, 100, 10, or 1 to go through the if statements.
	 * It then uses the modulus to decide which Roman Numeral is to be used for the 
	 * Roman Numeral string at each place. The method then concatenates each 
	 * appropriate place (thousands, hundreds, tens, ones) to create the Roman Numeral.
	 * @param arabicNumber
	 * @return
	 */
	public static String arabicToRoman(int arabicNumber)
	{
		String romanNumber = "";
		String thousands = "";
		String hundreds = "";
		String tens = "";
		String ones = "";
		int remainder = 0;
		int quotient = 0;
		if (arabicNumber >= 1000)
		{
			remainder = arabicNumber % 10;
			if (remainder == 9)
			{
				ones += "IX";
			}
			else if (remainder >= 5)
			{
				ones += "V";
				for (int i = remainder-5; i > 0; i--)
				{
					ones += "I";
				}
			}
			else if (remainder == 4)
			{
				ones += "IV";
			}
			else if (remainder >=1)
			{
				for (int i = remainder; i > 0; i--)
				{
					ones += "I";
				}
			}
			quotient = arabicNumber / 10;
			remainder = quotient % 10;
			if (arabicNumber >= 100)
			{
				if (remainder == 9)
				{
					tens += "XC";
				}
				else if (remainder >= 5)
				{
					tens += "L";
					for (int i = remainder-5; i > 0; i--)
					{
						tens += "X";
					}
				}
				else if (remainder == 4)
				{
					tens += "XL";
				}
				else if (remainder >= 1)
				{
					for (int i = remainder; i > 0; i--)
					{
						tens += "X";
					}
				}
			}
			quotient /= 10;
			remainder = quotient % 10;
			if (arabicNumber >= 10)
			{
				if (remainder == 9)
				{
					hundreds += "CM";
				}
				else if (remainder >= 5)
				{
					hundreds += "D";
					for (int i = remainder-5; i > 0; i--)
					{
						hundreds += "C";
					}
				}
				else if (remainder == 4)
				{
					hundreds += "CD";
				}
				else if (remainder >= 1)
				{
					for (int i = remainder; i > 0; i--)
					{
						hundreds += "C";
					}
				}
			}
			quotient /= 10;
			remainder = quotient % 10;
			if (arabicNumber >= 1)
			{
				for (int i = remainder; i > 0; i--)
				{
					thousands += "M";
				}
			}
			romanNumber = thousands+hundreds+tens+ones;
		}
		else if (arabicNumber >= 100)
		{
			remainder = arabicNumber % 10;
			if (remainder == 9)
			{
				ones += "IX";
			}
			else if (remainder >= 5)
			{
				ones += "V";
				for (int i = remainder-5; i > 0; i--)
				{
					ones += "I";
				}
			}
			else if (remainder == 4)
			{
				ones += "IV";
			}
			else if (remainder >=1)
			{
				for (int i = remainder; i > 0; i--)
				{
					ones += "I";
				}
			}
			quotient = arabicNumber / 10;
			remainder = quotient % 10;
			if (arabicNumber >= 10)
			{
				if (remainder == 9)
				{
					tens += "XC";
				}
				else if (remainder >= 5)
				{
					tens += "L";
					for (int i = remainder-5; i > 0; i--)
					{
						tens += "X";
					}
				}
				else if (remainder == 4)
				{
					tens += "XL";
				}
				else if (remainder >= 1)
				{
					for (int i = remainder; i > 0; i--)
					{
						tens += "X";
					}
				}
			}
			quotient /= 10;
			remainder = quotient % 10;
			if (arabicNumber >= 1)
			{
				if (remainder == 9)
				{
					hundreds += "CM";
				}
				else if (remainder >= 5)
				{
					hundreds += "D";
					for (int i = remainder-5; i > 0; i--)
					{
						hundreds += "C";
					}
				}
				else if (remainder == 4)
				{
					hundreds += "CD";
				}
				else if (remainder >= 1)
				{
					for (int i = remainder; i > 0; i--)
					{
						hundreds += "C";
					}
				}
			}
			romanNumber = hundreds+tens+ones;
		}
		else if (arabicNumber >= 10)
		{
			remainder = arabicNumber % 10;
			if (remainder == 9)
			{
				ones += "IX";
			}
			else if (remainder >= 5)
			{
				ones += "V";
				for (int i = remainder-5; i > 0; i--)
				{
					ones += "I";
				}
			}
			else if (remainder == 4)
			{
				ones += "IV";
			}
			else if (remainder >=1)
			{
				for (int i = remainder; i > 0; i--)
				{
					ones += "I";
				}
			}
			quotient = arabicNumber / 10;
			remainder = quotient % 10;
			if (arabicNumber >= 10)
			{
				if (remainder == 9)
				{
					tens += "XC";
				}
				else if (remainder >= 5)
				{
					tens += "L";
					for (int i = remainder-5; i > 0; i--)
					{
						tens += "X";
					}
				}
				else if (remainder == 4)
				{
					tens += "XL";
				}
				else if (remainder >= 1)
				{
					for (int i = remainder; i > 0; i--)
					{
						tens += "X";
					}
				}
			}
			romanNumber = tens+ones;
		}
		else if (arabicNumber >= 1)
		{
			remainder = arabicNumber % 10;
			if (remainder == 9)
			{
				ones += "IX";
			}
			else if (remainder >= 5)
			{
				ones += "V";
				for (int i = remainder-5; i > 0; i--)
				{
					ones += "I";
				}
			}
			else if (remainder == 4)
			{
				ones += "IV";
			}
			else if (remainder >=1)
			{
				for (int i = remainder; i > 0; i--)
				{
					ones += "I";
				}
			}
			romanNumber = ones;
		}
		return romanNumber;
	}
}

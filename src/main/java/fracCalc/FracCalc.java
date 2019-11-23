/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("Hello! This is your very own Frac Calc.");
    	System.out.print("Enter an expression to add, subtract, mulitply or divide");
    	System.out.print(" two integers or fractions");
    	String eq = userInput.nextLine();
    	System.out.println(produceAnswer(eq));
    	
        // TODO: Read the input from the user and call produceAnswer with an equation

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
    	Scanner inputUser = new Scanner(input);
    	String firstVal = inputUser.next();
    	String pemdas = inputUser.next();
    	String secondVal = inputUser.next();
    	
        // TODO: Implement this function to produce the solution to the input

        return secondVal;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}

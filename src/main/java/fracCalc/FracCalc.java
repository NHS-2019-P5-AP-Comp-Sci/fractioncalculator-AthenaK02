/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	String str = userInput.nextLine();
    	while (str != "quit") {
        	System.out.println("Hello! This is your very own Frac Calc.");
        	System.out.print("Enter an expression to add, subtract, mulitply or divide");
        	System.out.print(" two integers or fractions.");
        	System.out.println("Remember to add a space between the operator and each number!");
        	System.out.println("Type 'quit' to quit.");
        	String eq = userInput.nextLine();
        	System.out.println(produceAnswer(eq));
    	}
    	if (str == "quit") {
    		System.out.println("You have quit.");
    	}
    }
    public static String produceAnswer(String input) {
    	Scanner inputUser = new Scanner(input);
    	String firstVal = inputUser.next();
    	parsing(firstVal);
    	String mdas = inputUser.next();
    	String secondVal = inputUser.next();
    	String lol = parsing(secondVal);

        return lol;
    }
    public static String parsing(String inp) {
    	String whole = wholeNum(inp);
    	String numerator = numNum(inp);
    	String denominator = denNum(inp);
    	
    	String ans = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    	return ans;
    }
    public static String wholeNum(String one) {
    	if(one.contains("_")) {
    		return one.substring(0, one.indexOf("_"));
    	}
    	else if(!one.contains("_") && one.contains("/")) {
    		return "0";
    	}
    	else {
    		return one;
    	}
    }
    public static String numNum(String two) {
    	if(two.contains("_")) {
    		return two.substring(two.indexOf("_") + 1, two.indexOf("/"));
    	}
    	else if(!two.contains("_") && two.contains("/")) {
    		return two.substring(0, two.indexOf("/"));
    	}
    	else {
    		return "0";
    	}
    }
    public static String denNum(String three) {
    	if(three.contains("_")) {
    		return three.substring(three.indexOf("/") + 1, three.length());
    	}
    	else if(!three.contains("_") && three.contains("/")) {
    		return three.substring(three.indexOf("/") + 1, three.length());
    	}
    	else {
    		return "1";
    	}
    }

}

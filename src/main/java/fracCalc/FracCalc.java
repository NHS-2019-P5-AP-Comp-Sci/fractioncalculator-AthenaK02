/**
 * @author Mr. Rasmussen
 */
//
package fracCalc;
//
import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		System.out.println("Hello! This is your very own Frac Calc.");
		System.out.print("Enter an expression to add, subtract, mulitply or divide");
		System.out.print(" two integers or fractions. ");
		System.out.println("Remember to add a space between the operator and each number!");
		System.out.println("Type 'quit' to quit.");
		Scanner userInput = new Scanner(System.in);
		String str = userInput.nextLine();
		System.out.println(produceAnswer(str));
		// this needs to come before; also because it's a String you have to use
		// .equals()
		while (str.indexOf("quit") == -1) {
			System.out.print("Enter an expression to add, subtract, mulitply or divide");
			System.out.print(" two integers or fractions. ");
			System.out.println("Type 'quit' to quit.");
			str = userInput.nextLine();
			System.out.println(produceAnswer(str));
		}
		System.out.println("You have quit.");
		userInput.close();
	}

	//
	public static String produceAnswer(String input) {
		Scanner inputUser = new Scanner(input);
		String firstVal = inputUser.next();
		String whole = wholeNum(firstVal);
		int whole1 = Integer.parseInt(whole);
		String numerator = numNum(firstVal);
		int numerator1 = Integer.parseInt(numerator);
		String denominator = denNum(firstVal);
		int denominator1 = Integer.parseInt(denominator);

		int sign1 = 1;
		int sign2 = 1;

		if (whole1 != 0) {
			sign1 = Math.abs(whole1) / whole1;
			numerator1 = Math.abs(whole1) * denominator1 + numerator1;
		} else if (whole1 == 0 && numerator1 == 0) {
			sign1 = 0;
		} else {
			sign1 = Math.abs(numerator1) / numerator1;
			numerator1 = Math.abs(numerator1);
		}

		String mdas = inputUser.next();
		String secondVal = inputUser.next();

		whole = wholeNum(secondVal);
		int whole2 = Integer.parseInt(whole);
		numerator = numNum(secondVal);
		int numerator2 = Integer.parseInt(numerator);
		denominator = denNum(secondVal);
		int denominator2 = Integer.parseInt(denominator);

		if (whole2 != 0) {
			sign2 = Math.abs(whole2) / whole2;
			numerator2 = Math.abs(whole2) * denominator2 + numerator2;
		} else if (whole2 == 0 && numerator2 == 0) {
			sign2 = 0;
		} else {
			sign2 = Math.abs(numerator2) / numerator2;
			numerator2 = Math.abs(numerator2);
		}

		String answer1 = "";
		if (mdas.equals("+")) {
			answer1 = add(numerator1, denominator1, numerator2, denominator2, sign1, sign2);
		}
		if (mdas.equals("-")) {
			answer1 = subtract(numerator1, denominator1, numerator2, denominator2, sign1, sign2);
		}
		if (mdas.equals("/")) {
			answer1 = divide(numerator1, denominator1, numerator2, denominator2, sign1 * sign2);
		}
		if (mdas.equals("*")) {
			answer1 = multiply(numerator1, denominator1, numerator2, denominator2, sign1 * sign2);
		}

		return answer1;
	}

	// parsing separates the inputed string and rebuild it into one number
	public static String add(int numerator1, int denominator1, int numerator2, int denominator2, int sign1, int sign2) {
//multiply den1 & num1 by den2 and den2 & num2 by den1. Then add the resulting nums to get the new num and the new den should be den1*den2
		int ansa1 = sign1 * numerator1 * denominator2 + sign2 * numerator2 * denominator1;
		int ansa2 = denominator1 * denominator2;
		String anwer = reduce(ansa1, ansa2);
		return anwer;
	}

	public static String subtract(int numerator1, int denominator1, int numerator2, int denominator2, int sign1,
			int sign2) {
//same as add func but subtract
		int answ1 = sign1 * numerator1 * denominator2 - sign2 * numerator2 * denominator1;
		int answ2 = denominator1 * denominator2;
		String fanswer = reduce(answ1, answ2);
		return fanswer;
	}

	public static String multiply(int numerator1, int denominator1, int numerator2, int denominator2, int sign) {
		int num = numerator1 * numerator2 * sign;
		int den = denominator1 * denominator2;
		String finanswer = reduce(num, den);
		return finanswer;
	}

	public static String divide(int numerator1, int denominator1, int numerator2, int denominator2, int sign) {
//similar to mult function but switch num2 and den2 
		int num1 = numerator1 * denominator2 * sign;
		int num2 = denominator1 * numerator2;
		String finalanswer = reduce(num1, num2);
		return finalanswer;
	}

	public static String wholeNum(String one) {
		if (one.contains("_")) {
			return one.substring(0, one.indexOf("_"));
		} else if (one.contains("/")) {
			return "0";
		} else {
			return one;
		}
	}

	public static String numNum(String two) {
		if (two.contains("_")) {
			return two.substring(two.indexOf("_") + 1, two.indexOf("/"));
		} else if (two.contains("/")) {
			return two.substring(0, two.indexOf("/"));
		} else {
			return "0";
		}
	}

	public static String denNum(String three) {
		if (three.contains("/")) {
			return three.substring(three.indexOf("/") + 1);
		} else {
			return "1";
		}
	}

	public static String reduce(int num, int denom) {
		int n = Math.abs(num);
		int d = Math.abs(denom);
		if (denom < 0 && num > 0) {
			num = -n;
			denom = d;
		}
		if (num < 0 && denom < 0) {
			num = n;
			denom = d;
		}
		if (num == 0) {
			return "0";
		} else if (denom == 1) {
			return num + "";
		} else if (num % denom == 0) {
			return num / denom + "";
		}
		int x = Math.abs(num + denom);
		while (num % x != 0 || denom % x != 0) {
			x--;
		}
		num /= x;
		denom /= x;
		if (n > denom) {
			int mixed = num / denom;
			num = num % denom;
			n = Math.abs(num);
			d = Math.abs(denom);
			if (mixed != 0) {
				if (num < 0) {
					num = n;
					return mixed + "_" + num + "/" + denom;
				} else {
					return mixed + "_" + num + "/" + denom;
				}
			}
			else {
				n = Math.abs(num);
				d = Math.abs(denom);
				if (num < 0) {
					return num + "/" + denom;
				}
				else {
					return num + "/" + denom;
				}
			}
		} else {
			return num + "/" + denom;
		}

	}
}

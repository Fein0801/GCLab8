package co.grandcircus;

import java.util.Scanner;

// this is a concrete class that can be used over and over again
// you can also add your own validation methods here
public class GCValidator {

    public static String getString(Scanner sc, String prompt) {
	System.out.print(prompt);
	String s = sc.next(); // read user entry
	sc.nextLine(); // discard any other data entered on the line
	return s;
    }

    public static int getInt(Scanner sc, String prompt) {
	int i = 0;
	boolean valid = false;
	while (!valid) {
	    System.out.print(prompt);
	    if (sc.hasNextInt()) {
		i = sc.nextInt();
		valid = true;
	    } else {
		System.out.println("Error! Invalid integer value. Try again.");
	    }
	    sc.nextLine(); // discard any other data entered on the line
	}
	return i;
    }

    public static int getInt(Scanner sc, String prompt, int min, int max) {
	int i = 0;
	boolean valid = false;
	while (!valid) {
	    i = getInt(sc, prompt);
	    if (i < min)
		System.out.println("Error! Number must be " + min + " or greater.");
	    else if (i > max)
		System.out.println("Error! Number must be " + max + " or less.");
	    else
		valid = true;
	}
	return i;
    }

    public static double getDouble(Scanner sc, String prompt) {
	double d = 0;
	boolean valid = false;
	while (!valid) {
	    System.out.print(prompt);
	    if (sc.hasNextDouble()) {
		d = sc.nextDouble();
		valid = true;
	    } else {
		System.out.println("Error! Invalid decimal value. Try again.");
	    }
	    sc.nextLine(); // discard any other data entered on the line
	}
	return d;
    }

    public static double getDouble(Scanner sc, String prompt, double min, double max) {
	double d = 0;
	boolean valid = false;
	while (!valid) {
	    d = getDouble(sc, prompt);
	    if (d < min)
		System.out.println("Error! Number must be " + min + " or greater.");
	    else if (d > max)
		System.out.println("Error! Number must be " + max + " or less.");
	    else
		valid = true;
	}
	return d;
    }

    public static String getStringMatchingRegex(Scanner sc, String prompt, String regex) {
	boolean valid = false;

	String input;

	do {
	    input = getString(sc, prompt);
	    if (input.matches(regex)) {
		valid = true;
	    } else {
		System.out.println("Input must match the right format: ");
	    }

	} while (!valid);

	return input;
    }

}
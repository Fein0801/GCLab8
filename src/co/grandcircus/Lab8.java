package co.grandcircus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ben Feinstein
 */

public class Lab8 {

    private static ArrayList<Student> students = new ArrayList<Student>();
    private static final String FILE_NAME = "src\\co\\grandcircus\\studentData.txt";
    private static final String[] DATA_TYPES = { "favorite food", "hometown", "name" };

    public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	try {
	    // Creates student objects. File on GitHub
	    createStudentsFromFile();
	} catch (FileNotFoundException e) {
	    System.out.println("Ben needs to learn how to read files!");
	    e.printStackTrace(System.out);
	}

	getStudentInfo(userInput);

	System.out.println("Goodbye.");

	userInput.close();
    }

    private static void createStudent(String str) {
	if (str.contains("/") && !str.contains("#")) {
	    String[] parts = str.split("/");
	    Student s = new Student();
	    s.setName(parts[0]);
	    s.setFavoriteFood(parts[1]);
	    s.setHometown(parts[2]);
	    students.add(s);
	} else {
	    return;
	}
    }

    // File readers are finnicky and hard to understand. this takes in the constant
    private static void createStudentsFromFile() throws FileNotFoundException {
	Scanner fileInput = new Scanner(new FileReader(FILE_NAME));
	while (fileInput.hasNextLine()) {
	    String input = fileInput.nextLine();
	    createStudent(input);
	}
	fileInput.close();
    }

    // this is a terrible name, but this is the brains behind the program
    private static void getStudentInfo(Scanner sc) {
	boolean cont = true;
	System.out.print("Welcome to our Java class. ");
	while (cont) {
	    String numberPrompt = "\nWhich student would you like to know more about? (1 to " + students.size()
		    + ", 0 to quit)\n> ";
	    int studentNum = GCValidator.getInt(sc, numberPrompt, 0, students.size());
	    if (studentNum == 0) {
		return; // Quit if user enters 0
	    }

	    Student s = students.get(studentNum - 1);
	    String firstName = s.getFirstName();

	    System.out.printf("Student %d is %s. ", studentNum, s.getName(), firstName);

	    boolean wantsMoreInfo = true;
	    while (wantsMoreInfo) {
		String dataType = getDataType(sc, firstName);

		switch (dataType) {
		case "favorite food":
		    System.out.printf("%s's favorite food is %s. ", firstName, s.getFavoriteFood());
		    break;
		case "hometown":
		    System.out.printf("%s is from %s. ", firstName, s.getHometown());
		    break;
		case "name":
		    System.out.printf("I have already told you %s's name. Have you been paying attention?\n",
			    firstName);
		    break;
		}

		System.out.printf("Would you like more info about %s? (yes/no)\n> ", firstName);
		wantsMoreInfo = sc.nextLine().equalsIgnoreCase("yes");
	    }
	}
    }

    private static String getDataType(Scanner sc, String studentName) {
	ArrayList<String> dataTypes = new ArrayList<String>();
	String input = "";
	for (String s : DATA_TYPES) {
	    dataTypes.add(s);
	}

	while (!dataTypes.contains(input)) {
	    System.out.printf("What would you like to know about %s? ", studentName);
	    System.out.println();
	    System.out.print("(");
	    for (int index = 0; index < dataTypes.size(); index++) {
		System.out.print("\"" + dataTypes.get(index) + "\"");
		if (index < dataTypes.size() - 1) {
		    System.out.print(" or ");
		}
	    }
	    System.out.println(")");
	    input = sc.nextLine().toLowerCase();

	    if (!dataTypes.contains(input) && !input.equals("")) {
		System.out.printf("The data type \"%s\" does not exist. ", input);
	    }
	}
	return input;
    }
}

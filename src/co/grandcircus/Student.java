package co.grandcircus;

import java.util.ArrayList;

/**
 * @author Ben Feinstein
 * 
 *         This Student object is an object that contains a name (split into
 *         first and last name), a hometown, and a favorite food. I briefly
 *         considered age as well.
 */
public class Student {

    private String name;
    private String firstName;
    private String lastName;
    private String hometown;
    private String favoriteFood;

    private static final String[] DATA_TYPES = { "favorite food", "hometown", "name", "first name", "last name" };

    public Student() {
	hometown = "";
	favoriteFood = "";
	name = "";
    }

    public Student(String name) {
	this.name = name;
	hometown = "";
	favoriteFood = "";
    }

    // A collection of "getters" and "setters" for all the fields in this class
    public void setName(String name) {
	this.name = name;
	this.splitName();
    }

    public String getName() {
	return name;
    }

    public void setHometown(String hometown) {
	this.hometown = hometown;
    }

    public String getHometown() {
	return hometown;
    }

    public void setFavoriteFood(String food) {
	favoriteFood = food;
    }

    public String getFavoriteFood() {
	return favoriteFood;
    }

    public String getFirstName() {
	return this.firstName;
    }

    public String getLastName() {
	return this.lastName;
    }

    public static String[] getDataTypes() {
	return DATA_TYPES;
    }
    // End group of getters and setters

    // Overrides Object.equals() by making sure all fields are equal
    public boolean equals(Student s) {
	if (s.getHometown().equals(hometown) && s.getName().equals(name) && s.getFavoriteFood().equals(favoriteFood)) {
	    return true;
	}
	return false;
    }

    public String toString() {
	String s = "";
	s = s + "\nName: " + name;
	s = s + "\nHometown: " + hometown;
	s = s + "\nFavorite food: " + favoriteFood;
	return s;
    }

    // Splits name into first and last. Theoretically, this could be error prone.
    private void splitName() {
	String[] fullName = this.name.split(" ");
	this.firstName = fullName[0];
	this.lastName = fullName[1];
    }

    public static void sortByLastName(ArrayList<Student> studentList) {
	Student[] arr = studentList.toArray(new Student[studentList.size()]);
	sortByLastName(arr);
	studentList.clear();
	for (Student s : arr) {
	    studentList.add(s);
	}
    }

    public static void sortByLastName(Student[] arr) {
	// does a selection sort
	for (int i = 0; i < arr.length - 1; i++) {
	    int indexSmallest = i;

	    for (int j = i + 1; j < arr.length; j++) {
		if (arr[j].getLastName().compareToIgnoreCase(arr[indexSmallest].getLastName()) < 0) {
		    indexSmallest = j;
		}
	    }

	    Student temp = arr[i];
	    arr[i] = arr[indexSmallest];
	    arr[indexSmallest] = temp;
	}
    }

}

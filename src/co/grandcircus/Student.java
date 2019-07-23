package co.grandcircus;

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

    public static String[] getDataTypes() {
	return DATA_TYPES;
    }

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

    private void splitName() {
	String[] fullName = this.name.split(" ");
	this.firstName = fullName[0];
	this.lastName = fullName[1];
    }

    public String getFirstName() {
	return this.firstName;
    }

    public String getLastName() {
	return this.lastName;
    }
}

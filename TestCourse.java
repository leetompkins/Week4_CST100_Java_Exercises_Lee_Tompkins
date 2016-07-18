/* Program: Course
 * Summary: Week4 Exercise 10.9 
 * An application that creates a course object for storing students, course name, and number of students
 * The students are stored in a String Array and the array is able to change size depending on the number of students 
 * Students can be added, or removed from the course, the course can also be cleared (removes all students) 
 * Author: Lee Tompkins 
 * Date: Jul 17 2016 
 * File: TestCourse.java
 */
import java.util.Arrays; // for use of array copy

public class TestCourse {

	public static void main(String[] args) {
		Course c1 = new Course("Work on your TERRIBLE code commenting Lee"); // Create new course object with a name 
		c1.addStudent("Lee");     // add student with name ..
		c1.addStudent("Really");  // add student with name ..
		c1.addStudent("Will");    // add student with name ..
		c1.dropStudent("Really"); // remove student with name ..
		c1.showStudents(); // print all students in the course 
		// print number of students in the course 
		System.out.println("There are " + c1.getNumberOfStudents() + " students in the course.");
		
		

	}

}




class Course { // Create Course class
	// Course Data Fields
	private String courseName;
	private int numberOfStudents = 0;
	private String[] students = new String[numberOfStudents];
	
	
	public Course(String courseName) { // Constructor with specific parameters for courseName
		this.courseName = courseName;
	}
	public void addStudent(String student) {
		// adds a student to the course
		String[] tempArray = Arrays.copyOf(students, numberOfStudents + 1); // creates the new array 1 size larger with same values copied in
		students = tempArray; // sets original array equal to new array for new size
		students[numberOfStudents] = student; // puts new student in original array at the newly added index
		numberOfStudents += 1; // increases Number of Students in the course by one
	}
	public void showStudents() { // prints all the students in the course
		for(int i = 0; i < numberOfStudents; i++) {
			System.out.println(students[i]);
		}
	}
	public int getNumberOfStudents() { // returns the number of students in the course
		return numberOfStudents;
	}
	public String getCourseName() { // returns the course name 
		return courseName;
	}
	public void dropStudent(String student){ // Removes a student with a given name 
		for(int i = 0; i < numberOfStudents; i++) { // iterate through indexes till student is found 
			if(students[i] == student) {
				students[i] = students[numberOfStudents -1]; // replace dropped student with existing student, and decrease array size by one
				String[] tempArray = Arrays.copyOf(students, numberOfStudents - 1);
				students = tempArray; // set original array to the new array
				numberOfStudents -= 1; // subtract 1 from number of students
			}	
		}
	}
	public void clear(){ // clear all students from the class
		String[] tempArray = new String[0];
		students = tempArray;
		numberOfStudents = 0; // set number of students to 0 
	}
	
}

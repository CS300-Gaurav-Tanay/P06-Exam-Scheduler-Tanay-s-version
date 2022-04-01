//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exam Scheduler P06
// Course:   CS 300 Spring 2022
//
// Author:   Tanay Nagar
// Email:    tpnagar@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Gaurav Chopra
// Partner Email:   gmchopra@wisc.edu
// Partner Lecturer's Name: Mouna Kcem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         Avicenna Hartojo Tirtosuharto
// Online Sources:  YouTube Videos
//

/**
 * This class forms a data container for a Course having properties like the class's name and
 * its capacity
 *
 * @author tanaynagar
 * @author gmchopra
 * @author mounakacem
 * @author legault
 * @version 1.0
 */
public class Course {
  // Defining data fields
  private String name ; // Name of the Course
  private int numStudents; // Number of Students in the course

  //Implementing Constructor

  /**
   * Constructor for the course class called when a new Course Object is created.
   *
   * @param name Name of the Course
   * @param numStudents Number of Students in the Course
   * @throws IllegalArgumentException when the number of Students is less than zero (<0)
   */
  public Course(String name, int numStudents) throws IllegalArgumentException {
    //Making sure the integer provided is not negative
    if (numStudents < 0) {
      // integer is negative
      throw new IllegalArgumentException("Invalid Input: The numStudents integer passed into "
          + "the Course constructor at Object Creation is negative");
    }
    // Initializing name
    this.name = name;
    // Initializing numStudents
    this.numStudents = numStudents;
  } // course_Constructor ends

  //Implementing the getName() and the getNumStudents() methods

  /**
   * Getter method for the name of the course
   *
   * @return (String) Name of the Course
   */
  public String getName(){
    // Returning name
    return this.name;
  } // getName() ends

  /**
   * Getter methods for the number of students in the course
   *
   * @return (int) Number of Students in the Course
   */
  public int getNumStudents(){
    // Returning numStudents
    return this.numStudents;
  } // getNumStudents() ends

} // class ends

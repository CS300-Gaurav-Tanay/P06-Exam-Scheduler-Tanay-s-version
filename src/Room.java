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
 *
 */
public class Room {
  //Defining data fields
  private String location; // location of the room
  private int capacity; // max number of people the room can handle

  //Constructor
  public Room(String location, int capacity) throws IllegalArgumentException {
    // Checking if the provided integer is negative
    if (capacity < 0) {
      throw new IllegalArgumentException("Invalid Input: integer input value for capacity "
          + "passed to the constructor is negative");
    }
    // Initializing data fields
    this.location = location;
    this.capacity = capacity;

  } // constructor ends

  public String getLocation() {
    return this.location;
  } // getLocation() ends

  public int getCapacity() {
    return this.capacity;
  } // getCapacity() ends

  public Room reduceCapacity(int numToReduce) throws IllegalArgumentException {
    // Declaring local variables
    Room objToReturn;
    int reducedCapacity;

    //Making sure that the integer argument passed in is less than the or equal to the given
    // capacity of the room and throwing Exception if it is not
    if (numToReduce > this.getCapacity()) {
      throw new IllegalArgumentException("Invalid Input: The integer input passed in to the "
          + "reduceCapacity() method is more than the given capacity of the room object");
    }

    reducedCapacity = this.getCapacity() - numToReduce;

    // Creating new Room object with the reduced capacity
    objToReturn = new Room(this.getLocation(), reducedCapacity);
    // Returning
    return objToReturn;
  } // reduceCapacity() ends
} // Room ends

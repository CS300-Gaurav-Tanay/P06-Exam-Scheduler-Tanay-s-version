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

import java.util.Arrays;

/**
 * This class augments the Room and Course classes to create a system to assign courses to rooms
 * and provides certain behaviours which can be performed to the same (get number of rooms and
 * courses, check if a course has been assigned, get access to a particular room and course,
 * assign a course to a room and get the assignment for a room)
 *
 * @author tanaynagar
 * @author gmchopra
 * @author mounakacem
 * @author legault
 * @version 1.0
 */
public class Schedule {
  // Defining data fields
  private Room[] rooms; // an array of the Room objects available for exams
  private Course[] courses; // an array of the Course objects which require exam rooms
  private int[] assignments; // an array where the integer at index N is the index of the room
  // that course[N] has been assigned to

  // Implementing the constructors

  /**
   * initializes the rooms and courses arrays to the provided values, and creates an assignments
   * array of the correct length where all values are -1, indicating that the corresponding course
   * has not yet been assigned a room.
   *
   * @param rooms   rooms array to be included in the schedule
   * @param courses courses array to be included in the Schedule
   */
  public Schedule(Room[] rooms, Course[] courses) {
    // Initializing the rooms and the courses array
    this.rooms = rooms;
    this.courses = courses;
    // Initializing assignment array to be the length of the courses array and the making each
    // element -1
    this.assignments = new int[this.courses.length];
    Arrays.fill(this.assignments, -1);
  }

  /**
   * Initializes the rooms and courses arrays to the provided values and assignments to the
   * provided assignments array. May assume the assignments array is the correct length (equal to
   * the length of the courses array).
   *
   * @param rooms       rooms array for the Schedule
   * @param courses     courses array for the Schedule
   * @param assignments assignments array which holds info on which course is assigned to which
   *                    room
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
    // Initializing the rooms and the courses array
    this.rooms = rooms;
    this.courses = courses;
    // Initializing assignments to the provided value
    this.assignments = assignments;
  }

  // Implementing methods

  /**
   * Getter method for the number of rooms in the Schedule
   *
   * @return (int) Number of rooms in the Schedule
   */
  public int getNumRooms() {
    return this.rooms.length;
    //todo: confirm implementation with professor
  }

  /**
   * Getter method which returns a specific Room object depending on the index passed to it
   *
   * @param index index of the room Object which is to be returned by the method
   * @return (Room) Room Object which is returned
   * @throws IndexOutOfBoundsException when the index passed in to the method is negative or more
   *                                   than/equal to the number of Room objects in the Schedule
   */
  public Room getRoom(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= rooms.length) {
      // todo: check with gaurav
      // index is invalid
      throw new IndexOutOfBoundsException("Invalid Input: the integer parameter passed in to "
          + "the getRoom() method is either negative (< 0) more than/equal to the size of the "
          + "rooms array");
    }

    // Returning room Object since index is correct
    return this.rooms[index];
  }

  /**
   * Getter method for the number of Courses in the Schedule
   *
   * @return (int) number of courses in the schedule
   */
  public int getNumCourses() {
    return this.courses.length;
  }

  /**
   * Getter method which returns a specific Course object depending on the index passed to it
   *
   * @param index - index of the course object which is to be returned by the method
   * @return (Course) Course object to be returned
   * @throws IndexOutOfBoundsException when the index passed in to the method is negative or more
   *                                   than/equal to the number of Course objects in the Schedule
   */
  public Course getCourse(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= courses.length) {
      // todo: check with gaurav
      // index is invalid
      throw new IndexOutOfBoundsException("Invalid Input: the integer parameter is either "
          + "negative (< 0) more than/equal to the size of the courses array");
    }

    return this.courses[index];
  }

  /**
   * This method checks whether a course at a given index has been assigned a room or not
   *
   * @param index - index of the course object which is checked for assignment
   * @return (boolean) true if and only if the course at the given index has been assigned a room
   * and false otherwise.
   */
  public boolean isAssigned(int index) {
    // Since the course and the assignments are a parallel array
    if (assignments[index] != -1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method returns the room object assigned to the course at the index passed in
   *
   * @param index - index of Course object whose room assignment has to be returned
   * @return (Room) returns a room object assigned to the course at the given index
   * @throws IllegalArgumentException  when the room does not have enough capacity or the course
   *                                   has already been assigned a room
   * @throws IndexOutOfBoundsException When the given course or room index is less than zero or
   *                                   greater than equal to the length of the course or the room
   *                                   array respectively
   */
  public Room getAssignment(int index)
      throws IllegalArgumentException, IndexOutOfBoundsException {
    // todo: check with gaurav
    // Declaring local variables
    int roomIndex;
    Course tempObj;


    // Using the getCourse() method to assign the tmpObj object with the course at index "index"
    // This checks if the index is valid or not and throws an indexOutOfBoundsException if not
    // valid
    tempObj = this.getCourse(index);

    // Checking if the course has/has not been assigned to a room. If not, throwing an
    // IllegalArgumentException

    if (!(this.isAssigned(index))) {
      throw new IllegalArgumentException(
          "Invalid Input: The course at index " + index + " has " + "not been assigned yet");
    }

    //Now that we have checked that both the index is valid and the course is assigned with a
    // room,returning the room assigned with the course at index "index"

    roomIndex = assignments[index];
    return this.getRoom(roomIndex);
  }

  /**
   * This method checks whether all the courses have been assigned to rooms or not
   *
   * @return (boolean) returns true if and only if all courses have been assigned to rooms, false
   * otherwise
   */
  public boolean isComplete() {
    // Declaring local variables
    int i; // loop control variable

    // Running a for loop to iterate through index of each course
    for (i = 0; i < this.getNumCourses(); i++) {
      if (!(this.isAssigned(i))) {
        return false;
      }
    }

    //Since the whole for loop has been iterated through, all courses have been assigned and so
    // retuning true
    return true;
  }

  /**
   * Creates a schedule with the course at the first argument index assigned to the room at the
   * second argument index passed in
   *
   * @param courseIndex the index of the course to be assigned
   * @param roomIndex   the index of the room to be assigned
   * @return (Schedule) returns a new Schedule object with the course at the first argument index
   * assigned to the room at the second argument index
   * @throws IllegalArgumentException  when the room does not have enough capacity or the course
   *                                   has already been assigned a room
   * @throws IndexOutOfBoundsException when the index of the course or the room array is invalid
   *                                   in the passed parameters
   */
  public Schedule assignCourse(int courseIndex, int roomIndex) throws IllegalArgumentException,
      IndexOutOfBoundsException {
    // Declaring local variables
    Room[] roomDeepCopy;
    Course[] courseDeepCopy;
    int[] assignmentsDeepCopy;
    Schedule objToReturn;

    // Checking exception conditions

    // Checking if the room or the course index is invalid using the getRoom() and getCourse()
    // methods which check for the same
    this.getRoom(roomIndex);
    this.getCourse(courseIndex);

    if ((courseIndex < 0 || courseIndex >= courses.length) || (roomIndex < 0
        || roomIndex >= rooms.length)) {
      throw new IndexOutOfBoundsException("Given course or room index is invalid");
    }

    // Checking if the given course has already been assigned with a room
    if (this.isAssigned(courseIndex)) {
      throw new IllegalArgumentException("Invalid Input: The course index passed to the "
          + "assignCourse() method has already been assigned");
    }

    // Creating the new Schedule Object
    // Creating the deep copy of courses, rooms and assignments
    roomDeepCopy = Arrays.copyOf(this.rooms, this.rooms.length);
    courseDeepCopy = Arrays.copyOf(this.courses, this.courses.length);
    assignmentsDeepCopy = Arrays.copyOf(this.assignments, this.assignments.length);

    //Reducing Capacity for the specific room
    roomDeepCopy[roomIndex] =
        roomDeepCopy[roomIndex].reduceCapacity(courseDeepCopy[courseIndex].getNumStudents());

    // Assign room to course through assignments
    assignmentsDeepCopy[courseIndex] = roomIndex;

    //Creating the new scheduled object and returning it
    objToReturn = new Schedule(roomDeepCopy, courseDeepCopy, assignmentsDeepCopy);

    //returning
    return objToReturn;
  }

  /**
   * Creates a String representation of the given Schedule containing the corresponding room and
   * course assignments
   *
   * @return returns the string representation of a given schedule
   */
  @Override public String toString() {
    // Defining local variables
    String strReturn = "{";
    String tmpStr;
    int i;

    //running a for loop to iterate through each course
    for (i = 0; i < this.courses.length; i++) {
      if (!this.isAssigned(i)) {
        tmpStr = this.courses[i].getName() + ": " + "Unassigned";
      } else
        tmpStr = this.courses[i].getName() + ": " + this.rooms[assignments[i]].getLocation();
      strReturn = strReturn + tmpStr + ", ";
    }
    //Removing last ", "
    strReturn = strReturn.substring(0, strReturn.length() - 2);
    strReturn = strReturn + "}";
    return strReturn;
  }
}

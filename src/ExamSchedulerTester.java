import java.util.ArrayList;

public class ExamSchedulerTester {

  public static void main(String[] args) {
    //Running tests
    System.out.println("testCourse(): " + testCourse());
    System.out.println("testRoom(): " + testRoom());
    System.out.println("testAssignCourse(): " + testAssignCourse());
    System.out.println("testScheduleAccessors(): " + testScheduleAccessors());
    System.out.println("testFindSchedule(): " + testFindSchedule());
    System.out.println("testFindAllSchedules(): " + testFindAllSchedules());
  }

  // Implementing the testCourse() method
  public static boolean testCourse() {
    return testCourseValidInputTester() && testCourseInvalidInputTester();
  } // testCourse ends

  public static boolean testRoom() {
    return testRoomValidInputTester() && testRoomInvalidInputTester();
  }

  public static boolean testScheduleAccessors() {
    // todo
    return testScheduleAccessorsValidInputTester() && testScheduleAccessorsInvalidInputTester();
  }

  public static boolean testAssignCourse() {
    return testAssignCourseValidInputTester() && testAssignCourseInvalidInputTester();
  }

  public static boolean testFindSchedule() {
    return testFindScheduleValidInputTester() && testFindScheduleInvalidInputTester();
  }

  public static boolean testFindAllSchedules(){
    return testFindAllScheduleValidInputTester() /*&& testFindAllScheduleInvalidInputTester()*/;
  }

  private static boolean testCourseValidInputTester() {
    //Defining local variables
    String testName; // String parameter for testing testCourse
    int testNumStudents; // int parameter for testng testCourse
    Course testObj; //Object to test course with

    // Define test case
    //Test 1: getName() correctly returns String value of name which was initialized using
    // the constructor
    // Assigning values to variables
    testName = "CS300";
    testNumStudents = 1000;
    //Testing
    try {
      // Creating Course Object with test Values
      testObj = new Course(testName, testNumStudents);

      //Checking test condition if the getName methods returns name of course correctly
      if (!(testObj.getName().equals(testName))) {
        System.out.println("Problem Detected: Your getName() method does not return the String "
            + "variable that was passed to it at Object Creation");
        return false;
      }
    } catch (Exception e) {
      // the object creation should not throw an exception. Returning false if it does
      e.printStackTrace();
      System.out.println("Problem Detected: Your Course class's getName method threw an "
          + "exception when it shouldn't have");
      return false;
    }

    // Test 2: getNumStudents() correctly returns the int value of the numStudents variable
    // which was initialized/set using the class' parameterized constructor
    // Assigning values to variables
    testName = "CS300";
    testNumStudents = 1000;
    //Testing
    try {
      // Creating Course Object with test Values
      testObj = new Course(testName, testNumStudents);

      //Checking test condition if the getName methods returns name of course correctly
      if (testObj.getNumStudents() != testNumStudents) {
        System.out.println("Problem Detected: Your getNumStudents() method does not return the "
            + "int variable that was passed to it at Object Creation" + " ");
        return false;
      }
    } catch (Exception e) {
      // the object creation should not throw an exception. Returning false if it does
      e.printStackTrace();
      System.out.println("Your Course class's getNumStudents method threw an exception when it "
          + "shouldn't have");
      return false;
    }
    // All the above tests passed so returning true
    return true;
  }

  private static boolean testCourseInvalidInputTester() {
    //Defining local variables
    String testName; // String parameter for testing testCourse
    int testNumStudents; // int parameter for testng testCourse
    Course testObj; //Object to test course with

    // Define test case (test case 1 and 2 in ValidInputTester)
    // Test 3: Constructor throws an IllegalArgumentException (when int value < 0)
    // Assigning appropriate values to variables
    testName = "CS 300";
    testNumStudents = -1; //negative value
    //Testing
    try {
      // Course Object Creation
      testObj = new Course(testName, testNumStudents);
      // Expected: Constructor should throw an IllegalArgument Exception since value of
      // numStudents is negative
      System.out.println("Problem Detected: Your class Course's constructor does not throw an "
          + "exception when it should");
      return false; // since this line should not be reached
    } catch (IllegalArgumentException e) {
      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Problem Detected: Exception message does not have a description");
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your class Course's constructor throws an Exception"
          + " other than an IllegalArgument Exception when passed a negative int value");
      return false;
    }
    // All the above tests passed so returning true
    return true;
  }

  private static boolean testRoomValidInputTester() {
    // Defining local variables
    String testLocation;
    int testCapacity;
    Room testObj;
    int numToReduce;
    int reducedCapacity;

    // Define test cases
    // Test 1: Make sure the constructor sets the location of the room correctly and it is
    // correctly returned by the getLocation() method
    // Initializing Variables
    testLocation = "Noland 168";
    testCapacity = 258;
    // Testing
    try {
      // Object creation with test values
      testObj = new Room(testLocation, testCapacity);
      // Test-Condition
      if (!testObj.getLocation().equals(testLocation)) {
        System.out.println("Problem Detected: Your method getLocation() does not return the same"
            + " location as it was initialized with using the constructor");
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your method getLocation() threw an exception when "
          + "it shouldn't have");
      return false;
    }

    // Test 2: Make sure the constructor sets the capacity of the room correctly and it is
    // correctly returned by the getCapacity() method
    // Initializing Variables
    testLocation = "Noland 168";
    testCapacity = 258;
    // Testing
    try {
      // Object creation with test values
      testObj = new Room(testLocation, testCapacity);
      // Test-Condition
      if (testObj.getCapacity() != testCapacity) {
        System.out.println("Problem Detected: Your method getCapacity() does not return the same"
            + " location as it was initialized with using the constructor");
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your method getCapacity() threw an exception when "
          + "it shouldn't have");
      return false;
    }

    // Test 3: Checks if reduceCapacity correctly reduces capacity
    // Initializing variables
    testLocation = "Noland 168";
    testCapacity = 258;
    numToReduce = 18;
    reducedCapacity = testCapacity - numToReduce;
    //Testing
    try {
      // Object Creation
      testObj = new Room(testLocation, testCapacity);
      // Reducing Capacity
      testObj = testObj.reduceCapacity(numToReduce);
      // Checking test condition
      if (testObj.getCapacity() != reducedCapacity) {
        System.out.println("Problem detected: Your method reducedCapacity() does not reduce the"
            + " capacity as expected");
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your method reducedCapacity() threw an Exception "
          + "when it was being tested");
      return false;
    }
    // If this line is reached, all above tests pass and so true is returned
    return true;
  }

  private static boolean testRoomInvalidInputTester() {
    // Defining local variables
    String testLocation;
    int testCapacity;
    Room testObj;
    int numToReduce;
    int reducedCapacity;

    // Define test cases (test 4 and 5)
    // Test 4: Check if the right exception is passed by the constructor when the integer
    // passed in is negative
    // Assigning test variables
    testLocation = "Noland 168";
    testCapacity = -1; // negative
    //Testing
    try {
      // Object Creation
      testObj = new Room(testLocation, testCapacity);
      // Expected: Constructor should throw an IllegalArgumentException with a descriptive
      // error message
      // If this line is reached, then the exception is not thrown so returning false
      System.out.println("Problem Detected: Your constructor did not throw an exception when "
          + "passed a negative int value as input");
      return false;
    } catch (IllegalArgumentException e) {
      // Right Exception thrown
      // Checking for descriptive message
      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Problem Detected: The Exception which your constructor threw when "
            + "it was passed a negative value did ot have a descriptive message");
        return false;
      }
    } catch (Exception e) {
      // Wrong exception was passed
      e.printStackTrace();
      System.out.println("Problem Detected: Your class Room's constructor did not throw the "
          + "right exception when it was passed a negative value");
      return false;
    }

    // Test 5: Check if the right exception with a descriptive error message is passed when
    // argument is greater than the given room’s capacity
    // Assigning test variables
    testLocation = "Noland 168";
    testCapacity = 258;
    numToReduce = 259; // more than the given room capacity

    // Testing
    try {
      // Object Creation
      testObj = new Room(testLocation, testCapacity);
      // Calling the reduceCapacity() method
      testObj.reduceCapacity(numToReduce);
      // Expected: The reduceCapacity() method should throw an IllegalArgumentException
      System.out.println("Problem Detected: Your method reduceCapacity() does not throw an "
          + "exception when the integer argument passed to it is bigger than its given capacity");
      return false;
    } catch (IllegalArgumentException e) {
      // Right Exception was thrown
      // Checking for descriptive error message
      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println(" Problem Detected: Your method() reduceCapacity() does have a "
            + "descriptive message with the Exception it throws");
        return false;
      }
    } catch (Exception e) {
      // Some other exception was thrown
      e.printStackTrace();
      System.out.println("Problem Detected: Your method reduceCapacity() passes an exception "
          + "other than an IllegalArgumentException when passed an integer value bigger than "
          + "the Room's given capacity");
      return false;
    }

    return true;
  }

  private static boolean testScheduleAccessorsValidInputTester() {
    // Declaring local variables
    Course[] testCourses;
    Room[] testRooms;
    int[] testAssignments;
    Course testCourse;
    Room testRoom;
    Schedule testSchedule;
    String expectedString;

    /*
    The functionality of the constructor will be indirectly tested by testing the methods of
    the class Schedule
     */

    // Define test scenarios

    // Test 1: Makes sure the constructor correctly initializes the course array to the right
    // number of elements and at the same array too.

    // Assigning variables
    testCourse = new Course("CS 200", 254);
    testCourses = new Course[] {null, null, null, testCourse, null};
    testRooms = new Room[] {null, null, new Room("Noland 168", 280), null, null};

    // Expected: Constructors correctly sets the array passed to it as data fields in the
    // class and constructor initializes an assignments array of the same length as the course

    // Testing
    try {
      //Creating new schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      // Condition 1 (getNumCourses() works)
      if (testSchedule.getNumCourses() != testCourses.length) {
        System.out.println("Problem Detected: Your getNumCourses() method does not correctly "
            + "return the size of the courses array which the Schedule Object was assigned to "
            + "during object Creation");
        return false;
      }

      // Condition 2 (getCourse() works)
      if (!(testSchedule.getCourse(3).equals(testCourse))) {
        System.out.println("Problem Detected: Your method getCourse does not correctly return "
            + "the course Object at the desired index");
        return false;
      }
    } catch (Exception e) {
      // Program throws exception when it shoouldn't
      e.printStackTrace();
      System.out.println("Your constructor, getCourse() or getNumCourses() methods threw an "
          + "exception when they shouldn't have");
      return false;
    }

    // Test 2: Make sure that the constructor correctly initializes the room array to the
    // correct number of elements and the right elements

    // Assigning Variables
    testRoom = new Room("Noland 168", 280);
    testCourse = new Course("CS 200", 254);
    testCourses = new Course[] {null, null, null, testCourse, null};
    testRooms = new Room[] {null, null, testRoom, null, null};

    // Expected: Constructors correctly sets the array passed to it as data fields in the
    // class and constructor initializes an assignments array of the same length as the course

    // Testing
    try {
      //Creating new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      // Condition 1 (getNumRooms() returns the size of the array)
      if ((testSchedule.getNumRooms() != testRooms.length)) {
        System.out.println("Problem Detected: Your getNumRooms() method does not correctly "
            + "return the size of the rooms array which the Schedule Object was assigned to "
            + "during object Creation");
        return false;
      }

      // Condition 2 (getRoom() returns the correct Room Object at the correct index)
      if (!(testSchedule.getRoom(2).equals(testRoom))) {
        System.out.println("Problem Detected: Your method getRoom() does not correctly return "
            + "the Room Object at the desired index");
        return false;
      }
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
      System.out.println("Your constructor, getRoom() or getNumRooms() methods threw an "
          + "exception when they shouldn't have");
      return false;
    }

    //Test 3: Testing the isAssigned() method

    // Assigning the variables
    testRoom = new Room("Noland 168", 280);
    testCourse = new Course("CS 200", 254);
    testCourses = new Course[] {null, null, null, testCourse, null};
    testRooms = new Room[] {null, null, testRoom, null, null};

    //Testing
    try {
      // Creating a new Schedule
      testSchedule = new Schedule(testRooms, testCourses);

      // Condition 1 (isAssigned() returns false for an unassigned room for a newly created
      // Schedule Object)
      if (testSchedule.isAssigned(3)) {
        // If isAssigned() returns true
        System.out.println("Problem Detected: Your isAssigned() method returns true for an "
            + "unassigned course too");
        return false;
      }

      // Assigning the room at index 2 to the course at index 3
      testSchedule = testSchedule.assignCourse(3, 2);

      //Condition 2 (isAssigned() should return true now that the course has been assigned a room
      if (!testSchedule.isAssigned(3)) {
        // If isAssigned() returns false
        System.out.println("Problem Detected: Your isAssigned() course returns fals for a room "
            + "that has already been assigned");
        return false;
      }
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your isAssigned() threw an exception when it was "
          + "being tested with valid inputs");
      return false;
    }

    // Test 4: Testing the isComplete() method

    // Assigning the variables
    testRoom = new Room("Noland 168", 280);
    testCourse = new Course("CS 200", 254);
    testCourses = new Course[] {testCourse, testCourse, testCourse, testCourse, testCourse};
    testRooms = new Room[] {testRoom, testRoom, testRoom, testRoom, testRoom};

    // Testing
    try {
      // Creating new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      // Condition 1 (Checking if isComplete() gives false for a newly created schedule Object
      if (testSchedule.isComplete()) {
        // If isComplete() returns true
        System.out.println("Problem Detected: Your isComplete() returns true even when all of "
            + "the courses have not been assigned (for a newly created Schedule Object");
        return false;
      }

      // Assigning each course to a room
      testSchedule = testSchedule.assignCourse(0, 0);
      testSchedule = testSchedule.assignCourse(1, 1);
      testSchedule = testSchedule.assignCourse(2, 2);
      testSchedule = testSchedule.assignCourse(3, 3);
      testSchedule = testSchedule.assignCourse(4, 4);

      // Now that course has been assigned, isComplete() should return true
      // Condition 2 (isComplete() returns true for all objects being assigned)
      if (!testSchedule.isComplete()) {
        // If isComplete () returns false
        System.out.println("Problem Detected: Your isComplete() method returns false for "
            + "Schedule Object where all of course have been assigned to rooms");
        return false;
      }
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your isComplete() method threw an exception whe it "
          + "should have not");
      return false;
    }

    // Test 5: Testing the getAssignment() method

    //Assigning the variables
    testRoom = new Room("Noland 168", 280);
    testCourse = new Course("CS 200", 254);
    testCourses = new Course[] {null, null, null, testCourse, null};
    testRooms = new Room[] {null, null, testRoom, null, null};

    //Testing
    try {
      // Create a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      // Assigning course at index 3 to room at index 2
      testSchedule = testSchedule.assignCourse(3, 2);

      // Condition 1 (Checking if getAssignment() returns back the same room Object which was
      // assigned with the statement above
      if (!(testSchedule.getAssignment(3).getLocation().equals(testRoom.getLocation()))) {
        System.out.println("Problem Detected: Your getAssignment() method does not return the "
            + "same room which was passed to the Schedule Object and assigned earlier");
        return false;
      }
    } catch (Exception e) {
      // method throws exception when it shouldn't
      e.printStackTrace();
      System.out.println("Problem Detected: Your getAssignment() method threw an exception when"
          + " passed valid inputs");
      return false;
    }

    // Test 6: Testing the toString method

    // Assigning Variables
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 20), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 200)};
    expectedString = "{CS300: AG 125, CS200: HUM 3650, CS400: Unassigned}";

    // Testing
    try {
      // Creating new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      // Assigning course
      testSchedule = testSchedule.assignCourse(0, 0);
      testSchedule = testSchedule.assignCourse(1, 2);

      // Condition: Making sure that the toString method returns the contents of the Schedule
      // Object in the right Notation
      if (!testSchedule.toString().equals(expectedString)) {
        System.out.println("Problem Detected: Your toString method does not return the right "
            + "String when passed valid inputs");
        return false;
      }
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your toString() method in Schedule threw an "
          + "exception when passed valid inputs");
      return false;
    }

    // If all tests pass, return true
    return true;
  }

  private static boolean testScheduleAccessorsInvalidInputTester() {
    // Defining local variables
    Course[] testCourses;
    Room[] testRooms;
    Course testCourse;
    Room testRoom;
    Schedule testSchedule;

    // Define test scenarios
    // Test 1: getRoom() gives index out bounds exception if the the index is negative or more
    // than equal to the length of the Course Array

    // Assigning variables
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 20), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 200)};

    // Testing
    try {
      // Expected: getCourse() throws an IndexOutOfBoundsException with a descriptive message
      // Creating a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      // Condition 1 (Try calling the getCourse() method with an invalid index
      Course tmpCourse = testSchedule.getCourse(5);

      // If this line is reached, the exception is not thrown thus returning false;
      return false;
    } catch (IndexOutOfBoundsException e) {
      // This is the expected behaviour
      // Checking if the exception was thrown with a descriptive message
      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Your method getCourse() throws an IndexOutOfBounds "
            + "Exception without a descriptive message");
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your getCourse() method throws an Exception other "
          + "than the IndexOutOfBounds Exception when called with an invalid index");
      return false;
    }

    // Test 2: getCourse() gives index out bounds exception if the index is negative or more
    // than equal to the length of the Course Array

    // Assigning variables
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 20), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 200)};

    // Testing
    try {
      // Expected: getCourse() throws an IndexOutOfBoundsException with a descriptive message
      // Creating a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      // Condition 1 (Try calling the getCourse() method with an invalid index
      Room tmpRoom = testSchedule.getRoom(5);

      // If this line is reached, the exception is not thrown thus returning false;
      return false;
    } catch (IndexOutOfBoundsException e) {
      // This is the expected behaviour
      // Checking if the exception was thrown with a descriptive message
      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Your method getRoom() throws an IndexOutOfBounds "
            + "Exception without a descriptive error message");
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your getRoom() method throws an Exception other "
          + "than the IndexOutOfBounds Exception when called with an invalid index");
      return false;
    }


    // Test 3: The getAssignment() method throws an IndexOutOfBounds Exception of the integer
    // passed is invalid

    // Assigning Variables
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 20), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 200)};

    // Testing
    try {
      // Expected: getAssignment() throws an IndexOutOfBoundsException with a descriptive message
      // Creating a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      // Condition 1 (Try calling the getAssignment() method with an invalid index)
      Room tmpRoom = testSchedule.getAssignment(5);

      // If this line is reached, the exception is not thrown thus returning false;
      return false;
    } catch (IndexOutOfBoundsException e) {
      // This is the expected behaviour
      // Checking if the exception was thrown with a descriptive message
      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Your method getAssignment() throws an IndexOutOfBounds "
            + "Exception with no descriptive message");
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(
          "Problem Detected: Your getAssignment() method throws an Exception " + "other "
              + "than the IndexOutOfBounds Exception when called with an invalid index");
      return false;
    }

    // Test 4: The getAssignment() method throws an IllegalArgumentException if the course has
    // not been assigned a room

    //Assigning Values
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 20), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 200)};

    // Testing
    try {
      // Creating a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      // Calling getAssignment()
      // Expected: Should throw an IllegalArgumentException
      Room tmpRoom = testSchedule.getAssignment(1);

      //If this line is reached, then an exception was not thrown thus returning false
      return false;
    } catch (IllegalArgumentException e) {
      // This is the expected behaviour
      // Checking if the Exception was thrown with a descriptive error message or not
      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Problem Detected: Your method getAssignment() threw an "
            + "IllegalArgumentException without a descriptive error message");
        return false;
      }
    } catch (Exception e) {
      // Unexpected exception thrown
      e.printStackTrace();
      System.out.println("Problem Detected: Your getAssignment() method threw an exception "
          + "other than an IllegalArgumentException when passed an unassigned course index");
      return false;
    }

    // todo
    return true;
  }

  private static boolean testAssignCourseValidInputTester() {
    // Declaring local variables
    Course[] testCourses;
    Room[] testRooms;
    Schedule testSchedule;
    // Define Test Scenarios
    // Test 1: Assigning the course and then testing with isAssigned() and the getCapacity()
    // methods

    // Assigning Variables
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 20), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 200)};

    // Testing
    try {
      // Creating a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      //Assigning course at index 1 to room at index 2
      testSchedule = testSchedule.assignCourse(1, 2);

      // Condition 1 (Checking if isAssigned() gives true and checking change in capacity with
      // getCapacity
      if (!(testSchedule.isAssigned(1) && (testSchedule.getRoom(2).getCapacity() == 180))) {
        System.out.println("Problem Detected: Your method assignCourse() does not assign "
            + "properly or reduce capacity");
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your method assignCourse() threw an exception with "
          + "valid inputs");
      return false;
    }

    // todo
    return true;
  }

  private static boolean testAssignCourseInvalidInputTester() {
    // Declaring local variables
    Course[] testCourses;
    Room[] testRooms;
    Schedule testSchedule;

    // Test 1: assignCourse() gives IndexOutOfBounds exception for an invalid course index
    // Assigning Variables
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 20), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 200)};

    // Testing
    try {
      // Creating a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      //Assigning course at index 5 (invalid) to room at index 2
      testSchedule = testSchedule.assignCourse(5, 2);

      // If program continues past this, exception is not passed as expected so returning false
      System.out.println("Problem Detected: Your assignCourse() method does not throw an "
          + "exception when passed an invalid course index");
      return false;

    } catch (IndexOutOfBoundsException e) {

      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Problem Detected: IndexOutOfBounds Exception does not have a "
            + "descriptive message");
        return false;
      }

    } catch (Exception e) {
      // wrong exception thrown
      e.printStackTrace();
      System.out.println("Problem Detected: Your assignCourse() method threw an exception "
          + "other than IndexOutOfBoundsException when passed an invalid course index");
      return false;
    }

    // Test 2: assignCourse() gives IndexOutOfBounds exception for an invalid room index
    // Assigning Variables
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 20), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 200)};

    // Testing
    try {
      // Creating a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      //Assigning course at index 1 to room at index 5 (invalid)
      testSchedule = testSchedule.assignCourse(1, 5);

      // If program continues past this, exception is not passed as expected so returning false
      System.out.println("Problem Detected: Your assignCourse() method does not throw an "
          + "exception when passed an invalid room index");
      return false;

    } catch (IndexOutOfBoundsException e) {

      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Problem Detected: IndexOutOfBounds Exception does not have a "
            + "descriptive message");
        return false;
      }

    } catch (Exception e) {
      // wrong exception thrown
      e.printStackTrace();
      System.out.println("Problem Detected: Your assignCourse() method threw an exception "
          + "other than IndexOutOfBoundsException when passed an invalid room index");
      return false;
    }

    // Test 3: assignCourse() gives IllegalArgumentException if the given course has already
    // been assigned
    // Assigning Variables
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 20), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 200)};

    // Testing
    try {
      // Creating a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      //Assigning course at index 1 to room at index 5 (invalid)
      testSchedule = testSchedule.assignCourse(1, 2);
      // Assigning it a second time
      testSchedule = testSchedule.assignCourse(1, 2);

      // If program continues past this, exception is not passed as expected so returning false
      System.out.println("Problem Detected: Your assignCourse() method does not throw an "
          + "exception when an already assigned room is assigned again");
      return false;

    } catch (IllegalArgumentException e) {

      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Problem Detected: IllegalOutOfBounds Exception does not have a "
            + "descriptive message");
        return false;
      }

    } catch (Exception e) {
      // wrong exception thrown
      e.printStackTrace();
      System.out.println("Problem Detected: Your assignCourse() method threw an exception "
          + "other than IllegalArgumentException when an already assigned room is assigned "
          + "again");
      return false;
    }

    // Test 4: assignCourse() gives IllegalArgumentException if the given room does not have
    // sufficient capacity
    testCourses =
        new Course[] {new Course("CS300", 20), new Course("CS200", 100), new Course("CS400", 20)};
    testRooms = new Room[] {new Room("AG 125", 200), new Room("Noland 168", 200),
        new Room("HUM " + "3650", 99)};

    // Testing
    try {
      // Creating a new Schedule Object
      testSchedule = new Schedule(testRooms, testCourses);

      //Assigning course at index 1 to room at index 5 (invalid)
      testSchedule = testSchedule.assignCourse(1, 2);

      // If program continues past this, exception is not passed as expected so returning false
      System.out.println("Problem Detected: Your assignCourse() method does not throw an "
          + "exception when called on a room that does not have sufficient capacity");
      return false;

    } catch (IllegalArgumentException e) {

      if (e.getMessage() == null || e.getMessage().length() == 0) {
        System.out.println("Problem Detected: IllegalOutOfBounds Exception does not have a "
            + "descriptive message");
        return false;
      }

    } catch (Exception e) {
      // wrong exception thrown
      e.printStackTrace();
      System.out.println("Problem Detected: Your assignCourse() method threw an exception "
          + "other than IllegalArgumentException when an already assigned room is assigned "
          + "again");
      return false;
    }

    return true;
  }

  private static boolean testFindScheduleValidInputTester() {
    return false;
  }

  private static boolean testFindScheduleInvalidInputTester() {
    return false;
  }

  private static boolean testFindAllScheduleValidInputTester() {
    // Declaring local variables
    Course[] testCourses;
    Room[] testRooms;
    ArrayList<Schedule> testSchedulesList;
    String testString = "";
    // Defining test scenarios
    // Test 1: Passing in a valid room and course array input and checking if the right output
    // is returned

    //Assigning Variables
    testCourses = new Course[]{new Course("CS200", 50), new Course("CS300", 110),
        new Course("CS400", 75)};
    testRooms = new Room[]{new Room("Room1", 100), new Room("Room2", 150), new Room(
        "Room3", 75)};

    // Testing
    try {
      testSchedulesList = ExamScheduler.findAllSchedules(testRooms, testCourses);
      // Converting returned ArrayList into a String for easier comparison
      for (Schedule testSchedulePointer : testSchedulesList) {
        testString = testString + testSchedulePointer.toString();
      }
      // Condition 1
      if (!testString.equals("{CS200: Room1, CS300: Room2, CS400: Room3}{CS200: Room3, CS300: "
          + "Room2, CS400: Room1}")) {
        System.out.println();
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Problem Detected: Your findAllSchedules() method does not return the "
          + "expected schedule ");
      return false;
    }
    return true;
  }

  private static boolean testFindAllScheduleInvalidInputTester() {
    return false;
  }


}

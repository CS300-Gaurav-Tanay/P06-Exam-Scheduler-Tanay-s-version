public class ExamSchedulerTester {

  public static void main(String[] args) {
    //Running tests
    System.out.println("testCourse(): " + testCourse());
    System.out.println("testRoom(): " + testRoom());
  }

  // Implementing the testCourse() method
  public static boolean testCourse() {
    return testCourseValidInputTester() && testCourseInvalidInputTester();
  } // testCourse ends

  public static boolean testRoom() {
    return testRoomValidInputTester() && testRoomInvalidInputTester();
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
            + "int variable that was passed to it at Object Creation"
            + " ");
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
}

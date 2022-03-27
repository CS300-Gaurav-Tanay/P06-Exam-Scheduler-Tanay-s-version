public class ExamSchedulerTester {

  public static void main(String[] args) {
    //Running tests
    System.out.println("testCourse(): " + testCourse());
  }

  // Implementing the testCourse() method
  public static boolean testCourse() {
    return /*testCourseValidInputTester() &&*/ testCourseInvalidInputTester();
  } // testCourse ends

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
}

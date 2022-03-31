public class Course {
  // Defining data fields
  private String name ; // Name of the Course
  private int numStudents; // Number of Students in the course

  //Implementing Constructor
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

  public String getName(){
    return this.name;
  } // getName() ends

  public int getNumStudents(){
    return this.numStudents;
  } // getNumStudents() ends

}

import java.util.Arrays;

public class Schedule {
  // Defining data fields
  private Room[] rooms; // an array of the Room objects available for exams
  private Course[] courses; // an array of the Course objects which require exam rooms
  private int[] assignments; // an array where the integer at index N is the index of the room
  // that course[N] has been assigned to

  // Implementing the constructors

  public Schedule(Room[] rooms, Course[] courses) {
    // Initializing the rooms and the courses array
    this.rooms = rooms;
    this.courses = courses;
    // Initializing assignment array to be the length of the courses array and the making each
    // element -1
    this.assignments = new int[this.courses.length];
    Arrays.fill(this.assignments, -1);
  }

  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
    // Initializing the rooms and the courses array
    this.rooms = rooms;
    this.courses = courses;
    // Initializing assignments to the provided value
    this.assignments = assignments;
  }

  // Implementing methods
  public int getNumRooms() {
    return this.rooms.length;
    //todo: confirm implementation with professor
  }

  public Room getRoom(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= rooms.length) {
      // todo: check with gaurav
      // index is invalid
      throw new IndexOutOfBoundsException("Invalid Input: the integer parameter passed in to "
          + "the getRoom() method is either negative (< 0) more than/equal to the size of the "
          + "rooms array");
    }

    return this.rooms[index];
  }

  public int getNumCourses() {
    return this.courses.length;
  }

  public Course getCourse(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= courses.length) {
      // todo: check with gaurav
      // index is invalid
      throw new IndexOutOfBoundsException("Invalid Input: the integer parameter is either "
          + "negative (< 0) more than/equal to the size of the courses array");
    }

    return this.courses[index];
  }

  public boolean isAssigned(int index) {
    // Since the course and the assignments are a parallel array
    if (assignments[index] != -1) {
      return true;
    } else {
      return false;
    }

    // todo: check with gaurav and the professor
  }

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
  
  public Schedule assignCourse(int courseIndex, int roomIndex) throws IllegalArgumentException {
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

  @Override public String toString() {
    // Defining local variables
    String strReturn = "{";
    String tmpStr;
    int i;

    //running a for loop to iterate through each course
    for (i = 0; i < this.courses.length; i++) {
      if (!this.isAssigned(i)) {
        tmpStr = this.courses[i].getName() + ": " + "Unassigned";
      }
      else
        tmpStr = this.courses[i].getName() + ": " + this.rooms[assignments[i]].getLocation();
      strReturn = strReturn + tmpStr + ", ";
    }
    //Removing last ", "
    strReturn = strReturn.substring(0, strReturn.length() - 2);
    strReturn = strReturn + "}";
    return strReturn;
  }
}

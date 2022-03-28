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

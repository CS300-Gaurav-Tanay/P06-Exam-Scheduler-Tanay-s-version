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

import java.util.ArrayList;

/**
 * The ExamScheduler class provides methods to find a single schedule permutation and all possible
 * schedule permutations of the passed in room and courses arrays.
 *
 * @author tanaynagar
 * @author gmchopra
 * @author mounakacem
 * @author legault
 * @version 1.0
 */
public class ExamScheduler {

  /**
   * returns a valid Schedule for the given set of rooms and courses
   *
   * @param rooms   rooms array in which the courses have to be assigned
   * @param courses courses array which has to be assigned to the rooms
   * @return the first schedule which is valid
   * @throws IllegalStateException if no such schedule exists
   */
  public static Schedule findSchedule(Room[] rooms, Course[] courses)
      throws IllegalStateException {
    // Creating a new Schedule Object
    Schedule scheduleToPass = new Schedule(rooms, courses);
    // Calling findScheduleHelper
    return ExamScheduler.findScheduleHelper(scheduleToPass, 0);
  }

  /**
   * recursive method that assigns all unassigned courses in a Schedule beginning from the index
   * provided as an argument
   *
   * @param schedule Schedule Object in which the courses and the rooms have to be assigned
   * @param index    index from which the course have to start being assigned
   * @return (Schedule) The resulting schedule
   * @throws IllegalStateException if no valid Schedule is found
   */
  private static Schedule findScheduleHelper(Schedule schedule, int index)
      throws IllegalStateException {
    // Defining local variables
    int i, j = 0; // loop control variable
    Schedule newSchedule;
    boolean flag = true;

    // Base Case
    // If the provided index is equal to the number of course
    if (index == schedule.getNumCourses()) {
      // if the schedule isComplete
      if (schedule.isComplete()) {
        return schedule;
      } else {
        // Schedule in Invalid
        throw new IllegalStateException("Schedule Invalid");
      }
    }

    // If the provided index corresponds to a course that has already been assigned to a room,
    // recursively assign the courses at the following indexes and return the following schedule
    if (schedule.isAssigned(index)) {
      return findScheduleHelper(schedule, index++);
    } else {
      // If the provided index corresponds to a course that has NOT already been assigned
      // Iteratively try to assign each valid Room
      // Running a for loop
      for (i = 0; i < schedule.getNumRooms(); i++) {

        if (schedule.getRoom(i).getCapacity() >= schedule.getCourse(index).getNumStudents())
          try {
            newSchedule = schedule.assignCourse(index, i);
            return findScheduleHelper(newSchedule, index + 1);
          } catch (IllegalStateException e) {
            // NOTHING
          }
      }
    }
    // no valid Schedule found here
    throw new IllegalStateException("Schedule Invalid");
  }

  /**
   * returns an ArrayList containing all possible Schedules for the given set of rooms and
   * courses. (If none can be created, this ArrayList is empty.)
   *
   * @param rooms   rooms array to which the courses have to be assigned
   * @param courses courses array which are to be assigned to the rooms
   * @return (ArrayList of type Schedule) All Resulting valid Schedules
   */
  public static ArrayList<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {
    return findAllSchedulesHelper(new Schedule(rooms, courses), 0);
  }

  /**
   * recursive method that assigns all unassigned courses in a Schedule in ALL POSSIBLE ways,
   * beginning from the index provided as an argument
   *
   * @param schedule Schedule in which the course and the rooms have to be assigned
   * @param index index from which the course have to start being scheduled
   * @return (ArrayList of type Schedule) All valid resulting Schedules
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int index) {
    // Creating the ArrayList which will be returned
    ArrayList<Schedule> allSchedules = new ArrayList<>();

    // Base Case
    if (index == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        allSchedules.add(schedule);
        return allSchedules;
      }
    }


    if (schedule.isAssigned(index)) {
      allSchedules.addAll(findAllSchedulesHelper(schedule, index + 1));
      return allSchedules;
    } else {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        if (schedule.getRoom(i).getCapacity() >= schedule.getCourse(index).getNumStudents()) {
          Schedule newSchedule = schedule.assignCourse(index, i);
          allSchedules.addAll(findAllSchedulesHelper(newSchedule, index + 1));
        }
      }
    }
    return allSchedules;
  }
} // class ends

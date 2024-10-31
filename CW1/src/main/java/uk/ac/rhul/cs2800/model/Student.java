package uk.ac.rhul.cs2800.model;

import java.util.ArrayList;
import java.util.List;
import uk.ac.rhul.cs2800.exception.NoGradesAvailableException;

/**
 * This is defining a student class.
 */
public class Student {

  List<Grade> grades;

  /**
   * This is defining a student constructor.
   */
  public Student() {
    this.grades = new ArrayList<Grade>();
  }

  /**
   * this is a method that gets the average.
   *
   * @return the sum divided by the grade list size
   * @throws NoGradesAvailableException for when there is no grade available.
   */
  public float getComputerAverage() throws NoGradesAvailableException {
    if (grades.size() < 1) {
      throw new NoGradesAvailableException();
    }

    float sum = 0.00f;
    for (Grade grade : grades) {
      sum += grade.getScore();
    }
    return sum / this.grades.size();
  }

  /**
   * this method calls the another part of the code.
   *
   * @param grade is a parameter taken in by the addGrade method.
   */
  public void addGrade(Grade grade) {
    this.grades.add(grade);
  }

}

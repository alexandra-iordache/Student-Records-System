package uk.ac.rhul.cs2800.model;

import java.util.ArrayList;
import java.util.List;
import uk.ac.rhul.cs2800.exception.NoGradesAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * This class allows adding grades, registering modules, and retrieving module-specific grades.
 */
public class Student {

  private List<Grade> grades;
  private Registration registration;

  /**
   * Constructs a new Student with an empty grade list and a new Registration.
   */
  public Student() {
    this.grades = new ArrayList<>();
    this.registration = new Registration();
  }

  /**
   * Calculates and returns the average of all grades for the student.
   *
   * @return the average grade as a float.
   * @throws NoGradesAvailableException if there are no grades available for calculation.
   */
  public float getComputerAverage() throws NoGradesAvailableException {
    if (grades.isEmpty()) {
      throw new NoGradesAvailableException();
    }

    float sum = 0.00f;
    for (Grade grade : grades) {
      sum += grade.getScore();
    }
    return sum / this.grades.size();
  }

  /**
   * Adds a new grade to the student's list of grades.
   *
   * @param grade the Grade to add.
   */
  public void addGrade(Grade grade) {
    this.grades.add(grade);
  }

  /**
   * Registers a module for the student.
   *
   * @param module the Module to register.
   */
  public void registerModule(Module module) {
    this.registration.registerModule(module);
  }

  /**
   * Adds a grade to a specific module for the student.
   *
   * @param module the Module for which the grade is being added.
   * @param grade  the Grade to add.
   * @throws NoRegistrationException if the student is not registered for the specified module.
   */
  public void addModuleGrade(Module module, Grade grade) throws NoRegistrationException {
    this.registration.addGrade(module, grade);
  }

  /**
   * Retrieves the grade for a specific module.
   *
   * @param module the Module for which the grade is being retrieved.
   * @return the Grade for the specified module.
   * @throws NoRegistrationException if the student is not registered for the specified module.
   */
  public Grade getModuleGrade(Module module) throws NoRegistrationException {
    return this.registration.getGrade(module);
  }
}

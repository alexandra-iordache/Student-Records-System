package uk.ac.rhul.cs2800.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import uk.ac.rhul.cs2800.exception.NoGradesAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * This class allows adding grades, registering modules,
 * and retrieving module-specific grades.
 */

@Entity

public final class Student {

  @Id
  @GeneratedValue
  Long id;


  /**
   * The list of all grades assigned to this student.
   */
  private List<Grade> grades;

  /**
   * The registration object holding module and grade information.
   */
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
   * @return the average grade as a float
   * @throws NoGradesAvailableException if there are no grades available
   */
  public float getComputerAverage() throws NoGradesAvailableException {
    if (this.grades.isEmpty()) {
      throw new NoGradesAvailableException();
    }

    float sum = 0.0f;
    for (Grade grade : this.grades) {
      sum += grade.getScore();
    }
    return sum / this.grades.size();
  }

  /**
   * Adds a new grade to the student's list of grades.
   *
   * @param grade the Grade to add
   */
  public void addGrade(final Grade grade) {
    this.grades.add(grade);
  }

  /**
   * Registers a module for the student.
   *
   * @param module the Module to register
   */
  public void registerModule(final Module module) {
    this.registration.registerModule(module);
  }

  /**
   * Adds a grade to a specific module for the student.
   *
   * @param module the Module for which the grade is being added
   * @param grade the Grade to add
   * @throws NoRegistrationException if the module is not registered
   */
  public void addModuleGrade(final Module module, final Grade grade)
      throws NoRegistrationException {
    this.registration.addGrade(module, grade);
  }

  /**
   * Retrieves the grade for a specific module.
   *
   * @param module the Module for which the grade is being retrieved
   * @return the Grade for the specified module
   * @throws NoRegistrationException if the module is not registered
   */
  public Grade getModuleGrade(final Module module)

      throws NoRegistrationException {
    return this.registration.getGrade(module);
  }

}

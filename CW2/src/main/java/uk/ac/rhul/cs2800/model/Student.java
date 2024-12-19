package uk.ac.rhul.cs2800.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import uk.ac.rhul.cs2800.exception.NoGradesAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * Represents a Student entity, managing their
 * personal details, module registrations, and associated grades.
 */
@Entity
public final class Student {

  /**
   * The primary key identifier for this student.
   */
  @Id
  @GeneratedValue
  private Long id;

  /**
   * The first name of the student.
   */
  private String firstName;

  /**
   * The last name of the student.
   */
  private String lastName;

  /**
   * The username associated with the student.
   */
  private String username;

  /**
   * The email address of the student.
   */
  private String email;

  /**
   * The list of all grades assigned to this student.
   */
  @OneToMany(mappedBy = "student",
      cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<Grade> grades = new ArrayList<>();

  /**
   * The registration object holding module
   * and grade information for this student.
   */
  @OneToOne(cascade = CascadeType.ALL)
  private Registration registration;

  /**
   * Constructs a new Student with an empty grade list and a new Registration.
   */
  public Student() {
    this.grades = new ArrayList<>();
    this.registration = new Registration();
  }

  /**
   * Retrieves the student's unique ID.
   *
   * @return the student's ID
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the student's unique ID.
   *
   * @param id the new ID to assign
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * Retrieves the student's first name.
   *
   * @return the student's first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the student's first name.
   *
   * @param firstName the new first name to assign
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * Retrieves the student's last name.
   *
   * @return the student's last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the student's last name.
   *
   * @param lastName the new last name to assign
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * Retrieves the student's username.
   *
   * @return the student's username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the student's username.
   *
   * @param username the new username to assign
   */
  public void setUsername(final String username) {
    this.username = username;
  }

  /**
   * Retrieves the student's email.
   *
   * @return the student's email address
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the student's email.
   *
   * @param email the new email address to assign
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Retrieves the list of all grades assigned to this student.
   *
   * @return the list of grades
   */
  public List<Grade> getGrades() {
    return grades;
  }

  /**
   * Sets the list of grades for this student.
   *
   * @param grades the new list of grades
   */
  public void setGrades(final List<Grade> grades) {
    this.grades = grades;
  }

  /**
   * Computes the average of all grades for the student.
   *
   * @return the average grade as a float
   * @throws NoGradesAvailableException
   *         if there are no grades available for the student
   */
  public float computeAverage() throws NoGradesAvailableException {
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
   * @throws NoRegistrationException if
   *         the module is not registered for the student
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
   * @throws NoRegistrationException if
   *         the module is not registered for the student
   */
  public Grade obtainModuleGrade(final Module module)
      throws NoRegistrationException {
    return this.registration.getGrade(module);
  }
}

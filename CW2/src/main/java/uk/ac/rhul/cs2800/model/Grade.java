package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * This is a class defined for Grade.
 */
@Entity

public final class Grade {

  /**
   * Doing entities.
   */
  private @Id
  @GeneratedValue
  Long id;

  /**
   * The score for this grade.
   */
  private int score;

  /**
   * Added references to Module so we can map the Map.
   */

  @ManyToOne
  @JoinColumn(name = "module_id")
  private Module module;

  /**
   * Added references to Registration so we can map the Map.
   */

  @ManyToOne
  @JoinColumn(name = "registration_id")
  private Registration registration;

  /**
   * Added references to Student so we can map the Map.
   */

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  /**
   * Constructs a Grade with default score 0.
   */
  public Grade() {
    // default constructor
  }

  /**
   * Constructs a Grade with the given score.
   *
   * @param d the initial score for this Grade
   */
  public Grade(final int d) {
    this.score = d;
  }

  /**
   * Retrieves the score of this grade.
   *
   * @return the score
   */
  public int getScore() {
    return this.score;
  }

  /**
   * Sets the score for this grade.
   *
   * @param newScore the new score
   */
  public void setScore(final int newScore) {
    this.score = newScore;
  }

  /**
   * Gets the Id of the grade.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the id of the grade.
   *
   * @param id to grade
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * Gets module for grade.
   *
   * @return module
   */

  public Module getModule() {
    return module;
  }

  /**
   * Sets the module associated with this grade.
   *
   * @param module the module to associate
   */
  public void setModule(final Module module) {
    this.module = module;
  }

  /**
   * Sets the student associated with this grade.
   *
   * @param student the student to associate
   */
  public void setStudent(final Student student) {
    this.student = student;

  }

  /**
   * Getter and Setter for Student.
   *
   * @return student.
   */
  public Student getStudent() {
    return student;
  }


}

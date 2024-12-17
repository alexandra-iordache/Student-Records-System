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
   * Added references to Module and Registration
   * so we can map the Map<Module, Grade>.
   */

  @ManyToOne
  @JoinColumn(name = "module_id")
  private Module module;

  /**
   * Added references to Module and Registration
   *
   * so we can map the Map<Module, Grade>.
   */

  @ManyToOne
  @JoinColumn(name = "registration_id")
  private Registration registration;

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
   * Retrieves the score.
   *
   * @return the score of this grade
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

}

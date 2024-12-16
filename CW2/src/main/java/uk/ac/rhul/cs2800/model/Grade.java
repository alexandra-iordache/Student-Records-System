package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

/**
 * This is a class defined for Grade.
 */
@Entity

public final class Grade {

  @Id
  @GeneratedValue

  Long id;

  /**
   * The score for this grade.
   */
  private int score;

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

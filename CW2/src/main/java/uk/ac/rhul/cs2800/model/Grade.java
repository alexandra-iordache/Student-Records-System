package uk.ac.rhul.cs2800.model;

/**
 * This is a class defined for Grade.
 */
public class Grade {

  int score;

  /**
   * This is a constructor for the class Grade.
   */
  public Grade() {

  }

  /**
   * This is an instance method.
   *
   * @param d is a paramater inmported in to the grade method
   */
  public Grade(int d) {
    this.score = d;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

}

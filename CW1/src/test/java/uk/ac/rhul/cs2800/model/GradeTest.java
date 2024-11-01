package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * This is a class made to test the Grade class.
 */
public class GradeTest {

  @Test
  // Test 1
  void gradeTest() {
    Grade grade = new Grade();
    grade.setScore(3);
    assertEquals(3, grade.getScore());
  }

  @Test
  // Test 2
  void gradeTestForNewConstructor() {
    Grade grade = new Grade(4);
    assertEquals(4.0, grade.getScore());
  }
}
package uk.ac.rhul.cs2800.model;

//import static org.junit.jupiter.api.Assertion.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradesAvailableException;

/**
 * This is a class made to test the Student class.
 */
public class StudentTest {

  @Test
  // Test 1
  void getComputerAverage() throws NoGradesAvailableException {
    Student student = new Student();
    student.addGrade(new Grade(3));
    student.addGrade(new Grade(1));
    assertEquals(2.0, student.getComputerAverage());
  }

  @Test
  // Test 2
  void getcomputerAverageTestWithoutGrades() {
    assertThrows(NoGradesAvailableException.class, () -> {
      Student student = new Student();
      student.getComputerAverage();
    });
  }

}

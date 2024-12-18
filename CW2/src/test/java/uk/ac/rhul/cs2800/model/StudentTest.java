package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradesAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * This is a class made to test the Student class.
 */
public class StudentTest {

  @Test
  // Test 1
  void testComputeAverage() throws NoGradesAvailableException {
    Student student = new Student();
    student.addGrade(new Grade(3));
    student.addGrade(new Grade(1));
    assertEquals(2.0, student.computeAverage());
  }

  @Test
  // Test 2
  void testComputeAverageWithoutGrades() {
    assertThrows(NoGradesAvailableException.class, () -> {
      Student student = new Student();
      student.computeAverage();
    });
  }

  @Test
  // Test 3
  void testRegisterModule() {
    Student student = new Student();
    Module module = new Module("CS2800", "Software Engineering", true);
    student.registerModule(module);
    // No assertions needed here; if no exception is thrown, registration is assumed successful.
  }

  @Test
  // Test 4
  void testAddModuleGrade() throws NoRegistrationException {
    Student student = new Student();
    Module module = new Module("CS2800", "Software Engineering", true);
    Grade grade = new Grade(85);

    student.registerModule(module);
    student.addModuleGrade(module, grade);

    assertEquals(85, student.obtainModuleGrade(module).getScore());
  }

  @Test
  // Test 5
  void testObtainModuleGradeForUnregisteredModule() {
    Student student = new Student();
    Module module = new Module("CS2800", "Software Engineering", true);

    assertThrows(NoRegistrationException.class, () -> {
      student.obtainModuleGrade(module);
    });
  }

}

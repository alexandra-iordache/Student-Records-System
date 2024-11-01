package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * Tests for the Registration class.
 */
public class RegistrationTest {

  @Test
  void testRegisterModuleAndAddGrade() throws NoRegistrationException {
    Registration registration = new Registration();
    Module module = new Module("CS2800", "Software Engineering", true);
    Grade grade = new Grade(85);

    registration.registerModule(module);
    registration.addGrade(module, grade);

    assertEquals(85, registration.getGrade(module).getScore());
  }

  @Test
  void testGetGradeForUnregisteredModule() {
    Registration registration = new Registration();
    Module module = new Module("CS2800", "Software Engineering", true);

    assertThrows(NoRegistrationException.class, () -> {
      registration.getGrade(module);
    });
  }
}

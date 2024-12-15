package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * Tests for the Registration class.
 */
public class RegistrationTest {

  private Registration registration;
  private Module module;
  private Grade grade;

  @BeforeEach
  void setup() {
    registration = new Registration();
    module = new Module("CS2800", "Software Engineering", true);
    grade = new Grade(85);
  }

  @Test
  // Test 1
  void testAddGradeToRegisteredModule() throws NoRegistrationException {
    registration.registerModule(module); // Register the module first
    registration.addGrade(module, grade); // Add grade for the registered module
    assertEquals(85, registration.getGrade(module).getScore());
  }

  @Test
  // Test 2
  void testAddGradeToUnregisteredModule() {
    Module unregisteredModule = new Module("CS2900", "Advanced Software Engineering", true);

    assertThrows(NoRegistrationException.class, () -> {
      registration.addGrade(unregisteredModule, grade); // Attempt to add grade without registering
    });
  }
}

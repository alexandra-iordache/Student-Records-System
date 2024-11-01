package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Module class.
 */
public class ModuleTest {

  @Test
  void testModuleCreation() {
    Module module = new Module("CS2800", "Software Engineering", true);
    assertEquals("CS2800", module.getCode());
    assertEquals("Software Engineering", module.getName());
    assertEquals(true, module.isMandatoryNonCondonable());
  }
}

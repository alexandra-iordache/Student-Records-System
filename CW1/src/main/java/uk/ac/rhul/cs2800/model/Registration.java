package uk.ac.rhul.cs2800.model;

import java.util.HashMap;
import java.util.Map;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * This class manages module registrations for a student.
 */
public class Registration {

  private Map<Module, Grade> registrations;

  /**
   * Constructor for the Registration class.
   */
  public Registration() {
    registrations = new HashMap<>();
  }

  /**
   * Registers a module for the student.
   *
   * @param module the module to be registered
   */
  public void registerModule(Module module) {
    registrations.putIfAbsent(module, null);
  }

  /**
   * Adds a grade for a registered module.
   *
   * @param module the module to assign the grade
   * @param grade the grade to be added
   * @throws NoRegistrationException if the module is not registered
   */
  public void addGrade(Module module, Grade grade) throws NoRegistrationException {
    if (!registrations.containsKey(module)) {
      throw new NoRegistrationException("Module not registered");
    }
    registrations.put(module, grade);
  }

  /**
   * Gets the grade for a specific module.
   *
   * @param module the module to retrieve the grade for
   * @return the grade for the module
   * @throws NoRegistrationException if the module is not registered
   */
  public Grade getGrade(Module module) throws NoRegistrationException {
    if (!registrations.containsKey(module)) {
      throw new NoRegistrationException("Module not registered");
    }
    return registrations.get(module);
  }
}

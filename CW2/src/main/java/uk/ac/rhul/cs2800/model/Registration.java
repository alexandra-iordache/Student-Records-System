package uk.ac.rhul.cs2800.model;

import java.util.HashMap;
import java.util.Map;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * This class manages module registrations for a student.
 */
@Entity
public final class Registration {

  @Id
  @GeneratedValue
  Long id;

  /**
   * A mapping from Module objects to their Grade.
   */
  private Map<Module, Grade> registrations;

  /**
   * Constructor for the Registration class.
   * Uses a HashMap to store modules and their associated grades.
   */
  public Registration() {
    this.registrations = new HashMap<>();
  }

  /**
   * Registers a module for the student.
   *
   * @param module the module to be registered
   */
  public void registerModule(final Module module) {
    this.registrations.putIfAbsent(module, null);
  }

  /**
   * Adds a grade for a registered module.
   *
   * @param module the module to assign the grade
   * @param grade the grade to be added
   * @throws NoRegistrationException if the module is not registered
   */
  public void addGrade(final Module module, final Grade grade)

      throws NoRegistrationException {
    if (!this.registrations.containsKey(module)) {
      throw new NoRegistrationException("Module not registered");
    }
    this.registrations.put(module, grade);
  }

  /**
   * Gets the grade for a specific module.
   *
   * @param module the module to retrieve the grade for
   * @return the grade for the module
   * @throws NoRegistrationException if the module is not registered
   */
  public Grade getGrade(final Module module) throws NoRegistrationException {
    if (!this.registrations.containsKey(module)) {
      throw new NoRegistrationException("Module not registered");
    }
    return this.registrations.get(module);
  }

}

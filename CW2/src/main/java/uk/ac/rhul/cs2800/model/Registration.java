package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;
import java.util.HashMap;
import java.util.Map;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * This class manages module registrations for a student.
 */
@Entity
public final class Registration {

  /**
   * Added entities.
   */
  private @Id @GeneratedValue Long id;

  /**
   * Reference to Module for bidirectional relationship.
   */
  @ManyToOne
  @JoinColumn(name = "module_id")
  private Module module;

  /**
   * Using OneToMany with a map of Module->Grade.
   * The @MapKey annotation tells JPA to use
   * the 'module' field of Grade as the key.
   */

  @OneToMany(mappedBy = "registration")
  @MapKey(name = "module")
  private Map<Module, Grade> registrations = new HashMap<>();


  /**
   * Constructor for the Registration class.
   * Uses a HashMap to store modules and their associated grades.
   */
  public Registration() {
    // no need to initialise here.
  }

  /**
   * Registers a module for the student.
   *
   * @param newModule the module to be registered
   */
  public void registerModule(final Module newModule) {
    this.registrations.putIfAbsent(newModule, null);
  }

  /**
   * Adds a grade for a registered module.
   *
   * @param newModule the module to assign the grade
   * @param newGrade the grade to be added
   * @throws NoRegistrationException if the module is not registered
   */
  public void addGrade(final Module newModule, final Grade newGrade)

      throws NoRegistrationException {
    if (!this.registrations.containsKey(newModule)) {
      throw new NoRegistrationException("Module not registered");
    }
    this.registrations.put(newModule, newGrade);
  }

  /**
   * Gets the grade for a specific module.
   *
   * @param newModule the module to retrieve the grade for
   * @return the grade for the module
   * @throws NoRegistrationException if the module is not registered
   */
  public Grade getGrade(final Module newModule) throws NoRegistrationException {
    if (!this.registrations.containsKey(newModule)) {
      throw new NoRegistrationException("Module not registered");
    }
    return this.registrations.get(newModule);
  }

}

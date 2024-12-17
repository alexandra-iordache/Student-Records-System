package uk.ac.rhul.cs2800.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * This is a class defined for Module.
 */

@Entity

public final class Module {

  /**
   * Added in entities.
   */
  private @Id
  @GeneratedValue
  Long id;

  /**
   * The module code.
   */
  private String code;

  /**
   * The module name.
   */
  private String name;

  /**
   * Indicates if the module is mandatory non-condonable.
   */
  private boolean mnc;

  /**
   * Private registration list.
   */
  @OneToMany(mappedBy = "module")
  private List<Registration> registrations = new ArrayList<>();

  /**
   * Constructor for the Module class.
   *
   * @param moduleCode the module code
   * @param moduleName the module name
   * @param mandatoryNonCondonable if the module is mandatory non-condonable
   */
  public Module(final String moduleCode, final String moduleName,
      final boolean mandatoryNonCondonable) {
    this.code = moduleCode;
    this.name = moduleName;
    this.mnc = mandatoryNonCondonable;
  }

  /**
   * Get the module code.
   *
   * @return the module code
   */
  public String getCode() {
    return this.code;
  }

  /**
   * Get the module name.
   *
   * @return the module name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Check if the module is mandatory non-condonable.
   *
   * @return true if mandatory non-condonable, false otherwise
   */
  public boolean isMandatoryNonCondonable() {
    return this.mnc;
  }

}

package uk.ac.rhul.cs2800.model;

/**
 * This is a class defined for Module.
 */
public class Module {
  private String code;
  private String name;
  private boolean mnc; // mandatory non-condonable

  /**
   * Constructor for the Module class.
   *
   * @param code the module code
   * @param name the module name
   * @param mnc whether the module is mandatory non-condonable
   */
  public Module(String code, String name, boolean mnc) {
    this.code = code;
    this.name = name;
    this.mnc = mnc;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public boolean isMandatoryNonCondonable() {
    return mnc;
  }


}

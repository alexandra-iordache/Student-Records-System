package uk.ac.rhul.cs2800.exception;

/**
 * Exception thrown when a student tries to access a grade for an unregistered module.
 */
public class NoRegistrationException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor calling parent class constructor using super.
   *
   * @param message paramater being called.
   */

  public NoRegistrationException(String message) {
    super(message);
  }
}

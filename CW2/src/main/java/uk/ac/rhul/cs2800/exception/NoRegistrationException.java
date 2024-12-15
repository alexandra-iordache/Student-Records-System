package uk.ac.rhul.cs2800.exception;

/**
 * Thrown when a module is requested that is not registered.
 */
public class NoRegistrationException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new NoRegistrationException with a detail message.
   *
   * @param message the detail message
   */
  public NoRegistrationException(final String message) {
    super(message);
  }
}

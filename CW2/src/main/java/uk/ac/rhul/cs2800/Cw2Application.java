package uk.ac.rhul.cs2800;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main Application Class.
 */
@SpringBootApplication
public final class Cw2Application {

  /**
   * Private constructor to prevent instantiation.
   */
  private Cw2Application() {
    // no instances
  }

  /**
   * The main entry point for the Spring Boot application.
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    SpringApplication.run(Cw2Application.class, args);
  }

}

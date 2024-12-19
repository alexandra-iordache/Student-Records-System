package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Registration;

public interface RegistrationRepository
    extends CrudRepository<Registration, Long> {

}

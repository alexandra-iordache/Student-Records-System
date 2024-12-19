package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Student;

/**
 * Student repository extending to crudrepository.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {

}

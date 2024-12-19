package uk.ac.rhul.cs2800.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;


/**
 * Controller for handling grade-related operations.
 */
@RestController
@RequestMapping("/grades")
public class GradeController {

  /**
   * Repository for student data operations.
   */

  private final StudentRepository studentRepository;

  /**
   * Repository for grade data operations.
   */
  private final GradeRepository gradeRepository;

  /**
   * Creates a new instance of GradeController.
   *
   * @param studentRepo repository for student data
   * @param gradeRepo repository for grade data
   */
  public GradeController(final StudentRepository studentRepo,
      final GradeRepository gradeRepo) {
    this.studentRepository = studentRepo;
    this.gradeRepository = gradeRepo;
  }


  /**
   * Adds a grade for a student.
   *
   * @param params contains "student_id" and "score"
   * @return the created grade
   */
  @PostMapping("/addGrade")
  public ResponseEntity<?> addGrade(@RequestBody
  final Map<String, Integer> params) {


    Student student = this.studentRepository
        .findById(Long.valueOf(params.get("student_id")))
        .orElseThrow(() -> new RuntimeException("Student not found"));


    Grade grade = new Grade();
    grade.setScore(Integer.valueOf(params.get("score")));
    grade.setStudent(student);

    // Save the Grade object
    Grade savedGrade = gradeRepository.save(grade);

    // Return the saved Grade
    return ResponseEntity.ok(savedGrade);

  }

}

package uk.ac.rhul.cs2800.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;

@RestController
public class GradeController {

  private final StudentRepository studentRepository;

  private final GradeRepository gradeRepository;

  public GradeController(StudentRepository studentRepository, GradeRepository gradeRepository) {
    this.studentRepository = studentRepository;
    this.gradeRepository = gradeRepository;

  }

  @PostMapping(value = "/grade/addGrade")
  public ResponseEntity<Grade> addGrade(@RequestBody Map<String, String> params) {
    Student student =
        studentRepository.findById(Long.valueOf(params.get("movie_id"))).orElseThrow();

    Grade grade = new Grade();
    grade.setScore(Integer.valueOf(params.get("score")));
    grade.setStudent(student);

    grade = gradeRepository.save(grade);
    return ResponseEntity.ok(grade);

  }

}

package com.harsha.student_curd.controller;

import com.harsha.student_curd.model.Student;
import com.harsha.student_curd.service.CourseService;
import com.harsha.student_curd.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
  StudentService studentService;
  CourseService courseService;
  public StudentController(StudentService studentService,CourseService courseService){
      this.studentService = studentService;
      this.courseService = courseService;
  }

  @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
      return ResponseEntity.ok(studentService.getStudents());
  }
  @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
      Student student = studentService.getStudentById(id);
      if (student == null) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.ok(student);
  }
  @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
      return ResponseEntity.status(HttpStatus.CREATED)
              .body(studentService.addStudent(student));
  }
  @PutMapping("/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student updatedStudent){
   Student student = studentService.updateStudent(id,updatedStudent);
   if(student == null) {
     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }
   return ResponseEntity.ok(student);
   }
  @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
      return ResponseEntity.ok(studentService.deleteStudent(id));
  }
    @PutMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<Student> enrollStudent(
            @PathVariable int studentId,
            @PathVariable int courseId) {
        Student student = studentService.enrollStudent(studentId, courseId);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(student);
    }
}

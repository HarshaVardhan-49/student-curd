package com.harsha.student_curd.service;

import com.harsha.student_curd.exception.StudentNotFoundException;
import com.harsha.student_curd.model.Course;
import com.harsha.student_curd.model.Student;
import com.harsha.student_curd.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
//    private List<Student> students = new ArrayList<>(List.of(
//            new Student(001,"Vedu",9),
//            new Student(002,"junnu",5),
//            new Student(003,"jenni",4)
//    ));

    StudentRepository studentRepository;
    CourseService courseService;

    public StudentService(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(int id){

        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student with id"+id+"not Found!"));
    }
    public Student addStudent(Student student){
        //students.add(student);
        return studentRepository.save(student);
    }
    public Student updateStudent(int id, Student updatedStudent){
        Student exesting = getStudentById(id);
        if(exesting == null) return null;
        exesting.setName(updatedStudent.getName());
        exesting.setAge(updatedStudent.getAge());
        return studentRepository.save(exesting);
    }
    public String deleteStudent(int id){
        Student found = getStudentById(id);
        if(found == null){
            return "Student" + id +"not found";
        }
        else {
            studentRepository.deleteById(id);
            return "Student" + id + " deleted";
        }
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentsByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public List<Student> getStudentsOlderThan(int age) {
        return studentRepository.findByAgeGreaterThan(age);
    }

    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameContaining(name);
    }

    public List<Student> getStudentsByNameQuery(String name) {
        return studentRepository.findStudentByName(name);
    }

    public List<Student> getStudentsOlderThanQuery(int age) {
        return studentRepository.findStudentsOlderThan(age);
    }

    public List<Student> searchStudentsByNameQuery(String name) {
        return studentRepository.searchByName(name);
    }

    public List<Student> getStudentsByCourseTitle(String title) {
        return studentRepository.findByCourseTitle(title);
    }

    public Student enrollStudent(int studentId, int courseId) {
        Student student = getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);

        if (student == null || course == null) {
            return null;
        }

        student.setCourse(course);
        return studentRepository.save(student);
    }

}

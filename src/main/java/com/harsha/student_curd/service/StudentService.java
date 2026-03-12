package com.harsha.student_curd.service;

import com.harsha.student_curd.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>(List.of(
            new Student(001,"Vedu",9),
            new Student(002,"junnu",5),
            new Student(003,"jenni",4)
    ));

    public List<Student> getStudents(){
        return students;
    }
    public Student getStudentById(int id){
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public Student addStudent(Student student){
        students.add(student);
        return student;
    }
    public Student updateStudent(int id, Student updatedStudent){
        Student exesting = getStudentById(id);
        if(exesting == null) return null;
        exesting.setName(updatedStudent.getName());
        exesting.setAge(updatedStudent.getAge());
        return exesting;
    }
    public String deleteStudent(int id){
        Student found = getStudentById(id);
        if(found == null){
            return "Student" + id +"not found";
        }
        else {
            students.removeIf(s -> s.getId() == id);
            return "Student" + id + " deleted";
        }
    }

}

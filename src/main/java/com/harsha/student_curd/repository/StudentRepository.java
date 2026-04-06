package com.harsha.student_curd.repository;

import com.harsha.student_curd.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByName(String name);

    List<Student> findByAge(int age);

    List<Student> findByAgeGreaterThan(int age);

    List<Student> findByNameContaining(String name);
}

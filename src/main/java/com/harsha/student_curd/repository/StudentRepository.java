package com.harsha.student_curd.repository;

import com.harsha.student_curd.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByName(String name);

    List<Student> findByAge(int age);

    List<Student> findByAgeGreaterThan(int age);

    List<Student> findByNameContaining(String name);

    // JPQL - find by name
    @Query("SELECT s FROM Student s WHERE s.name = :name")
    List<Student> findStudentByName(@Param("name") String name);

    // JPQL - find students older than age
    @Query("SELECT s FROM Student s WHERE s.age > :age")
    List<Student> findStudentsOlderThan(@Param("age") int age);

    // JPQL - search by name containing
    @Query("SELECT s FROM Student s WHERE s.name LIKE %:name%")
    List<Student> searchByName(@Param("name") String name);

    @Query(value = "SELECT s.* FROM student s JOIN course c ON s.course_id = c.course_id WHERE c.course_title = :title", nativeQuery = true)
    List<Student> findByCourseTitle(@Param("title") String title);
}

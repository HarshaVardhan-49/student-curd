package com.harsha.student_curd.repository;

import com.harsha.student_curd.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {
}

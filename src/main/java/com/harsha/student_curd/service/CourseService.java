package com.harsha.student_curd.service;

import com.harsha.student_curd.model.Course;
import com.harsha.student_curd.repository.CourseRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepo.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    public String deleteCourse(int id) {
        courseRepo.deleteById(id);
        return "Course " + id + " deleted!";
    }
}
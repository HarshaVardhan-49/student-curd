package com.harsha.student_curd.controller;

import com.harsha.student_curd.model.Course;
import com.harsha.student_curd.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.addCourse(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        return ResponseEntity.ok(courseService.deleteCourse(id));
    }
}
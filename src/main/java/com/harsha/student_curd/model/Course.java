package com.harsha.student_curd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseTitle;
//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    private List<Student> students = new ArrayList<>();

    public Course(){}
    public Course(int courseId,String courseTitle){
        this.courseId = courseId;
        this.courseTitle = courseTitle;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public int getCourseId(){return courseId;}
    public String getCourseTitle(){return courseTitle;}
    public List<Student> getStudents(){return students;}

    public void setCourseId(int courseId){this.courseId = courseId;}
    public void setCourseTitle(String courseTitle){this.courseTitle = courseTitle;}
    public void setStudents(List<Student> students){this.students = students;}
}

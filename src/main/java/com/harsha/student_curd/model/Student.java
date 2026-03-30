package com.harsha.student_curd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn (name = "course_id")
    private Course course;

    public Student(){

    }

    public Student(int id, String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Course getCourse(){return course;}

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCourse(Course course){this.course = course;}
}

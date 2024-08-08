package com.example.demo.controllers;

import com.example.demo.data.StudentRequest;
import com.example.demo.services.CourseServiceImpl;
import com.example.demo.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;


@Controller
public class StudentMutations {

    @Autowired
    StudentServiceImpl studentService;


    @Autowired
    CourseServiceImpl courseService;

    @MutationMapping
    public String createStudent(@Argument StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }

    @MutationMapping
    public String createCourse(@Argument StudentRequest courses){
        return courseService.createCourse(courses);
    }
}


package com.example.demo.data;

import com.example.demo.entity.OptCourses;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class StudentRequest {

    private Long id;

    private String firstName;

    private String lastName;

    private String street;

    private String city;

    List<OptCourses> optCoursesList;
}

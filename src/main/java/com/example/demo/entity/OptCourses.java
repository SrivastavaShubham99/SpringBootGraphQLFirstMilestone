package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OptCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String stream;

    @ManyToMany
    @JoinTable(
            name = "opt_course_student", // Join table name
            joinColumns = @JoinColumn(name = "opt_course_id"), // Column referencing OptCourses entity
            inverseJoinColumns = @JoinColumn(name = "student_id") // Column referencing StudentEntity entity
    )
    private List<StudentEntity> studentEntityList;
}

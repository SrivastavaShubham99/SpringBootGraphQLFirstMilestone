package com.example.demo.services;

import com.example.demo.data.StudentRequest;
import com.example.demo.repository.OptCourseRepository;
import com.example.demo.services.contract.CourseService;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl implements CourseService {

    OptCourseRepository optCourseRepository;
    CourseServiceImpl(OptCourseRepository courseRepository){
        this.optCourseRepository=courseRepository;
    }

    @Override
    public String createCourse(StudentRequest courses) {

        courses.getOptCoursesList().stream().forEach( e -> {
            optCourseRepository.save(e);
        });
        return "course created successfully";
    }
}

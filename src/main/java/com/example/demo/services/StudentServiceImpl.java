package com.example.demo.services;

import com.example.demo.data.StudentRequest;
import com.example.demo.entity.OptCourses;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.OptCourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.contract.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    OptCourseRepository optCourseRepository;

    StudentServiceImpl(StudentRepository studentRepository,OptCourseRepository optCourseRepository){
        this.studentRepository=studentRepository;
        this.optCourseRepository=optCourseRepository;
    }

    @Override
    public String createStudent(StudentRequest student) {

        List<OptCourses> optCoursesList = new ArrayList<>();
        List<StudentEntity> studentEntityList = new ArrayList<>();

        student.getOptCoursesList().forEach( e -> {
            OptCourses optCourses=optCourseRepository.save(e);
            optCoursesList.add(optCourses);
            StudentEntity studentEntity=new StudentEntity();
            studentEntity.setFirstName(student.getFirstName());
            studentEntity.setLastName(student.getLastName());
            studentEntity.setCity(student.getCity());
            studentEntity.setStreet(student.getStreet());
            StudentEntity res=studentRepository.save(studentEntity);
            studentEntityList.add(res);
            res.setOptCoursesList(optCoursesList);
            optCourses.setStudentEntityList(studentEntityList);
        });


        return "Student created successfully";
    }
}

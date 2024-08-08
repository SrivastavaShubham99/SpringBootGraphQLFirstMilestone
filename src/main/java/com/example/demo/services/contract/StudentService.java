package com.example.demo.services.contract;

import com.example.demo.data.StudentRequest;
import com.example.demo.entity.StudentEntity;

public interface StudentService {
    public String createStudent(StudentRequest student);
}

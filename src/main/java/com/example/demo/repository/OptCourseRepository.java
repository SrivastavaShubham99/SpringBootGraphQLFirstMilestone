package com.example.demo.repository;

import com.example.demo.entity.OptCourses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptCourseRepository extends JpaRepository<OptCourses,Long> {
}

package com.example.universityapplication.service;

import com.example.universityapplication.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    List<Course> findByDeparment(String departmentName);
    Optional<Course> addCourse(Course course);
    List<Course> findAllByDepartmentsAndOrderByCourseName();
}

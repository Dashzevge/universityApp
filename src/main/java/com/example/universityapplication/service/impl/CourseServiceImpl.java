package com.example.universityapplication.service.impl;

import com.example.universityapplication.model.Course;
import com.example.universityapplication.repository.CourseRepository;
import com.example.universityapplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findByDeparment(String departmentName) {
        return null;
    }

    @Override
    public Optional<Course> addCourse(Course course) {
        return Optional.of(courseRepository.save(course));
    }

    @Override
    public List<Course> findAllByDepartmentsAndOrderByCourseName() {
        return courseRepository.findAllByDepartmentsAndOrderByCourseName();
    }
}

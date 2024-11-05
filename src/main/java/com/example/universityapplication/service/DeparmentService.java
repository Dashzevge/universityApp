package com.example.universityapplication.service;

import com.example.universityapplication.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public interface DeparmentService {
    Optional<Department> addDepartment(Department department);
    Optional<Department> updateDepartment(Department department);
    @Transactional
    List<Department> getDepartmentsWithCoursesOrderedByName();
}

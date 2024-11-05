package com.example.universityapplication.service.impl;

import com.example.universityapplication.model.Department;
import com.example.universityapplication.repository.DepartmentRepository;
import com.example.universityapplication.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DeparmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Optional<Department> addDepartment(Department department) {
        return Optional.of(departmentRepository.save(department));
    }
    @Override
    public Optional<Department> updateDepartment(Department department) {
        // Use merge to update the detached entity
        return Optional.of(departmentRepository.save(department));
    }
    @Override
    public List<Department> getDepartmentsWithCoursesOrderedByName() {
        return departmentRepository.findAllDepartmentsWithCourses();
    }

}

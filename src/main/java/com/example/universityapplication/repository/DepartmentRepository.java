package com.example.universityapplication.repository;

import com.example.universityapplication.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("SELECT DISTINCT d FROM department d LEFT JOIN FETCH d.courses ORDER BY d.departmentName")
    List<Department> findAllDepartmentsWithCourses();
}

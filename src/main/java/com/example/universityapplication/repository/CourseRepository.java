package com.example.universityapplication.repository;

import com.example.universityapplication.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    @Query("SELECT d.courseName FROM course d LEFT JOIN FETCH d.course ORDER BY d.departmentName")
    List<Course> findAllByDepartmentsAndOrderByCourseName();
}

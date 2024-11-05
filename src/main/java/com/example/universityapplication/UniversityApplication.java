package com.example.universityapplication;

import com.example.universityapplication.model.Course;
import com.example.universityapplication.model.Department;
import com.example.universityapplication.model.Professor;
import com.example.universityapplication.service.CourseService;
import com.example.universityapplication.service.DeparmentService;
import com.example.universityapplication.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UniversityApplication {

    @Autowired
    CourseService courseService;
    @Autowired
    DeparmentService deparmentService;
    @Autowired
    ProfessorService professorService;

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {

            // Create and save departments first
            Department csDepartment = new Department("Computer Science");
            Department mathDepartment = new Department("Mathematics");
            Department phyDepartment = new Department("Physics");

            csDepartment = deparmentService.addDepartment(csDepartment).orElseThrow();
            mathDepartment = deparmentService.addDepartment(mathDepartment).orElseThrow();
            phyDepartment = deparmentService.addDepartment(phyDepartment).orElseThrow();

            // Create professors and associate with managed departments
            Professor alice = new Professor("Alice", "Smith", csDepartment);
            Professor john = new Professor("John", "Doe", mathDepartment);
            Professor emma = new Professor("Emma", "Johnson", phyDepartment);
            Professor daniel = new Professor("Daniel", "Lee", csDepartment);

            // Save professors
            professorService.addProfessor(alice);
            professorService.addProfessor(john);
            professorService.addProfessor(emma);
            professorService.addProfessor(daniel);

            // Create courses without setting professors initially
            Course dataStructures = new Course("Data Structures");
            Course algorithms = new Course("Algorithms");
            Course calculus = new Course("Calculus");

            // Save courses first
            dataStructures = courseService.addCourse(dataStructures).orElseThrow();
            algorithms = courseService.addCourse(algorithms).orElseThrow();
            calculus = courseService.addCourse(calculus).orElseThrow();

            // Set professors for courses after saving
            dataStructures.setProfessors(List.of(alice, daniel));
            algorithms.setProfessors(List.of(alice));
            calculus.setProfessors(List.of(john));

            // Update courses with professors
            courseService.addCourse(dataStructures);
            courseService.addCourse(algorithms);
            courseService.addCourse(calculus);

            // Set courses for departments and save
            csDepartment.setCourses(List.of(dataStructures, algorithms));
            mathDepartment.setCourses(List.of(calculus));
            deparmentService.updateDepartment(csDepartment);
            deparmentService.updateDepartment(mathDepartment);
            System.out.println(deparmentService.getDepartmentsWithCoursesOrderedByName());
        };
}

}

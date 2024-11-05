package com.example.universityapplication.service;

import com.example.universityapplication.model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfessorService {
    List<Professor> professorsOrderByLastName();
    Optional<Professor> addProfessor(Professor professor);
}

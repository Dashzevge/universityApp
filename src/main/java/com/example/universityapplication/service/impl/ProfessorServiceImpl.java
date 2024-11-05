package com.example.universityapplication.service.impl;

import com.example.universityapplication.model.Professor;
import com.example.universityapplication.repository.ProfessorRepository;
import com.example.universityapplication.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> professorsOrderByLastName() {
        return professorRepository.findAllByOrderByLastNameAsc();
    }
    @Override
    public Optional<Professor> addProfessor(Professor professor) {
        return Optional.of(professorRepository.save(professor));
    }
}

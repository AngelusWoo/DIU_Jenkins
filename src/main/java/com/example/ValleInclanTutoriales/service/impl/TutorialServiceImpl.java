package com.example.ValleInclanTutoriales.service.impl;

import com.example.ValleInclanTutoriales.dto.TutorialDTO;
import com.example.ValleInclanTutoriales.dto.converter.TutorialDTOConverter;
import com.example.ValleInclanTutoriales.model.Tutorial;
import com.example.ValleInclanTutoriales.model.TutorialRepository;
import com.example.ValleInclanTutoriales.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorialServiceImpl implements TutorialService {
    private final TutorialDTOConverter DTOconverter;
    private final TutorialRepository repository;

    // GET
    @Override
    public ResponseEntity<?> getAllTutorials() {
        List<Tutorial> result = repository.findAll();
        if (result.isEmpty()) return ResponseEntity.notFound().build();
        else {
            List<TutorialDTO> dtoList = result.stream().map(DTOconverter::convertToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    @Override
    public ResponseEntity<?> getAllTutorials(String title) {
        List<Tutorial> result = repository.findByTitleContaining(title);
        if (result == null) return ResponseEntity.notFound().build();
        else {
            List<TutorialDTO> dtoList = result.stream().map(DTOconverter::convertToDTO)
                .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }

    @Override
    public ResponseEntity<?> getTutorialById(String id) {
        Tutorial result = repository.findById(id).orElse(null);
        if (result == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> findByPublished() {
        List<Tutorial> result = repository.findByPublished(true);
        if (result == null) return ResponseEntity.notFound().build();
        else {
            List<TutorialDTO> dtoList = result.stream().map(DTOconverter::convertToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        }
    }


    // POST
    @Override
    public ResponseEntity<?> addTutorial(Tutorial newT) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newT));
    }

    // PUT
    @Override
    public ResponseEntity<?> updateTutorial(Tutorial edit, String id) {
        return repository.findById(id).map(u -> {
            u.setTitle(edit.getTitle());
            u.setDescription(edit.getDescription());
            u.setPublished(edit.isPublished());
            return ResponseEntity.ok(repository.save(u));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // DELETE
    @Override
    public ResponseEntity<?> deleteTutorial(String id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> deleteAllTutorials() {
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}

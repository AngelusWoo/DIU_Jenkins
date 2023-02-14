package com.example.ValleInclanTutoriales.service;

import com.example.ValleInclanTutoriales.model.Tutorial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface TutorialService {
    public ResponseEntity<?> getAllTutorials();
    public ResponseEntity<?> getAllTutorials(String title);
    public ResponseEntity<?> getTutorialById(String id);
    public ResponseEntity<?> findByPublished();
    public ResponseEntity<?> addTutorial(@RequestBody Tutorial newT);
    public ResponseEntity<?> updateTutorial(@RequestBody Tutorial edit, @PathVariable String id);
    public ResponseEntity<?> deleteTutorial(@PathVariable String id);
    public ResponseEntity<?> deleteAllTutorials();
}

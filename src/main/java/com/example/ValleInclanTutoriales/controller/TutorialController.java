package com.example.ValleInclanTutoriales.controller;

import com.example.ValleInclanTutoriales.model.Tutorial;
import com.example.ValleInclanTutoriales.service.impl.TutorialServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TutorialController {
	private final TutorialServiceImpl tService;


    //GET
    @GetMapping("/tutorials")
	public ResponseEntity<?> getAllTutorials() {
		return tService.getAllTutorials();
	}

    @GetMapping("/tutorials/{title}")
    public ResponseEntity<?> getAllTutorials(@PathVariable String title) {
		return tService.getAllTutorials(title);
    }

	@GetMapping("/tutorials/id/{id}")
	public ResponseEntity<?> getTutorialById(@PathVariable String id) {
		return tService.getTutorialById(id);
	}

    @GetMapping("/tutorials/published")
    public ResponseEntity<?> getTutorialByPublished() {
		return tService.findByPublished();
    }


    //POST
    @PostMapping("/tutorials")
	public ResponseEntity<?> addTutorial(@RequestBody Tutorial newT) {
		return tService.addTutorial(newT);
	}


    //PUT
    @PutMapping("/tutorials/id/{id}")
	public ResponseEntity<?> updateTutorial(@RequestBody Tutorial edit, @PathVariable String id) {
		return tService.updateTutorial(edit,id);
	}


    //DELETE
    @DeleteMapping("/tutorials/id/{id}")
	public ResponseEntity<?> deleteTutorial(@PathVariable String id) {
		return tService.deleteTutorial(id);
	}

    @DeleteMapping("/tutorials/delete/all")
	public ResponseEntity<?> deleteAllTutorials() {
		return tService.deleteAllTutorials();
	}
}

package com.yash.dev.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.dev.rest.exception.ResourceNotFoundException;
import com.yash.dev.rest.model.NoteUtil;
import com.yash.dev.rest.repository.NoteRepository;

/**
 * Created by Yashwanth Anand S
 **/

@RestController
@RequestMapping("/API")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;

	@GetMapping("/Notes")
	public List<NoteUtil> listAllNotes() {
		return noteRepository.findAll();
	}

	@PostMapping("/Note")
	public NoteUtil createNote(@Valid @RequestBody NoteUtil note) {
		return noteRepository.save(note);
	}

	@GetMapping("/Notes/{id}")
	public NoteUtil getNoteById(@PathVariable(value = "id") Long noteId) {
		return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
	}

	@PutMapping("/Notes/{id}")
	public NoteUtil updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody NoteUtil noteDetails) {

		NoteUtil note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

		note.setTitle(noteDetails.getTitle());
		note.setContent(noteDetails.getContent());

		NoteUtil updatedNote = noteRepository.save(note);
		return updatedNote;
	}

	@DeleteMapping("/Notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
		NoteUtil note = noteRepository.findById(noteId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

		noteRepository.delete(note);

		return ResponseEntity.ok().build();
	}

}

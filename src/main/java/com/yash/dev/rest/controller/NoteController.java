package com.yash.dev.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

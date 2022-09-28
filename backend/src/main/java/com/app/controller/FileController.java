package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojo.Notes;
import com.app.service.NotesServiceImpl;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FileController {
	
	NotesServiceImpl notesSerivceImpl;
	
	@PostMapping("/upload/{notes}")
	public ResponseEntity<String> uploadNotes(@RequestBody MultipartFile notes){
		
		return new ResponseEntity<String>("Uploaded Successfully",HttpStatus.OK);
	}
	@GetMapping("getNotes/{id}")
	public ResponseEntity<Notes> getNotesById(@PathVariable String id){
		return new ResponseEntity<Notes>(notesSerivceImpl.getNotesById(id),HttpStatus.OK);
	}
	
}

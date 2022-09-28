package com.app.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojo.Notes;
import com.app.respository.NotesRepository;

@Service
@Transactional
public class NotesServiceImpl implements INotesService {
	@Autowired
	private NotesRepository notesRepo;
	@Override
	public Notes getNotesById(String id) {
		// TODO Auto-generated method stub
		return notesRepo.findById(id).orElseThrow(null);
	}
	@Override
	public Notes uploadNotes(MultipartFile notes){
		String notesName =notes.getOriginalFilename();
		Notes notesDoc=new Notes(notesName,((Notes) notes).getNotesType(),notesName, ((Notes) notes).getNotesData());
		return notesRepo.save(notesDoc);
	}



}

package com.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojo.Notes;

public interface INotesService {
	public Notes getNotesById(String id);
	public Notes uploadNotes(MultipartFile notes ) ;
}

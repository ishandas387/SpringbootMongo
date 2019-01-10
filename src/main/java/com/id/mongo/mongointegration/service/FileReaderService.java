package com.id.mongo.mongointegration.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.id.mongo.mongointegration.model.Student;
import com.id.mongo.mongointegration.repo.StudentRepository;

@Service
public class FileReaderService {
	
	@Autowired
	private StudentRepository studentRepo;

	public void jsonFileReader(){
		String filePath ="G:/jsontestfiles";
		try {
			List<Student> studentList= new ArrayList<>();
			Files.newDirectoryStream(Paths.get(filePath),
			        path -> path.toString().endsWith(".json"))
			        .forEach(path  -> createListOfObjects(path.toFile(),studentList));
			studentRepo.save(studentList);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	private void createListOfObjects(File file, List<Student> studentList) {
		Student student = new Student();
		try {
			InputStream io = new FileInputStream(file);
			ObjectMapper mapper = new ObjectMapper();
			student = mapper.readValue(io, Student.class);
			studentList.add(student);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

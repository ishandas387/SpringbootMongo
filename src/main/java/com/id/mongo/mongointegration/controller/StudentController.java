package com.id.mongo.mongointegration.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.mongo.mongointegration.model.Student;
import com.id.mongo.mongointegration.model.Workorder;
import com.id.mongo.mongointegration.repo.StudentRepository;
import com.id.mongo.mongointegration.repo.WoRepository;
import com.id.mongo.mongointegration.service.AggregatorService;
import com.id.mongo.mongointegration.service.FileReaderService;

@RestController
@RequestMapping("/student")
public class StudentController {
  @Autowired
  private StudentRepository repository;
  
  @Autowired
  private WoRepository woRepository;
  
  @Autowired
  private FileReaderService fileReaderService;
  
  @Autowired
  private AggregatorService aggregatorService;
  
  @GetMapping(value = "/")
  public List<Student> getAllStudent() {
    return repository.findAll();
  }

  @GetMapping(value = "/{id}")
  public Student getSById(@PathVariable("id") ObjectId id) {
    return repository.findByid(id);
  }
  
  @PutMapping(value = "/{id}")
  public void modifySById(@PathVariable("id") ObjectId id, @Valid @RequestBody Student student) {
    repository.save(student);
  }
  
  @PostMapping(value = "/")
  public Student createS(@Valid @RequestBody Student student) {
    repository.save(student);
    return student;
  }
  
  @DeleteMapping(value = "/{id}")
  public void deleteS(@PathVariable ObjectId id) {
    repository.delete(repository.findByid(id));
  }
  
  @GetMapping(value = "/testfolder")
  public String getFileNames() {
	  fileReaderService.jsonFileReader();
    return "done";
  }
  
  
  @GetMapping(value = "/aggregate")
  public List<Workorder> getAggregatedWo() {
	  
    return aggregatorService.getAggregatedResult();
  }
  
  @GetMapping(value = "/wo")
  public List<Workorder> getAll() {
	  
    return woRepository.findAll();
  }
}
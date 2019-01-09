package com.id.mongo.mongointegration.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.id.mongo.mongointegration.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	Student findByid(ObjectId id);
}
package com.id.mongo.mongointegration.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.id.mongo.mongointegration.model.Workorder;

@Repository
public interface WoRepository extends MongoRepository<Workorder, String> {

	
} 
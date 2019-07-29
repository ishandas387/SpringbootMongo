package com.id.mongo.mongointegration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.stereotype.Component;

import com.id.mongo.mongointegration.model.Workorder;

@Component
public class AggregatorService {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public List<Workorder> getAggregatedResult(){
		
		AggregationOperation sortByCountCreation = Aggregation.sort(new Sort(Direction.ASC, "_id")) ;
		AggregationOperation groupbyWorkorderId= Aggregation.group("wid").last("otherProps").as("otherProps").last("wid").as("wid");
		Aggregation aggregation = Aggregation.newAggregation(sortByCountCreation, groupbyWorkorderId);
		AggregationResults<Workorder> aggregate = mongoTemplate.aggregate(aggregation, Workorder.class, Workorder.class);
		return aggregate.getMappedResults();
	}

	private SortOperation sort(Sort sort) {
		return null;
	}

}

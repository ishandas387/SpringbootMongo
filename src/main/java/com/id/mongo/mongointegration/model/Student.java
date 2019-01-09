package com.id.mongo.mongointegration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

	@Id	
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	private String name;
	private String age;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}



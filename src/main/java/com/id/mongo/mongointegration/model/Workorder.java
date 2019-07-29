package com.id.mongo.mongointegration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="woCollection")
public class Workorder {

	@Id
	String _id;
	String wid;
	String otherProps;

	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getOtherProps() {
		return otherProps;
	}
	public void setOtherProps(String otherProps) {
		this.otherProps = otherProps;
	}
	
}

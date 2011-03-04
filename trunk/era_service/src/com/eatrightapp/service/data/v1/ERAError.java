package com.eatrightapp.service.data.v1;

public class ERAError {
	private String id;
	private String field;
	private String description;
	
	public ERAError(String error, String field, String description) {
		setId(error);
		setField(field);
		setDescription(description);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}

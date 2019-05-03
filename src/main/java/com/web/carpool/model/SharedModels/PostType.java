package com.web.carpool.model.SharedModels;

public enum PostType implements IEnum<PostType> {
  PASSENGER("Passenger"), DRIVER("Driver");
	
	private String value;
	
	PostType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public PostType valueOfIgnoreCase(String value) {
		return valueOf(value.toUpperCase());
	}
}
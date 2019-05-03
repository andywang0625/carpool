package com.web.carpool.model.SharedModels;

public enum PostStatus implements IEnum<PostStatus> {
	DRAFT("Draft"),
	ATTEMPTING("Attempting"),
	PROCESSING("Processing"),
	CLOSED("Closed"),
	CLOSED_WITH_ERROR("Closed with error");

	private String value;

	PostStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public PostStatus valueOfIgnoreCase(String value) {
		return valueOf(value.toUpperCase());
	}
}
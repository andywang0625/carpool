package com.web.carpool.model.SharedModels;

public enum PostRepeatType implements IEnum<PostRepeatType>{
	ONE_OFF("One Off"), MULTI_TIMES("Multi Times"), REPEATED("Repeated");

	private String value;

	PostRepeatType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public PostRepeatType valueOfIgnoreCase(String value) {
		return valueOf(value.toUpperCase());
	}
}
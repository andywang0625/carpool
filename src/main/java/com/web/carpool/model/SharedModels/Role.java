package com.web.carpool.model.SharedModels;

public enum Role implements IEnum<Role> {
	ADMIN("Admin"), USER("User"), GUEST("Guest");

	private String value;

	private Role(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public Role valueOfIgnoreCase(String value) {
		return valueOf(value.toUpperCase());
	}
}
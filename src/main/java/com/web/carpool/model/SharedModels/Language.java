package com.web.carpool.model.SharedModels;

public enum Language implements IEnum<Language> {
	UNKNOWN("Unknown"),
	ENGLISH("English"),
	FRENCH("French"),
	MANDARINE("Mandarine"),
	CANTONESE("Cantonese"),
	GERMAN("German"),
	KOREAN("Korean"),
	JAPANESE("Japanese");

	private String value;

	Language(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public Language valueOfIgnoreCase(String value) {
		return valueOf(value.toUpperCase());
	}
}
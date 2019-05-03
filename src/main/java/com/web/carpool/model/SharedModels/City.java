package com.web.carpool.model.SharedModels;

public enum City implements IEnum<City> {
	UNKNOWN("Unknown"),
	TORONTO("Toronto"),
	MONTREAL("Montreal"),
	VANCOUVER("Vancouver"),
	EDMONTON("Edmonton"),
	OTTAWA("Ottawa"),
	GATINEAU("Gatineau"),
	QUEBEC_CITY("Quebec City"),
	HAMILTON("Hamilton"),
	LONDON("London"),
	VICTORIA("Victoria"),
	HALIFAX("Halifax"),
	OSHAWA("Oshawa"),
	WINDSOR("Windsor");

	private String value;

	City(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public City valueOfIgnoreCase(String value) {
		return valueOf(value.toUpperCase());
	}
}
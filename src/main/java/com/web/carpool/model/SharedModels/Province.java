package com.web.carpool.model.SharedModels;

public enum Province {
	UNKNOWN("Unknown"),
	ONTARIO("Ontario"),
	QUEBEC("Quebec"),
	BRITISH_COLUMBIA("British Columbia"),
	ALBERTA("Alberta"),
	MANITOBA("Manitoba"),
	NOVA_SCOTIA("Nova Scotia");

	private String value;

	Province(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
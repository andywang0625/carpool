package com.web.carpool.model.SharedModels;

public enum VehicleColor implements IEnum<VehicleColor> {
	UNKNOWN("Unknown"), RED("Red"), SILVER("Silver"), BLUE("Blue"), GREEN("Green"), GREY("Grey");

	private String value;

	private VehicleColor(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public VehicleColor valueOfIgnoreCase(String value) {
		return valueOf(value.toUpperCase());
	}
}
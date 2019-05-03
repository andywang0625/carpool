package com.web.carpool.model.SharedModels;

public enum VehicleBrand implements IEnum<VehicleBrand> {
	UNKNOWN("Unknown"),
	FORD("Ford"),
	TOYOTA("Toyota"),
	HONDA("Honda"),
	CHEVROLET("Chevrolet"),
	NISSAN("Nissan"),
	GMC("GMC"),
	HYUNDAI("Hyundai"),
	RAM("RAM"),
	KIA("Kia"),
	MAZDA("Mazda");

	private String value;

	private VehicleBrand(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public VehicleBrand valueOfIgnoreCase(String value) {
		return valueOf(value.toUpperCase());
	}

}
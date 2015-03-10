package com.procurandoape.user;

public enum PlaceType {

	NEEDS_PLACE("user.placetype.needplace", "NEEDS"),
	HAS_PLACE("user.placetype.hasplace", "HAS");

	private String textValue;

	private String databaseValue;

	PlaceType(String value, String databaseValue) {
		this.textValue = value;
		this.databaseValue = databaseValue;
	}

	public String getValue() {
		return this.textValue;
	}

	public String databaseValue() {
		return this.databaseValue;
	}

	public static PlaceType getEnumName(String name) {
		if (name.equals("NEEDS")) {
			return PlaceType.NEEDS_PLACE;
		}
		return PlaceType.HAS_PLACE;
	}
}

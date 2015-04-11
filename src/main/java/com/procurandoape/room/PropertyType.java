package com.procurandoape.room;

import com.procurandoape.util.I18nMessageKey;

public enum PropertyType {

	APARTAMENT("placetorental.propertytype.apartament"),
	HOUSE("placetorental.propertytype.house"),
	KITNET("placetorental.propertytype.kitnet"),
	HOSTEL("placetorental.propertytype.hostel"),
	REPUBLIC("placetorental.propertytype.republic");

	private String name;

	PropertyType(String name) {
		this.name = name;
	}

	public String getName() {
		return I18nMessageKey.getKey(this.name);
	}

}

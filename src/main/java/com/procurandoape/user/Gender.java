package com.procurandoape.user;

import com.procurandoape.util.I18nMessageKey;

public enum Gender {

	MALE("user.gender.male"),
	FEMALE("user.gender.female"),
	OTHER("user.gender.other");

	private String value;

	Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return I18nMessageKey.getKey(this.value);
	}

}

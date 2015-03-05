package com.procurandoape.room;

import com.procurandoape.util.I18nMessage;

public enum PriceType {

	WEEK("pricetype.week"), MONTH("pricetype.month");

	private String value;

	PriceType(String value) {
		this.value = value;
	}

	public String getValue() {
		return I18nMessage.getKey(value);
	}

}

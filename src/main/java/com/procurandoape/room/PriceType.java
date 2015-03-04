package com.procurandoape.room;

import com.procurandoape.util.I18nMessage;

public enum PriceType {

	WEEK(I18nMessage.getKey("pricetype.week")), MONTH(I18nMessage.getKey("pricetype.month"));

	private String value;

	PriceType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

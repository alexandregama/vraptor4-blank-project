package com.procurandoape.converters;

import javax.persistence.AttributeConverter;

public class BooleanToStringConverterJPA implements AttributeConverter<Boolean, String>  {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		if (attribute != null && attribute) {
			return "Y";
		}
		return "N";
	}

	@Override
	public Boolean convertToEntityAttribute(String value) {
		if (value != null && value.equals("Y")) {
			return true;
		}
		return false;
	}

}

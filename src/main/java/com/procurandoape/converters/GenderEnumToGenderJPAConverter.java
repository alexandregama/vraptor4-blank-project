package com.procurandoape.converters;

import javax.persistence.AttributeConverter;

import com.procurandoape.user.Gender;

public class GenderEnumToGenderJPAConverter implements AttributeConverter<Gender, String> {

	@Override
	public String convertToDatabaseColumn(Gender value) {
		return value.toString().substring(0, 1);
	}

	@Override
	public Gender convertToEntityAttribute(String dbData) {
		if (dbData.equals("M")) {
			return Gender.MALE;
		}
		else if (dbData.equals("F")) {
			return Gender.FEMALE;
		}
		else {
			return Gender.OTHER;
		}
	}

}

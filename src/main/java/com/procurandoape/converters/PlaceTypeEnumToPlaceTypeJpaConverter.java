package com.procurandoape.converters;

import javax.persistence.AttributeConverter;

import com.procurandoape.user.PlaceType;

public class PlaceTypeEnumToPlaceTypeJpaConverter implements AttributeConverter<PlaceType, String> {

	@Override
	public String convertToDatabaseColumn(PlaceType value) {
		return value.databaseValue();
	}

	@Override
	public PlaceType convertToEntityAttribute(String dbData) {
		return PlaceType.getEnumName(dbData);
	}

}

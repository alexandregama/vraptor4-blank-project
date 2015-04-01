package com.procurandoape.room;

import javax.persistence.AttributeConverter;

import com.procurandoape.user.GenderOrientation;

public class GenderOrientationEnumToGenderOrientationJPAConverter implements AttributeConverter<GenderOrientation, String> {

	@Override
	public String convertToDatabaseColumn(GenderOrientation attribute) {
		if (attribute.equals(GenderOrientation.BISSEXUAL)) {
			return "B";
		}
		else if (attribute.equals(GenderOrientation.GAY)) {
			return "G";
		}
		else if (attribute.equals(GenderOrientation.HETEROSEXUAL)) {
			return "H";
		}
		throw new RuntimeException("The follow attribute for GenderOrientationConverter is invalid: " + attribute);
	}

	@Override
	public GenderOrientation convertToEntityAttribute(String dbData) {
		if (dbData == null || dbData.isEmpty()) {
			return null;
		}
		else if (dbData.equals("B")) {
			return GenderOrientation.BISSEXUAL;
		}
		else if (dbData.equals("H")) {
			return GenderOrientation.HETEROSEXUAL;
		}
		else if (dbData.equals("G")) {
			return GenderOrientation.GAY;
		}
		throw new RuntimeException("An invalid enum was retrieve from database to Gender Orientation Converter: " + dbData);
	}

}

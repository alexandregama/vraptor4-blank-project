package com.procurandoape.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PlaceTypeValidator implements ConstraintValidator<ValidPlaceType, PlaceType> {

	@Override
	public void initialize(ValidPlaceType constraintAnnotation) {
	}

	@Override
	public boolean isValid(PlaceType value, ConstraintValidatorContext context) {
		return value != null;
	}

}

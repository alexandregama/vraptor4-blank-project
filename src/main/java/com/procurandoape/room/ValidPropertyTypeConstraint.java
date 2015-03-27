package com.procurandoape.room;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPropertyTypeConstraint implements ConstraintValidator<ValidPropertyType, PropertyType> {

	@Override
	public void initialize(ValidPropertyType constraintAnnotation) {
	}

	@Override
	public boolean isValid(PropertyType value, ConstraintValidatorContext context) {
		return value != null;
	}

}

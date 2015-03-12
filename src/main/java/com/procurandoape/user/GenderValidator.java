package com.procurandoape.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<ValidGender, Gender> {

	@Override
	public void initialize(ValidGender constraintAnnotation) {

	}

	@Override
	public boolean isValid(Gender value, ConstraintValidatorContext context) {
		return value != null;
	}

}

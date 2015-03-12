package com.procurandoape.jpavalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.procurandoape.user.City;

public class CityValidator implements ConstraintValidator<ValidCity, City> {

	@Override
	public void initialize(ValidCity constraintAnnotation) {
	}

	@Override
	public boolean isValid(City value, ConstraintValidatorContext context) {
		if (value == null || value.getId() == null) {
			return false;
		}
		return true;
	}

}

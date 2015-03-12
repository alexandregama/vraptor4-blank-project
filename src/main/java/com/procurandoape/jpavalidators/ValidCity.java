package com.procurandoape.jpavalidators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = CityValidator.class)
public @interface ValidCity {

	String message() default "{user.city.invalid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

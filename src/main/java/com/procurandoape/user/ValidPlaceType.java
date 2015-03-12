package com.procurandoape.user;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PlaceTypeValidator.class)
public @interface ValidPlaceType {

	String message() default "{user.placetype.empty}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}

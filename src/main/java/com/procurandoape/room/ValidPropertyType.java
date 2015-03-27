package com.procurandoape.room;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = ValidPropertyTypeConstraint.class)
public @interface ValidPropertyType {

	String message() default "{placetorental.propertytype.valid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}

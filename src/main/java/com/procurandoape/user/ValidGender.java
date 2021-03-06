package com.procurandoape.user;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = GenderValidator.class)
public @interface ValidGender {

	String message() default "{user.gender.empty}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

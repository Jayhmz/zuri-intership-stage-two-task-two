package com.zuri.hng.stage.two.tasktwo.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = ResponseValidatorImpl.class)
public @interface ResponseValidator {
	
	Class<? extends Enum<?>> enumClass();

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

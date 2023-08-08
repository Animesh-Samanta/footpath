package com.footpath.online.constrains;

import java.lang.annotation.*;
import com.footpath.online.validation.EmailValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy =  EmailValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstrain {
    String message() default "Invalid Domain used for sign up.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

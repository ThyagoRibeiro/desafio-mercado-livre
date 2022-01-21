package br.com.mercado_livre.desafio.adapters.http.v1.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UUIDValidator.class})
public @interface IsUUID {

    String message() default "deve estar no formato UUID.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
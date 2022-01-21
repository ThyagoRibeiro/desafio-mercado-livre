package br.com.mercado_livre.desafio.adapters.http.v1.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class UUIDValidator implements ConstraintValidator<IsUUID, String> {

    @Override
    public void initialize(IsUUID uuidAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try{
            UUID.fromString((String) value);
            return true;
        } catch (IllegalArgumentException | NullPointerException exception) {
            return false;
        }
    }
}

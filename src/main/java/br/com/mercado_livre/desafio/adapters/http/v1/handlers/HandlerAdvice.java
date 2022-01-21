package br.com.mercado_livre.desafio.adapters.http.v1.handlers;

import br.com.mercado_livre.desafio.adapters.http.v1.models.response.MensagemPadronizadaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class HandlerAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<MensagemPadronizadaResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        Collection<String> mensagens = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(
                fieldError -> {
                    String message = String.format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
                    mensagens.add(message);
                }
        );

        MensagemPadronizadaResponse mensagemPadronizadaResponse = new MensagemPadronizadaResponse(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemPadronizadaResponse);

    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<MensagemPadronizadaResponse> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {

        Collection<String> mensagens = new ArrayList<>();
        constraintViolationException.getConstraintViolations().forEach(
                violation -> {
                    String message = String.format("Parâmetro %s %s", violation.getPropertyPath(), violation.getMessage());
                    mensagens.add(message);
                }
        );

        MensagemPadronizadaResponse mensagemPadronizadaResponse = new MensagemPadronizadaResponse(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemPadronizadaResponse);

    }

}
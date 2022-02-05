package com.cd2tec.javaChallenge.api.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
            List<Erro.details> details = new ArrayList<>();

            for (ObjectError error : ex.getBindingResult().getAllErrors()){
                String nome = ((FieldError)error).getField();
                String descricao = error.getDefaultMessage();

                details.add(new Erro.details(nome,descricao));
            }
            
            Erro erro = new Erro();
            erro.setCodeStatus(status.value());
            erro.setLocalDateTime(LocalDateTime.now());
            erro.setDetalhes(details);
        return handleExceptionInternal(ex, erro, headers, status, request);
    }
}

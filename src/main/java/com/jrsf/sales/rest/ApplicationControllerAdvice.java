package com.jrsf.sales.rest;

import com.jrsf.sales.rest.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlevalidationErros(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messsages = bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(messsages);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex){
        String messageErro = ex.getMessage();
        HttpStatus statusCode = ex.getStatus();
        ApiErrors apiErrors = new ApiErrors(messageErro);
        return new ResponseEntity(apiErrors, statusCode);
    }
}

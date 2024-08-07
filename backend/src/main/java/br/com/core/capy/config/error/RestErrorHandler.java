package br.com.core.capy.config.error;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.springframework.http.HttpStatus.*;
@RestControllerAdvice
public class RestErrorHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException erro, WebRequest webRequest) {
        return criaResponseEntity(BAD_REQUEST, erro, webRequest);
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e, WebRequest webRequest) {
        return criaResponseEntity(NOT_FOUND, e, webRequest);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e, WebRequest webRequest) {
        return criaResponseEntity(INTERNAL_SERVER_ERROR, e, webRequest);
    }

    private ResponseEntity<ErrorResponse> criaResponseEntity(HttpStatus httpStatus, Exception e, WebRequest webRequest) {
        String message = "";
        if (e != null && e.getMessage() != null) {
            message = e.getMessage();
        }
        ErrorResponse reposta = new ErrorResponse(message, httpStatus.value(), httpStatus.getReasonPhrase(), LocalDateTime.now(), webRequest.getDescription(false), new ArrayList<>());
        return ResponseEntity.status(httpStatus).body(reposta);
    }


}
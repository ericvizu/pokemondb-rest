package com.ericvizu.pokemondb_rest.resources.exceptions;

import com.ericvizu.pokemondb_rest.services.exceptions.ItemDuplicadoException;
import com.ericvizu.pokemondb_rest.services.exceptions.NumeroInvalidoException;
import com.ericvizu.pokemondb_rest.services.exceptions.RecursoNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ItemDuplicadoException.class)
    public ResponseEntity<StandardError> objectAlreadyExists(ItemDuplicadoException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(status.value(), "Already exists",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<StandardError> resourceNotFound(RecursoNaoEncontradoException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(status.value(), "Resource not found",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }@ExceptionHandler(NumeroInvalidoException.class)
    public ResponseEntity<StandardError> invalidNumberInserted(NumeroInvalidoException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(status.value(), "Invalid number",
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}

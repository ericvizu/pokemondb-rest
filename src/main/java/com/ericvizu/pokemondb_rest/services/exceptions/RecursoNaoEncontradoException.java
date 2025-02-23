package com.ericvizu.pokemondb_rest.services.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {
    public RecursoNaoEncontradoException(Long id) {
        super("Missing resource with id" + id);
    }
}

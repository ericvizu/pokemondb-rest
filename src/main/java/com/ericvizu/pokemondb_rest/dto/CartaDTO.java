package com.ericvizu.pokemondb_rest.dto;

public record CartaDTO(String nome, String numero, String raridade, String colecao, String tipo, String subtipo,
                       String holo, Integer ano, String regulamento, String idioma, Integer quantidadeInicial) {
}
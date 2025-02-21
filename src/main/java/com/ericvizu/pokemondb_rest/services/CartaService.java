package com.ericvizu.pokemondb_rest.services;

import com.ericvizu.pokemondb_rest.dto.CartaDTO;
import com.ericvizu.pokemondb_rest.entities.Carta;
import com.ericvizu.pokemondb_rest.repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CartaService {

    @Autowired
    private CartaRepository repository;


    //TODO Os identificadores de uma carta de Pokémon são:
    // - Número
    // - Holo
    // - Ano
    // - Idioma

    // Pensei na possibilidade de ao adicionar uma carta que já existe o cadastro, ele adicionar 1 no parâmetro de
    // quantidade do objeto.
    // Porém, vou tentar pensar mais se isso é o melhor a se fazer
    public Carta create(CartaDTO obj) {
        Carta carta = new Carta(obj);
        for (Carta c : findAll()) {
            if ((Objects.equals(carta.getNome(), c.getNome())) && (Objects.equals(carta.getHolo(), c.getHolo())) && (Objects.equals(carta.getAno(), c.getAno())) && (Objects.equals(carta.getIdioma(), c.getIdioma()))) {
                throw new RuntimeException(("Carta com o mesmo nome já encontrada"));
            }
        }
        return repository.save(carta);
    }

    public List<Carta> findAll() {
        return repository.findAll();
    }
}



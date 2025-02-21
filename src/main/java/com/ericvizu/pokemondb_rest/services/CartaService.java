package com.ericvizu.pokemondb_rest.services;

import com.ericvizu.pokemondb_rest.dto.CartaDTO;
import com.ericvizu.pokemondb_rest.entities.Carta;
import com.ericvizu.pokemondb_rest.repositories.CartaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartaService {
    //TODO Tratamento de exceção

    @Autowired
    private CartaRepository repository;

    //Os identificadores de uma carta de Pokémon são:
    // - Número
    // - Holo
    // - Ano
    // - Idioma

    // Pensei na possibilidade de ao adicionar uma carta que já existe o cadastro, ele adicionar 1 no parâmetro de
    // quantidade do objeto.
    // Porém, vou tentar pensar mais se isso é o melhor a se fazer

    //TODO Adicionar o componente de Inventário ao create
    public Carta create(CartaDTO obj) {
        Carta carta = new Carta(obj);
        for (Carta c : findAll()) {
            if ((Objects.equals(carta.getNome(), c.getNome())) && (Objects.equals(carta.getHolo(), c.getHolo())) && (Objects.equals(carta.getAno(), c.getAno())) && (Objects.equals(carta.getIdioma(), c.getIdioma()))) {
                throw new RuntimeException(("Carta com o mesmo nome já encontrada"));
            }
        }
        return repository.save(carta);
    }

    public Carta read(Long id) {
        try {
            Optional<Carta> obj = repository.findById(id);
            return obj.orElseThrow(() -> new RuntimeException("Missing resource with id" + id));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Missing id number");
        }
    }

    public Carta update(Long id, CartaDTO obj) {
        try {
            Carta entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Missing resource with id" + id);
        }
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new RuntimeException("Missing resource with id" + id);
            }
            repository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Missing id number.");
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Missing resource with id" + id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Carta> findAll() {
        return repository.findAll();
    }

    public void updateData(Carta entity, CartaDTO obj) {
        if (!(obj.nome() == null)) entity.setNome(obj.nome());
        if (!(obj.numero() == null)) entity.setNumero(obj.numero());
        if (!(obj.raridade() == null)) entity.setRaridade(obj.raridade());
        if (!(obj.colecao() == null)) entity.setColecao(obj.colecao());
        if (!(obj.tipo() == null)) entity.setTipo(obj.tipo());
        if (!(obj.subtipo() == null)) entity.setSubtipo(obj.subtipo());
        if (!(obj.holo() == null)) entity.setHolo(obj.holo());
        if (!(obj.ano() == null)) entity.setAno(obj.ano());
        if (!(obj.regulamento() == null)) entity.setRegulamento(obj.regulamento());
        if (!(obj.idioma() == null)) entity.setIdioma(obj.idioma());
    }
}
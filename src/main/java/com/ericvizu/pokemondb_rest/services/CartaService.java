package com.ericvizu.pokemondb_rest.services;

import com.ericvizu.pokemondb_rest.dto.CartaDTO;
import com.ericvizu.pokemondb_rest.entities.Carta;
import com.ericvizu.pokemondb_rest.repositories.CartaRepository;
import com.ericvizu.pokemondb_rest.services.exceptions.DatabaseException;
import com.ericvizu.pokemondb_rest.services.exceptions.ItemDuplicadoException;
import com.ericvizu.pokemondb_rest.services.exceptions.RecursoNaoEncontradoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartaService {

    @Autowired
    private CartaRepository repository;

    //Os identificadores de uma carta de Pokémon são:
    // - Número
    // - Holo
    // - Ano
    // - Idioma

    //TODO Adicionar o componente de Inventário ao create
    public Carta create(CartaDTO obj) {
        Carta carta = new Carta(obj);
        for (Carta c : findAll()) {
            if ((Objects.equals(carta.getNome(), c.getNome())) && (Objects.equals(carta.getHolo(), c.getHolo())) && (Objects.equals(carta.getAno(), c.getAno())) && (Objects.equals(carta.getIdioma(), c.getIdioma()))) {
                throw new ItemDuplicadoException(("Esta carta já se encontra cadastrada"));
            }
        }
        // Aqui vai entrar o quantidadeInicial da CartaDTO
        return repository.save(carta);
    }

    public Carta read(Long id) {
        try {
            Optional<Carta> obj = repository.findById(id);
            return obj.orElseThrow(() -> new RuntimeException("Não foi possível encontrar item com ID " + id + "."));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Não foi informado o ID.");
        }
    }

    public Carta update(Long id, CartaDTO obj) {
        try {
            Carta entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontradoException(id);
        }
    }

    //TODO SE quantidade não for nula, ENTÃO não pod e deletar
    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new RecursoNaoEncontradoException(id);
            }
            repository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Não foi informado o ID.");
        } catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontradoException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
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
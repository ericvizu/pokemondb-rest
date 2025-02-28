package com.ericvizu.pokemondb_rest.services;

import com.ericvizu.pokemondb_rest.dto.UsuarioDTO;
import com.ericvizu.pokemondb_rest.entities.Usuario;
import com.ericvizu.pokemondb_rest.repositories.UsuarioRepository;
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
public class UsuarioService {

    //TODO Refatorar toda essa parte ao implementar Spring Security

    @Autowired
    private UsuarioRepository repository;

    public Usuario create(UsuarioDTO obj) {
        Usuario usuario = new Usuario();
        for (Usuario c : findAll()) {
            if (Objects.equals(c.getNome(), usuario.getNome())) {
                throw new ItemDuplicadoException("Este usuário já se encontra cadastro");
            }
        }
        return repository.save(usuario);
    }

    public Usuario read(Long id) {
        try {
            Optional<Usuario> obj = repository.findById(id);
            return obj.orElseThrow(() -> new RuntimeException("Não foi possível encontrar usuário com ID " + id + "."));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Não foi informado o ID.");
        }
    }

    public Usuario update(Long id, UsuarioDTO obj) {
        try {
            Usuario entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontradoException(id);
        }
    }

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

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public void updateData(Usuario entity, UsuarioDTO obj) {
        if (!(obj.nome() == null)) entity.setNome(obj.nome());
    }
}

package com.ericvizu.pokemondb_rest.services;

import com.ericvizu.pokemondb_rest.dto.InventarioDTO;
import com.ericvizu.pokemondb_rest.entities.Inventario;
import com.ericvizu.pokemondb_rest.repositories.InventarioRepository;
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
public class InventarioService {

    @Autowired
    private InventarioRepository repository;

    // Para duplicidade, devo verificar se existe uma entrada com o mesmo usuário e carta já cadastrado.
    // Visto que dois usuários diferentes podem ter a mesma carta e o mesmo usuário pode ter várias cartas diferentes.
    public Inventario create(InventarioDTO obj) {
        Inventario inventario = new Inventario();
        for (Inventario c : findAll()) {
            if (Objects.equals(c.getCartaID(), inventario.getCartaID()) && Objects.equals(c.getUsuarioID(), inventario.getUsuarioID())) {
                throw new ItemDuplicadoException("Já existe um usuário com este carta");
            }
        }
        return repository.save(inventario);
    }

    public Inventario read(Long id) {
        try {
            Optional<Inventario> obj = repository.findById(id);
            return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Não informado o ID.");
        }
    }

    public Inventario update(Long id, InventarioDTO obj) {
        try {
            Inventario entity = repository.getReferenceById(id);
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
            throw new RuntimeException("Não informado o ID.");
        } catch (RecursoNaoEncontradoException e) {
            throw new RecursoNaoEncontradoException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<Inventario> findAll() {
        return repository.findAll();
    }

    public void updateData(Inventario entity, InventarioDTO obj) {
        if (!(obj.usuarioID() == null)) entity.setUsuarioID(obj.usuarioID());
        if (!(obj.cartaID() == null)) entity.setCartaID(obj.cartaID());
        if (!(obj.quantidade() == null)) entity.setQuantidade(obj.quantidade());
    }
}

package com.ericvizu.pokemondb_rest.services;

import com.ericvizu.pokemondb_rest.dto.InventarioDTO;
import com.ericvizu.pokemondb_rest.entities.Inventario;
import com.ericvizu.pokemondb_rest.repositories.InventarioRepository;
import com.ericvizu.pokemondb_rest.services.exceptions.ItemDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository repository;

    // Para duplicidade, devo verificar se existe uma entrada com o mesmo usuário e carta já cadastrado.
    // Visto que dois usuários diferentes podem ter a mesma carta e o mesmo usuário pode ter várias cartas diferentes.
    public Inventario create(InventarioDTO obj) {
        Inventario inventario = new Inventario();
        for (Inventario c : repository.findAll()) {
            if (Objects.equals(c.getCartaID(), inventario.getCartaID()) && Objects.equals(c.getUsuarioNumero(), inventario.getUsuarioNumero())) {
                throw new ItemDuplicadoException("Já existe um usuário com este carta");
            }
        }
        return repository.save(inventario);
    }
}

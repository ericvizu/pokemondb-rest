package com.ericvizu.pokemondb_rest.repositories;

import com.ericvizu.pokemondb_rest.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

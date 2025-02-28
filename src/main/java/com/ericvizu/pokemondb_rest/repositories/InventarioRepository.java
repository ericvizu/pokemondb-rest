package com.ericvizu.pokemondb_rest.repositories;

import com.ericvizu.pokemondb_rest.entities.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}

package com.ericvizu.pokemondb_rest.repositories;

import com.ericvizu.pokemondb_rest.entities.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartasRepository extends JpaRepository<Carta, Long> {
}

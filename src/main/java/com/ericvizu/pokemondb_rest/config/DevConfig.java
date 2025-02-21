package com.ericvizu.pokemondb_rest.config;

import com.ericvizu.pokemondb_rest.repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Configuration
//@Profile("dev")
public class DevConfig implements CommandLineRunner {
    @Autowired
    private CartaRepository cartaRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}

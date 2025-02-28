package com.ericvizu.pokemondb_rest.config;

import com.ericvizu.pokemondb_rest.repositories.CartaRepository;
import com.ericvizu.pokemondb_rest.repositories.UsuarioRepository;
import com.ericvizu.pokemondb_rest.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevConfig implements CommandLineRunner {
    @Autowired
    private CartaRepository cartaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioRepository inventarioRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}

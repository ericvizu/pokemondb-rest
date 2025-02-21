package com.ericvizu.pokemondb_rest.resources;

import com.ericvizu.pokemondb_rest.dto.CartaDTO;
import com.ericvizu.pokemondb_rest.entities.Carta;
import com.ericvizu.pokemondb_rest.services.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/carta")
public class CartaResource {

    @Autowired
    private CartaService service;

    @PostMapping
    public ResponseEntity<Carta> create(@RequestBody CartaDTO obj) {
        Carta newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).body(newObj);
    }
}
